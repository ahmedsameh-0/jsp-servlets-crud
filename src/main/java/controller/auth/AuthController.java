package controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthController extends HttpServlet {

    //  Just for test
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "auth-login":
                login(req, res);
                break;
            case "auth-register":
                register(req, res);
                break;
            default:
                login(req, res);
                break;
        }
    }

    private static void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");

        if (username == null || username.isEmpty() || password.isEmpty() || password == null) {
            req.setAttribute("error", "Please enter all coulmn, the coulmn not be blank.");
        }

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            req.getSession().setAttribute("username", username);
//            req.setAttribute("error", "SUC");
            res.sendRedirect("index.jsp");
        } else {
            req.setAttribute("error", "Invalid username or password.");
            req.getRequestDispatcher("auth/login.jsp").forward(req, res);
        }
    }

    private static void register(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // A
    }

}
