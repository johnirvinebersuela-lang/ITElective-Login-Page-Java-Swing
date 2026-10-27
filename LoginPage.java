import java.awt.*;
import javax.swing.*;

public class LoginPage extends JFrame {
    private static final String VALID_USERNAME = "111";
    private static final String VALID_PASSWORD = "111";

    private final JTextField usernameField = new JTextField(18);
    private final JPasswordField passwordField = new JPasswordField(18);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }

    public LoginPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(8, 10, 8, 10);
        constraints.anchor = GridBagConstraints.LINE_START;

        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("Username:"), constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0;
        add(new JLabel("Password:"), constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        add(passwordField, constraints);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(event -> submitLogin());
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        add(loginButton, constraints);

        getRootPane().setDefaultButton(loginButton);
        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }

    private void submitLogin() {
        char[] password = passwordField.getPassword();

        try {
            String username = usernameField.getText().trim();

            if (username.isBlank() || password.length == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Enter both your username and password.",
                        "Missing information",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!VALID_USERNAME.equals(username)
                    || !java.util.Arrays.equals(password, VALID_PASSWORD.toCharArray())) {
                JOptionPane.showMessageDialog(
                        this,
                        "The username or password is incorrect.",
                        "Sign-in failed",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            new HomePage().setVisible(true);
            dispose();
        } catch (RuntimeException exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(
                    this,
                    "An unexpected error occurred. Please try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            java.util.Arrays.fill(password, '\0');
            passwordField.setText("");
        }
    }
}
