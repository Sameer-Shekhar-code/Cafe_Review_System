package backend.service;

import backend.DTO.LoginDTO;
import backend.JDBC.DatabaseConnector;

import java.sql.*;

public class LoginService {

    public boolean validateUser(LoginDTO user) {
        String query = "SELECT * FROM user WHERE Email = ? AND Password = ? UNION SELECT * FROM user WHERE Name = ? AND Password = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}