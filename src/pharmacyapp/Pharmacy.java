/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ajocme_sd2022
 */
public class Pharmacy {
    Scanner in = new Scanner(System.in);
    private ArrayList<Medicine> medicines;
    private ArrayList<Account> accounts;

    public Pharmacy(ArrayList<Medicine> medicines, ArrayList<Account> accounts) {
        this.medicines = medicines;
        this.accounts = accounts;
    }

    public void viewUsers() {
        for (Account account : accounts) {
            if (account instanceof Customer) {
                System.out.println(account);
                if (!((Customer) account).getPurchasedMedicine().isEmpty()) {
                    System.out.println("Purchase history:");
                    Customer acc = (Customer) account;
                    computeTotal(acc, acc.getPurchasedMedicine());
                }
            }
        }
    }

    public Pharmacy() {
        medicines = new ArrayList();
        accounts = new ArrayList();
    }

    public Account registerPharmacist() {
        Account a = inputAccount();
//        System.out.println("\nPersonal Information:");
        PersonalInfo p = inputPerInfo();
        Pharmacist ph = new Pharmacist(p, a);
        accounts.add(ph);
        System.out.println("Account successfully created");
        System.out.println("---------------------------------------------------\n\n");
        return ph;
    }

    public Account loginPharmacist() {
        Account a = inputAccount();
        for (int i = 0; i < accounts.size(); ++i) {
            Account acc = accounts.get(i);
            if (acc.getUsername().equals(a.getUsername()) && acc.getPassword().equals(a.getPassword())) {
                return acc;
            }
        }
        return new Account();
    }

    public Account registerCustomer() {
        Account a = inputAccount();
//        System.out.println("\nPersonal Information:");
        PersonalInfo p = inputPerInfo();
        if (p.getAge() >= 18) {
            Customer c = new Customer(p, a);
            accounts.add(c);
            System.out.println("Account successfully created!Welcome");
//            System.out.println("Customer Mode" + );
            return c;
        }
        return new Account();
    }
//    if (name instanceof User) {
//                            System.out.println("Customer Mode:" + name.accountInfo());
//                            success = "success";
//                            med="customer";
//                        } else if (name instanceof Pharmacist) {
//                            System.out.println("Pharmacist mode: " + name.accountInfo());
//                            success = "success";
//                            med="pharmacist";
//    
//    
    public Account loginCustomer() {
        Account a = inputAccount();
        for (int i = 0; i < accounts.size(); ++i) {
            Account acc = accounts.get(i);
            if (acc.getUsername().equalsIgnoreCase(a.getUsername()) && acc.getPassword().equalsIgnoreCase(a.getPassword())) {
                return acc;
            }
        }
        return new Account();
    }

    public void addMedicine() {
        String type = inputString("Enter type: ");
        String bname = inputString("Enter brand name: ");
        String gname = inputString("Enter generic name: ");
        double price = inputInt("Enter price: ");
        int quant = inputInt("Enter quantity: ");
        medicines.add(new Medicine(type, bname, price, gname, quant));
        
    }

//    public void removeMedicine(String name) {
//        for (Medicine m : medicines) {
//            if (m.getGenericName().equals(name)) {
//                medicines.remove(m);
//            }
//        }
//    }

    public ArrayList<Medicine> purchaseMed(Customer c, ArrayList<Medicine> purchased) {
        while (true) {
            System.out.println("Enter medicine: ");
            String med = in.next();
            int quant = inputInt("Enter quantity: ");
            Medicine foundmed = findMedicine(med);
            if (foundmed.getBrandName() != null) {
                if (foundmed.getQuantity() >= quant) {
                    foundmed.setQuantity(foundmed.getQuantity() - quant);
                    Medicine purMed = new Medicine(med, foundmed.getPrice(), quant);
                    c.addPurchasedMedicine(purMed);
                    purchased.add(purMed);
                    System.out.println("Press any key to add more\nPress 'a' to exit");
                    String ch = in.next();
                    if (ch.equalsIgnoreCase("a")) {
                        computeTotal(c, purchased);
                        break;
                    } 
                } else {
                    System.out.println("Medicine stock is insufficient\nThe available only is " + foundmed.getQuantity());
                }
            } else {
                System.out.println("Medicine is unavailable!");
            }
        }
        return purchased;
    }

    public void computeTotal(Customer c, ArrayList<Medicine> pmed) {
        double total = 0;
        System.out.println("__________________________________________________");
        for (Medicine m : pmed) {
            System.out.println("Medicine: " + m.getBrandName());
            System.out.println("Price: " + m.getPrice());
            System.out.println("Quantity: " + m.getQuantity());
            System.out.println("Total: " + m.getPrice() * m.getQuantity());
            total += m.getPrice() * m.getQuantity();
            System.out.println("__________________________________________________");
        }
        if (c.getAge() > 59) {
            total = total - (total * .20);
            System.out.println("DISCOUNT 20%");
        }
        System.out.println("TOTAL AMOUNT: " + total);
        System.out.println("__________________________________________________\n\n");
    }

    public void addMedicine(Medicine m) {
        medicines.add(m);
    }

    public Medicine findMedicine(String medName) {
        for (Medicine m : medicines) {
            if (m.getBrandName().equals(medName)) {
                return m;
            }
        }
        return new Medicine();
    }

    public void displayMed() {
        for (Medicine m : medicines) {
            System.out.println(m);
        }
    }

    public void displayType() {
        String type = inputString("Enter type of medicine: ");
        for (Medicine m : medicines) {
            if (m.getType().equals(type)) {
                System.out.println(m);
            }
        }
    }

    public String inputString(String label) {
        System.out.print(label);
        return in.nextLine();
    }

    public int inputInt(String label) {
        System.out.print(label);
        return in.nextInt();
    }

    public PersonalInfo inputPerInfo() {
        String fname = inputString("Enter First Name: ");
        String lname = inputString("Enter last Name: ");
        String age = inputString("Enter Age: ");
        return new PersonalInfo(fname, lname, Integer.valueOf(age));
    }

    public Account inputAccount() {
        System.out.println("\n---------------Personal Information---------------");
        String uname = inputString("\nEnter User Name: ");
        String pass = inputString("Enter Password: ");
        return new Account(uname, pass);
    }

    public void viewType(String type) {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\n%20s | %20s | %20s | %20s |%20s", "Type", "BrandName", "Price", "Generic Name", "Quantity\n");
         System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        for (Medicine m : medicines) {
            if (m.getType().equalsIgnoreCase(type)) {
                System.out.println(m);
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public void addStock() {
        medicines.add(new Medicine("Cough", "Solmux", 35, "Carbocistine", 50));
        medicines.add(new Medicine("Headache", "Aspirin", 25, "acetylsalicylic acid", 50));
        medicines.add(new Medicine("Allergies", "Allerkid", 25, "Cetirizine", 50));
        medicines.add(new Medicine("Body Pain", "Alaxan", 25, "Ibufrofen + Paracetamol", 50));

        medicines.add(new Medicine("Cough", "ExpelOD", 35, "Ambroxol", 50));
        medicines.add(new Medicine("Headache", "Motrin", 25, "Ibuprofen", 50));
        medicines.add(new Medicine("Allergies", "Allerta", 23, "Cetirizine", 50));
        medicines.add(new Medicine("Body Pain", "Rexidol", 10, "Paracetamol Caffeine", 50));

        medicines.add(new Medicine("Cough", " Myracof", 30, "Ambroxol", 50));
        medicines.add(new Medicine("Headache", "Norflex", 50, "Orphenadrine citrate", 50));
        medicines.add(new Medicine("Allergies", "Allegra", 25, "Loratadine", 50));
        medicines.add(new Medicine("Body Pain", "Medicol", 20, "Ibuprofen s", 50));

    }

    public void displayMed(int in4) {
        switch (in4) {
            case 1:
                viewType("Cough");
                break;
            case 2:
                viewType("Headache");
                break;
            case 3:
                viewType("Allergies");
                break;
            case 4:
                viewType("Body Pain");
                break;
            case 5:
                break;
            default:
                System.out.println("\nIVALID INPUT!");
        }
    }
    
}
