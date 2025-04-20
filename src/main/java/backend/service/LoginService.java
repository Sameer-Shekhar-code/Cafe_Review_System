package backend.service;

import backend.JDBC.DatabaseConnector;

import java.sql.*;

public class LoginService {

    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM user WHERE Email = ? AND Password = ? UNION SELECT * FROM User WHERE Name = ? AND Password = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, username);
            stmt.setString(4, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // ✅ If there's a match, login is valid
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}