package controller;

import model.bean.Product;
import model.service.IProductService;
import model.service.Impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {
    IProductService productService=new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
//                editEmployee(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
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
//                viewEmployee(request, response);
                break;
            case "search":
                findByProductName(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }


    }
    //do get
    private void listProduct (HttpServletRequest request, HttpServletResponse response){
        List<Product> products = this.productService.selectAllProduct();

        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list.jsp");
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
        Product product = productService.getProductById(id);
        RequestDispatcher requestDispatcher;
        if (product == null) {
            requestDispatcher = request.getRequestDispatcher("view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("view/product/edit.jsp");
            request.setAttribute("product", product);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByProductName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Product> productList = productService.findByProductName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        request.setAttribute("products", productList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee", product);
            dispatcher = request.getRequestDispatcher("view/product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");

        Double price=Double.parseDouble( request.getParameter("price"));
        int quantity =Integer.parseInt( request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description= request.getParameter("description");
        Integer category= Integer.parseInt(request.getParameter("category"));



        Product product = new Product(name, price,quantity,color,description,category);
        try {
            productService.insertProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("msg","ADD new success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
//
//        int employeeId = Integer.parseInt(request.getParameter("id"));
//
//        String customerName = request.getParameter("name");
//
//        String customerBirthday = request.getParameter("birthday");
//
//        Product employee = new Product(employeeId,customerName, customerBirthday);
//
//        boolean check = false;
//        try {
//            check = employeeService.updateEmployee(employee);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (check) {
//            request.setAttribute("message", "Chỉnh sữa đã thành công");
//
//        } else {
//            request.setAttribute("message", "Chỉnh sửa không thành công");
//        }
//        request.setAttribute("customer", employee);
//
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productService.deleteProduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

