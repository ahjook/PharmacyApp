/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Drag.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ajocme_sd2022
 */
public class LoginJFrame extends JFrame {
     ArrayList<String> UserName = new ArrayList<>();
     ArrayList<String> Password = new ArrayList<>();
      JLabel  Username , Pass ;
      JTextField u2;
      JButton login , cancel;
      JPasswordField pass;
      
      public LoginJFrame(){    
		JFrame jf = new JFrame("Suarez Pharmacy"); 
                JPanel panel = new JPanel(); 
					//enter name label
		JLabel label = new JLabel();	
                JLabel label6 = new JLabel();
                label6.setText("<html><h1> Create Account</h1></html>");
                label6.setBounds(100, 0, 200, 100);
//                label6
                
                Username = new JLabel("Username:");
                Username.setBounds(2, 120, 100, 100);
                u2 = new JTextField();
                u2.setBounds(90, 150, 270, 30);
                
                Pass = new JLabel("Password:");
                Pass.setBounds(2, 160, 100, 100);
                pass = new JPasswordField();
                pass.setBounds(90, 190, 270, 30);
                
                			//submit button
		JButton login =new JButton("Login");    
		login.setBounds(90,360,100, 30);    
                
                JButton cancel =new JButton("Cancel");    
		cancel.setBounds(260, 360, 100, 30);    
                
                jf.add(label6);
                jf.add(Username);
                jf.add(u2);
                jf.add(Pass);
                jf.add(pass);
                jf.add(login);   
                jf.add(cancel);   
		jf.setSize(500,500);    
		jf.setLayout(null);    
		jf.setVisible(true);    
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
              
                login.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent evt)
                    {
                       
        
                        if(evt.getSource() == login ){
                        String UserText;
                        String PassText;
                        UserText = u2.getText();
                        PassText = pass.getText();
                        if(UserText.equalsIgnoreCase("") && PassText.equalsIgnoreCase("")) {
                            JOptionPane.showMessageDialog(jf, "Login Succesful");
                        }
                        else 
                            {
                            JOptionPane.showMessageDialog(jf, "Invalid Username or Password");   
                            }
                        }
                        
                    }
         
                });
                cancel.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent e)
                    {
                        cancel.setText("Cancel!!");
                    }
         
        });
                
              
      }
}
