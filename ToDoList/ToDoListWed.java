import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;


public class ToDoListWed extends JFrame{

    public ToDoListWed(){
        
        //creating a frame
        setTitle("Wednesday ToDo List");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.GREEN);

        JLabel label2 = new JLabel("Enter what to add to your todo list : ");
        label2.setBounds(20, 20, 250, 20);

        JTextField text2 = new JTextField();
        text2.setBounds(220, 20, 200, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(420, 20, 60, 20);
        JButton removeButton = new JButton("Remove");

        JButton buttonThurssday = new JButton(">Thursday");
        buttonThurssday.setBounds(380, 400, 100, 25);

        JButton backButton = new JButton("Back<");
        backButton.setBounds(300, 400, 70, 25);

    

       //adding components to frame2 
        add(label2);
        add(text2);
        add(buttonThurssday);
        add(addButton);
        add(backButton);
        


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = text2.getText();
                JCheckBox checkBox = new JCheckBox();
                checkBox.setText(text);
                checkBox.setSelected(false);
                checkBox.setBounds(20, getContentPane().getComponentCount() * 20 + 60, 300, 20); // X-position is set and Y-position keeps on changing
                add(checkBox);
                revalidate(); // Revalidate the frame to reflect changes
                repaint(); // Repaint the frame to reflect changes
                }
            });
            

        buttonThurssday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == buttonThurssday){
                
                    new ToDoListThu();
                    
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == backButton){
                    dispose();
                    new ToDoListTue();
                    
                }
            }
        });

        setVisible(true);
    }

    
    
    public static void main(String[] args) {
        new ToDoListWed();
    }

}
