package frontend.dashboard;

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CafeDetails extends JFrame {

    CafeDetails(){
        setTitle("CafeDetails");
        setSize(1500, 1100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(161, 107, 68));
        setLayout(null);

        JPanel cafePanel = new JPanel();
        cafePanel.setBackground(new Color(62, 39, 35));
        cafePanel.setBounds(300,50,800,1200);
        cafePanel.setLayout(new BoxLayout(cafePanel, BoxLayout.Y_AXIS));



        try {
            URL imageUrl = new URL("https://lh3.googleusercontent.com/p/AF1QipO70JLlS1GPF7o_KyPJHLVro1yT6yaediO8lanM=s1360-w1360-h1020");
            ImageIcon imageIcon = new ImageIcon(imageUrl);

            Image scaledImage = imageIcon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            cafePanel.add(Box.createVerticalStrut(30));
            cafePanel.add(imageLabel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel cafe = new JPanel();
        cafe.setLayout(new BoxLayout(cafe , BoxLayout.X_AXIS));
        cafe.setBackground(null);

        JLabel cafeName = new JLabel("Zen Cafe");
        cafeName.setFont(new Font("Serif", Font.BOLD, 40));
        cafeName.setForeground(Color.WHITE);
        cafeName.setAlignmentX(Component.RIGHT_ALIGNMENT);

        cafeName.setBorder(BorderFactory.createEmptyBorder(10, 100, 0, 0));

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
        rating.setAlignmentX(Component.LEFT_ALIGNMENT);
        rating.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 80));

        cafe.add(cafeName);
        cafe.add(Box.createHorizontalGlue());
        cafe.add(starLabel);
        cafe.add(rating);

        JLabel timing = new JLabel("Opens 9am Closes 10:30pm");
        timing.setFont(new Font("Serif", Font.BOLD, 24));
        timing.setForeground(Color.WHITE);
        timing.setAlignmentX(Component.RIGHT_ALIGNMENT);
        timing.setBorder(BorderFactory.createEmptyBorder(10,0,0,40));

        JLabel category = new JLabel("Continental");
        category.setFont(new Font("Serif", Font.BOLD, 24));
        category.setForeground(Color.WHITE);
        category.setAlignmentX(Component.RIGHT_ALIGNMENT);
        category.setBorder(BorderFactory.createEmptyBorder(10,0,0,200));

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setMaximumSize(new Dimension(700, 1));
        separator.setForeground(Color.WHITE);

        JLabel location = new JLabel("<html>Galaxy Garden, N Main Rd, Koregaon Park,<br>Pune, Maharashtra 411001</html>");
        location.setFont(new Font("Serif" , Font.BOLD, 24));
        location.setForeground(Color.WHITE);
        location.setAlignmentX(Component.RIGHT_ALIGNMENT);
        location.setBorder(BorderFactory.createEmptyBorder(10, 80, 0, 80));


        JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
        separator2.setMaximumSize(new Dimension(700, 1));
        separator2.setForeground(Color.WHITE);




        JLabel phoneno = new JLabel("9021712312");
        phoneno.setFont(new Font("Serif" , Font.BOLD, 28));
        phoneno.setForeground(Color.WHITE);
        phoneno.setAlignmentX(Component.RIGHT_ALIGNMENT);
        phoneno.setBorder(BorderFactory.createEmptyBorder(10,0,0,180));

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setMaximumSize(new Dimension(700, 1));
        separator1.setForeground(Color.WHITE);


        JLabel website = new JLabel("zencafe.co");
        website.setFont(new Font("Serif" , Font.BOLD, 28));
        website.setForeground(Color.WHITE);
        website.setAlignmentX(Component.RIGHT_ALIGNMENT);
        website.setBorder(BorderFactory.createEmptyBorder(10,0,0,180));

        JSeparator separator3 = new JSeparator(SwingConstants.HORIZONTAL);
        separator3.setMaximumSize(new Dimension(700, 1));
        separator3.setForeground(Color.WHITE);

        JLabel bestseller = new JLabel("BestSellers");
        bestseller.setFont(new Font("Serif" , Font.BOLD, 32));
        bestseller.setForeground(Color.WHITE);
        bestseller.setAlignmentX(Component.RIGHT_ALIGNMENT);
        bestseller.setBorder(BorderFactory.createEmptyBorder(10,0,0,180));

        JLabel items = new JLabel("Hummus with warm pita    Teriyaki tofu with soba noodles    Green burrito");
        items.setFont(new Font("Serif" , Font.BOLD, 32));
        items.setForeground(Color.WHITE);
        items.setAlignmentX(Component.RIGHT_ALIGNMENT);

        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(cafe);
        cafePanel.add(Box.createVerticalStrut(2));
        cafePanel.add(timing);
        cafePanel.add(Box.createVerticalStrut(2));
        cafePanel.add(category);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(separator);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(location);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(separator2);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(phoneno);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(separator1);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(website);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(separator3);
        cafePanel.add(Box.createVerticalStrut(10));
        cafePanel.add(bestseller);
        cafePanel.add(Box.createVerticalStrut(5));
        cafePanel.add(items);

        add(cafePanel);

        setVisible(true);


    }

    public static void main(String[] args){
        new CafeDetails();
    }
}