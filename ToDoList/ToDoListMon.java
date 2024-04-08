import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;

public class ToDoListMon extends JFrame{

    //method
    public ToDoListMon(){

        //creating a frame
        setTitle("Monday ToDo List");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel label1 = new JLabel("Enter what to add to your todo list : ");
        label1.setBounds(20, 20, 250, 20);

        JTextField text1 = new JTextField();
        text1.setBounds(220, 20, 200, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(420, 20, 60, 20);

        
        JButton removeButton = new JButton("Remove");

        JButton buttonTuesday = new JButton(">Tuesday");
        buttonTuesday.setBounds(380, 400, 110, 25);

       //adding components to frame2 
        add(label1);
        add(text1);
        add(buttonTuesday);
        add(addButton);


        //add button that will create a checkbox and add text to it from user input
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = text1.getText();
                JCheckBox checkBox = new JCheckBox();
                checkBox.setText(text);
                checkBox.setSelected(false);
                checkBox.setBounds(20, getContentPane().getComponentCount() * 20 + 60, 300, 20); // X-position is set and Y-position keeps on changing
                add(checkBox);
                revalidate(); // Revalidate the frame to reflect changes
                repaint(); // Repaint the frame to reflect changes
                }
            });
            
        //this button will open  new window once its clicked
        buttonTuesday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == buttonTuesday){
        
                    new ToDoListTue();

                }
            }
        });

        setVisible(true);
    }

    
    
    public static void main(String[] args) {
        new ToDoListMon();
    }

}
