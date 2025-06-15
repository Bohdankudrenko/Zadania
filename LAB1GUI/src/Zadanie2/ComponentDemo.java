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

        // Layout okna
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        // JTextField z początkowym tekstem
        textField = new JTextField("Wpisz coś tutaj", 15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(textField, gbc);

        // JLabel z tekstem
        label = new JLabel("Etykieta pokazuje wpisany tekst");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(label, gbc);

        // Przycisk do pokazywania tekstu z pola tekstowego w etykiecie
        showTextButton = new JButton("Pokaż tekst");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(showTextButton, gbc);

        // Przycisk, który będzie włączał/wyłączał pole tekstowe i zmieniał swój tekst
        toggleButton = new JButton("Wyłącz pole tekstowe");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(toggleButton, gbc);

        // Dodajemy obsługę przycisków
        showTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pobieramy tekst z JTextField i ustawiamy w JLabel
                String text = textField.getText();
                label.setText("Wpisano: " + text);
            }
        });

        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Włączamy/wyłączamy pole tekstowe
                boolean enabled = textField.isEnabled();
                textField.setEnabled(!enabled);
                // Zmieniamy tekst przycisku odpowiednio
                toggleButton.setText(enabled ? "Włącz pole tekstowe" : "Wyłącz pole tekstowe");
            }
        });

        // Ustawienia okna
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

