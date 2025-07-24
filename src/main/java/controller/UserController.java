package controller;

import model.User;
import service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        try {
            userService = new UserService();
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            switch (action) {
                case "create-user":
                    insertUser(request, response);
                    break;
                case "update-user":
                    updateUser(request, response);
                    break;
                case "delete-user":
                    deleteUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "list":
                    listPage(request, response);
                    break;
                case "list-json":
                    listJson(request, response);
                    break;
                default:
                    listPage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (NamingException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        int phoneNo = Integer.parseInt(request.getParameter("phoneNo"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(name, phoneNo, address, email, password);
        userService.insertUser(user);
        response.sendRedirect(request.getContextPath() + "/user/list.jsp");

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int phoneNo = Integer.parseInt(request.getParameter("phoneNo"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User updatedUser = new User(id, name, phoneNo, address, email, password);
        userService.updateUser(updatedUser);
        response.sendRedirect(request.getContextPath() + "/user/list.jsp");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        response.sendRedirect(request.getContextPath() + "/user/list.jsp");
    }

    private void listJson(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, NamingException, ServletException {

        // Check is user authentected for return the json data or no 
        Object isAuth = request.getSession().getAttribute("user");

        if (isAuth == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        try {
            List<User> listUser = userService.getAllUsers();

            Map<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("data", listUser);

            String json = new Gson().toJson(jsonResponse);
            System.out.println(json);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"error\":\"" + ex.getMessage() + "\"}");
        }
    }

    private void listPage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, NamingException {

        try {
            List<User> listUser = userService.getAllUsers();
            request.setAttribute("listUser", listUser);

            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/user/list.jsp");
            dispatcher.forward(request, response);
        } catch (NamingException ex) {
            throw new ServletException(ex);
        }
    }
}
