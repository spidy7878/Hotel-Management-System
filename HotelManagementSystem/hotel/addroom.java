package HotelManagementSystem.hotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class addroom extends JFrame implements ActionListener
{
    JLabel lblroomno, lblavailable, lblclean, lblprice, lbltype;
    JTextField tfroom, tfprice;
    JComboBox availablecombo, cleancombo, typecombo;
    JButton add, cancel;

    addroom()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        lblroomno = new JLabel("Room No :");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,20);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        lblavailable = new JLabel("Availability :");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,20);
        add(lblavailable);

        String availableOptions[] = {"Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        lblclean = new JLabel("Clean Status :");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,20);
        add(lblclean);

        String cleanOptions[] = {"Cleaned","Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        lblprice = new JLabel("Price :");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,20);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        lbltype = new JLabel("Type :");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,20);
        add(lbltype);

        String typeOptions[] = {"Single Bed","Double Bed","Couple Special"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);  

        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("pics/room.JPEG"));
        JLabel image = new JLabel(i1);
        image.setBounds(430,60,450,280);
        add(image);

        setBounds(330,200,940,470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String roomno = tfroom.getText();
            String availability = (String)availablecombo.getSelectedItem();
            String status =(String)cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String)typecombo.getSelectedItem(); 

            try{
                conn c = new conn();
                String str = "insert into room values('"+roomno+"','"+availability+"','"+status+"','"+price+"','"+type+"')";

                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[])
    {
        new addroom();
    }
}
