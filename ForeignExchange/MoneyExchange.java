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
        frame.getContentPane().setBackground(new Color(0xD8D8FF));
        

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

        JLabel label4 = new JLabel("*THESE ARE ASSUMED EXCHANGE RATES.");
        label4.setBounds(470, 520, 300, 30);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(590, 200, 100, 30);
        

        JLabel extraLabel1 = new JLabel();

        JLabel extraLabel2 = new JLabel();

        JLabel extraLabel3 = new JLabel();

        JPanel resultPanel1 = new JPanel();
        resultPanel1.setBounds(20, 300, 380, 50);
        resultPanel1.setBackground(new Color(0xCECECE));
        resultPanel1.add(extraLabel1);

        JPanel resultPanel2 = new JPanel();
        resultPanel2.setBounds(20, 390, 380, 50);
        resultPanel2.setBackground(new Color(0xCECECE));
        resultPanel2.add(extraLabel2);

        JPanel resultPanel3 = new JPanel();
        resultPanel3.setBounds(20, 480, 380, 50);
        resultPanel3.setBackground(new Color(0xCECECE));
        resultPanel3.add(extraLabel3);

        JLabel logo = new JLabel(new ImageIcon("logo_fes2.png")); //adding the logo
        logo.setBounds(485, 340, 260, 140);


        // adding all the components to the frame
        frame.add(comboBox1);
        frame.add(comboBox2);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(amount);
        frame.add(resultPanel1);
        frame.add(resultPanel2);
        frame.add(resultPanel3);
        frame.add(convertButton);
        frame.add(logo);


        // adding the action listener to the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromCurrency = (String) comboBox1.getSelectedItem();
                String toCurrency = (String) comboBox2.getSelectedItem();
                double amountValue = Double.parseDouble(amount.getText());

                if (fromCurrency=="Ugx" && toCurrency=="USD") {
                    double result = amountValue*(0.00026);
                    extraLabel3.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                    extraLabel2.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                }

                else if (fromCurrency=="Ugx" && toCurrency=="EUR") {
                    double result = amountValue*(0.00025);
                    extraLabel3.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                    extraLabel2.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                }

                else if (fromCurrency=="USD" && toCurrency=="Ugx") {
                    double result = amountValue*(3805);
                    extraLabel3.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                    extraLabel2.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                }

                else if (fromCurrency=="EUR" && toCurrency=="Ugx") {
                    double result = amountValue*(4050);
                    extraLabel3.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                    extraLabel2.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                }

                else if (fromCurrency == "USD" && toCurrency == "EUR") {
                    double result = amountValue*0.94;
                    extraLabel3.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                    extraLabel2.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                }

                else if (fromCurrency == "EUR" && toCurrency =="USD") {
                    double result = amountValue*1.05;
                    extraLabel3.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                    extraLabel2.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                }

            }
        });

        frame.setVisible(true);
    }
}