import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class ToDoListMon extends JFrame{

    //method
    public ToDoListMon(){

        //creating a frame
        setTitle("Monday ToDo List");
        setSize(560,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(0xE8F8FC));

        JLabel label1 = new JLabel("Enter what to add to your todo list : ");
        label1.setBounds(20, 20, 250, 20);

        JTextField text1 = new JTextField();
        text1.setBounds(220, 20, 200, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(420, 20, 110, 20);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(420, 45, 110, 20);

        JButton buttonTuesday = new JButton(">Tuesday");
        buttonTuesday.setBounds(420, 400, 110, 25);

        JButton saveToFile = new JButton("Save");
        saveToFile.setBounds(420, 370, 110, 25);

        JButton retrieveFile = new JButton("Retrieve");
        retrieveFile.setBounds(420, 340, 110, 25);

       //adding components to frame2 
        add(label1);
        add(text1);
        add(buttonTuesday);
        add(addButton);
        add(removeButton);
        add(saveToFile);
        add(retrieveFile);


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


        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] components = getContentPane().getComponents();  //this gets all components from the frame ie labels, buttons, checkboxes etc.
                for (Component component : components) {       //this will iterate over each and every component
                    if (component instanceof JCheckBox) {     // this will check if the current component is a checkbox
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {         //this will check if the checkbox if it is selected
                            remove(checkBox);                //if the checkbox is selected, it will remove it from the list
                        }
                    }
                }
                revalidate(); 
                repaint(); 
            }
        });
            
        //this button will open  new window once its clicked
        buttonTuesday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == buttonTuesday){
                    dispose();
                    new ToDoListTue();

                }
            }
        });

        // adding what is typed to a file when save button is clicked
        saveToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Output_Mon.txt"));
                    
                    for (Component component : getContentPane().getComponents()) {
                        if (component instanceof JCheckBox) {
                            JCheckBox checkBox = (JCheckBox) component;
                            writer.write(checkBox.getText());
                            writer.newLine();
                        }
                    }

                    writer.close();
                } catch (java.io.IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });


        // reading each line from the file back to the frame as a check box
        retrieveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Output_Mon.txt"));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        JCheckBox checkBox = new JCheckBox();
                        checkBox.setText(line);
                        checkBox.setSelected(false);
                        checkBox.setBounds(20, getContentPane().getComponentCount() * 20 + 60, 300, 20);
                        add(checkBox);
                    }

                    reader.close();
                    revalidate();
                    repaint();


                }
                catch (java.io.IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });

        setVisible(true);
    }

    
    
    public static void main(String[] args) {
        new ToDoListMon();
    }

}
