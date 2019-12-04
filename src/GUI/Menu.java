/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ajocme_sd2022
 */
public class Menu {
    
      JButton purchased , cancel;
    
      
      public Menu(){    
		JFrame jf = new JFrame("Suarez Pharmacy"); 
                JPanel panel = new JPanel(); 
					//enter name label
		JLabel label = new JLabel();	
                JLabel label6 = new JLabel();
                label6.setText("<html><h1>Available Medicine</h1></html>");
                label6.setBounds(100, 0, 200, 100);
                label6.setLocation(150, 30);
                label6.setSize(150, 150);
//                label6
                //submit button
		JButton purchased =new JButton("Purchased");    
		purchased.setBounds(90,360,100, 30);    
                
                JButton cancel =new JButton("Exit");    
		cancel.setBounds(260, 360, 100, 30);    
                
                jf.add(label6);
                jf.add(purchased);   
                jf.add(cancel);   
		jf.setSize(1000,700);    
		jf.setLayout(null);    
		jf.setVisible(true);    
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
                
                purchased.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent e)
                    {
                        
                        
                    }
         
                });
                cancel.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent e)
                    {
                        System.exit(2);
                    }
         
        });
                
              
      }
}
