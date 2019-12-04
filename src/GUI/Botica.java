/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
                        
public class Botica extends JFrame{
       
        private JButton pharmacist;
        
        public Botica() 
        {
            JFrame frame = new JFrame("Suarez Pharmacy");
            JPanel panel = new JPanel(); 
            JLabel label1 = new JLabel();
            label1.setText("<html><h1> Your Hometown </h1></html>");
            label1.setBounds(110, 90, 200, 50);
            JLabel label2 = new JLabel();
            label2.setText("<html><h1>Pharmacy </h1></html>");
            label2.setBounds(140, 130, 200, 50);
             JLabel label3 = new JLabel();
            label3.setText("<html><h1>,is here for life</h1></html>");
            label3.setBounds(110, 170, 200, 50);
//            customer = new JButton();
            pharmacist = new JButton();
//            customer.setText("Customer");
//          button1.setLocation(null);
//                customer.setToolTipText("Sign in to continue!"); 
//                customer.setBackground(Color.MAGENTA);
//                customer.setLocation(customer.getX() + customer.getWidth(), customer.getY());
////              button1.setSize(100, 50);
//                customer.setVisible(true);
//                customer.setBounds(130,200,150,30);  
            pharmacist = new JButton();
                pharmacist.setToolTipText("Join Now!"); 
                pharmacist.setText("JOIN");
                pharmacist.setBackground(Color.CYAN);
                pharmacist.setLocation(pharmacist.getX() + pharmacist.getWidth(), pharmacist.getY());
//                button2.setSize(100, 50);
                pharmacist.setVisible(true);
                pharmacist.setBounds(130,250,150,30); 
            this.setBackground(Color.CYAN);  
            this.setTitle("Suarez Pharmacy");
            this.setLayout(null);
            this.setVisible(true);
            this.setSize(500,500);
//            this.add(customer);
            this.add(pharmacist);
            this.add(label1);
            this.add(label2);
             this.add(label3);
//            this.add(panel);
//               f.setSize(400,400);    
//               f.setLayout(null);    
//               f.setVisible(true);   
//        customer.addActionListener(new ActionListener()
//        {
//            @Override
//            public  void actionPerformed(ActionEvent e)
//            {
//                Drag.Page2 reg = new Drag.Page2();
//                reg.setVisible(true); 
//                dispose();
//            }
//         
//        });
         pharmacist.addActionListener(new ActionListener()
        {
            @Override
            public  void actionPerformed(ActionEvent e)
            {
                Drag.Page2 reg = new Drag.Page2();
                reg.setVisible(true); 
                dispose();
            }
         
        });
        }
        
        
        
        
    }

//          button1.addActionListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent ae) {
//                button1.setSize(200, 200);
//               button1.setText("Hello, I am Clicked!!");
//           }
//
//       });












