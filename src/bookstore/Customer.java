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
        Books.bookList.remove(book);
    }
    
    void redeemBuy(Book book) {
        if (book.getPrice() - points/100 < 0) {
            points -= book.getPrice() * 100;
        }
        
        else {
            points = 0;
        }
        state.manageStatus(points);
        Books.bookList.remove(book);
        //buy multiple
    }
}
