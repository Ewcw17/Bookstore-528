/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import bookstore.Customers;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.Stage;

/**
 *
 * @author elchoi
 */
public class Owner extends User {
    private String username = "admin";
    private String password = "admin";

    public Owner(String username, String password) {
        super(username, password);
    }
    
    // throw errors for deleting admin and duplicates
    void addCustomer(String username, String password){        
        Customer customer = new Customer(username, password, 0);
        Customers.customerList.add(customer);
    }

    void deleteCustomer(int index){
        Customers.customerList.remove(index);
    }
    // throw errors for duplicates and bookPrice below 0
    void addBook(String bookName, int bookPrice){
        Book book = new Book(bookName, bookPrice);
        Books.bookList.add(book);
    }
    
    void deleteBook(int index){
        Books.bookList.remove(index);
    }
    
}
