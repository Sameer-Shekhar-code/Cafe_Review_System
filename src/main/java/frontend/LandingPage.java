package frontend;

import frontend.demographic_details.Login;
import frontend.demographic_details.SignUp;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LandingPage extends JFrame {

    public LandingPage() {
        setTitle("Landing Page");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(161, 107, 68));
        setLayout(null);

        URL imageUrl = getClass().getResource("/Assests/image.png"); // leading slash
        if (imageUrl != null) {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setBounds(0, -40, imageIcon.getIconWidth(), imageIcon.getIconHeight());

            add(imageLabel);


        } else {
            System.out.println("Image not found at /Assests/image.png");
        }

        JLabel header = new JLabel("<html> Inviting all the Coffee Lovers <br>& Café Enthusiasts!</html>");
        header.setFont(new Font("Serif",Font.BOLD,56));
        header.setForeground(Color.BLACK);
        header.setBounds(680, 10, 1000, 200);
        add(header);

        JLabel subheader = new JLabel("<html>Love café hopping?<br>Explore spots, share reviews, snap pics, and vibe <br>with coffee lovers Sip. Snap. Share. <br>Your next fave café awaits!</html>");
        subheader.setFont(new Font("Serif",Font.PLAIN,40));
        subheader.setForeground(Color.WHITE);
        subheader.setBounds(680, 140, 1000, 300);
        add(subheader);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.BOLD, 32));
        loginButton.setBackground(new Color(62, 39, 35));
        loginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(1000, 450, 180, 70);
        add(loginButton);

        JButton SignUpButton = new JButton("SignUp");
        SignUpButton.setFont(new Font("Serif", Font.BOLD, 32));
        SignUpButton.setBackground(new Color(62, 39, 35));
        SignUpButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        SignUpButton.setForeground(Color.WHITE);
        SignUpButton.setBounds(1000, 550, 180, 70);
        add(SignUpButton);

        loginButton.addActionListener(e -> {
            dispose();
            new Login();
        });

        SignUpButton.addActionListener(e -> {
            dispose();
            new SignUp();
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LandingPage::new);
    }
}
