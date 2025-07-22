package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

    // Not Needed any more connect to db via jndi-name that has been added in other sources dir
    public static final String JDBC = "jdbc/firstCrud";

    private static DataSource dataSource;

    private static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup(JDBC);
        }
        return dataSource;
    }

    public static boolean executeUpdate(String sql, Object... params) {

        try (Connection conn = getDataSource().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Connection connect() {
        try {
            return getDataSource().getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
