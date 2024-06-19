package bank.management.system;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup2 extends JFrame implements ActionListener {
    String formno;

    JComboBox combobox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPan, textAdhaar;
    JRadioButton r1, r2, e1, e2;

    JButton next;

    signup2(String formno){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Bank Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//convert from image to imageicon
        JLabel image = new JLabel(i3);//can't add imageicon directly so store in JLabel
        image.setBounds(150, 5, 100, 100);//position of the imageicon
        add(image);//to add the image to the frame

        this.formno = formno;

        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300, 30, 600, 40);
        add(l1);
        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(300, 60, 600, 40);
        add(l2);

        //religion
        JLabel l3 = new JLabel("Religion");
        l3.setFont(new Font("MVboli", Font.BOLD, 20));
        l3.setBounds(100, 120, 200, 30);
        add(l3);
        
        //dropdown menu to select religion using 'JCombobox' type
        String religion[] = {"Hindu", "Christian", "Sikh", "Muslim", "Jain", "Other"};
        combobox = new JComboBox(religion);
        combobox.setBackground(new Color(235, 255, 255));
        combobox.setFont(new Font("Raleway", Font.BOLD, 14));
        combobox.setBounds(300, 120, 400, 30);
        add(combobox);

        //category select
        JLabel l4 = new JLabel("Category");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(100, 170, 100, 30);
        add(l4);

        //dropdown for Category
        String Category[] = {"General", "SC", "ST", "OBC", "other"};
        comboBox2 = new JComboBox(Category);
        comboBox2.setBackground(new Color(235, 255, 255));
        comboBox2.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox2.setBounds(300, 170, 400, 30);
        add(comboBox2);

        //income
        JLabel l5 = new JLabel("Income");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setBounds(100, 220, 100, 30);
        add(l5);
        //dropdown for income
        String income[] = {"Null", "below 5 lakhs", "5 - 7.5 lakhs", "7.5 - 10 lakhs", "10 - 25 lakhs","25 - 50 lakhs", "above 50 lakhs"};
        comboBox3 = new JComboBox<>(income);
        comboBox3.setBackground(new Color(235, 255, 255));
        comboBox3.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox3.setBounds(300, 220, 400, 30);
        add(comboBox3);

        //education
        JLabel l6 = new JLabel("Education");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(100, 270, 100, 30);
        add(l6);
        //dropdown for education
        String education[] = { "Matriculation", "Graduation", "Post Graduation", "Doctorate", "Other"};
        comboBox4 = new JComboBox(education);
        comboBox4.setBackground(new Color(235, 255, 255));
        comboBox4.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox4.setBounds(300, 270, 400, 30);
        add(comboBox4);

        //Occupation
        JLabel l7 = new JLabel("Occupation");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(100, 340, 200, 30);
        add(l7);
        //dropdown for occupation
        String occupation[] = {"Student", "Salaried", "Self-employed", "Business", "retired", "Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox5.setBounds(300, 340, 400, 30);
        comboBox5.setBackground(new Color(235, 255, 255));
        add(comboBox5);

        //PAN number
        JLabel l8 = new JLabel("PAN number");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(100, 390, 200, 30);
        add(l8);
        //textfield for PAN number
        textPan = new JTextField();
        textPan.setBounds(300, 390, 400, 30);
        textPan.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textPan);

        //Adhaar Number
        JLabel l9 = new JLabel("Adhaar Number");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(100, 440, 200, 30);
        add(l9);
        //textfield for adhaar number
        textAdhaar = new JTextField();
        textAdhaar.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdhaar.setBounds(300, 440, 400, 30);
        add(textAdhaar);

        //senior citizen -- yes or no
        JLabel l10 = new JLabel("Senior Citizen");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        l10.setBounds(100, 490, 200, 30);
        add(l10);
        //JRadiobuttons - yes
        r1 = new JRadioButton("Yes");
        r1.setBackground(new Color(235, 255, 255));
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBounds(300, 490, 150, 30);
        add(r1);
        //r2 button - no
        r2 = new JRadioButton("No");
        r2.setBackground(new Color(235, 255, 255));
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBounds(450, 490, 150, 30);
        add(r2);
        //Group the buttons so that only one can get selected
        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(r1);
        buttongroup.add(r2);

        
        //existing account -- yes or no
        JLabel l11 = new JLabel("Existing Account");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        l11.setBounds(100, 540, 200, 30);
        add(l11);
        //JRadiobuttons - yes
        e1 = new JRadioButton("Yes");
        e1.setBackground(new Color(235, 255, 255));
        e1.setFont(new Font("Raleway", Font.BOLD, 14));
        e1.setBounds(300, 540, 150, 30);
        add(e1);
        //r2 button - no
        e2 = new JRadioButton("No");
        e2.setBackground(new Color(235, 255, 255));
        e2.setFont(new Font("Raleway", Font.BOLD, 14));
        e2.setBounds(450, 540, 150, 30);
        add(e2);
        //Group the buttons so that only one can get selected
        ButtonGroup buttongroup2 = new ButtonGroup();
        buttongroup2.add(e1);
        buttongroup2.add(e2);

        //for displaying the form number
        JLabel l12 = new JLabel("Form No. :");
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(600, 10, 100, 30);
        add(l12);
        JLabel l13 = new JLabel(formno);//formno stores the formno from the signup page
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        l13.setBounds(660, 10, 100, 30);
        add(l13);

        //next button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570, 590, 100, 30);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        setSize(850, 750);
        setLocation(450, 50);
        getContentPane().setBackground(new Color(235, 255, 255));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String rel = (String)combobox.getSelectedItem();
        String categ = (String)comboBox2.getSelectedItem();
        String inc = (String)comboBox3.getSelectedItem();
        String educ = (String)comboBox4.getSelectedItem();
        String Occup = (String)comboBox5.getSelectedItem();
        String pan = textPan.getText();
        String adhaar = textAdhaar.getText();
        String s_citizen = null;
        if(r1.isSelected()){
            s_citizen = "Yes";

        }else if(r2.isSelected()){
            s_citizen = "No";
    
        }

        String eAccount = null;
        if(e1.isSelected()){
            eAccount = "Yes";
        
        }else if(e2.isSelected()){
            eAccount = "No";
        }

        try{
            if(textPan.getText().equals("") || textAdhaar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all details");
            }else{
                connect c1 = new connect();
                String query = "insert into Signuptwo values('"+formno+"','"+rel+"','"+categ+"','"+inc+"','"+educ+"','"+Occup+"','"+pan+"','"+adhaar+"', '"+s_citizen+"','"+eAccount+"')";
                c1.statement.executeUpdate(query);
                new signup3(formno);//load up the third signup page if query is successfully executed
                setVisible(false);
            }
        }catch(Exception E){
            
        }
    }
    public static void main(String[] args) {
        new signup2("");
    }

}
