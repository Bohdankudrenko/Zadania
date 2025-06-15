package Zadanie1;

import javax.swing.*;
import java.awt.*;

public class ListTransferApp extends JFrame {

    private JList<String> list1, list2;
    private DefaultListModel<String> model1, model2;
    private JButton btn1, btnAll1, btn2, btnAll2;

    public ListTransferApp() {
        setTitle("Transfer List");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model1 = new DefaultListModel<>();
        model2 = new DefaultListModel<>();

        model1.addElement("Java");
        model1.addElement("Python");
        model1.addElement("C++");
        model1.addElement("JavaScript");

        list1 = new JList<>(model1);
        list2 = new JList<>(model2);

        btn1 = new JButton(">");
        btnAll1 = new JButton(">>");
        btn2 = new JButton("<");
        btnAll2 = new JButton("<<");

        JPanel listPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        listPanel.add(new JScrollPane(list1));
        listPanel.add(new JScrollPane(list2));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        buttonPanel.add(btn1);
        buttonPanel.add(btnAll1);
        buttonPanel.add(btn2);
        buttonPanel.add(btnAll2);

        setLayout(new BorderLayout(10, 10));
        add(new JLabel("  Lista 1:"), BorderLayout.WEST);
        add(listPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        btn1.addActionListener(e -> moveSelectedItem(model1, list1, model2));
        btn2.addActionListener(e -> moveSelectedItem(model2, list2, model1));

        btnAll1.addActionListener(e -> moveAllItems(model1, model2));
        btnAll2.addActionListener(e -> moveAllItems(model2, model1));
    }

    private void moveSelectedItem(DefaultListModel<String> fromModel, JList<String> fromList, DefaultListModel<String> toModel) {
        int selectedIndex = fromList.getSelectedIndex();
        if (selectedIndex != -1) {
            String item = fromModel.getElementAt(selectedIndex);
            fromModel.remove(selectedIndex);
            toModel.addElement(item);
        }
    }

    private void moveAllItems(DefaultListModel<String> fromModel, DefaultListModel<String> toModel) {
        for (int i = 0; i < fromModel.getSize(); i++) {
            toModel.addElement(fromModel.getElementAt(i));
        }
        fromModel.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListTransferApp().setVisible(true));
    }
}

