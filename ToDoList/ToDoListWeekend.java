import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ToDoListWeekend extends JFrame{

    public ToDoListWeekend(){
        
        //creating a frame
        setTitle("Weekend ToDo List");
        setSize(520,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(0xC080C0));

        JLabel label2 = new JLabel("Enter what to add to your todo list : ");
        label2.setBounds(20, 20, 250, 20);

        JTextField text2 = new JTextField();
        text2.setBounds(220, 20, 200, 20);

        JButton addButton = new JButton("Add");
        addButton.setBounds(420, 20, 60, 20);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(415, 45, 81, 20);

        JButton buttonMonday = new JButton("Monday<");
        buttonMonday.setBounds(380, 400, 100, 25);

        JButton backButton = new JButton("Back<");
        backButton.setBounds(300, 400, 70, 25);

        JButton saveToFile = new JButton("Save");
        saveToFile.setBounds(390, 370, 80, 25);

        JButton retrieveFile = new JButton("Retrieve");
        retrieveFile.setBounds(380, 340, 100, 25);


       //adding components to frame2 
        add(label2);
        add(text2);
        add(buttonMonday);
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
            

        buttonMonday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == buttonMonday){
                    dispose();
                    new ToDoListMon();
                    
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(e.getSource() == backButton){
                    dispose();
                    new ToDoListFri();
                }
            }
        });

        // adding what is typed to a file when save button is clicked
        saveToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Output_Weekend.txt"));
                    
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
                    BufferedReader reader = new BufferedReader(new FileReader("Output_Weekend.txt"));

                    String lineCheckBox;
                    while ((lineCheckBox = reader.readLine()) != null) {
                        JCheckBox checkBox = new JCheckBox();
                        checkBox.setText(lineCheckBox);
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
        new ToDoListWeekend();
    }

}

