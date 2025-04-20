package backend.service;

import frontend.dashboard.Dashboard;
import backend.JDBC.DatabaseConnector;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Dashboard_service {

    Dashboard d;
    private List<String> cafeNames = new ArrayList<>();
    private List<String> imageUrls = new ArrayList<>();
    private List<String> rating = new ArrayList<>();
    private List<String> reviews = new ArrayList<>();

    private int currentIndex = 0;

    public Dashboard_service(Dashboard dashboardInstance) {
        this.d = dashboardInstance;
        loadCafeData();
    }

    private void loadCafeData() {
        String query = "SELECT c.Name AS cafe_name, MIN(i.Image_URL) AS image_url, c.Average_Rating as Rating, c.Total_Reviews as totalReview " +
                "FROM Cafe c " +
                "LEFT JOIN Image i ON c.Cafe_Id = i.Cafe_id " +
                "GROUP BY c.Cafe_Id";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                cafeNames.add(rs.getString("cafe_name"));
                imageUrls.add(rs.getString("image_url"));
                rating.add(rs.getString("Rating"));
                reviews.add(rs.getString("totalReview"));
            }

            if (!cafeNames.isEmpty()) {
                startSlideshow();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startSlideshow() {
        JLabel[] imageLabels = { d.jLabel2, d.jLabel3, d.jLabel4, d.jLabel6, d.jLabel9, d.jLabel10 };
        JTextField[] nameFields = { d.jTextField5, d.jTextField4, d.jTextField3, d.jTextField6, d.jTextField7, d.jTextField8 };
        JLabel[] ratingLabels={d.jLabel7, d.jLabel11, d.jLabel13, d.jLabel15, d.jLabel17, d.jLabel19};
        JLabel[] reviewLabels={d.jLabel8, d.jLabel12, d.jLabel14, d.jLabel16, d.jLabel18, d.jLabel21};


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    for (int i = 0; i < imageLabels.length; i++) {
                        int dataIndex = (currentIndex + i) % cafeNames.size();
                        nameFields[i].setText(cafeNames.get(dataIndex));
                        ratingLabels[i].setText(rating.get(dataIndex));
                        reviewLabels[i].setText("("+reviews.get(dataIndex)+")");

                        try {
                            String imageUrl = imageUrls.get(dataIndex);
                            ImageIcon icon = new ImageIcon(new URL(imageUrl));
                            Image img = icon.getImage();
                            Image resizedImage = img.getScaledInstance(imageLabels[i].getWidth(), imageLabels[i].getHeight(), Image.SCALE_SMOOTH);
                            imageLabels[i].setIcon(new ImageIcon(resizedImage));
                        } catch (Exception e) {
                            imageLabels[i].setText("No image");
                            imageLabels[i].setIcon(null);
                        }
                    }

                    currentIndex = (currentIndex + imageLabels.length) % cafeNames.size();
                });
            }
        }, 0, 3000); // every 3 seconds
    }
}
