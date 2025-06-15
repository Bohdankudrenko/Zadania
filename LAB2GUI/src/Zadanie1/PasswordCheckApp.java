package Zadanie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordCheckApp extends JFrame implements ActionListener {
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton okButton;

    public PasswordCheckApp() {
        super("Password Checker");

        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Enter password:"));
        passwordField1 = new JPasswordField(15);
        add(passwordField1);

        add(new JLabel("Confirm password:"));
        passwordField2 = new JPasswordField(15);
        add(passwordField2);

        okButton = new JButton("OK");
        okButton.addActionListener(this);
        add(okButton);

        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pass1 = new String(passwordField1.getPassword());
        String pass2 = new String(passwordField2.getPassword());

        if (!pass1.equals(pass2)) {
            JOptionPane.showMessageDialog(this, "Passwords are not matched!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!pass1.equals("codejava")) {
            JOptionPane.showMessageDialog(this, "Passwords matched but incorrect", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Password is correct!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasswordCheckApp());
    }
}

