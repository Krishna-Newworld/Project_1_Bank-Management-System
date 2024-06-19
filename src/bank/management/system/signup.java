package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.*;....these three were not neede after I changed Statement in the 'connect' class
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;


public class signup extends JFrame implements ActionListener {
    //for gender selection
    JRadioButton r1, r2, m1, m2, m3;

    JButton next;


    JTextField textName, textFathername, textemail, textMs, textaddress, textcity, textpin, textstate;
    
    JDateChooser dateChooser;

    Random ran = new Random();

    long first4 =(ran.nextLong() % 9000L) +1000L;

    String first = " " + Math.abs(first4);
    
    signup(){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//converting i2 to i3 - Image -> ImageIcon
        JLabel image = new JLabel(i3);//can't add ImageIcon i3 directly so store in JLabel
        image.setBounds(25,10, 100, 100);//location on the frame
        add(image); //to add the image to the frame

        //we have to add random application number to the form so ' + first', that 'first' will be the no.
        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("page 1");
        label2.setBounds(330, 70, 600, 30);
        label2.setFont(new Font("Ralway", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(290, 90, 600, 30);
        add(label3);

        JLabel labelname = new JLabel("Name :");
        labelname.setFont(new Font("Raleway", Font.BOLD, 20));
        labelname.setBounds(100, 190, 100, 30);
        add(labelname);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        //"father's name" text
        JLabel labelFname = new JLabel("Father's Name :");
        labelFname.setFont(new Font("Raleway", Font.BOLD, 20));
        labelFname.setBounds(100, 240, 200, 30);
        add(labelFname);
        //text box to take input from user
        textFathername = new JTextField();
        textFathername.setFont(new Font("Raleway", Font.BOLD, 14));
        textFathername.setBounds(300, 240, 400, 30);
        add(textFathername);

        //dateofbirth text
        JLabel DOB = new JLabel("Date Of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 340, 200, 30);
        add(DOB);
        //DOB along with the calender
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300,340, 400, 30);
        add(dateChooser);

        //gender select
        JLabel LabelG = new JLabel("Gender");
        LabelG.setFont(new Font("Raleway", Font.BOLD, 20));
        LabelG.setBounds(100,290, 200, 30);
        add(LabelG);
        //and we need select buttons for this one, male(), female(), other()

        //male button
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));//to make it same as background color to blend it in
        r1.setBounds(300,290, 60, 30);
        add(r1);

        //female button
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));//to make it same as background color to blend it in
        r2.setBounds(450, 290, 90, 30);
        add(r2);

        //we also have to ensure that only one of the
        //male or female button gets selected.
        //to add that functionality we need to group these two buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        //email address text
        JLabel labelemail = new JLabel("email");
        labelemail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelemail.setBounds(100, 390, 200, 30);
        add(labelemail);

        //email text field
        textemail = new JTextField();
        textemail.setFont(new Font("Raleway", Font.BOLD, 14));
        textemail.setBounds(300, 390, 400, 30);
        add(textemail);

        //label marital status
        JLabel labelMs = new JLabel("Marital Status");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100, 440, 200, 30);
        add(labelMs);
        //button for married
        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        m1.setBounds(300, 440, 90, 30);
        m1.setBackground(new Color(222, 255, 228));
        add(m1);
        //button for single
        m2 = new JRadioButton("Single");
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        m2.setBounds(450, 440, 90, 30);
        m2.setBackground(new Color(222, 255, 228));
        add(m2);
        //button for other
        m3 = new JRadioButton("other");
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        m3.setBounds(600, 440, 90, 30);
        m3.setBackground(new Color(222, 255, 228));
        add(m3);

        //now grouping buttons so only one of the two can be selected
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(m1);
        buttonGroup2.add(m2);
        buttonGroup2.add(m3);
        //it's better to have buttons for marital status 
        //as it is more clear

        //text feild for marital status
        //textMs = new JTextField();
        //textMs.setFont(new Font("Raleway", Font.BOLD, 14));
        //textMs.setBounds(300, 440, 400, 30);
        //add(textMs);

        //address
        JLabel address = new JLabel("address");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 490, 200, 30 );
        add(address);
        //text field for address
        textaddress = new JTextField();
        textaddress.setFont(new Font("Raleway", Font.BOLD, 14));
        textaddress.setBounds(300, 490, 400, 30);
        add(textaddress);

        //your City
        JLabel labelcity = new JLabel("city");
        labelcity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelcity.setBounds(100, 540, 100, 30);
        add(labelcity);
        //text field
        textcity = new JTextField();
        textcity.setFont(new Font("Raleway", Font.BOLD, 14));
        textcity.setBounds(300, 540, 400, 30);
        add(textcity);

        //pin-code
        JLabel labelpin = new JLabel("Pincode");
        labelpin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelpin.setBounds(100, 590, 100, 30);
        add(labelpin);
        //text field pincode
        textpin = new JTextField();
        textpin.setFont(new Font("Raleway", Font.BOLD, 14));
        textpin.setBounds(300, 590, 400, 30);
        add(textpin);

        //your state
        JLabel labelstate = new JLabel("State");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(100, 640, 100, 30);
        add(labelstate);
        //state text field
        textstate = new JTextField();
        textstate.setFont(new Font("Raleway", Font.BOLD, 14));
        textstate.setBounds(300, 640, 400, 30);
        add(textstate);
        

        //AFTER WE HAVE FILLED THE DETAILS WE NEED TO MOVE TO THE NEXT PAGE
        //we need to create the NEXT button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 680, 80, 30);
        next.addActionListener(this);
        add(next);


        //we have to take input from the users
        //so build labels and text fields respectively

        //frame won't automatically be of a set layout
        //we will manually adjust the layout that's why setLayout(null)
        setLayout(null);
        setSize(850, 800); //size of the frame
        setLocation(360, 40); //the location of the frame
        //setting the frame to an rgb color value
        Color customcolor = new Color(222, 252, 228);
        getContentPane().setBackground(customcolor);

        setVisible(true);
    }

    //connecting the buttons, textfields with actions to be performed, data reading, storing etc
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        String formno = first;
        String name = textName.getText();//use 'get.Text()' to read text from a JTextField
        String fathername = textFathername.getText();
        //now DOB has to be read from the calender, so it will be different
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;//null preset so Male or female can get stored there
        if(r1.isSelected()){//isSelected for JRadiobuttons
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        String email = textemail.getText();
        String marital =  null;//'null' default preset so marital status can be stored
        if(m1.isSelected()){
            marital = "Married";
        }else if(m2.isSelected()){
            marital = "Unmarried";
        }else if(m3.isSelected()){
            marital = "Other";
        }
        String address = textaddress.getText();
        String city = textcity.getText();
        String pincode = textpin.getText();
        String state = textstate.getText();

        //Now all this data needs to be stored in the database in this order
        //using try and catch because the program can throw exceptions while storing the data
        try{
            if(textName.getText().equals("")){
                //if the name field is empty->"", then show "Fill all name fields"
                JOptionPane.showMessageDialog(null, "Fill all name fields");
            }else{
                //if name field is filled..data will get stored
                connect connect1 = new connect();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"', '"+email+"','"+marital+"', '"+address+"','"+city+"','"+pincode+"','"+state+"')";
                connect1.statement.executeUpdate(q);
                new signup2(formno);
                setVisible(false);
                //after the data has been stored, we move on to the signup2 page
                //and the 'signup' page closed, by setting the visibility as 'false'

            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup();
    }
    
}
