import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.models.Cart;

@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String action = request.getParameter("action");

	    if ("Back".equals(action)) {
	        // Redirect to the book search page
	        response.sendRedirect("bookSearch.jsp");
	    } else if ("Bill".equals(action)) {
	        // Process the billing logic here
	        // ...
	    }
	}
}