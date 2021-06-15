package controller;

import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Employee;
import model.bean.Position;
import model.service.IDivisionService;
import model.service.IEducationDegree;
import model.service.IEmployeeService;
import model.service.IPositionService;
import model.service.impl.DivisionServiceImpl;
import model.service.impl.EducationDegreeImpl;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private IPositionService positionService = new PositionServiceImpl();
    private IDivisionService divisionService = new DivisionServiceImpl();
    private IEducationDegree educationDegree = new EducationDegreeImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                break;
            case "search":
                break;
            default:
                listEmployee(request, response);
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
                break;
            default:
                listEmployee(request, response);
                break;
        }

    }

    //do get
    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = this.employeeService.selectAllEmployee();

        request.setAttribute("employees", employees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {

        List<Position> positionList = positionService.selectAllPosition();
        List<Division> divisions = this.divisionService.selectAllDivision();
        List<EducationDegree> educationDegrees = this.educationDegree.selectAllEducation();

        request.setAttribute("positions", positionList);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educations", educationDegrees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// Do post

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {

        String employeeName = request.getParameter("name");

        String employeeBirthday = request.getParameter("birthday");

        String employeeIdCard = request.getParameter("Card");

        Double salary = Double.parseDouble(request.getParameter("salary"));

        String phone = request.getParameter("phone");

        String email = request.getParameter("email");

        String address = request.getParameter("address");

        int position = Integer.parseInt(request.getParameter("position"));

        int education = Integer.parseInt(request.getParameter("education"));

        int division = Integer.parseInt(request.getParameter("division"));


        String username = request.getParameter("username");

        Employee employee = new Employee(employeeName, employeeBirthday, employeeIdCard, salary,
                phone, email, address, position, education, division, username);
        try {
            Map<String, String> mapMsg = employeeService.insertEmployee(employee);
            if (mapMsg.isEmpty()) {
                List<Position> positions = positionService.selectAllPosition();
                List<Division> divisions = this.divisionService.selectAllDivision();
                List<EducationDegree> educationDegrees = this.educationDegree.selectAllEducation();
                request.setAttribute("positions", positions);
                request.setAttribute("divisions", divisions);
                request.setAttribute("educations", educationDegrees);
                request.setAttribute("massage","Thêm mới thành công");

                request.getRequestDispatcher("view/employee/create.jsp").
                        forward(request, response);
//                listEmployee(request, response);
            } else {
                request.setAttribute("employeeInfo", employee);
                request.setAttribute("msgName", mapMsg.get("name"));
                request.setAttribute("msgEmail", mapMsg.get("email"));
                List<Position> positions = positionService.selectAllPosition();
                List<Division> divisions = this.divisionService.selectAllDivision();
                List<EducationDegree> educationDegrees = this.educationDegree.selectAllEducation();
                request.setAttribute("positions", positions);
                request.setAttribute("divisions", divisions);
                request.setAttribute("educations", educationDegrees);

                request.getRequestDispatcher("view/employee/create.jsp").
                        forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        List<Position> positions = positionService.selectAllPosition();
//        List<Division> divisions = this.divisionService.selectAllDivision();
//        List<EducationDegree> educationDegrees = this.educationDegree.selectAllEducation();
//        request.setAttribute("positions", positions);
//        request.setAttribute("divisions", divisions);
//        request.setAttribute("educations", educationDegrees);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



    }
}
