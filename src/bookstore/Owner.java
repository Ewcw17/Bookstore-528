/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import bookstore.Customers;
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
    void addCustom(String username, String password) {        
        Customer customer = new Customer(username, password, 0);
        Customers.customerlist.add(customer);
    }

    void deleteCustomer(String username, String password) {
        Customer customer = new Customer(username, password, 0);
        Customers.customerlist.remove(customer);
    }
    // throw errors for duplicates and bookPrice below 0
    void addBook(String bookName, int bookPrice) {
        Book book = new Book(bookName, bookPrice);
        Books.bookList.add(book);
    }
    
    void deleteBook(String bookName, int bookPrice) {
        Book book = new Book(bookName, bookPrice);
        Books.bookList.remove(book);
    }
    
}
