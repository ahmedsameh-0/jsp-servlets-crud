package service;

import model.User;
import dto.LoginDto;
import jakarta.servlet.ServletException;
import util.DBUtil;
import java.sql.*;
import javax.naming.NamingException;
import util.DBQuery;

public class AuthService {

    public boolean register(User user) throws ServletException, NamingException {
        try (Connection conn = DBUtil.connect(); PreparedStatement stmt = conn.prepareStatement(DBQuery.getRegisterQuery())) {
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ServletException(ex);

        }
    }

    public User login(LoginDto dto) throws ServletException, NamingException {
        try (Connection conn = DBUtil.connect(); PreparedStatement stmt = conn.prepareStatement(DBQuery.getLoginQuery())) {
            stmt.setString(1, dto.getEmail());
            stmt.setString(2, dto.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
