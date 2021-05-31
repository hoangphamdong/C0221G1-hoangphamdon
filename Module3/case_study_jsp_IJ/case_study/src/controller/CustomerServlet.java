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
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
   private ICustomerService customerService=new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
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

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer customerId=Integer.parseInt(request.getParameter("customerId"));
        String customerName=request.getParameter("customerName");
        String customerBirthDay=request.getParameter("customerBirthDay");
        String customerGander=request.getParameter("customerGander");
        Integer customerIdCard=Integer.parseInt(request.getParameter("customerIdCard"));
        String customerPhone=request.getParameter("customerPhone");


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action =request.getParameter("action");
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                break;
            case "search":
                break;
            default:
                listCustomer(request,response);
                break;
        }


    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
    RequestDispatcher dispatcher=request.getRequestDispatcher("view/customer/create.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {

    int customerId=Integer.parseInt(request.getParameter("customerId"));
    Customer customer=this.customerService.findById(customerId);
    RequestDispatcher dispatcher;

    if(customer==null){
        dispatcher=request.getRequestDispatcher("view/Error-404.jsp");

    }else {
        request.setAttribute("customer",customer);
        dispatcher=request.getRequestDispatcher("view/customer/delete.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
    int customerId=Integer.parseInt(request.getParameter("customerId"));
    Customer customer=this.customerService.findById(customerId);
    RequestDispatcher dispatcher;
    if(customer==null){
        dispatcher=request.getRequestDispatcher("view/error-404.jsp");
    }
    else {
        this.customerService.remove(customerId);

        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer>customers=this.customerService.findAll();
        request.setAttribute("customers",customers);

        RequestDispatcher dispatcher=request.getRequestDispatcher("view/customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
