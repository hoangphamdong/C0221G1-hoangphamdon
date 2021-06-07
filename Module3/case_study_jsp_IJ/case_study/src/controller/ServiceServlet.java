package controller;

import model.bean.Customer;
import model.bean.Service;
import model.service.IServiceService;
import model.service.Impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = ("/service"))
public class ServiceServlet extends HttpServlet {

    IServiceService serviceService = new ServiceServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            default:
                listService(request, response);
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
            default:
                listService(request, response);
                break;
        }
    }

    //Do get
    private void listService(HttpServletRequest request, HttpServletResponse response) {

        List<Service> services = serviceService.selectAllService();
        request.setAttribute("services", services);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //do post
    private void createService(HttpServletRequest request, HttpServletResponse response) {

        String serviceName = request.getParameter("serviceName");

        int serviceArea= Integer.parseInt(request.getParameter("serviceArea"));

        Double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));

       int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));

        int rentTypeID = Integer.parseInt(request.getParameter("rentTypeID"));

        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));

        String standardRoom = request.getParameter("standardRoom");

        String description = request.getParameter("description");

        Double poolArea = Double.parseDouble(request.getParameter("poolArea"));

        int floors = Integer.parseInt(request.getParameter("floors"));

        Service service = new Service(serviceName, serviceArea, serviceCost, serviceMaxPeople,
                rentTypeID, serviceTypeId, standardRoom, description,poolArea,floors);
        try {
            serviceService.insertService(service);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
