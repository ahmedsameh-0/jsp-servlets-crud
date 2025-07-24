package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class AuthFilter implements Filter {

    private static final List<String> PUBLIC_URLS = List.of(
            "/auth/login.jsp",
            "/auth/register.jsp",
            "/AuthController",
            "index.jsp"
    );

    private static final List<String> PRIVATE_URLS = List.of(
            "/user/add.jsp",
            "/user/edit.jsp",
            "/user/list.jsp",
            "/UserController?action=list-json"
    );

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String path = req.getRequestURI().substring(req.getContextPath().length());
        Object user = req.getSession().getAttribute("user");

        if (isStaticFile(path)) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (matches(path, PUBLIC_URLS)) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (matches(path, PRIVATE_URLS)) {
            if (user == null) {
                res.setStatus(HttpServletResponse.SC_FORBIDDEN);
                req.getRequestDispatcher("/error/403.jsp").forward(req, res);
                return;
            }
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    private boolean matches(String path, List<String> patterns) {
        for (String pattern : patterns) {
            if (path.equals(pattern) || path.startsWith(pattern)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStaticFile(String path) {
        return path.startsWith("/static/");
    }

}
