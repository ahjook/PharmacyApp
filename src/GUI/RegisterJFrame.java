/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author ajocme_sd2022
 */
import Drag.Login;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import pharmacyapp.*;

public class RegisterJFrame extends JFrame {

    JLabel Name, Username, Age, Password, Address;
    JTextField n1, u1, a1 ,a2;
    JButton btn1;
    JPasswordField p1;

    public RegisterJFrame() {
        JFrame f = new JFrame("Suarez Pharmacy");
        //submit button
        JButton btn1 = new JButton("Register");
        btn1.setBounds(150, 360, 100, 30);
        //enter name label
        JLabel label = new JLabel();
        JLabel label5 = new JLabel();
        label5.setText("<html><h1>Create Account </h1></html>");
        label5.setBounds(100, 0, 200, 100);
//		label.setText("Enter Name :");
//		label.setBounds(0, 50, 100, 100);
//					//empty label which will show event after button clicked
//		JLabel Name1 = new JLabel();
//		Name.setBounds(150, 100, 200, 50);
//					//textfield to enter name
//		JTextField textfield = new JTextField();
//		textfield.setBounds(80, 85, 250, 30);
        //add to frame
        Name = new JLabel("Name:");
        Name.setBounds(2, 50, 100, 100);
        Username = new JLabel("Username:");
        Username.setBounds(2, 90, 100, 100);
        Age = new JLabel("Age:");
        Age.setBounds(2, 130, 100, 100);
//        Age = new JLabel("Age:");
//        Age.setBounds(220, 130, 100, 100);
//        Phone = new JLabel("Phone Number:");
//        Phone.setBounds(2, 170, 100, 100);
//        Address = new JLabel("Address:");
//        Address.setBounds(2, 210, 100, 100);
        Address = new JLabel("Password:");
        Address.setBounds(2, 170, 100, 100);
        Password = new JLabel("ConfirmedPassword:");
        Password.setBounds(2, 210, 100, 100);

        n1 = new JTextField();
        n1.setBounds(90, 80, 270, 30);
        u1 = new JTextField();
        u1.setBounds(90, 120, 270, 30);
        a1 = new JTextField();
        a1.setBounds(90, 160, 270, 30);
//        a1 = new JTextField();
//        a1.setBounds(260, 160, 100, 30);
//        a2 = new JTextField();
//        a2.setBounds(90, 240, 270, 30);
//        ph1 = new JTextField();
//        ph1.setBounds(90, 200, 150, 30);
//                
        a2 = new JPasswordField();
        a2.setBounds(90, 240, 270, 30);
        p1 = new JPasswordField();
        p1.setBounds(90, 200, 270, 30);
//                

        f.add(label5);
        f.add(Name);
        f.add(n1);
        f.add(Username);
        f.add(u1);
//        f.add(Birthday);
//        f.add(b1);
        f.add(Age);
        f.add(a1);
//        f.add(Phone);
//        f.add(ph1);
//        f.add(Address);
//        f.add(a2);
        f.add(Password);
        f.add(p1);
        f.add(Address);
        f.add(a2);
        f.add(label);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Save Button
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                  try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/PharmacyApp";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // the mysql insert statement
            String query = " insert into register(fullname,username,age,password,address)"
                    + " values (?,?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, n1.getText());
            preparedStmt.setString(2, u1.getText());
            preparedStmt.setString(3, a1.getText());
            preparedStmt.setString(4, p1.getText());
//            preparedStmt.setString(5, a.getText());

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        Login login = new Login();
        login.setVisible(true);
        JOptionPane.showMessageDialog(null, "Successfully Registered!!!");
        f.dispose();

            }

            //action listener
//            @Override
//            public void actionPerformed(ActionEvent ae) {
////                    Name.setText("Registered!");
//
//                if (ae.getSource() == btn1) {
////                      JTextField n1 , u1 , b1, a1, a2 , ph1;
//                    int x = 0;
//                    String s1 = n1.getText();
//                    String s2 = u1.getText();
////                    String s3 = b1.getText();
//                    String s4 = a1.getText();
////                    String s5 = a2.getText();
////                    String s6 = ph1.getText();
//                    char[] s7 = p1.getPassword();
//                    char[] s8 = p2.getPassword();
//                    String s9 = new String(s7);
//                    String s0 = new String(s8);
//                }
//
//            }

            private boolean RegisterData() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

          
        });
        f.add(btn1);
        f.setSize(500, 500);
    }

    public Boolean RegisterData(ActionEvent ae) {

        if (ae.getSource() == btn1) {
            String Name = n1.getText();
            String Username = u1.getText();
            String Age = a1.getText();
            String Password = new String(p1.getPassword());
            String Address = new String(a2.getText());

            if (Name.equals("")) //Username
            {
                JOptionPane.showMessageDialog(null, "Please Input Name");
                n1.requestFocusInWindow();
                return false;
            }
            if (Username.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Input Username");
                u1.requestFocusInWindow();
                return false;
            }
            if (Age.equals("")) {
                int edad = Integer.parseInt(Age);
                if (edad < 18) {
                    JOptionPane.showMessageDialog(null, "Sorry! Underage are not allowed to register");
                } else {

                }
                JOptionPane.showMessageDialog(null, "Please Input Age");
                a1.requestFocusInWindow();
                return false;

            }
            if (Password.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Input Password");
                p1.requestFocusInWindow();
                return false;
            }
            if (Address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Input Password");
                a2.requestFocusInWindow();
                return false;
            }
            if (!Password.equals(Address)) //Check if the password is match
            {
                JOptionPane.showMessageDialog(null, "Password not match");
                p1.requestFocusInWindow();
                return false;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
           
            }
        });
        
    }
}
