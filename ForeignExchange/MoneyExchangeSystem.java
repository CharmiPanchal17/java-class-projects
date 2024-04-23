import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//super class
class ForeignCurrencyConvertor{

    protected String fromCurrency;
    protected String toCurrency;
    protected double amountValue;
    protected double result;
    protected double rate;

    ForeignCurrencyConvertor(String fromCurrency, String toCurrency, double amountAmount){
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amountValue = amountAmount;
    }
}

//child class
public class MoneyExchangeSystem extends ForeignCurrencyConvertor{

    MoneyExchangeSystem(String fromCurrency, String toCurrency, double amountAmount){
        super(fromCurrency, toCurrency, amountAmount);
    }

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

        JLabel extraLabel4 = new JLabel();

        

        JPanel resultPanel1 = new JPanel();
        resultPanel1.setBounds(20, 300, 380, 40);
        resultPanel1.setBackground(new Color(0xCECECE));
        resultPanel1.add(extraLabel1);

        JPanel resultPanel2 = new JPanel();
        resultPanel2.setBounds(20, 360, 380, 40);
        resultPanel2.setBackground(new Color(0xCECECE));
        resultPanel2.add(extraLabel2);

        JPanel resultPanel3 = new JPanel();
        resultPanel3.setBounds(20, 420, 380, 40);
        resultPanel3.setBackground(new Color(0xCECECE));
        resultPanel3.add(extraLabel3);

        JPanel resultPanel4 = new JPanel();
        resultPanel4.setBounds(20, 480, 380, 40);
        resultPanel4.setBackground(new Color(0xCECECE));
        resultPanel4.add(extraLabel4);

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
        frame.add(resultPanel4);
        frame.add(convertButton);
        frame.add(logo);


        // adding the action listener to the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    String fromCurrency = (String) comboBox1.getSelectedItem();
                    String toCurrency = (String) comboBox2.getSelectedItem();
                    double amountValue = 0;
                    double result = 0;

                    //exception handling if invalid input of amount
                    try{
                        amountValue = Double.parseDouble(amount.getText());
                    }
                    catch(NumberFormatException ex){
                        extraLabel3.setText("Invalid Input of amount");
                        return;  //this will return an error if conversion to a number fails
                    }


                    String exchangeRate = JOptionPane.showInputDialog(frame, "Enter the exchange rate from " + fromCurrency + " to " + toCurrency + ": ");
                    double rate = Double.parseDouble(exchangeRate);

                    if (fromCurrency=="Ugx" && toCurrency=="USD") {
                        result = amountValue*rate;
                        extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                        extraLabel2.setText("The rate of " + fromCurrency + " to " + toCurrency+" is: " +rate);
                        extraLabel3.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                        extraLabel4.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    }

                    else if (fromCurrency=="Ugx" && toCurrency=="EUR") {
                        result = amountValue*rate;
                        extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                        extraLabel2.setText("The rate of " + fromCurrency + " to " + toCurrency+" is: " + rate);
                        extraLabel3.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                        extraLabel4.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    }

                    else if (fromCurrency=="USD" && toCurrency=="Ugx") {
                        result = amountValue*rate;
                        extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                        extraLabel2.setText("The rate of " + fromCurrency + " to " + toCurrency+" is: " +rate);
                        extraLabel3.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                        extraLabel4.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    }

                    else if (fromCurrency=="EUR" && toCurrency=="Ugx") {
                        result = amountValue*rate;
                        extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                        extraLabel2.setText("The rate of " + fromCurrency + " to " + toCurrency+" is: " + rate);
                        extraLabel3.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                        extraLabel4.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    }

                    else if (fromCurrency == "USD" && toCurrency == "EUR") {
                        result = amountValue*rate;
                        extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                        extraLabel2.setText("The rate of " + fromCurrency + " to " + toCurrency+" is: " + rate);
                        extraLabel3.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                        extraLabel4.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    }

                    else if (fromCurrency == "EUR" && toCurrency =="USD") {
                        result = amountValue*rate;
                        extraLabel1.setText("Converting from: " + fromCurrency + " to: " + toCurrency);
                        extraLabel2.setText("The rate of " + fromCurrency + " to " + toCurrency+" is: " + rate);
                        extraLabel3.setText("The value of currency in " + fromCurrency + " is: " + amountValue);
                        extraLabel4.setText("The value of converted currency in " + toCurrency + " is: " + result);
                    }

                    //adding all information to a file
                    BufferedWriter outputData = new BufferedWriter(new FileWriter("output.txt"));
                    outputData.write("The currency you converted from is: " + fromCurrency + "\n");
                    outputData.write("The currency you converted to is: " + toCurrency + "\n");
                    outputData.write("The exchange rate of " + fromCurrency + " to " + toCurrency + " is: " + rate + "\n");
                    outputData.write("The amount in " + fromCurrency + " you converted is: " + amountValue + "\n");
                    outputData.write("The converted amount in " + toCurrency + " is: " + result + "\n");
                    outputData.close();


                }
                catch(Exception ex){
                    return;
                }
                

            }
        });

        frame.setVisible(true);

    }
}