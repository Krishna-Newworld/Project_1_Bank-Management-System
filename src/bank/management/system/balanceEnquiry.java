package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class balanceEnquiry extends JFrame implements ActionListener{
    String pin;

    JLabel label2;

    JButton b1;

    balanceEnquiry(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 720);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance is Rs");
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        label1.setBounds(430, 180, 400, 35);
        l3.add(label1);//because we want it to show on the image on top of the frame
        //otherwise add(label) will add it to the frame, but it will be hidden because of the image

        label2 = new JLabel();
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        label2.setBounds(430, 220, 400, 35);
        l3.add(label2);

        //withdrawl Button
        b1 = new JButton("Back");
        b1.setBounds(700, 360, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;
        try{
            connect c = new connect();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where TRIM(pin) ='"+pin+"' ");
            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new main_class(pin);
        //we are not putting if(isSelected) because there is only one button
    }

    public static void main(String[] args){
        new balanceEnquiry("");
    }


}
