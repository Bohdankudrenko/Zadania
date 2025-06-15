package Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorApp extends JFrame {

    private JTextArea textArea;
    private JComboBox<String> colorCombo;
    private JButton boldButton, italicButton, decreaseButton, increaseButton;
    private int fontSize = 14;
    private boolean isBold = false;
    private boolean isItalic = false;

    public TextEditorApp() {
        setTitle("Edytor Tekstu");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Edytor tekstu
        textArea = new JTextArea();
        textArea.setBackground(Color.LIGHT_GRAY); // domyślny kolor tła
        textArea.setForeground(Color.BLACK);      // domyślny kolor tekstu
        textArea.setFont(new Font("Arial", Font.PLAIN, fontSize));
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Lista kolorów
        String[] colors = {"Czarny", "Czerwony", "Zielony", "Niebieski", "Pomarańczowy", "Różowy"};
        colorCombo = new JComboBox<>(colors);
        colorCombo.addActionListener(e -> changeTextColor());

        // Przyciski formatowania
        boldButton = new JButton("B");
        italicButton = new JButton("I");
        decreaseButton = new JButton("Z");
        increaseButton = new JButton("P");

        boldButton.addActionListener(e -> toggleBold());
        italicButton.addActionListener(e -> toggleItalic());
        decreaseButton.addActionListener(e -> changeFontSize(-1));
        increaseButton.addActionListener(e -> changeFontSize(1));

        // Panel górny (lista kolorów)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Kolor tekstu:"));
        topPanel.add(colorCombo);

        // Panel dolny (przyciski)
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(new JLabel("Styl:"));
        bottomPanel.add(boldButton);
        bottomPanel.add(italicButton);
        bottomPanel.add(decreaseButton);
        bottomPanel.add(increaseButton);

        // Rozkład
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void changeTextColor() {
        String selected = (String) colorCombo.getSelectedItem();
        switch (selected) {
            case "Czarny":
                textArea.setForeground(Color.BLACK); break;
            case "Czerwony":
                textArea.setForeground(Color.RED); break;
            case "Zielony":
                textArea.setForeground(Color.GREEN); break;
            case "Niebieski":
                textArea.setForeground(Color.BLUE); break;
            case "Pomarańczowy":
                textArea.setForeground(Color.ORANGE); break;
            case "Różowy":
                textArea.setForeground(Color.PINK); break;
        }
    }

    private void toggleBold() {
        isBold = !isBold;
        updateFont();
    }

    private void toggleItalic() {
        isItalic = !isItalic;
        updateFont();
    }

    private void changeFontSize(int change) {
        fontSize = Math.max(8, fontSize + change); // minimalny rozmiar 8
        updateFont();
    }

    private void updateFont() {
        int style = Font.PLAIN;
        if (isBold) style |= Font.BOLD;
        if (isItalic) style |= Font.ITALIC;
        textArea.setFont(new Font("Arial", style, fontSize));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditorApp().setVisible(true));
    }
}
