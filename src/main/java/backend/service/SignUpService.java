package backend.service;
import backend.JDBC.DatabaseConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpService {

    public boolean registerUser(String name, String password, String phoneNumber, String email, String userType, Date joinDate) {
        Connection connection = DatabaseConnector.getConnection(); // Ensure you have the correct database connection
        if (connection == null) {
            return false; // Connection failed
        }

        // Corrected SQL query to match column names in the 'user' table
        String query = "INSERT INTO user (Name, Password, Phone_Number, Email, user_type, Join_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, phoneNumber); // Corrected column name for phone
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, userType);
            preparedStatement.setDate(6, joinDate); // Corrected column name for join date

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true if the insert is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurs
        }
    }


}
