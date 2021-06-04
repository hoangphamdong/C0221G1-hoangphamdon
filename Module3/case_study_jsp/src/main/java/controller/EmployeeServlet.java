package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.service.IEmployeeService;
import model.service.Impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "edit":

                break;
            case "view":

                break;
            case "search":

                break;
            default:
                listEmployee(request, response);
                break;
        }

    }

    //do get
    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeService.selectAllEmployee();
        request.setAttribute("employees", employees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list1.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String customerName = request.getParameter("name");
//
//        String customerBirthday = request.getParameter("birthday");
//
//        int customerGender = Integer.parseInt(request.getParameter("gender"));
//
//        String customerIdCard = request.getParameter("idCard");
//
//        String customerPhone = request.getParameter("phone");
//
//        String customerEmail = request.getParameter("email");
//
//        String customerAddress = request.getParameter("address");
//
//        int customerType = Integer.parseInt(request.getParameter("type"));
//
//        Customer customer = new Customer(customerType, customerName, customerBirthday, customerGender,
//                customerIdCard, customerPhone, customerEmail, customerAddress);
//        try {
//            customerService.insertCustomer(customer);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
