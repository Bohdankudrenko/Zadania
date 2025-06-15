package Zadanie1;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser; // pamiętaj dodać bibliotekę

public class KanbanApp extends JFrame {
    private DefaultListModel<Task> todoModel = new DefaultListModel<>();
    private DefaultListModel<Task> inProgressModel = new DefaultListModel<>();
    private DefaultListModel<Task> doneModel = new DefaultListModel<>();

    private JList<Task> todoList = new JList<>(todoModel);
    private JList<Task> inProgressList = new JList<>(inProgressModel);
    private JList<Task> doneList = new JList<>(doneModel);

    private JPopupMenu popupMenu;
    private JMenuItem deleteItem;
    private JMenuItem editItem;

    public KanbanApp() {
        setTitle("Kanban Project Manager");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(1, 3));
        boardPanel.add(createListPanel("TODO", todoList));
        boardPanel.add(createListPanel("IN PROGRESS", inProgressList));
        boardPanel.add(createListPanel("DONE", doneList));

        JButton addButton = new JButton("Add new task");
        addButton.addActionListener(e -> openTaskForm(null, todoModel));

        add(addButton, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);

        setupPopupMenu();
        setupDnD(todoList);
        setupDnD(inProgressList);
        setupDnD(doneList);
    }

    private JPanel createListPanel(String title, JList<Task> list) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        list.setCellRenderer(new TaskRenderer());
        list.setComponentPopupMenu(popupMenu);
        list.addMouseListener(new TaskMouseListener(list));
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        return panel;
    }

    private void setupPopupMenu() {
        popupMenu = new JPopupMenu();
        deleteItem = new JMenuItem("Delete");
        editItem = new JMenuItem("Edit");

        deleteItem.addActionListener(e -> deleteSelectedTask());
        editItem.addActionListener(e -> editSelectedTask());

        popupMenu.add(deleteItem);
        popupMenu.add(editItem);
    }

    private void deleteSelectedTask() {
        JList<Task> list = getSelectedList();
        if (list != null && !list.isSelectionEmpty()) {
            ((DefaultListModel<Task>) list.getModel()).removeElementAt(list.getSelectedIndex());
        }
    }

    private void editSelectedTask() {
        JList<Task> list = getSelectedList();
        if (list != null && !list.isSelectionEmpty()) {
            Task task = list.getSelectedValue();
            openTaskForm(task, (DefaultListModel<Task>) list.getModel());
        }
    }

    private void openTaskForm(Task task, DefaultListModel<Task> model) {
        JTextField titleField = new JTextField();
        JTextArea descArea = new JTextArea(3, 20);
        String[] priorities = {"Low", "Medium", "High"};
        JComboBox<String> priorityBox = new JComboBox<>(priorities);
        JDateChooser dateChooser = new JDateChooser();

        if (task != null) {
            titleField.setText(task.title);
            descArea.setText(task.description);
            priorityBox.setSelectedItem(task.priority);
            dateChooser.setDate(task.dueDate);
        }

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Description:"));
        panel.add(new JScrollPane(descArea));
        panel.add(new JLabel("Priority:"));
        panel.add(priorityBox);
        panel.add(new JLabel("Due Date:"));
        panel.add(dateChooser);

        int result = JOptionPane.showConfirmDialog(this, panel, task == null ? "Add Task" : "Edit Task",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            if (task == null) {
                Task newTask = new Task(titleField.getText(), descArea.getText(),
                        (String) priorityBox.getSelectedItem(), dateChooser.getDate());
                model.addElement(newTask);
            } else {
                task.title = titleField.getText();
                task.description = descArea.getText();
                task.priority = (String) priorityBox.getSelectedItem();
                task.dueDate = dateChooser.getDate();
                repaint();
            }
        }
    }

    private JList<Task> getSelectedList() {
        if (todoList.getSelectedIndex() != -1) return todoList;
        if (inProgressList.getSelectedIndex() != -1) return inProgressList;
        if (doneList.getSelectedIndex() != -1) return doneList;
        return null;
    }

    private void setupDnD(JList<Task> list) {
        list.setDragEnabled(true);
        list.setDropMode(DropMode.INSERT);
        list.setTransferHandler(new TaskTransferHandler());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KanbanApp().setVisible(true));
    }

    class Task {
        String title;
        String description;
        String priority;
        Date dueDate;

        Task(String title, String description, String priority, Date dueDate) {
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.dueDate = dueDate;
        }

        public String toString() {
            return title + " [" + priority + "]";
        }
    }

    class TaskRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Task task) {
                label.setToolTipText(task.description);
            }
            return label;
        }
    }

    class TaskMouseListener extends MouseAdapter {
        private final JList<Task> list;

        TaskMouseListener(JList<Task> list) {
            this.list = list;
        }

        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
                int index = list.locationToIndex(e.getPoint());
                list.setSelectedIndex(index);
            }
        }
    }

    class TaskTransferHandler extends TransferHandler {
        private Task task;

        public int getSourceActions(JComponent c) {
            return MOVE;
        }

        protected Transferable createTransferable(JComponent c) {
            JList<Task> list = (JList<Task>) c;
            task = list.getSelectedValue();
            return new StringSelection(task.toString());
        }

        protected void exportDone(JComponent c, Transferable t, int action) {
            if (action == MOVE) {
                ((DefaultListModel<Task>) ((JList<?>) c).getModel()).removeElement(task);
            }
        }

        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(DataFlavor.stringFlavor);
        }

        public boolean importData(TransferSupport support) {
            try {
                String title = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
                JList.DropLocation dl = (JList.DropLocation) support.getDropLocation();
                JList<Task> target = (JList<Task>) support.getComponent();
                DefaultListModel<Task> model = (DefaultListModel<Task>) target.getModel();
                model.add(dl.getIndex(), task);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
}

