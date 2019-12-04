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
                        
public class Page2 extends JFrame{
        private JButton login;
        private JButton register;
        
        public Page2() 
        {
            JFrame frame = new JFrame("Suarez Pharmacy");
            JPanel panel = new JPanel(); 
            JLabel label1 = new JLabel();
            label1.setText("<html><h1>Suarez Pharmacy </h1></html>");
            label1.setBounds(110, 90, 200, 50);
            login = new JButton();
            register = new JButton();
            login.setText("login");
//          button1.setLocation(null);
                login.setToolTipText("Sign in to continue!"); 
                login.setBackground(Color.cyan);
                login.setLocation(login.getX() + login.getWidth(), login.getY());
//              button1.setSize(100, 50);
                login.setVisible(true);
                login.setBounds(130,200,150,30);  
            register = new JButton();
                register.setToolTipText("Create an account!"); 
                register.setText("Register");
                register.setBackground(Color.cyan);
                register.setLocation(register.getX() + register.getWidth(), register.getY());
//                button2.setSize(100, 50);
                register.setVisible(true);
                register.setBounds(130,250,150,30); 
            panel.setBackground(Color.cyan);
            this.setBackground(Color.cyan);  
            this.setTitle("Suarez Pharmacy");
            this.setLayout(null);
            this.setVisible(true);
            this.setSize(500, 500);
            this.add(login);
            this.add(register);
            this.add(label1);
//            this.add(panel);
//               f.setSize(400,400);    
//               f.setLayout(null);    
//               f.setVisible(true);   
        login.addActionListener(new ActionListener()
        {
            @Override
            public  void actionPerformed(ActionEvent e)
            {
               LoginJFrame log = new LoginJFrame();
//               log.setVisible(true);
               
            }
        });
        register.addActionListener(new ActionListener()
        {
            @Override
            public  void actionPerformed(ActionEvent e)
            {
               RegisterJFrame reg = new RegisterJFrame();
               reg.setVisible(true);
                
               
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












///
//import java.awt.*;  
//import javax.swing.*;  
//public class botica {  
//   public botica()  
//       {  
//       JFrame f= new JFrame("Medicine App");    
//       JPanel panel=new JPanel();  
//       panel.setBounds(40,80,200,200);    
//       panel.setBackground(Color.BLACK);  
//       JButton b1=new JButton("Login");    
//       b1.setBounds(50,100,80,30);    
//       b1.setBackground(Color.MAGENTA);  
//       JButton b2=new JButton("Register");  
//       b2.setBounds(100,100,80,30);    
//       b2.setBackground(Color.cyan);  
//       panel.add(b1); panel.add(b2);  
//       f.add(panel);  
//               f.setSize(400,400);    
//               f.setLayout(null);    
//               f.setVisible(true);    
//       }  
//     
//   }  