/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import java.io.IOException;
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
    
    public int getPoints(){
        return points;
    }
    
    public Status getState(){
        return state;
    }
    
    public String getUsername() {
        return username;
    }
    
    void buy(Book book) throws IOException {
        int totalCost = book.getPrice();
        points += (totalCost * 10);
        state.manageStatus(points);
        Books.bookList.remove(book);
        Books.bookWrite();
    }
    
    void redeemBuy(Book book) throws IOException {
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
        Books.bookWrite();
        //buy multiple
    }
    
}
