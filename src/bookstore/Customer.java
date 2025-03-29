/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import java.util.ArrayList;

/**
 *
 * @author elchoi
 */


public class Customer extends User{
    private int points;
    private Status state;
    
    public Customer(String username, String password, int points) {
        super(username, password);
        this.points = points;   
    }
    
    void buy(Book book) {
        int totalCost = book.getPrice();
        points += (totalCost * 10);
        state.manageStatus(points);
        Books.bookList.remove(book);
    }
    
    void redeemBuy(Book book) {
        int totalCost;
        if (book.getPrice() - points/100 <= 0) {
            points -= book.getPrice() * 100;
            totalCost = 0;
        }
        
        else {
            points = 0;
            totalCost = book.getPrice() - points/100;
            
        }
        state.manageStatus(points);
        Books.bookList.remove(book);
        //buy multiple
    }
    
    int getPoints() {
        return points;
    }
    
    String getUsername() {
        return username;
    }
    
    Status getState() {
        return state;
    }
}
