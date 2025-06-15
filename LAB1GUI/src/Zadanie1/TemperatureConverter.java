package Zadanie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {

    private JTextField celsiusTextField;
    private JLabel resultLabel;
    private JButton convertButton;

    public TemperatureConverter() {
        super("Konwerter Celsjusz -> Farenheit");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label = new JLabel("Temperatura w °C:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = GridBagConstraints.EAST;
        add(label, gbc);

        celsiusTextField = new JTextField(10);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(celsiusTextField, gbc);

        convertButton = new JButton("Konwertuj");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(convertButton, gbc);

        resultLabel = new JLabel("Wynik pojawi się tutaj");
        gbc.gridy = 2;
        add(resultLabel, gbc);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Dopasowanie rozmiaru okna do komponentów
        setLocationRelativeTo(null); // Wyśrodkowanie okna na ekranie
    }

    private void convertTemperature() {
        try {
            String text = celsiusTextField.getText();
            double celsius = Double.parseDouble(text);
            double fahrenheit = celsius * 9 / 5 + 32;
            resultLabel.setText(String.format("%.2f °C = %.2f °F", celsius, fahrenheit));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Proszę wpisać poprawną wartość liczbową.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TemperatureConverter().setVisible(true);
        });
    }
}

