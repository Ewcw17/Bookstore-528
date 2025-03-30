/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import java.io.IOException;

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
        this.state = new Status();
        this.state.manageStatus(this.points);
    }
    
    boolean ownerLogin(){
        return false;
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
    
    public String getPassword() {
        return password;
    }
    
    public int buy(Book book){
        int totalCost = book.getPrice();
        points += (totalCost * 10);
        state.manageStatus(points);
        
        return totalCost;
    }
    
    public int redeemBuy(Book book){
        int totalCost;
        if (book.getPrice() - points/100 <= 0) {
            points -= book.getPrice() * 100;
            totalCost = 0;
        }
        
        else {
            totalCost = book.getPrice() - points/100;
            points = (points%100);
            
        }
        state.manageStatus(points);
        
        return totalCost;
    }
    
}
