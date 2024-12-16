import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.models.Book;
import com.bookstore.models.Cart;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedBooks = request.getParameterValues("bookId");
        String[] quantities = request.getParameterValues("quantity");

        if (selectedBooks == null || quantities == null) {
            response.sendRedirect("error.jsp"); // Redirect or handle error
            return;
        }

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        try {
            for (int i = 0; i < selectedBooks.length; i++) {
                int bookId = Integer.parseInt(selectedBooks[i]);
                int quantity = Integer.parseInt(quantities[i]);
                
                // Create a new Book object with default values for name and price
                // You should ideally fetch this information from a database or another source
                Book book = new Book(bookId, "Default Name", null, null, 0.0, 0);
                
                cart.addBook(book, quantity);
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp"); // Handle parsing error
            return;
        }

        request.getSession().setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
