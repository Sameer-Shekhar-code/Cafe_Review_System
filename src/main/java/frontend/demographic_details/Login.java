package frontend.demographic_details;

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import frontend.dashboard.Dashboard;

public class Login extends JFrame implements ActionListener {

    JTextField usernameField;
    JTextField passwordField;
    JButton loginButton;
    JSVGCanvas svgCanvas;
    JSVGCanvas svgCanvas1;

    public Login() {
        setTitle("Login");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(161, 107, 68));
        setLayout(null);

        svgCanvas = new JSVGCanvas();
        URL svgURL = getClass().getClassLoader().getResource("Assests/svg1.svg");
        if (svgURL != null) {
            svgCanvas.setURI(svgURL.toString());
        } else {
            System.err.println("SVG file not found!");
        }
        svgCanvas.setBounds(0, 10, 900, 900);
        svgCanvas.setOpaque(false);
        svgCanvas.setBackground(new Color(0, 0, 0, 0));
        add(svgCanvas);


        svgCanvas1 = new JSVGCanvas();
        URL svgURL1 = getClass().getClassLoader().getResource("Assests/svg2.svg");
        if (svgURL1 != null) {
            svgCanvas1.setURI(svgURL1.toString());
        } else {
            System.err.println("SVG file not found!");
        }
        svgCanvas1.setBounds(595, -175, 900, 900);
        svgCanvas1.setOpaque(false);
        svgCanvas1.setBackground(new Color(0, 0, 0, 0));
        add(svgCanvas1);


        JPanel loginBox = new JPanel();
        loginBox.setBounds(450, 140, 600, 450);
        loginBox.setBorder(BorderFactory.createLineBorder(new Color(62, 39, 35), 3));
        loginBox.setBackground(Color.WHITE);
        loginBox.setLayout(new BoxLayout(loginBox, BoxLayout.Y_AXIS));
        loginBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBox.setOpaque(true);
        loginBox.setVisible(true);

        JLabel title = new JLabel("Good vibes, great cafes. Come on in!");
        title.setFont(new Font("Serif", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.Y_AXIS));
        usernamePanel.setOpaque(false);
        usernamePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel entername = new JLabel("Enter username/Email");
        entername.setFont(new Font("Serif", Font.BOLD, 24));
        entername.setAlignmentX(Component.LEFT_ALIGNMENT);

        usernameField = new JTextField(20);
        usernameField.setBackground(new Color(62, 39, 35));
        usernameField.setForeground(Color.WHITE);
        usernameField.setMaximumSize(new Dimension(400, 45));
        usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameField.setCaretColor(Color.WHITE);
        usernameField.setFont(new Font("Serif", Font.PLAIN, 24));

        usernamePanel.add(entername);
        usernamePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        usernamePanel.add(usernameField);


        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        passwordPanel.setOpaque(false);
        passwordPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel enterpass = new JLabel("Enter password");
        enterpass.setFont(new Font("Serif", Font.BOLD, 24));
        enterpass.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordField = new JPasswordField(20);
        passwordField.setBackground(new Color(62, 39, 35));
        passwordField.setForeground(Color.WHITE);
        passwordField.setMaximumSize(new Dimension(400, 45));
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setFont(new Font("Serif", Font.PLAIN, 24));

        passwordPanel.add(enterpass);
        passwordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        passwordPanel.add(passwordField);


        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.BOLD, 32));
        loginButton.setBackground(new Color(62, 39, 35));
        loginButton.setForeground(Color.WHITE);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setMaximumSize(new Dimension(160, 55));
        loginButton.addActionListener(this);


        loginBox.add(Box.createRigidArea(new Dimension(0, 20)));
        loginBox.add(title);
        loginBox.add(Box.createRigidArea(new Dimension(0, 20)));
        loginBox.add(usernamePanel);
        loginBox.add(Box.createRigidArea(new Dimension(0, 20)));
        loginBox.add(passwordPanel);
        loginBox.add(Box.createRigidArea(new Dimension(0, 40)));
        loginBox.add(loginButton);


        add(loginBox);


        getContentPane().setComponentZOrder(loginBox, 0);

        loginButton.addActionListener(e -> {
            dispose();
            new Dashboard();
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getText());
        if (e.getSource() == loginButton) {
            if (!username.isEmpty() && !password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Login Successful");
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter username");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter password");
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
