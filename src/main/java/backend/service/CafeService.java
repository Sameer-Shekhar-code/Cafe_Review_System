package backend.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import backend.DTO.CafeDetailsDTO;
import backend.JDBC.DatabaseConnector;

public class CafeService {

    public CafeDetailsDTO getCafeDetailsById(int cafeId) {
        CafeDetailsDTO dto = new CafeDetailsDTO();

        try (Connection conn = DatabaseConnector.getConnection()) {
            // 1. Basic cafe info
            String cafeSql = "SELECT c.Name, c.Website, l.Address, l.Area, l.City, l.Pincode, o.Name as OwnerName, o.Email, o.Phone " +
                    "FROM Cafe c " +
                    "JOIN Location l ON c.Location_id = l.Location_id " +
                    "JOIN Owner o ON c.Owner_id = o.Owner_id " +
                    "WHERE c.Cafe_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(cafeSql)) {
                stmt.setInt(1, cafeId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    dto.name = rs.getString("Name");
                    dto.website = rs.getString("Website");
                    dto.location = rs.getString("Address") + ", " + rs.getString("Area") + ", " + rs.getString("City") + " - " + rs.getString("Pincode");
                    dto.phone = rs.getString("Phone");
                }
            }

            // 2. Categories
            String catSql = "SELECT cat.Name FROM Category cat JOIN Cafe_Category cc ON cat.Category_id = cc.Category_id WHERE cc.Cafe_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(catSql)) {
                stmt.setInt(1, cafeId);
                ResultSet rs = stmt.executeQuery();
                List<String> categories = new ArrayList<>();
                while (rs.next()) {
                    categories.add(rs.getString("Name"));
                }
                dto.categories = String.join(", ", categories);
            }

            // 3. Bestsellers
            String bestSql = "SELECT b.Name FROM Bestseller b JOIN Cafe_Bestseller cb ON b.Bestseller_id = cb.Bestseller_id WHERE cb.Cafe_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(bestSql)) {
                stmt.setInt(1, cafeId);
                ResultSet rs = stmt.executeQuery();
                List<String> bestsellers = new ArrayList<>();
                while (rs.next()) {
                    bestsellers.add(rs.getString("Name"));
                }
                dto.bestsellers = String.join(", ", bestsellers);
            }

            // 4. Rating and reviews
            String ratingSql = "SELECT AVG(Rating) as avgRating, COUNT(*) as totalReviews FROM Review WHERE Cafe_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(ratingSql)) {
                stmt.setInt(1, cafeId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    dto.rating = String.format("%.1f", rs.getDouble("avgRating"));
                    dto.reviews = rs.getString("totalReviews");
                }
            }

            // 5. Image URL
            String imgSql = "SELECT Image_URL FROM Image WHERE Cafe_id = ? LIMIT 1";
            try (PreparedStatement stmt = conn.prepareStatement(imgSql)) {
                stmt.setInt(1, cafeId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    dto.imageUrl = rs.getString("Image_URL");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }
}
