//package backend.service;
//import frontend.dashboard.Dashboard;
//import backend.JDBC.DatabaseConnector;
//
//import javax.swing.*;
//import java.awt.*;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class Dashboard_service {
//    Dashboard d=new Dashboard();
//    Dashboard_service(){
//        try {
//            Connection conn = DatabaseConnector.getConnection();
//            if (conn == null) {
//                System.out.println("Database connection failed!");
//                return;
//            }
//
//            String query = "SELECT c.Name AS cafe_name, i.Image_URL AS image_url " +
//                    "FROM Cafe c " +
//                    "LEFT JOIN Image i ON c.Cafe_id = i.Cafe_id " +
//                    "GROUP BY c.Cafe_id " +
//                    "LIMIT 1";
//
//            PreparedStatement ps = conn.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next() ) {
//                String cafeName = rs.getString("cafe_name");
//                String imagePath = rs.getString("image_url");
//
//               d.jTextField5.setText(cafeName);
//
//                try {
//                    ImageIcon icon = new ImageIcon(imagePath); // Can be file path or URL
//                    Image img = icon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
//                    d.jLabel2.setIcon(new ImageIcon(img));
//                } catch (Exception e) {
//                    System.out.println("Error loading image: " + imagePath);
//                    d.jLabel2.setText("Image not found");
//                }
//
//
//            }
//
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    }
//
//

package backend.service;

import backend.JDBC.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        Connection conn = DatabaseConnector.getConnection();
        if (conn != null) {
            System.out.println("Database connected successfully!");

            try {
                String query = "SELECT Cafe_Id, Name FROM cafe LIMIT 5";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                System.out.println("Cafe_Id\tName");
                while (rs.next()) {
                    int cafeId = rs.getInt("Cafe_Id");
                    String name = rs.getString("Name");
                    System.out.println(cafeId + "\t" + name);
                }

                // Close resources
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}

