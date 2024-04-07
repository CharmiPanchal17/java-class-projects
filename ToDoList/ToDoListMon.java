import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;

public class ToDoListMon extends JFrame{
    
    public static void main(String[] args) {
        
        //creating a frame
        JFrame frame1 = new JFrame("Monday ToDo List");
        frame1.setSize(500,500);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        frame1.getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel label1 = new JLabel("Enter what to add to your todo list : ");
        label1.setBounds(20, 20, 250, 20);

        JTextField text1 = new JTextField();
        text1.setBounds(220, 20, 200, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(420, 20, 60, 20);
        JButton removeButton = new JButton("Remove");

        JButton buttonTuesday = new JButton(">Tuesday");
        buttonTuesday.setBounds(380, 400, 90, 25);

       //adding components to frame1 
        frame1.add(label1);
        frame1.add(text1);
        frame1.add(buttonTuesday);
        frame1.add(addButton);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = text1.getText();
                JCheckBox checkBox = new JCheckBox();
                checkBox.setText(text);
                checkBox.setSelected(true);
                checkBox.setBounds(20, frame1.getContentPane().getComponentCount() * 20 + 60, 300, 20); // X-position is set and Y-position keeps on changing
                frame1.add(checkBox);
                frame1.revalidate(); // Revalidate the frame to reflect changes
                frame1.repaint(); // Repaint the frame to reflect changes
                }
            });
            

        buttonTuesday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == buttonTuesday){

                    ToDoListTue frame2 = new ToDoListTue();
                    frame2.setVisible(true);
                }
            }
        });

        frame1.setVisible(true);
    }
}
