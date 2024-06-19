package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class signup3 extends JFrame implements ActionListener {
    String formno;
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;

    JButton s, c;

    signup3(String formno){
        this.formno = formno;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//convert from image to imageicon
        JLabel image = new JLabel(i3);//can't add imageicon directly so store in JLabel
        image.setBounds(150, 5, 100, 100);//position of the imageicon
        add(image);//to add the image to the frame
    
        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(280, 70, 400, 40);
        add(l2);

        JLabel l3 = new JLabel("Account Type");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(100, 140, 200, 30);
        add(l3);

        r1 = new JRadioButton("Savings Acoount");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(245, 252, 252));
        r1.setBounds(100, 190, 200, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(245, 252, 252));
        r2.setBounds(350, 190, 300, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(245, 252, 252));
        r3.setBounds(100, 220, 200, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(new Color(245, 252, 252));
        r4.setBounds(350, 220, 300, 30);
        add(r4);

        ButtonGroup Groupbutton = new ButtonGroup();
        Groupbutton.add(r1);
        Groupbutton.add(r2);
        Groupbutton.add(r3);
        Groupbutton.add(r4);

        JLabel l4 = new JLabel("Card Number");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(100, 300, 200, 30);
        add(l4);

        JLabel l5= new JLabel("(Your 16 digit Card Number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100, 330, 300, 20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-9393");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(330, 300, 300, 30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on ATM card/Cheque Book and Statement)");
        l7.setFont(new Font("Raleway", Font.BOLD, 12));
        l7.setBounds(330, 330, 500, 20);
        add(l7);

        JLabel l8 = new JLabel("PIN");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(100, 370, 200, 30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(330, 370, 200, 30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway", Font.BOLD, 12));
        l10.setBounds(100, 400, 200, 30);
        add(l10);

        JLabel l11 = new JLabel("Services Required");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        l11.setBounds(100, 450, 200, 30);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(245, 252, 252));
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBounds(100, 500, 100, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(245, 252, 252));
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(245, 252, 252));
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(new Color(245, 252, 252));
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        c4.setBounds(350, 550, 400, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(245, 252, 252));
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        c5.setBounds(100, 590, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-statement");
        c6.setBackground(new Color(245, 252, 252));
        c6.setFont(new Font("Raleway", Font.BOLD, 14));
        c6.setBounds(350, 590, 400, 30);
        add(c6);

        //this checkbox will remain checked, it won't be unchecked
        //thats why JCheckBox("......", true) 'true ensures that the check box is true'
        JCheckBox c7 = new JCheckBox("I here by declare that the details entered above are correct and to the best of my knowledge", true);
        c7.setBackground(new Color(245, 252, 252));
        c7.setFont(new Font("Raleway", Font.BOLD, 10));
        c7.setBounds(100, 620, 700, 25);
        add(c7);

        //form number
        JLabel l12 = new JLabel("Form No. :");
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(600, 10, 100, 30);
        add(l12);
        JLabel l13 = new JLabel(formno);//formno stores the formno from the signup page
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        l13.setBounds(660, 10, 100, 30);
        add(l13);

        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD, 14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(200, 650, 100, 30);
        s.addActionListener(this);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD, 14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(480, 650, 100, 30);
        c.addActionListener(this);
        add(c);

        getContentPane().setBackground(new Color(245, 252, 252));
        setSize(850, 800);
        setLayout(null);
        setLocation(400, 20);
        setVisible(true);
    
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String atype = null;
        if(r1.isSelected()){
            atype = "Savings Account";
        }else if(r2.isSelected()){
            atype = "Fixed Deposit Account";
        }else if(r3.isSelected()){
            atype = "Current Account";
        }else if(r4.isSelected()){
            atype = "Recurring Deposit Account";
        }
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = " " + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = " " + Math.abs(first3);
    
        String fac = " ";
        if(c1.isSelected()){
            fac = fac + "ATM CARD";
        }else if(c2.isSelected()){
            fac = fac + "Internet Banking";
        }else if(c3.isSelected()){
            fac = fac + "Mobile Banking";
        }else if(c4.isSelected()){
            fac = fac + "EMAIL Alerts";    
        }else if(c5.isSelected()){
            fac = fac + "Cheque Book";    
        }else if(c6.isSelected()){
            fac = fac + "E-statement";    
        }

        try {
            if(e.getSource()==s){//if 'submit' button is clicked
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Select necessary fields");
                }else{
                    connect c1 = new connect();
                    String query1 = "insert into signupthree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+fac+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(query1);//excute query 1
                    c1.statement.executeUpdate(query2);//execute query 2
                    JOptionPane.showMessageDialog(null, "Card Number : "+cardno + "\n Pin : " + pin);
                    new Deposit(pin);//pass the pin into the Deposit class
                    setVisible(false);
                        
                    
                }
            }else if (e.getSource()==c){//if 'cancel' button is clicked
                System.exit(0);//exit
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new signup3("");
    }
}
