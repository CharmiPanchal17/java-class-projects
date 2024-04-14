import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoneyExchange {
    
    public static void main(String[] args) {

        JFrame frame = new JFrame("FOREIGN EXCHANGE SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        

        //creating the elements for the combobox
        String[] currencies1 = {"Ugx", "USD" , "EUR"};
        String[] currencies2 = {"Ugx", "USD" , "EUR"};


        JComboBox<String> comboBox1 = new JComboBox<String>(currencies1);
        comboBox1.setBounds(200, 20, 100,30);

        JComboBox<String> comboBox2 = new JComboBox<String>(currencies2);
        comboBox2.setBounds(590, 20, 100,30);

        JLabel label1 = new JLabel("Select the currency to convert: ");
        label1.setBounds(20, 20, 250, 20);

        JLabel label2 = new JLabel("Enter the amount of currency to convert: ");
        label2.setBounds(20, 200, 350, 20);

        JTextField amount = new JTextField();
        amount.setBounds(280, 200, 300, 30);

        JLabel label3 = new JLabel("Select the currency to convert to: ");
        label3.setBounds(390, 20, 250, 20);

        JLabel label4 = new JLabel("The converted currency is: ");
        label4.setBounds(30, 400, 250, 20);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(590, 200, 100, 30);

        frame.add(comboBox1);
        frame.add(comboBox2);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(amount);
        frame.add(convertButton);


        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromCurrency = (String) comboBox1.getSelectedItem();
                String toCurrency = (String) comboBox2.getSelectedItem();
                double amountValue = Double.parseDouble(amount.getText());

                if (fromCurrency=="Ugx" && toCurrency=="USD") {
                    double result = amountValue*(0.00026);
                }
            }
        });

        frame.setVisible(true);
    }
}