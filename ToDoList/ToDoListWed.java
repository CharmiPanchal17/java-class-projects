import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;


public class ToDoListWed extends JFrame{

    public ToDoListWed(){
        
        //creating a frame
        setTitle("Wednesday ToDo List");
        setSize(520,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(0xADE6BB));

        JLabel label2 = new JLabel("Enter what to add to your todo list : ");
        label2.setBounds(20, 20, 250, 20);

        JTextField text2 = new JTextField();
        text2.setBounds(220, 20, 200, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(420, 20, 60, 20);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(415, 45, 81, 20);

        JButton buttonThurssday = new JButton(">Thursday");
        buttonThurssday.setBounds(380, 400, 100, 25);

        JButton backButton = new JButton("Back<");
        backButton.setBounds(300, 400, 70, 25);

        JButton saveToFile = new JButton("Save");
        saveToFile.setBounds(390, 370, 80, 25);

        JButton retrieveFile = new JButton("Retrieve");
        retrieveFile.setBounds(380, 340, 100, 25);


    

       //adding components to frame2 
        add(label2);
        add(text2);
        add(buttonThurssday);
        add(addButton);
        add(backButton);
        add(removeButton);
        add(saveToFile);
        add(retrieveFile);


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

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Component[] components = getContentPane().getComponents();
                    for (Component component : components) {
                        if (component instanceof JCheckBox) {
                            JCheckBox checkBox = (JCheckBox) component;
                            if (checkBox.isSelected()) {
                                remove(checkBox);
                            }
                        }
                    }
                    revalidate(); // Revalidate the frame to reflect changes
                    repaint(); // Repaint the frame to reflect changes
                }
            });
            

        buttonThurssday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == buttonThurssday){
                    dispose();
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

        // adding what is typed to a file when save button is clicked
        saveToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("C:\\Users\\Dell\\Desktop\\java-class-projects\\ToDoList\\Output_Wed.txt"));
                    
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
                    BufferedReader reader = new BufferedReader(new java.io.FileReader("C:\\Users\\Dell\\Desktop\\java-class-projects\\ToDoList\\Output_Wed.txt"));

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
        new ToDoListWed();
    }

}
