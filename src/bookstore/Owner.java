/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import bookstore.Customers;
import java.io.IOException;
import java.util.ArrayList;

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
    void addCustomer(String username, String password) throws IOException {        
        Customer customer = new Customer(username, password, 0);
        Customers.customerList.add(customer);
        Customers.customerWrite();  // No need to modify method calls
    }

    void deleteCustomer(String username, String password) throws IOException {
        Customer customer = new Customer(username, password, 0);
        Customers.customerList.remove(customer);
        Customers.customerWrite();
    }
    // throw errors for duplicates and bookPrice below 0
    void addBook(String bookName, int bookPrice) throws IOException {
        Book book = new Book(bookName, bookPrice);
        Books.bookList.add(book);
        Books.bookWrite();
    }
    
    void deleteBook(String bookName, int bookPrice) throws IOException {
        Book book = new Book(bookName, bookPrice);
        Books.bookList.remove(book);
        Books.bookWrite();
    }
    
}
