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
public class BodyPain extends Medicine {

    public BodyPain() {
    }

    public BodyPain(String type, String brandName, double price, String genericName, int quantity) {
        super(type, brandName, price, genericName, quantity);
    }

    public BodyPain(String brandName, double price, int quantity) {
        super(brandName, price, quantity);
    }
    
    
}
