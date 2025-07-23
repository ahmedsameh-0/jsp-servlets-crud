package controller;

import entity.User;
import entity.dto.LoginDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import javax.naming.NamingException;
import service.AuthService;

@WebServlet("/AuthController")
public class AuthController extends HttpServlet {

    private static AuthService authService;

    @Override
    public void init() throws ServletException {
        authService = new AuthService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            
            switch (action) {
                case "/login":
                    login(req, res);
                    break;
                case "/register":
                    register(req, res);
                    break;
            }
        } catch (NamingException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "/":
                welcome(req, res);
                break;
            case "/logout":
                logout(req, res);
                break;
        }
    }

    private static void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NamingException {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        LoginDto dto = new LoginDto(username, password);
        
        User user = authService.login(dto);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getFullName());
            response.sendRedirect("/index.jsp");
        } else {
            request.setAttribute("error", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private static void register(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    }

    private static void welcome(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        if (req.getSession().getAttribute("username") == null) {
            res.sendRedirect("/auth/login.jsp");
            return;
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, res);
    }

    private void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().invalidate();
        res.sendRedirect("/auth/login.jsp");
    }
}
