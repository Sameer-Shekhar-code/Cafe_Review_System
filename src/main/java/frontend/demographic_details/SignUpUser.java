package frontend.demographic_details;

import org.apache.batik.swing.JSVGCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class SignUpUser extends JFrame implements ActionListener{

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


        getContentPane().setBackground(new Color(161, 107, 68));
        setLayout(null);

        svgCanvas = new JSVGCanvas();
        URL svgURL = getClass().getClassLoader().getResource("Assests/svg1.svg");
        if (svgURL != null) {
            svgCanvas.setURI(svgURL.toString());
        } else {
            System.err.println("SVG file not found!");
        }
        svgCanvas.setBounds(0, 60, 900, 900);
        svgCanvas.setOpaque(false);
        svgCanvas.setBackground(new Color(0, 0, 0, 0));


        svgCanvas1 = new JSVGCanvas();
        URL svgURL1 = getClass().getClassLoader().getResource("Assests/svg2.svg");
        if (svgURL1 != null) {
            svgCanvas1.setURI(svgURL1.toString());
        } else {
            System.err.println("SVG file not found!");
        }
        svgCanvas1.setBounds(595, -170, 900, 900);
        svgCanvas1.setOpaque(false);
        svgCanvas1.setBackground(new Color(0, 0, 0, 0));

        JPanel SignUpBox = new JPanel();
        SignUpBox.setBounds(450, 100, 600, 650);
        SignUpBox.setBorder(BorderFactory.createLineBorder(new Color(62, 39, 35), 3));
        SignUpBox.setBackground(Color.WHITE);
        SignUpBox.setLayout(new BoxLayout(SignUpBox, BoxLayout.Y_AXIS));
        SignUpBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel PhonenoPanel = new JPanel();
        PhonenoPanel.setLayout(new BoxLayout(PhonenoPanel, BoxLayout.Y_AXIS));
        PhonenoPanel.setOpaque(false);
        PhonenoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel enterphoneno = new JLabel("Enter your Phone Number");
        enterphoneno.setFont(new Font("Serif", Font.BOLD, 24));
        enterphoneno.setAlignmentX(Component.LEFT_ALIGNMENT);

        PhonenoField = new JTextField(20);
        PhonenoField.setBackground(new Color(62, 39, 35));
        PhonenoField.setForeground(Color.WHITE);
        PhonenoField.setMaximumSize(new Dimension(400, 45));
        PhonenoField.setAlignmentX(Component.LEFT_ALIGNMENT);
        PhonenoField.setCaretColor(Color.WHITE);
        PhonenoField.setFont(new Font("Serif", Font.PLAIN, 24));

        PhonenoPanel.add(enterphoneno);
        PhonenoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        PhonenoPanel.add(PhonenoField);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.setOpaque(false);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel entername = new JLabel("Enter your Name");
        entername.setFont(new Font("Serif", Font.BOLD, 24));
        entername.setAlignmentX(Component.LEFT_ALIGNMENT);

        nameField = new JTextField(20);
        nameField.setBackground(new Color(62, 39, 35));
        nameField.setForeground(Color.WHITE);
        nameField.setMaximumSize(new Dimension(400, 45));
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameField.setCaretColor(Color.WHITE);
        nameField.setFont(new Font("Serif", Font.PLAIN, 24));

        namePanel.add(entername);
        namePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        namePanel.add(nameField);

        JPanel EmailPanel = new JPanel();
        EmailPanel.setLayout(new BoxLayout(EmailPanel, BoxLayout.Y_AXIS));
        EmailPanel.setOpaque(false);
        EmailPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel enteremail = new JLabel("Enter email");
        enteremail.setFont(new Font("Serif", Font.BOLD, 24));
        enteremail.setAlignmentX(Component.LEFT_ALIGNMENT);

        EmailField = new JTextField(20);
        EmailField.setBackground(new Color(62, 39, 35));
        EmailField.setForeground(Color.WHITE);
        EmailField.setMaximumSize(new Dimension(400, 45));
        EmailField.setAlignmentX(Component.LEFT_ALIGNMENT);
        EmailField.setCaretColor(Color.WHITE);
        EmailField.setFont(new Font("Serif", Font.PLAIN, 24));

        EmailPanel.add(enteremail);
        EmailPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        EmailPanel.add(EmailField);

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

        JPanel ConfirmpassPanel = new JPanel();
        ConfirmpassPanel.setLayout(new BoxLayout(ConfirmpassPanel, BoxLayout.Y_AXIS));
        ConfirmpassPanel.setOpaque(false);
        ConfirmpassPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel confirmpass = new JLabel("Confirm password");
        confirmpass.setFont(new Font("Serif", Font.BOLD, 24));
        confirmpass.setAlignmentX(Component.LEFT_ALIGNMENT);

        ConfirmpassField = new JPasswordField(20);
        ConfirmpassField.setBackground(new Color(62, 39, 35));
        ConfirmpassField.setForeground(Color.WHITE);
        ConfirmpassField.setMaximumSize(new Dimension(400, 45));
        ConfirmpassField.setAlignmentX(Component.LEFT_ALIGNMENT);
        ConfirmpassField.setCaretColor(Color.WHITE);
        ConfirmpassField.setFont(new Font("Serif", Font.PLAIN, 24));

        ConfirmpassPanel.add(confirmpass);
        ConfirmpassPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        ConfirmpassPanel.add(ConfirmpassField);


        SignUpButton = new JButton("SignUp");
        SignUpButton.setFont(new Font("Serif", Font.BOLD, 32));
        SignUpButton.setBackground(new Color(62, 39, 35));
        SignUpButton.setForeground(Color.WHITE);
        SignUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        SignUpButton.setMaximumSize(new Dimension(200, 60));

        SignUpButton.addActionListener(this);

        add(svgCanvas);
        add(svgCanvas1);

        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(namePanel);
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(PhonenoPanel);
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(EmailPanel);
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(passwordPanel);
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 20)));
        SignUpBox.add(ConfirmpassPanel);
        SignUpBox.add(Box.createRigidArea(new Dimension(0, 40)));
        SignUpBox.add(SignUpButton);

        add(SignUpBox);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        String name = nameField.getText();
        String password = new String(passwordField.getText());
        String phoneno = PhonenoField.getText();
        String email = EmailField.getText();
        String confirmpass = new String(ConfirmpassField.getText());
        if (e.getSource() == SignUpButton) {
            if (!name.isEmpty() && !password.isEmpty() && !phoneno.isEmpty() && !email.isEmpty() && !confirmpass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "SignUp Successful");
            } else if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter name");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter password");
            }else if(phoneno.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter phone Number");
            }else if(email.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter email");
            }else if(confirmpass.isEmpty()){
                JOptionPane.showMessageDialog(null, "Confirm password");
            }
        }
    }

    public static void main(String[] args) {
        new SignUpUser();
    }
}