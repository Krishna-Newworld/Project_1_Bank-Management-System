package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mini extends JFrame implements ActionListener{
   
    String pin;

    JButton button;
    mini(String pin){
        this.pin = pin;
    //here the size of the frame will be a little smaller than other frames
        
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20,20);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 400, 200);
        add(label1);

        JLabel label2 = new JLabel("Owner");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(150, 20, 200, 20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20, 80, 300, 25);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20, 400, 300, 25);
        add(label4);
        //now we will be taking out the data 
        //storing it in these 4 labels

        try{

            connect c = new connect();
            ResultSet resultSet = c.statement.executeQuery("select * from login where TRIM(pin) = '"+pin+"'");
            while(resultSet.next()){
                label3.setText("card Number:  "+ resultSet.getString("card_number").substring(0,5) + "XXXXXXXX"+ resultSet.getString("card_number").substring(13));
                //this is done to display the 16 digit card number as 1234XXXXXXXX6789. covering   
                //substring(beginIndex-Inclusive, endIndex-exclusive) --> so (0,5) would mean show from 0 to 4, since 5 is exclusive, substring(13) would mean 13 onwards(inclusive) show. no exclusive number is given. it will show till the end
                //by writing sunstring(12) we were committing the mistake of including the 12th character to be shown since substring(12) is taken as 12 inclusive, since only 1 number is given
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            //deposit amount and withdrawal amount etc is gonna come here
            int balance =0;
            connect c = new connect();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where TRIM(pin) = '"+pin+"' ");
            while(resultSet.next()){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");

                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));

                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your total Balance is Rs "+balance);

        }catch(Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }
    
    
    public static void main(String[] args) {
        new mini("");
    }


}