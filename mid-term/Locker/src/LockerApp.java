import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApp extends JFrame {

    private final JTextField passwordField;
    private final JLabel statusLabel;
    private String password = "";

    public LockerApp() {
        setTitle("Locker Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel passwordLabel = new JLabel("Enter Password:");
        add(passwordLabel);

        passwordField = new JTextField(10);
        add(passwordField);

        JButton setButton = new JButton("Enter");
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (password.isEmpty()) {
                    password = passwordField.getText();
                    statusLabel.setText("Password Set");
                } else {
                    String enteredPassword = passwordField.getText();
                    if (enteredPassword.equals(password)) {
                        statusLabel.setText("Correct Password");
                    } else {
                        statusLabel.setText("Incorrect Password");
                    }
                }
                passwordField.setText("");
            }
        });
        add(setButton);

        statusLabel = new JLabel("");
        add(statusLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LockerApp();
    }
}