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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pin extends JFrame implements ActionListener{

    JButton b1, b2;
    JPasswordField p1, p2;

    String pin;

    Pin(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 720);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        label1.setBounds(430, 180, 400, 35);
        l3.add(label1);

        JLabel label2 = new JLabel("New PIN: ");
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        label2.setBounds(430, 220, 150, 35);
        l3.add(label2);

        //password field
        p1 = new JPasswordField();
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(600, 220, 180, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p1);//add it on the image not on the frame

        JLabel label3 = new JLabel("Re- Enter  New PIN: ");
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setForeground(Color.WHITE);
        label3.setBounds(430, 250, 400, 35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(600, 255, 180, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p2);//add it on the image not on the frame


         //Deposit Button
        b1 = new JButton("CHANGE");
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

        setSize(1550, 1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        

        try{//we used try because there is always chances for exception while doing
            //while connecting and updating databases

            char[] charpin1 = p1.getPassword();
            String pin1 = new String(charpin1);
            char[] charpin2 = p2.getPassword();
            String pin2 = new String(charpin2);


            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }

            if(e.getSource()==b1){
                //check if text feild is empty or not
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter new PIN");
                    return;

                }
 
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-enter new PIN");
                    return;
                }

                connect c = new connect();
                //change the PIN in all three tables wherever it has been listed in the database, in all columns and all tables
                String q1 = "update bank set pin = '"+pin1+"'where TRIM(pin) = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"'where TRIM(pin) = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"'where TRIM(pin) = '"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                //when PIN change is successful
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new main_class(pin);

            }else if(e.getSource()==b2){
                new main_class(pin);
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Pin("");
    }
}
