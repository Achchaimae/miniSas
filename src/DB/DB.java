package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static ResultSet query(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/miniSas",
                    "root",
                    ""
            );
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static int executeUpdate(String query, Object... parameters) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/miniSas",
                    "root",
                    ""
            );
            PreparedStatement stmt = con.prepareStatement(query);
            setParameters(stmt, parameters);
            return stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    private static void setParameters(PreparedStatement stmt, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            stmt.setObject(i + 1, parameters[i]);
        }
    }
}