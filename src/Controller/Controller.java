/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ajocme_sd2022
 */
public class Controller {
      Model model = new Model();

    public boolean purchase(String username, String brandname, String quantity, String money) {
        boolean success = false;
        try {
            int qty = Integer.parseInt(quantity);
            try {
                double cash = Double.parseDouble(money);
                if (model.purchase(username, brandname, qty, cash) == true) {
                    return success = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Money should be a number!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantity should be a number!");
        }
        return success;
    }

    public int login(String username, String password) {
        int success = 400;
        success = model.login(username, password);
        return success;
    }

    public boolean register(String uname, String age, String password) {
        boolean success = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/eulin", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `user` WHERE username='" + uname + "'");

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username is already taken!");
            } else {
                try {
                    int myAge = Integer.parseInt(age);
                    if (myAge < 18) {
                        JOptionPane.showMessageDialog(null, "Minors are not allowed to register!");
                    } else {
                        return success = model.register(uname, myAge, password);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Age should only be a number!");
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Eror connecting to database!");

        }
        return success;
    }

    public boolean addMedicine(String bname, String gname, String type, String quant, String prc) {
        boolean success = false;
        try {
            double price = Double.parseDouble(prc);
            try {
                int qty = Integer.parseInt(quant);
                return success = model.addMedicine(bname, gname, type, qty, price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity should be a number!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price should be a number!");
        }
        return success;
    }

    public boolean removeMedicine(String bname) {
        boolean success = false;
        boolean exist = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/eulin", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicine` WHERE brandname='" + bname + "'");

            while (rs.next()) {
                if (rs.getString("brandname").equals(bname)) {
                    exist = true;
                    return success = model.removeMedicine(bname);
                }
            }
            if (exist == false) {
                JOptionPane.showMessageDialog(null, "Medicine do not exist!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Eror connecting to database!");
        }

        return success;
    }

}

