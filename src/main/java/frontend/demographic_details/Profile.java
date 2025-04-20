package frontend.demographic_details;

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Profile extends JFrame {

    JSVGCanvas picCanvas;
    JTextField pnameField;
    JTextField PhonenoField;
    JTextField EmailField;
    JTextField passwordField;
    JTextField currpassField;
    JTextField newpassField;

    public Profile() {
        setTitle("Profile");
        setSize(800, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(161, 107, 68));
        setLayout(new BorderLayout());

        picCanvas = new JSVGCanvas();
        URL svgURL = getClass().getClassLoader().getResource("Assests/ellipse.svg");
        if (svgURL != null) {
            picCanvas.setURI(svgURL.toString());
        } else {
            System.err.println("SVG file not found!");
        }
        picCanvas.setPreferredSize(new Dimension(120, 120));
        picCanvas.setOpaque(false);
        picCanvas.setBackground(new Color(0, 0, 0, 0));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        topPanel.add(picCanvas);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Serif", Font.BOLD, 32));
        pnameField = new JTextField("John Doe");
        styleDisplayField(pnameField);


        JLabel phoneno = new JLabel("Phone Number");
        phoneno.setFont(new Font("Serif", Font.BOLD, 32));
        PhonenoField = new JTextField("+91 9876543210");
        styleDisplayField(PhonenoField);


        JLabel email = new JLabel("Email");
        email.setFont(new Font("Serif", Font.BOLD, 32));
        EmailField = new JTextField("john.doe@example.com");
        styleDisplayField(EmailField);


        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Serif", Font.BOLD, 32));
        passwordField = new JTextField("********");
        styleDisplayField(passwordField);


        JLabel changepass = new JLabel("Change Password");
        changepass.setFont(new Font("Serif", Font.BOLD, 24));
        changepass.setForeground(Color.WHITE);
        changepass.setAlignmentY(LEFT_ALIGNMENT);


        JPanel changepassPanel = new JPanel();
        changepassPanel.setBackground(new Color(62, 39, 35));
        changepassPanel.setPreferredSize(new Dimension(300, 180));
        changepassPanel.setMaximumSize(new Dimension(800, 180));
        changepassPanel.setMinimumSize(new Dimension(200, 180));
        changepassPanel.setLayout(new BoxLayout(changepassPanel, BoxLayout.Y_AXIS));
        changepassPanel.setAlignmentY(Component.CENTER_ALIGNMENT);


        JPanel currpasswordPanel = new JPanel();
        currpasswordPanel.setLayout(new BoxLayout(currpasswordPanel, BoxLayout.Y_AXIS));
        currpasswordPanel.setOpaque(false);
        currpasswordPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel currpass = new JLabel("Current password");
        currpass.setFont(new Font("Serif", Font.BOLD, 24));
        currpass.setForeground(Color.WHITE);
        currpass.setAlignmentX(Component.LEFT_ALIGNMENT);


        currpassField = new JPasswordField(20);
        currpassField.setBackground(new Color(62, 39, 35));
        currpassField.setForeground(Color.WHITE);
        currpassField.setMaximumSize(new Dimension(400, 45));
        currpassField.setAlignmentX(Component.LEFT_ALIGNMENT);
        currpassField.setCaretColor(Color.WHITE);
        currpassField.setFont(new Font("Serif", Font.PLAIN, 24));

        currpasswordPanel.add(currpass);
        currpasswordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        currpasswordPanel.add(currpassField);

        JPanel newpasswordPanel = new JPanel();
        newpasswordPanel.setLayout(new BoxLayout(newpasswordPanel, BoxLayout.Y_AXIS));
        newpasswordPanel.setOpaque(false);
        newpasswordPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel newpass = new JLabel("New password");
        newpass.setFont(new Font("Serif", Font.BOLD, 24));
        newpass.setForeground(Color.WHITE);
        newpass.setAlignmentX(Component.LEFT_ALIGNMENT);


        newpassField = new JPasswordField(20);
        newpassField.setBackground(new Color(62, 39, 35));
        newpassField.setForeground(Color.WHITE);
        newpassField.setMaximumSize(new Dimension(400, 45));
        newpassField.setAlignmentX(Component.LEFT_ALIGNMENT);
        newpassField.setCaretColor(Color.WHITE);
        newpassField.setFont(new Font("Serif", Font.PLAIN, 24));


        newpasswordPanel.add(newpass);
        newpasswordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        newpasswordPanel.add(newpassField);


        changepassPanel.add(currpasswordPanel);
        changepassPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        changepassPanel.add(newpasswordPanel);

        JButton resetpass = new JButton("Reset Password");
        resetpass.setFont(new Font("Serif",Font.BOLD,28));
        resetpass.setBackground(new Color(62, 39, 35));
        resetpass.setForeground(Color.WHITE);
        resetpass.setAlignmentY(Component.CENTER_ALIGNMENT);

        changepass.setAlignmentX(Component.CENTER_ALIGNMENT);
        changepassPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        addToMain(mainPanel, name, pnameField);
        addToMain(mainPanel, phoneno, PhonenoField);
        addToMain(mainPanel, email, EmailField);
        addToMain(mainPanel, pass, passwordField);
        mainPanel.add(changepass);
        mainPanel.add(changepassPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        mainPanel.add(resetpass);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE;

        centerWrapper.add(mainPanel, gbc);
        add(centerWrapper, BorderLayout.CENTER);

        setVisible(true);
    }

    private void styleDisplayField(JTextField field) {
        field.setEditable(false);
        field.setPreferredSize(new Dimension(500, 40));
        field.setMaximumSize(new Dimension(800, 40));
        field.setMinimumSize(new Dimension(400, 40));
        field.setCaretColor(Color.WHITE);
        field.setFont(new Font("Serif", Font.PLAIN, 24));
        field.setBorder(BorderFactory.createLineBorder(new Color(62, 39, 35), 3));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void addToMain(JPanel panel, JLabel label, JTextField field) {
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.setOpaque(false);
        wrapper.setAlignmentX(Component.LEFT_ALIGNMENT);

        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        wrapper.add(label);
        wrapper.add(Box.createRigidArea(new Dimension(0, 5)));
        wrapper.add(field);
        wrapper.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(wrapper);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Profile::new);
    }
}
