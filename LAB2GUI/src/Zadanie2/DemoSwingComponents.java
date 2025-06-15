package Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoSwingComponents extends JFrame implements ActionListener {
    // JTextArea + przyciski font
    private JTextArea textArea;
    private JButton btnBold, btnItalic, btnPlain, btnInsert, btnAppend, btnSetRowsCols;

    // JPasswordField + info
    private JPasswordField passwordField;
    private JButton btnCheckPassword;
    private JLabel passwordInfoLabel;

    // JRadioButton - systemy
    private JRadioButton rbWindows, rbLinux, rbMac;
    private ButtonGroup systemGroup;
    private JLabel systemLabel;
    private JButton btnShowSystem;

    // JCheckBox - kursy
    private JCheckBox cbJava, cbPython, cbWeb;
    private JButton btnShowPrice;

    public DemoSwingComponents() {
        super("Demo Swing Components");
        setLayout(new BorderLayout());

        // PANEL TEXT AREA + CONTROLS
        JPanel panelTextArea = new JPanel(new BorderLayout());
        textArea = new JTextArea("Please write something...", 5, 20);
        textArea.setFont(new Font("Serif", Font.PLAIN, 14));
        panelTextArea.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelTextButtons = new JPanel(new GridLayout(2, 3, 5, 5));
        btnBold = new JButton("Bold");
        btnItalic = new JButton("Italic");
        btnPlain = new JButton("Plain");
        btnInsert = new JButton("Insert Text");
        btnAppend = new JButton("Append Text");
        btnSetRowsCols = new JButton("Set Rows/Cols");

        btnBold.addActionListener(this);
        btnItalic.addActionListener(this);
        btnPlain.addActionListener(this);
        btnInsert.addActionListener(this);
        btnAppend.addActionListener(this);
        btnSetRowsCols.addActionListener(this);

        panelTextButtons.add(btnBold);
        panelTextButtons.add(btnItalic);
        panelTextButtons.add(btnPlain);
        panelTextButtons.add(btnInsert);
        panelTextButtons.add(btnAppend);
        panelTextButtons.add(btnSetRowsCols);

        panelTextArea.add(panelTextButtons, BorderLayout.SOUTH);

        // PANEL PASSWORD
        JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPassword.setBorder(BorderFactory.createTitledBorder("Password Field Demo"));
        panelPassword.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        panelPassword.add(passwordField);
        btnCheckPassword = new JButton("Check Length");
        btnCheckPassword.addActionListener(this);
        panelPassword.add(btnCheckPassword);
        passwordInfoLabel = new JLabel("Length: 0");
        panelPassword.add(passwordInfoLabel);

        // PANEL RADIO BUTTONS (Systemy)
        JPanel panelRadio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRadio.setBorder(BorderFactory.createTitledBorder("Select System"));
        rbWindows = new JRadioButton("Windows");
        rbLinux = new JRadioButton("Linux");
        rbMac = new JRadioButton("Mac");
        systemGroup = new ButtonGroup();
        systemGroup.add(rbWindows);
        systemGroup.add(rbLinux);
        systemGroup.add(rbMac);
        panelRadio.add(rbWindows);
        panelRadio.add(rbLinux);
        panelRadio.add(rbMac);
        btnShowSystem = new JButton("Show System");
        btnShowSystem.addActionListener(this);
        panelRadio.add(btnShowSystem);
        systemLabel = new JLabel("Selected: None");
        panelRadio.add(systemLabel);

        // PANEL CHECKBOX (Kursy)
        JPanel panelCheckbox = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCheckbox.setBorder(BorderFactory.createTitledBorder("Select Courses"));
        cbJava = new JCheckBox("Java ($100)");
        cbPython = new JCheckBox("Python ($120)");
        cbWeb = new JCheckBox("Web Dev ($90)");
        panelCheckbox.add(cbJava);
        panelCheckbox.add(cbPython);
        panelCheckbox.add(cbWeb);
        btnShowPrice = new JButton("Show Price");
        btnShowPrice.addActionListener(this);
        panelCheckbox.add(btnShowPrice);

        // POŁĄCZENIE PANELI
        JPanel panelTop = new JPanel(new GridLayout(3, 1));
        panelTop.add(panelPassword);
        panelTop.add(panelRadio);
        panelTop.add(panelCheckbox);

        add(panelTop, BorderLayout.NORTH);
        add(panelTextArea, BorderLayout.CENTER);

        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // JTextArea - zmiana fontu
        if (src == btnBold) {
            textArea.setFont(new Font("Serif", Font.BOLD, 14));
        } else if (src == btnItalic) {
            textArea.setFont(new Font("Serif", Font.ITALIC, 14));
        } else if (src == btnPlain) {
            textArea.setFont(new Font("Serif", Font.PLAIN, 14));
        } else if (src == btnInsert) {
            textArea.insert("[INSERTED TEXT]", 0);  // wstaw na początek
        } else if (src == btnAppend) {
            textArea.append(" [APPENDED TEXT]");
        } else if (src == btnSetRowsCols) {
            textArea.setRows(10);
            textArea.setColumns(30);
            // Odśwież layout by zmiany były widoczne:
            textArea.revalidate();
        }

        // JPasswordField - długość hasła
        else if (src == btnCheckPassword) {
            int length = passwordField.getPassword().length;
            passwordInfoLabel.setText("Length: " + length);
        }

        // JRadioButton - pokazanie wybranego systemu
        else if (src == btnShowSystem) {
            if (rbWindows.isSelected()) {
                systemLabel.setText("Selected: Windows");
            } else if (rbLinux.isSelected()) {
                systemLabel.setText("Selected: Linux");
            } else if (rbMac.isSelected()) {
                systemLabel.setText("Selected: Mac");
            } else {
                systemLabel.setText("Selected: None");
            }
        }

        // JCheckBox - sumaryczna cena kursów
        else if (src == btnShowPrice) {
            int price = 0;
            StringBuilder courses = new StringBuilder("Courses selected: ");

            if (cbJava.isSelected()) {
                price += 100;
                courses.append("Java ");
            }
            if (cbPython.isSelected()) {
                price += 120;
                courses.append("Python ");
            }
            if (cbWeb.isSelected()) {
                price += 90;
                courses.append("Web Dev ");
            }

            if (price == 0) {
                JOptionPane.showMessageDialog(this, "No courses selected!");
            } else {
                JOptionPane.showMessageDialog(this,
                        courses.toString() + "\nTotal price: $" + price);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DemoSwingComponents::new);
    }
}

