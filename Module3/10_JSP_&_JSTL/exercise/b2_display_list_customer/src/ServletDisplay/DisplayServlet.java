package ServletDisplay;

import model.Student;

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
    ArrayList<Student> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Student("Hoàng Phạm Đông", "30/01/2002", "Daklak", "img/hoangphamdong.jpg"));
        list.add(new Student("Hoàng Phạm Đông", "30/01/2002", "Daklak", "img/hoangphamdong.jpg"));
        list.add(new Student("Hoàng Phạm Đông", "30/01/2002", "Daklak", "img/hoangphamdong.jpg"));
        list.add(new Student("Hoàng Phạm Đông", "30/01/2002", "Daklak", "img/hoangphamdong.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("student",list);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
