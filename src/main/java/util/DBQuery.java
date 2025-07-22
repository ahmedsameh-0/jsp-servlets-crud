package util;

public class DBQuery {

    private static final String selectQuery = "SELECT * FROM users";
    private static final String getByIdQuery = "SELECT * FROM users WHERE id=?";
    private static final String updateQuery = "UPDATE users SET fullName = ?, phoneNumber = ?, addess = ?, email = ?, password = ? WHERE id = ?";
    private static final String insertQuery = "INSERT INTO users (fullName, phoneNumber, address, email, password) VALUES (?,?,?,?,?)";
    private static final String deleteQuery = "DELETE FROM users WHERE id = ?";
    
    public static String getSelectQuery() {
        return selectQuery;
    }

    public static String getGetByIdQuery() {
        return getByIdQuery;
    }

    public static String getUpdateQuery() {
        return updateQuery;
    }

    public static String getInsertQuery() {
        return insertQuery;
    }

    public static String getDeleteQuery() {
        return deleteQuery;
    }

}
