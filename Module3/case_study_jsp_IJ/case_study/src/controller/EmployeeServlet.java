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
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
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
                viewEmployee(request, response);
                break;
            case "search":
                findByEmployeeName(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
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
        Employee employee = employeeService.selectEmployee(id);
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/employee/edit.jsp");
            request.setAttribute("employee", employee);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("view/error-404.jsp");
        } else {
            request.setAttribute("customer",employee);
            dispatcher = request.getRequestDispatcher("view/customer/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //do post

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {

        String employeeName = request.getParameter("name");

        String employeeBirthday = request.getParameter("birthday");

        String idCard = request.getParameter("idCard");

        Double salary = Double.parseDouble(request.getParameter("salary"));

        String phone = request.getParameter("phone");

        String email = request.getParameter("email");

        String address = request.getParameter("address");

        int position = Integer.parseInt(request.getParameter("position"));

        int degree = Integer.parseInt(request.getParameter("degree"));

        int division = Integer.parseInt(request.getParameter("division"));

        String user = request.getParameter("user");

        Employee employee = new Employee(employeeName, employeeBirthday, idCard, salary,
                phone, email, address, position, degree, division, user);
        try {
            employeeService.insertEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            employeeService.deleteEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employeeName = request.getParameter("name");

        String employeeBirthday = request.getParameter("birthday");

        String idCard = request.getParameter("idCard");

        Double salary = Double.parseDouble(request.getParameter("salary"));

        String phone = request.getParameter("phone");

        String email = request.getParameter("email");

        String address = request.getParameter("address");

        int position = Integer.parseInt(request.getParameter("position"));

        int degree = Integer.parseInt(request.getParameter("degree"));

        int division = Integer.parseInt(request.getParameter("division"));

        String user = request.getParameter("user");

        Employee employee = new Employee(employeeName, employeeBirthday, idCard, salary,
                phone, email, address, position, degree, division, user);
        boolean check = false;
        try {
            check = employeeService.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (check) {
            request.setAttribute("message", "Chỉnh sữa đã thành công");

        } else {
            request.setAttribute("message", "Chỉnh sửa không thành công");
        }
        request.setAttribute("customer", employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByEmployeeName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Employee> employeeList = employeeService.findByEmployeeName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        request.setAttribute("employees",employeeList );
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
