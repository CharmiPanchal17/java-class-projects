import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class ToDoListWeekend extends JFrame{

    public ToDoListWeekend(){
        
        //creating a frame
        setTitle("Weekend ToDo List");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.ORANGE);

        JLabel label2 = new JLabel("Enter what to add to your todo list : ");
        label2.setBounds(20, 20, 250, 20);

        JTextField text2 = new JTextField();
        text2.setBounds(220, 20, 200, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(420, 20, 60, 20);
        JButton removeButton = new JButton("Remove");

        JButton buttonDay = new JButton("Monday<");
        buttonDay.setBounds(380, 400, 100, 25);

       //adding components to frame2 
        add(label2);
        add(text2);
        add(buttonDay);
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
            

        buttonDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == buttonDay){

                    ToDoListMon frame2 = new ToDoListMon();
                }
            }
        });

        setVisible(true);
    }

    
    
    public static void main(String[] args) {
        new ToDoListWeekend();
    }

}

