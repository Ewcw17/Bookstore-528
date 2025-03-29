/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author elchoi
 */
public class Customers {
    public static ArrayList<Customer> customerList = new ArrayList<Customer>();
    
    static void customerWrite() throws IOException {
        FileWriter customerWrite = new FileWriter("customers.txt");
        for (int i = 0; i < customerList.size(); i++) {
            customerWrite.write(customerList.get(i).getUsername() + "," + customerList.get(i).getPoints() + "," + customerList.get(i).getState().getStatus() + "\n");
        }
        customerWrite.close();
    }
    
    void customerDisplay() { 
    if (customerList == null || customerList.isEmpty()) {
        System.out.println("No customers to display.");
        return;
    }

    for (int i  = 0; customerList.size() < i; i++) {
            System.out.println(customerList.get(i).getUsername() + "," + customerList.get(i).getPoints() + "," + customerList.get(i).getState().getStatus());
        }
    }
    
    
}
