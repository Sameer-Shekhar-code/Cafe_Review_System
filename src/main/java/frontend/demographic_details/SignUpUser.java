package frontend.demographic_details;

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SignUpUser extends JFrame implements ActionListener {

    JTextField nameField;
    JTextField passwordField;
    JTextField PhonenoField;
    JTextField EmailField;
    JTextField ConfirmpassField;
    JButton SignUpButton;
    JSVGCanvas svgCanvas;
    JSVGCanvas svgCanvas1;

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
        JPanel SignUpBox = new JPanel();
        SignUpBox.setBounds(450, 100, 600, 650);
        SignUpBox.setBorder(BorderFactory.createLineBorder(new Color(62, 39, 35), 3));
        SignUpBox.setBackground(Color.WHITE);
        SignUpBox.setLayout(new BoxLayout(SignUpBox, BoxLayout.Y_AXIS));
        layeredPane.add(SignUpBox, Integer.valueOf(2));

        nameField = new JTextField(20);
        PhonenoField = new JTextField(20);
        EmailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        ConfirmpassField = new JPasswordField(20);

        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(createInputPanel("Enter your Name", nameField));
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(createInputPanel("Enter your Phone Number", PhonenoField));
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(createInputPanel("Enter email", EmailField));
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(createInputPanel("Enter password", passwordField));
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(createInputPanel("Confirm password", ConfirmpassField));
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 40)));

        SignUpButton = new JButton("SignUp");
        SignUpButton.setFont(new Font("Serif", Font.BOLD, 32));
        SignUpButton.setBackground(new Color(62, 39, 35));
        SignUpButton.setForeground(Color.WHITE);
        SignUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        SignUpButton.setMaximumSize(new Dimension(200, 60));
        SignUpButton.addActionListener(this);
        SignUpBox.add(SignUpButton);

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
        String password = passwordField.getText();
        String phoneno = PhonenoField.getText();
        String email = EmailField.getText();
        String confirmpass = ConfirmpassField.getText();

        if (e.getSource() == SignUpButton) {
            if (!name.isEmpty() && !password.isEmpty() && !phoneno.isEmpty() &&
                    !email.isEmpty() && !confirmpass.isEmpty()) {

                if (!password.equals(confirmpass)) {
                    JOptionPane.showMessageDialog(this, "Passwords do not match!");
                } else {
                    JOptionPane.showMessageDialog(this, "SignUp Successful");
                }

            } else if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter name");
            } else if (phoneno.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter phone Number");
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter email");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter password");
            } else if (confirmpass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Confirm password");
            }
        }
    }

    public static void main(String[] args) {
        new SignUpUser();
    }
}
