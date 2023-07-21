package HotelManagementSystem.hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem()
    {
        setSize(1280,600);            // size of the frame in respect to width and height.
        setLocation(100, 100);                // Dis is the location of the frame shown in the screen just like margin from top and bottom.
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("pics/first.jpeg"));    //Setting image inside frame
        JLabel image = new JLabel(i1);                                                        // use label object to add image in frame
        image.setBounds(0, 0, 1280, 600);
        add(image);


        JLabel text = new JLabel("Hotel Management System");                          //JLabel is inbuilt java.swing func used to label the text in frame.
        text.setBounds(300,55,1000,90);                                   //set.Bounds is used to adjust the text or image from the frame w.r.t margin.
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif",Font.PLAIN, 50));
        image.add(text);                                                                   //add func is important to make the changes in the frame with the changes such as image or text.

        JButton next = new JButton("Next");
        next.setBounds(500,480,150,40);
        next.setForeground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,22));
        image.add(next);

        setVisible(true);                                                                   // to set visible the image to the user.
        
        while(true)
        {
            text.setVisible(false);                                      // Multithreading - It is a programming Concept used to do
            try{                                                               //                  small unit of task in the application.
                Thread.sleep(500);                                      // 1.Here we used try and catch for the dripping of the text.
            }                                                                  // 2.A small concept of logic for looking the page damn good.
            catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Login();
    }
    public static void main(String args[])
    {
        new HotelManagementSystem();
    }
}
