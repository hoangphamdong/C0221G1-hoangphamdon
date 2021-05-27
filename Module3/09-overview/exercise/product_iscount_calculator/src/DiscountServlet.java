import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet",value = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price=request.getParameter("price");
        String discount=request.getParameter("discount");

        double discountAmount=Double.parseDouble(price)*Double.parseDouble(discount)*0.01;
        double discountPrice=Double.parseDouble(price)-discountAmount;

        request.setAttribute("amount",discountAmount);
        request.setAttribute("price",discountPrice);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
