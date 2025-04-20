package frontend.review;

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Review extends JFrame {

    String userName;
    int rating;
    String timeStamp;

    public Review() {
        setTitle("Review");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(161, 107, 68));
        setLayout(new BorderLayout());

        JPanel reviewPanel = new JPanel();
        reviewPanel.setBackground(new Color(62, 39, 35));
        reviewPanel.setLayout(new BoxLayout(reviewPanel, BoxLayout.Y_AXIS));
        reviewPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(reviewPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(800, 700));
        add(scrollPane, BorderLayout.CENTER);

        try {
            URL imageUrl = new URL("https://lh3.googleusercontent.com/p/AF1QipO70JLlS1GPF7o_KyPJHLVro1yT6yaediO8lanM=s1360-w1360-h1020");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image scaledImage = imageIcon.getImage().getScaledInstance(700, 300, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            reviewPanel.add(Box.createVerticalStrut(30));
            reviewPanel.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel review = new JPanel();
        review.setLayout(new BoxLayout(review, BoxLayout.X_AXIS));
        review.setBackground(null);

        JLabel cafeName = new JLabel("Zen Cafe");
        cafeName.setFont(new Font("Serif", Font.BOLD, 40));
        cafeName.setForeground(Color.WHITE);
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

        JLabel rating = new JLabel("4.3(1254)");
        rating.setFont(new Font("Serif", Font.BOLD, 32));
        rating.setForeground(Color.WHITE);

        review.add(cafeName);
        review.add(Box.createHorizontalGlue());
        review.add(starLabel);
        review.add(rating);
        review.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 120));

        JTextField writeRev = new JTextField("Write a Review");
        writeRev.setPreferredSize(new Dimension(580, 100));
        writeRev.setMaximumSize(new Dimension(700, 110));
        writeRev.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        writeRev.setBackground(new Color(161, 107, 68));
        writeRev.setForeground(Color.WHITE);
        writeRev.setFont(new Font("Serif" , Font.BOLD , 32));
        writeRev.setFont(new Font("Serif", Font.PLAIN, 20));
        writeRev.setAlignmentX(Component.CENTER_ALIGNMENT);


        reviewPanel.add(Box.createVerticalStrut(2));
        reviewPanel.add(review);
        reviewPanel.add(Box.createVerticalStrut(10));
        reviewPanel.add(writeRev);
        reviewPanel.add(createReview());
        reviewPanel.add(Box.createVerticalStrut(5));
        reviewPanel.add(createReview());
        reviewPanel.add(Box.createVerticalStrut(5));
        reviewPanel.add(createReview());
        reviewPanel.add(Box.createVerticalStrut(5));
        reviewPanel.add(createReview());
        reviewPanel.add(Box.createVerticalStrut(5));
        reviewPanel.add(createReview());



        setVisible(true);
    }

    public Component createReview() {
        JPanel reviewPanel = new JPanel();
        reviewPanel.setLayout(new BoxLayout(reviewPanel, BoxLayout.X_AXIS));
        reviewPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        reviewPanel.setOpaque(false);

        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));
        outerPanel.setMaximumSize(new Dimension(1000, 150));
        outerPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment
        outerPanel.setOpaque(false);

        JLabel usernameLabel = new JLabel(userName);
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 22));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));

        ImageIcon starIcon = null;
        try {
            starIcon = new ImageIcon(new URL("https://cdn-icons-png.flaticon.com/512/1828/1828884.png"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Image img = starIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        starIcon = new ImageIcon(img);
        JLabel starLabel = new JLabel(starIcon);

        JLabel rateLabel = new JLabel(String.valueOf(rating));
        rateLabel.setFont(new Font("Serif", Font.BOLD, 24));
        rateLabel.setForeground(Color.YELLOW);
        rateLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

        JPanel rightGroup = new JPanel();
        rightGroup.setLayout(new BoxLayout(rightGroup, BoxLayout.X_AXIS));
        rightGroup.setOpaque(false);
        rightGroup.add(starLabel);
        rightGroup.add(rateLabel);

        reviewPanel.add(usernameLabel);
        reviewPanel.add(Box.createHorizontalGlue());
        reviewPanel.add(rightGroup);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setMaximumSize(new Dimension(1200, 1));
        separator.setForeground(Color.GRAY);

        outerPanel.add(reviewPanel);
        outerPanel.add(Box.createVerticalStrut(10));
        outerPanel.add(separator);

        return outerPanel;
    }


    public static void main(String[] args) {

        new Review();
    }
}
