package controller;

import model.bean.Customer;
import model.service.ICustomerService;
import model.service.Impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "view":
                break;
            case "search":
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
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "view":
                break;
            case "search":
                findByCustomerName(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }


    }
    //do get

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerService.selectAllCustomer();
        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
            request.setAttribute("customer", customer);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByCustomerName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Customer> customerList = customerService.findByCustomerName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        request.setAttribute("customers", customerList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //do post
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String customerName = request.getParameter("name");
        String customerBirthday = request.getParameter("birthday");
        int customerGender = Integer.parseInt(request.getParameter("gender"));
        String customerIdCard = request.getParameter("idCard");
        String customerPhone = request.getParameter("phone");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("address");
        int customerType = Integer.parseInt(request.getParameter("type"));
        Customer customer = new Customer(customerType, customerName, customerBirthday, customerGender,
                customerIdCard, customerPhone, customerEmail, customerAddress);
        try {
            customerService.insertCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("id"));

        int customerTypeId = Integer.parseInt(request.getParameter("type"));

        String customerName = request.getParameter("name");

        String customerBirthday = request.getParameter("birthday");

        int customerGender = Integer.parseInt(request.getParameter("gender"));

        String customerIdCard = request.getParameter("card");

        String customerPhone = request.getParameter("phone");

        String customerEmail = request.getParameter("email");

        String customerAddress = request.getParameter("address");

        Customer customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender,
                customerIdCard, customerPhone, customerEmail, customerAddress);

        boolean check = false;
        try {
            check = customerService.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check) {
            request.setAttribute("message", "Chỉnh sữa đã thành công");

        } else {
            request.setAttribute("message", "Chỉnh sửa không thành công");
        }
        request.setAttribute("customer", customer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            customerService.deleteCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
