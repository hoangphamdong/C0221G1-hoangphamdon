package servlet_display;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DisplayServlet", urlPatterns = {"/display"})
public class DisplayServlet extends HttpServlet {
    ArrayList<Customer> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Customer("Hoàng Phạm Đông", "30/01/2002", "Daklak", "img/hoangphamdong.jpg"));
        list.add(new Customer("Kiều Nhi", "30/01/2004", "Đà Nẵng", "img/hinh2.jpg"));
        list.add(new Customer("Cẩm Đang", "22/05/2002", "Hà Nội", "img/hình 3.jpg"));
        list.add(new Customer("King Kông", "30/01/2002", "Quảng Trị", "img/hoangphamdong.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customer",list);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
