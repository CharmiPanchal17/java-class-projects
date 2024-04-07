import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;

public class ToDoListTue extends JFrame{

    public ToDoListTue(){
        
        //creating a frame
        setTitle("Tuesday ToDo List");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLUE);

        JLabel label2 = new JLabel("Enter what to add to your todo list : ");
        label2.setBounds(20, 20, 250, 20);

        JTextField text2 = new JTextField();
        text2.setBounds(220, 20, 200, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(420, 20, 60, 20);
        JButton removeButton = new JButton("Remove");

        JButton buttonWednesday = new JButton(">Wednesday");
        buttonWednesday.setBounds(380, 400, 110, 25);

       //adding components to frame2 
        add(label2);
        add(text2);
        add(buttonWednesday);
        add(addButton);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = text2.getText();
                JCheckBox checkBox = new JCheckBox();
                checkBox.setText(text);
                checkBox.setSelected(true);
                checkBox.setBounds(20, getContentPane().getComponentCount() * 20 + 60, 300, 20); // X-position is set and Y-position keeps on changing
                add(checkBox);
                revalidate(); // Revalidate the frame to reflect changes
                repaint(); // Repaint the frame to reflect changes
                }
            });
            

        buttonWednesday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == buttonWednesday){

                    ToDoListWed frame2 = new ToDoListWed();
                }
            }
        });

        setVisible(true);
    }

    
    
    public static void main(String[] args) {
        new ToDoListTue();
    }

}
