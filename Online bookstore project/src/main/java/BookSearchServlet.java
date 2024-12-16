import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDAO;
import com.bookstore.models.Book;

@WebServlet("/BookSearchServlet")
public class BookSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Session validation
        HttpSession session = request.getSession(false);  // Get the session, but don't create a new one
        if (session == null || session.getAttribute("username") == null) {
            // If no session exists or the user is not logged in, redirect to login page
            response.sendRedirect("login.jsp");
        } else {
            // User is logged in, proceed with book search logic
            String username = (String) session.getAttribute("username");
            
            // Get search parameters from the request
            String searchType = request.getParameter("searchType");
            String searchValue = request.getParameter("searchValue");

            // Call the DAO to search books based on the search type and value
            List<Book> books = BookDAO.searchBooks(searchType, searchValue);

            // Set the search results as a request attribute and forward to the results JSP page
            request.setAttribute("books", books);
            request.getRequestDispatcher("bookResults.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Just redirect to POST logic for search handling
        doPost(request, response);
    }
}
