package HotelManagementSystem.hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class addemployee extends JFrame implements ActionListener{

    JTextField tfname, tfage, tfphone, tfemail, tfsalary, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;


    
    addemployee()
    {
       setLayout(null);
        
        JLabel lblname = new JLabel("Name        :");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma", Font.BOLD,14));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,30,180,30);
        add(tfname);

        JLabel lblage = new JLabel("Age        :");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma", Font.BOLD,14));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,80,180,30);
        add(tfage);

        JLabel lblgender = new JLabel("Gender        :");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma", Font.BOLD,14));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma", Font.BOLD,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130,100 ,30);
        rbfemale.setFont(new Font("Tahoma", Font.BOLD,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("Job        :");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma", Font.BOLD,14));
        add(lbljob);

        String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Managers","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,180,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lblsalary = new JLabel("Salary      :");
        lblsalary.setBounds(60,230,120,30);  
        lblsalary.setFont(new Font("Tahoma", Font.BOLD,14));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,180,30);
        add(tfsalary);

         JLabel lblphone = new JLabel("Phone      :");
        lblphone.setBounds(60,280,120,30);  
        lblphone.setFont(new Font("Tahoma", Font.BOLD,14));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,280,180,30);
        add(tfphone);

        JLabel lblemail= new JLabel("Email      :");
        lblemail.setBounds(60,330,120,30);  
        lblemail.setFont(new Font("Tahoma", Font.BOLD,14));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,330,180,30);
        add(tfemail);

        JLabel lblaadhar= new JLabel("Aadhar No      :");
        lblaadhar.setBounds(60,380,120,30);  
        lblaadhar.setFont(new Font("Tahoma", Font.BOLD,14));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,180,30);
        add(tfaadhar);

        submit = new JButton("Submit");
        submit.setBounds(200,430,180,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/four.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,450);
        add(image);

        setBounds(350,200,850,540);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String name = tfname.getText();
        String age = tfage.getText();
        String phone = tfphone.getText();
        String salary = tfsalary.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        String gender = null;

        if(rbmale.isSelected())
        {
            gender="Male";
        }
        else if(rbfemale.isSelected())
        {
            gender="Female";
        }

        String job = (String) cbjob.getSelectedItem();

        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }

        if(age.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Age should not be empty");
            return;
        }

        if(phone.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Phone should not be empty");
            return;
        }

        if(salary.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Salary should not be empty");
            return;
        }

     //   if(email.equals("")&&email.contains("@") && email.contains(".com"));
     //   {
     //       JOptionPane.showMessageDialog(null,"Should be an E-mail'");
     //       return;
     //   }

        try{
                conn c = new conn();
                String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Employee Added Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    public static void main(String args[])
    {
         new addemployee();
    }

}
