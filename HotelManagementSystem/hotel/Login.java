package HotelManagementSystem.hotel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;



public class Login extends JFrame implements ActionListener
{

    JTextField username, password ;
    JButton login, cancel;

    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Username - Text

        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

        // Username - TextField where we take input.

        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        // Password

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        // Password - TextField

        password = new JTextField();
        password.setBounds(150,70,150,30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);        


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/loginpic.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setBounds(500,200,600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            String user = username.getText();
            String pass = password.getText();

            try{
                conn c= new conn();

                String query = "Select *from login where username ='"+user+"' and password ='"+pass+"'";
                ResultSet rs=c.s.executeQuery(query);

                if(rs.next())
                {
                    setVisible(true);
                    new Dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String args[])
    {
        new Login();
    }
}
