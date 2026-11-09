import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public static void main(String[] args) {
        LoginPage frame = new LoginPage();
        frame.setVisible(true);
    }

    public LoginPage() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);

        c.gridx = 0; 
        c.gridy = 0; 
        add(new JLabel("Username:"), c);

        c.gridx = 1;
        c.gridy = 0;
        usernameField = new JTextField(15);
        add(usernameField, c);

        c.gridx = 0; 
        c.gridy = 1; 
        add(new JLabel("Password:"), c);

        c.gridx = 1; 
        c.gridy = 1; 
        passwordField = new JPasswordField(15);
        add(passwordField, c);

        c.gridx = 0; 
        c.gridy = 2; 
        c.gridwidth = 2; 
        loginButton = new JButton("Login");
        add(loginButton, c);

        
        pack(); 
        setLocationRelativeTo(null); 

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword()); // Clean beginner approach to get text

        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(this, "Enter both your username and password.");
        } 
        else if (username.equals("111") && password.equals("111")) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new HomePage().setVisible(true);
            dispose();
        } 
        else {
            JOptionPane.showMessageDialog(this, "The username or password is incorrect.");
            passwordField.setText(""); 
        }
    }
}