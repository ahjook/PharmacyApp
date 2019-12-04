/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

/**
 *
 * @author ajocme_sd2022
 */
public class Pharmacist extends Account{

    public Pharmacist() {
    }

    public Pharmacist(String username, String password, String role) {
        super(username, password);
    }

    public Pharmacist(String username, String password, String fname, String lname, int age) {
        super(username, password, fname, lname, age);
    }

    public Pharmacist(PersonalInfo p, Account a) {
        super(p, a);
    }
    
}
