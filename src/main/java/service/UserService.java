package service;

import entity.User;
import jakarta.servlet.ServletException;
import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import javax.naming.NamingException;
import util.DBQuery;

public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class.getName());

    public static boolean insertUser(User user){
        try (Connection conn = DBUtil.connect(); PreparedStatement stmt = conn.prepareStatement(DBQuery.getInsertQuery())) {

            stmt.setString(1, user.getFullName());
            stmt.setInt(2, user.getPhoneNo());
            stmt.setString(3, user.getAddress());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());

            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            log.severe(ex.getMessage());
        }
        return false;
    }

    public static boolean updateUser(User user) {
        try (Connection conn = DBUtil.connect(); PreparedStatement stmt = conn.prepareStatement(DBQuery.getUpdateQuery())) {

            stmt.setString(1, user.getFullName());
            stmt.setInt(2, user.getPhoneNo());
            stmt.setString(3, user.getAddress());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setInt(6, user.getId());

            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            log.severe(ex.getMessage());
        }
        return false;
    }

    public static boolean deleteUser(int id) {
        try (Connection conn = DBUtil.connect(); PreparedStatement stmt = conn.prepareStatement(DBQuery.getDeleteQuery())) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            log.severe(ex.getMessage());
        }
        return false;
    }

    public static List<User> getAllUsers() throws ServletException, NamingException {
        List<User> users = new ArrayList<>();
        try (
                Connection conn = DBUtil.connect(); PreparedStatement stmt = conn.prepareStatement(DBQuery.getSelectQuery()); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getInt("phoneNumber"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
        } catch (Exception ex) {
            log.severe(ex.getMessage());
        }
        return users;
    }

    public static Optional<User> getUserById(int id) throws ServletException, NamingException {
        try (
                Connection conn = DBUtil.connect(); PreparedStatement stmt = conn.prepareStatement(DBQuery.getGetByIdQuery());) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getInt("phoneNumber"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
        } catch (Exception ex) {
            log.severe(ex.getMessage());
        }
        return Optional.empty();
    }
}
