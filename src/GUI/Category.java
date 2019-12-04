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
public class Category {
    
      JButton Cough , Headache , Allergies , BodyPain , Exit;
    
      
      public Category(){    
		JFrame j2 = new JFrame("Suarez Pharmacy"); 
                JPanel panel = new JPanel(); 
					//enter name label
		JLabel label = new JLabel();	
                JLabel label6 = new JLabel();
//                label6.setText("Medicine Category");
//                
//                label6.setLocation(30, 0);
//                label6.setSize(150, 50);
//                label6
                //submit button Cough
//                Cough , Headache , Allergies , BodyPain , Exit
		JButton Cough = new JButton("Cough");    
		Cough.setBounds(30,70,100, 30);    
                
                JButton Headache = new JButton("Headache");    
		Headache.setBounds(30, 200, 100, 30); 
                
                JButton Allergies = new JButton("Allergies");    
		Allergies.setBounds(30, 350, 100, 30);    
                
                JButton BodyPain = new JButton("BodyPain");    
		BodyPain.setBounds(30, 500, 100, 30);    
                
                JButton Exit = new JButton("Back");    
		Exit.setBounds(850, 600, 100, 30);    
                
                j2.add(label6);
                j2.add(Cough);   
                j2.add(Headache);   
                j2.add(Allergies);   
                j2.add(BodyPain);   
                j2.add(Exit);   
		j2.setSize(500,500);    
		j2.setLayout(null);    
		j2.setVisible(true);    
		j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
                
                Cough.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent e)
                    {
                        
                        
                    }
         
                });
                Headache.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent e)
                    {
                       
                    }
                });
                Allergies.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent e)
                    {
                        
                    }
                });
                BodyPain.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent e)
                    {
                       
                    }
                });
                Exit.addActionListener(new ActionListener()
                {
                    @Override
                    public  void actionPerformed(ActionEvent e)
                    {
                        
                    }
                });
                
              
      }
}
