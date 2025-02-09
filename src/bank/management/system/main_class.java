package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main_class extends JFrame implements ActionListener{
    
    JButton b1, b2, b3, b4, b5, b6, b7;
    
    String pin;

    main_class(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 720);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(430, 140, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 28));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(410, 235, 150,30);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAW");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(700, 235, 150,30);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(410, 275, 150,30);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(700, 275, 150,30);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(410, 315, 150,30);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(700, 315, 150,30);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(700, 355, 150,30);
        b7.addActionListener(this);
        l3.add(b7);

        





        setLayout(null);
        setSize(1550,1080);
        setLocation(0, 0);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        }else if(e.getSource() == b7){
            System.exit(0);
        }else if(e.getSource()==b2){
            new withdrawl(pin);
            setVisible(false);
        }else if(e.getSource()==b6){
            new balanceEnquiry(pin);
            setVisible(false);
        }else if(e.getSource()==b3){
            new FastCash(pin);
            setVisible(false);
        }else if(e.getSource()==b5){
            new Pin(pin);
            setVisible(false);
        }else if(e.getSource()==b4){
            new mini(pin);
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new main_class("");
    }
}
