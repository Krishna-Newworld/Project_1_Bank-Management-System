package bank.management.system;

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
//import java.sql.Date;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class withdrawl extends JFrame implements ActionListener{
    
    String pin;

    TextField textField;

    JButton b1, b2;


    withdrawl(String pin){
        this.pin = pin;

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 720);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        label1.setBounds(460, 180, 400, 35);
        l3.add(label1);//because we want it to show on the image on top of the frame
        //otherwise add(label) will add it to the frame, but it will be hidden because of the image

        JLabel label2 = new JLabel("ENTER YOUR AMOUNT");
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        label2.setBounds(460, 220, 400, 35);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 260, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);//add it on the image not on the frame
        
        //withdrawl Button
        b1 = new JButton("WITHDRAWL");
        b1.setBounds(700, 320, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        //BACK Button
        b2 = new JButton("BACK");
        b2.setBounds(700, 360, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);
    
        
        
        
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            try{
            String amount = textField.getText();
            Date date = new Date();
            if(textField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
            }else{
                connect c = new connect();
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE TRIM(pin) = '"+pin+"' ");
                int balance = 0; // = Integer.parseInt(resultSet.getString("amount"));
                //the problem is this balance = 0
                System.out.println(balance);
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                //if balance is less than withdrawl amount..then put a notification
                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited successfully");
                setVisible(false);
                new main_class(pin);


            }
            }catch(Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource()==b2){
            setVisible(false);
            new main_class(pin);
        }
    }
    
    public static void main(String[] args) {
        new withdrawl("");//why?
    }
}
