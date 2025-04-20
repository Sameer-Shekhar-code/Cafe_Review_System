package frontend.demographic_details;

import backend.service.SignUpService;
import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;

public class SignUpUser extends JFrame implements ActionListener {

    JTextField nameField, phoneField, emailField;
    JPasswordField passwordField, confirmPasswordField;
    JButton signUpButton;
    JSVGCanvas svgCanvas, svgCanvas1;

    SignUpUser() {
        setTitle("SignUpUser");
        setSize(1500, 1100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Layered Pane to manage overlapping components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1500, 1100);
        add(layeredPane);

        // Background Panel
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 1500, 1100);
        backgroundPanel.setBackground(new Color(161, 107, 68));
        layeredPane.add(backgroundPanel, Integer.valueOf(0));
        backgroundPanel.setLayout(null);

        // SVG 1
        svgCanvas = new JSVGCanvas();
        URL svgURL = getClass().getClassLoader().getResource("Assests/svg1.svg");
        if (svgURL != null) {
            svgCanvas.setURI(svgURL.toString());
        } else {
            System.err.println("SVG file 1 not found!");
        }
        svgCanvas.setBounds(0, 60, 900, 900);
        svgCanvas.setOpaque(false);
        svgCanvas.setBackground(new Color(0, 0, 0, 0));
        layeredPane.add(svgCanvas, Integer.valueOf(1));

        // SVG 2
        svgCanvas1 = new JSVGCanvas();
        URL svgURL1 = getClass().getClassLoader().getResource("Assests/svg2.svg");
        if (svgURL1 != null) {
            svgCanvas1.setURI(svgURL1.toString());
        } else {
            System.err.println("SVG file 2 not found!");
        }
        svgCanvas1.setBounds(595, -170, 900, 900);
        svgCanvas1.setOpaque(false);
        svgCanvas1.setBackground(new Color(0, 0, 0, 0));
        layeredPane.add(svgCanvas1, Integer.valueOf(1));

        // SignUpBox Panel
        JPanel signUpBox = new JPanel();
        signUpBox.setBounds(450, 100, 600, 650);
        signUpBox.setBorder(BorderFactory.createLineBorder(new Color(62, 39, 35), 3));
        signUpBox.setBackground(Color.WHITE);
        signUpBox.setLayout(new BoxLayout(signUpBox, BoxLayout.Y_AXIS));
        layeredPane.add(signUpBox, Integer.valueOf(2));

        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        signUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        signUpBox.add(createInputPanel("Enter your Name", nameField));
        signUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        signUpBox.add(createInputPanel("Enter your Phone Number", phoneField));
        signUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        signUpBox.add(createInputPanel("Enter email", emailField));
        signUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        signUpBox.add(createInputPanel("Enter password", passwordField));
        signUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        signUpBox.add(createInputPanel("Confirm password", confirmPasswordField));
        signUpBox.add(Box.createRigidArea(new Dimension(0, 40)));

        signUpButton = new JButton("SignUp");
        signUpButton.setFont(new Font("Serif", Font.BOLD, 32));
        signUpButton.setBackground(new Color(62, 39, 35));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setMaximumSize(new Dimension(200, 60));
        signUpButton.addActionListener(this);
        signUpBox.add(signUpButton);

        setVisible(true);
    }

    // Moved method here
    private JPanel createInputPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Serif", Font.BOLD, 24));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        textField.setBackground(new Color(62, 39, 35));
        textField.setForeground(Color.WHITE);
        textField.setMaximumSize(new Dimension(400, 45));
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setCaretColor(Color.WHITE);
        textField.setFont(new Font("Serif", Font.PLAIN, 24));

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(textField);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String password = new String(passwordField.getPassword());
        String phoneNumber = phoneField.getText();  // Make sure you're getting 'phoneNumber' here
        String email = emailField.getText();
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (e.getSource() == signUpButton) {
            if (!name.isEmpty() && !password.isEmpty() && !phoneNumber.isEmpty() &&  // Correct variable 'phoneNumber'
                    !email.isEmpty() && !confirmPassword.isEmpty()) {

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(this, "Passwords do not match!");
                } else {
                    // Get the current date for 'Join_date'
                    Date joinDate = new Date(Calendar.getInstance().getTimeInMillis()); // Correct field for join date

                    SignUpService signUpService = new SignUpService();
                    boolean isRegistered = signUpService.registerUser(name, password, phoneNumber, email, "Customer", joinDate); // Passing correct params

                    if (isRegistered) {
                        JOptionPane.showMessageDialog(this, "SignUp Successful");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error occurred during SignUp");
                    }
                }

            } else {
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter name");
                } else if (phoneNumber.isEmpty()) {  // Correct check for phoneNumber
                    JOptionPane.showMessageDialog(this, "Enter phone number");
                } else if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter email");
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter password");
                } else if (confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Confirm password");
                }
            }
        }
    }

    public static void main(String[] args) {
        new SignUpUser();
    }
}
