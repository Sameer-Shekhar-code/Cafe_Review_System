package frontend.dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import backend.service.CafeService;
import backend.DTO.CafeDetailsDTO;

public class CafeDetails extends JFrame {
    String URL;
    String cafeName2;
    String time;
    String cafeCategory;
    String cafeLocation;
    String cafeRating;
    String cafeReviews;
    String cafePhone;
    String cafeWebsite;
    String cafeBestsellers;
    CafeDetails() {
            // --- Fetch Data from Backend ---
            CafeService cafeService = new CafeService();
            CafeDetailsDTO data = cafeService.getCafeDetailsById(1); // Example Cafe_id

            // Assign fetched data to frontend fields
            this.cafeName2 = data.name;
            this.URL = data.imageUrl;
            this.cafeWebsite = data.website;
            this.cafePhone = data.phone;
            this.cafeLocation = data.location;
            this.cafeCategory = data.categories;
            this.cafeBestsellers = data.bestsellers;
            this.cafeRating = data.rating;
            this.cafeReviews = data.reviews;
            this.time = "9:00 AM - 10:00 PM"; // Placeholder, update if fetched

            // --- Continue with your UI setup as before ---
            setTitle("CafeDetails");
            setSize(1100, 700);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            setTitle("CafeDetails");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(161, 107, 68));
        setLayout(new BorderLayout());

        JPanel cafePanel = new JPanel();
        cafePanel.setBackground(new Color(62, 39, 35));
        cafePanel.setLayout(new BoxLayout(cafePanel, BoxLayout.Y_AXIS));
        cafePanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(cafePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(new Dimension(800, 700));

        add(scrollPane, BorderLayout.CENTER);

        try {
            URL imageUrl = new URL(URL);
            ImageIcon imageIcon = new ImageIcon(imageUrl);

            Image scaledImage = imageIcon.getImage().getScaledInstance(700, 300, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            cafePanel.add(Box.createVerticalStrut(30));
            cafePanel.add(imageLabel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel cafe = new JPanel();
        cafe.setLayout(new BoxLayout(cafe, BoxLayout.X_AXIS));
        cafe.setBackground(null);

        JLabel cafeName = new JLabel(cafeName2);
        cafeName.setFont(new Font("Serif", Font.BOLD, 40));
        cafeName.setForeground(Color.WHITE);
        cafeName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        cafeName.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 50));


        ImageIcon starIcon = null;
        try {
            starIcon = new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/512/1828/1828884.png"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Image img = starIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        starIcon = new ImageIcon(img);
        JLabel starLabel = new JLabel(starIcon);
        starLabel.setAlignmentX(LEFT_ALIGNMENT);

        JLabel rating = new JLabel(cafeRating+"("+cafeReviews+")");
        rating.setFont(new Font("Serif", Font.BOLD, 32));
        rating.setForeground(Color.WHITE);
        rating.setAlignmentX(Component.LEFT_ALIGNMENT);


        cafe.add(cafeName);
        cafe.add(Box.createHorizontalGlue());

        cafe.add(starLabel);
        cafe.add(rating);
        cafe.setAlignmentX(CENTER_ALIGNMENT);
        cafe.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 120));

        JLabel timing = new JLabel("Opening hours: "+time);
        timing.setFont(new Font("Serif", Font.BOLD, 24));
        timing.setForeground(Color.WHITE);
        timing.setAlignmentX(Component.RIGHT_ALIGNMENT);
        timing.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 85));

        JLabel category = new JLabel(cafeCategory);
        category.setFont(new Font("Serif", Font.BOLD, 24));
        category.setForeground(Color.WHITE);
        category.setAlignmentX(Component.RIGHT_ALIGNMENT);
        category.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 250));


        JLabel location = new JLabel(cafeLocation);
        location.setFont(new Font("Serif", Font.BOLD, 24));
        location.setForeground(Color.WHITE);
        location.setAlignmentX(Component.RIGHT_ALIGNMENT);
        location.setBorder(BorderFactory.createEmptyBorder(10, 100, 0, 100));
        scrollPane.setViewportView(cafePanel);

        JLabel phoneno = new JLabel(cafePhone);
        phoneno.setFont(new Font("Serif", Font.BOLD, 28));
        phoneno.setForeground(Color.WHITE);
        phoneno.setAlignmentX(Component.RIGHT_ALIGNMENT);
        phoneno.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 180));


        JLabel website = new JLabel(cafeWebsite);
        website.setFont(new Font("Serif", Font.BOLD, 28));
        website.setForeground(Color.WHITE);
        website.setAlignmentX(Component.RIGHT_ALIGNMENT);
        website.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 180));

        JLabel bestseller = new JLabel("BestSellers");
        bestseller.setFont(new Font("Serif", Font.BOLD, 32));
        bestseller.setForeground(Color.WHITE);
        bestseller.setAlignmentX(Component.RIGHT_ALIGNMENT);
        bestseller.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 200));

        JLabel items = new JLabel(cafeBestsellers);
        items.setFont(new Font("Serif", Font.BOLD, 24));
        items.setForeground(Color.WHITE);
        items.setAlignmentX(Component.RIGHT_ALIGNMENT);
        items.setBorder(BorderFactory.createEmptyBorder(10, 100, 0, 0));


        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(cafe);
        cafePanel.add(Box.createVerticalStrut(2));
        cafePanel.add(timing);
        cafePanel.add(Box.createVerticalStrut(2));
        cafePanel.add(category);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(createSeparator());
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(location);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(createSeparator());
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(phoneno);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(createSeparator());
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(website);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(createSeparator());
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(bestseller);
        cafePanel.add(Box.createVerticalStrut(0));
        cafePanel.add(items);

        scrollPane.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    System.out.println("Scrolling up");
                } else {
                    System.out.println("Scrolling down");
                }
            }
        });

        setVisible(true);
    }

    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setMaximumSize(new Dimension(900, 1));
        separator.setForeground(Color.WHITE);
        return separator;
    }


    public static void main(String[] args) {
        new CafeDetails();
    }
}