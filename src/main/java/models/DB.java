package models;

import java.sql.*;

public class DB {
    public static Connection conn;
    public static String dbURL = "jdbc:mysql://localhost:3306/fca";
    public static String dbUser = "root";
    public static String dbPass = "";

    public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
       }
    }

    public boolean checkIfUserExists(String user_id) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE user_id=?");
        statement.setString(1,user_id);
        ResultSet res = statement.executeQuery();
        if (res.next())
            return true;
        return false;
    }
    public void addUser(String user_id, String email, String name) throws SQLException {
        if (!checkIfUserExists(user_id)) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO users (user_id,email,name) VALUES (?,?,?)");
            statement.setString(1,user_id);
            statement.setString(2,email);
            statement.setString(3,name);
            statement.executeUpdate();
            System.out.println("User Added");
        }
        else {
            System.out.println("User already exist");
        }
    }
    public String getUserStatus(String user_id) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE user_id=?");
        statement.setString(1,user_id);
        ResultSet res = statement.executeQuery();
        if (res.next())
            return res.getString("status");

        return null;
    }
}
