/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

import Drag.*;
import GUI.*;
import java.util.ArrayList;
import java.util.Scanner;

//import pharmacyapp.Botica.Botica;

/**
 *
 * @author ajocme_sd2022
 */
public class PharmacyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Pharmacy p = new Pharmacy();
        p.addStock();
//        display.firstMenu();
        Account acc = new Account();
//        RegisterJFrame reg = new RegisterJFrame();
//          Cough co = new Cough();
        Botica bot = new Botica();
//        Page1 pag = new Page1();
//      Login log = new Login();
//        new Botica();

        OUTER_1:
        while (true) {
            OUTER_2:
            while (true) {
                System.out.println("----------------------------------WELCOME TO SUAREZ PHARMACY----------------------------------------");
                System.out.print("\n1. Customer\n2. Pharmacist\nEnter Choice: ");
                int in1 = input.nextInt();
//                System.out.println("\nInput 1 if you want to sign up and input 2 if you want to login");
                System.out.println("\n--------------------------------------------------");
               System.out.print("1. Register\n2. Log In\nEnter Choice: ");
                int in2 = input.nextInt();
                switch (in1) {
                    //customer
                    case 1:
                        switch (in2) {
                            case 1:
                                acc = p.registerCustomer();
                                if (acc.getUsername() == null) {
                                    System.out.println("\nMINORS ARE NOT ALLOWED TO PURCHASE!\n");
                                    break;
                                } else {
                                    break OUTER_2;
                                }
                            case 2:
                                acc = p.loginCustomer();
                                if (acc.getUsername() != null) {
                                    break OUTER_2;
                                } else {
                                    System.out.println("\nCANNOT FIND ACCOUNT!");
                                }
                                break;
                            default:
                                System.out.println("\nINVALID INPUT!");
                        }
                        break;
                    //pharmacist
                    case 2:
                        switch (in2) {
                            case 1:
                                acc = p.registerPharmacist();
                                break OUTER_2;
                            case 2:
                                acc = p.loginPharmacist();
                                if (acc.getUsername() != null) {
                                    break OUTER_2;
                                } else {
                                    System.out.println("\nCANNOT FIND ACCOUNT!");
                                }
                                break;
                            default:
                                System.out.println("\nINVALID INPUT!");
                        }
                        break;
                    default:
                        System.err.println("Invalid Input.");
                        break;
                }
            }

            //if customer
            if (acc instanceof Customer) {
                ArrayList<Medicine> purchasedTempHolder = new ArrayList();
                OUTER_3:
                while (true) {
//                    System.out.println("--------------------------------------------------\n");
                    System.out.println("\n----------------Choose Number----------------------");
                    System.out.print("\n1. Purchased Medicine\n2. Exit\nEnter Choice: ");
                    switch (input.nextInt()) {
                        case 1:
                            System.out.println("\n----------------Menu By Category-------------------");
                            System.out.println("\n1. Cough\n2. Headache\n3. allergies\n4. Body Pain\n5. Exit\nEnter Choice:");
//                            System.out.println("Enter Choice:");
                            int in4 = input.nextInt();
                            System.out.println("\n---------------------------------------------------------Medicines by Category-------------------------------------------------\n");
                            System.out.println("");
                            p.displayMed(in4);
                            if (in4 <= 5 && in4 > 0) {
                                p.purchaseMed((Customer) acc, purchasedTempHolder);
                            }
                            break;
                        case 2:
                            p.computeTotal((Customer) acc, purchasedTempHolder);
                            break OUTER_3;
                        default:
                            System.out.println("\nINVALID INPUT!");
                    }
                }
                //if pharmacist
            } else {
                OUTER_4:
                while (true) {
                    System.out.println("----------------Choose Number--------------------------");
                    System.out.print("1. View Types of Medicine\n2. Add Medicine\n3.Exit \nEnter Choice: ");
                    switch (input.nextInt())
                    {
                        case 1:
                            System.out.println("---------------------------------------------------------");
                            System.out.println("\n1. Cough\n2. Headache\n3. allergies\n4. Body Pain\n5. Exit\n");
                            int in4 = input.nextInt();
                            p.displayMed(in4);
                            break;
                        case 2:
                            p.addMedicine();
                            System.out.println("Successfully Added!");
                            break;
//                        case 3:
//                            p.viewUsers();
//                            break ;
                        case 3:
//                              p.registerPharmacist();
//                            String medname = input.nextLine();
//                            p.removeMedicine(medname);
                            break OUTER_4;
                        default:
                            System.out.println("\nINVALID INPUT!\n");
                    }
                }
            }
        }

    }
    
}
