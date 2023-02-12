package praktikum.java_swing_awt_todolist;             

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Action { 
    private ArrayList<String> TODOS = new ArrayList<>();
    private ToDoList toDoList;

    public Action(ToDoList toDoList) { 
        this.toDoList = toDoList;
        this.toDoList.setAddButton(new AddButtonListener());
        this.toDoList.setDeleteButton(new DeleteButtonListener());
    }
    
    class AddButtonListener implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            if (toDoList.getTodos().getText().isEmpty()) {
                // Display massage
                JOptionPane.showMessageDialog(null, "Tidak ada task yang ditambahkan", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                TODOS.add(toDoList.getTodos().getText());
                toDoList.getToDoList().setListData(TODOS.toArray(new String[0]));
                toDoList.getTodos().setText("");
                JOptionPane.showMessageDialog(null, "Task berhasil ditambahkan", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class DeleteButtonListener implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) { 
            if (TODOS.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tidak ada task yang dihapus", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                TODOS.remove(toDoList.getToDoList().getSelectedIndex());
                toDoList.getToDoList().setListData(TODOS.toArray(new String[0]));
                JOptionPane.showMessageDialog(null, "Task berhasil dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
            }   
        }
    }

    public static void main(String args[]) { 
        ToDoList toDoList = new ToDoList();
        Action action = new Action(toDoList);

        toDoList.setTitle("TP_PBO_MOD13_IF4409_1305210087_AFH");
        toDoList.setLocationRelativeTo(toDoList);
        toDoList.setVisible(true);
    }
}
