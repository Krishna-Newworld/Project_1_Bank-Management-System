package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
//import java.sql.SQLException;
import javax.swing.*;

public class login extends JFrame implements ActionListener {
    
    JLabel label1, label2, label3;

    JTextField textField2;

    JPasswordField passwordField3;

    JButton button1, button2, button3;

    //login constructor
    login(){//constructing a frame of some specific dimensions and components
        super("Krishna's Bank Project");
        //Bank Icon GUI
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//converting i2 to i3 - Image -> ImageIcon
        JLabel image = new JLabel(i3);//can't add ImageIcon i3 directly so store in JLabel
        image.setBounds(350,10, 100, 100);//location on the frame
        add(image); //to add the image to the frame

        //card icon on the bottom
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));//accessing the image
        Image ii2 = ii1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(650, 240, 100, 100);
        add(iimage);//iimage = card image

        label1 = new JLabel("WELCOME TO BANK");//JLabel is used to show text on frame
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230,125, 450, 40);
        add(label1);

        label2 = new JLabel("Card No:");//JLabel is used to show text on frame
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setBounds(150,190, 375, 30);
        add(label2);

        //card no. text box
        textField2 = new JTextField(15);
        textField2.setBounds(325,190, 230, 30);
        textField2.setFont(new Font("Ralway",Font.BOLD, 14));
        add(textField2);

        label3 = new JLabel("PIN: ");//JLabel is used to show text on frame
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setBounds(150,250, 375, 30);
        add(label3);

        //password box
        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325, 250, 230, 30);
        passwordField3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(passwordField3);

        //signIn button
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        //CLEAR button
        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(420, 300, 100, 30);
        button2.addActionListener(this);
        add(button2);

        //SIGN UP button
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setBackground((Color.BLACK));
        button3.setForeground(Color.WHITE);
        button3.setBounds(300, 350, 220, 30);
        button3.addActionListener(this);
        add(button3);

        //Background
        ImageIcon background1 = new ImageIcon(ClassLoader.getSystemResource("icon/5172658.jpg"));
        Image background2 = background1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon background3 = new ImageIcon(background2);
        JLabel the_background = new JLabel(background3);
        the_background.setBounds(0, 0, 850, 480);
        add(the_background);



        setLayout(null);//otherwise the icon is by default placed in the centre of the frame
        //we don't want (border layout default)

        setSize(850, 480);
        setLocation(200, 80);
        //setUndecorated(true);
        //this line to remove that topmost bar containing these - [] X
        setVisible(true);

    }
    //to store the actions performed on a button - when we click it
    @Override
    public void actionPerformed(ActionEvent e){//event will get stored in 'e', which button was 'clicked'
        try{//accordingly perform necessary actions
            if(e.getSource() == button1){//if button is clicked
                connect c = new connect();
                String cardno = textField2.getText().trim();
                char[] char_pin = passwordField3.getPassword();
                String pin = new String(char_pin).trim();
                String q = "SELECT * FROM login WHERE TRIM(card_number) = '"+cardno+"' AND TRIM(pin) = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                
                /*This - resultSet.next() is the problem*/
                if(resultSet.next()){//its returning false..why? the problem is her
                    //we need to find a way to confirm the card number and pin is present in the database
                    setVisible(false);
                    new main_class(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
                //till then
                //setVisible(false);
                //new main_class(pin);
                
            }else if(e.getSource() == button2){//if button2 is clicked
                textField2.setText("");//pass an empty string indicating - clear
                passwordField3.setText("");//pass an empty string indicating - clear
            }else if (e.getSource() == button3){//if button3 is clicked
                new signup();
                setVisible(false);
            }

        }catch(Exception E){//to catch exceptions during button operations
            E.printStackTrace();//gives the stack trace of where the exception was thrown
        }
    }

    public static void main(String[] args){
        new login();//TO ACTUALLY LOAD/make THE FRAME appear ON THE SCREEN
    }
}
