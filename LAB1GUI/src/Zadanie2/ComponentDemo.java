package Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentDemo extends JFrame {

    private JTextField textField;
    private JLabel label;
    private JButton toggleButton;
    private JButton showTextButton;

    public ComponentDemo() {
        super("Demo komponentów Swing");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        textField = new JTextField("Wpisz coś tutaj", 15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(textField, gbc);

        label = new JLabel("Etykieta pokazuje wpisany tekst");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(label, gbc);

        showTextButton = new JButton("Pokaż tekst");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(showTextButton, gbc);

        toggleButton = new JButton("Wyłącz pole tekstowe");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(toggleButton, gbc);

        showTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                label.setText("Wpisano: " + text);
            }
        });

        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean enabled = textField.isEnabled();
                textField.setEnabled(!enabled);
                toggleButton.setText(enabled ? "Włącz pole tekstowe" : "Wyłącz pole tekstowe");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ComponentDemo().setVisible(true);
        });
    }
}

