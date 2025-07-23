package util;

import jakarta.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

    // Not Needed any more connect to db via jndi-name that has been added in other sources dir
    public static final String JDBC = "jdbc/firstCrud";

    private static DataSource dataSource;

    private static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            try {
                InitialContext ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup(JDBC);
            } catch (NamingException e) {
                throw e;
            }
        }
        return dataSource;
    }

    public static boolean executeUpdate(String sql, Object... params) throws ServletException, NamingException {
        try (Connection conn = getDataSource().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            stmt.executeUpdate();
            return true;
        }  catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public static Connection connect() throws ServletException, NamingException {
        try {
            return getDataSource().getConnection();
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
