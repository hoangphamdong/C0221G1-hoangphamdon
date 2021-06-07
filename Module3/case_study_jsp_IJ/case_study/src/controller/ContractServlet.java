package controller;

import model.bean.Contract;
import model.bean.Customer;
import model.service.IContractService;
import model.service.Impl.ContractServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    IContractService contractService = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
                break;
            case "delete":
                deleteContract(request, response);
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
                break;
            case "view":
                break;
            case "search":
                findContractByCustomerName(request, response);
                break;
            default:
                listCustomerUserContract(request, response);
                break;
        }

    }

    // Do get;

    private void listCustomerUserContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contracts = contractService.selectAllContract();

        request.setAttribute("contracts", contracts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Do post
    private void createContract(HttpServletRequest request, HttpServletResponse response) {

        String startDay = request.getParameter("startDay");

        String startMonth = request.getParameter("startMonth");

        String startYear = request.getParameter("startYear");

        String startContract = startYear + startMonth + startDay;

        String endDay = request.getParameter("endDay");

        String endMonth = request.getParameter("endMonth");

        String endYear = request.getParameter("endYear");

        String endContract = endYear + endMonth + endDay;

        Double deposit = Double.parseDouble(request.getParameter("deposit"));

        Double total = Double.parseDouble(request.getParameter("total"));

        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        int customerId = Integer.parseInt(request.getParameter("customerId"));

        int serviceId = Integer.parseInt(request.getParameter("serviceId"));


        Contract contract = new Contract(startContract, endContract, deposit, total,
                employeeId, customerId, serviceId);
        try {
            contractService.insertContract(contract);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            contractService.deleteContract(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findContractByCustomerName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Contract> contractList = contractService.findContractByCustomerName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        request.setAttribute("contracts", contractList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

