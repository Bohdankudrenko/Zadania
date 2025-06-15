package Zadanie2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerManager extends JFrame {
    private JTextField nameField, emailField, phoneField;
    private JButton addButton, clearButton, deleteButton;
    private JTable customerTable;
    private DefaultTableModel tableModel;

    public CustomerManager() {
        setTitle("Customer Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add New Customer"));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        addButton = new JButton("Add");
        clearButton = new JButton("Clear");
        formPanel.add(addButton);
        formPanel.add(clearButton);

        tableModel = new DefaultTableModel(new String[]{"Name", "Email", "Phone"}, 0);
        customerTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(customerTable);

        deleteButton = new JButton("Delete Selected");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(deleteButton);

        setLayout(new BorderLayout(10, 10));
        add(formPanel, BorderLayout.NORTH);
        add(tableScroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addCustomer());

        clearButton.addActionListener(e -> clearFields());

        deleteButton.addActionListener(e -> deleteSelectedCustomer());
    }

    private void addCustomer() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{name, email, phone});
        clearFields();
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }

    private void deleteSelectedCustomer() {
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this customer?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a customer to delete!", "No Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerManager().setVisible(true));
    }
}
