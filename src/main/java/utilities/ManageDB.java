package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {

    public static void openConnection(String dbURL, String dbUser, String dbPass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(dbURL,dbUser,dbPass);
        stmt = con.createStatement();
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }


}
