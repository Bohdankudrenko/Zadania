package Zadanie1;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ContactsApp {

    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> contactList;
    private JTextField nameField, emailField, phoneField, addressField, dobField;
    private JLabel ageLabel;
    private JButton saveNewButton, saveExistingButton;

    private Map<String, Contact> contacts = new LinkedHashMap<>();
    private String selectedContact = null;

    public ContactsApp() {
        frame = new JFrame("Contacts Project");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Lista kontaktów
        listModel = new DefaultListModel<>();
        contactList = new JList<>(listModel);
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(contactList);
        listScrollPane.setPreferredSize(new Dimension(180, 0));

        // Formularz
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        JLabel title = new JLabel("Contacts Project");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.GRAY);

        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        dobField = new JTextField();
        ageLabel = new JLabel("0 years");

        saveNewButton = new JButton("Save New");
        saveExistingButton = new JButton("Save Existing");
        saveExistingButton.setEnabled(false);

        formPanel.add(new JLabel("Name"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("e-mail"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Phone number"));
        formPanel.add(phoneField);
        formPanel.add(new JLabel("Address"));
        formPanel.add(addressField);
        formPanel.add(new JLabel("Date of birth (yyyy-MM-dd)"));
        formPanel.add(dobField);
        formPanel.add(new JLabel("Age"));
        formPanel.add(ageLabel);
        formPanel.add(saveNewButton);
        formPanel.add(saveExistingButton);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(title, BorderLayout.NORTH);
        rightPanel.add(formPanel, BorderLayout.CENTER);

        frame.add(listScrollPane, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.CENTER);

        // Obsługa zdarzeń
        contactList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                selectedContact = contactList.getSelectedValue();
                if (selectedContact != null && contacts.containsKey(selectedContact)) {
                    Contact c = contacts.get(selectedContact);
                    nameField.setText(c.name);
                    emailField.setText(c.email);
                    phoneField.setText(c.phone);
                    addressField.setText(c.address);
                    dobField.setText(c.dob);
                    ageLabel.setText(c.getAge() + " years");
                    saveExistingButton.setEnabled(true);
                }
            }
        });

        saveNewButton.addActionListener(e -> {
            String name = nameField.getText();
            if (name.isEmpty()) return;

            Contact newContact = new Contact(
                    name,
                    emailField.getText(),
                    phoneField.getText(),
                    addressField.getText(),
                    dobField.getText()
            );
            contacts.put(name, newContact);
            listModel.addElement(name);
            clearForm();
        });

        saveExistingButton.addActionListener(e -> {
            if (selectedContact != null && contacts.containsKey(selectedContact)) {
                Contact updated = new Contact(
                        nameField.getText(),
                        emailField.getText(),
                        phoneField.getText(),
                        addressField.getText(),
                        dobField.getText()
                );
                contacts.put(selectedContact, updated);
                int index = contactList.getSelectedIndex();
                listModel.set(index, updated.name);
                if (!selectedContact.equals(updated.name)) {
                    contacts.remove(selectedContact);
                }
                selectedContact = updated.name;
                ageLabel.setText(updated.getAge() + " years");
            }
        });

        // Dane przykładowe
        addSampleData();

        // Pokaż okno
        frame.setVisible(true);
    }

    private void addSampleData() {
        addContact(new Contact("Jan Kowalski", "jan@xyz.com", "123456789", "Warsaw", "1990-01-01"));
        addContact(new Contact("Marian Nowak", "marian@xyz.com", "111222333", "Krakow", "1985-05-15"));
        addContact(new Contact("Janina Urban", "janina@xyz.com", "444555666", "Lodz", "2000-12-12"));
        addContact(new Contact("Ewelina Nowak-Maciag", "ewelina@xyz.com", "777888999", "Gdansk", "1995-07-07"));
    }

    private void addContact(Contact c) {
        contacts.put(c.name, c);
        listModel.addElement(c.name);
    }

    private void clearForm() {
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
        dobField.setText("");
        ageLabel.setText("0 years");
        selectedContact = null;
        contactList.clearSelection();
        saveExistingButton.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContactsApp::new);
    }

    static class Contact {
        String name, email, phone, address, dob;

        public Contact(String name, String email, String phone, String address, String dob) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.dob = dob;
        }

        public int getAge() {
            try {
                LocalDate birthDate = LocalDate.parse(dob);
                return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
            } catch (Exception e) {
                return 0;
            }
        }
    }
}
