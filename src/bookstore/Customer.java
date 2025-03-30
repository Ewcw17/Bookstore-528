/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;

/**
 *
 * @author elchoi
 */


public class Customer extends User{
    private int points;
    private Status state;
    private CheckBox select;
    
    public Customer(String username, String password, int points) {
        super(username, password);
        this.points = points;
        this.select = new CheckBox();
        this.state = new Status();
        this.state.manageStatus(this.points);
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
    
    public CheckBox getSelect(){
        return select;
    }
    
    void buy(Book book) throws IOException {
        int totalCost = book.getPrice();
        points += (totalCost * 10);
        state.manageStatus(points);
        Books.bookList.remove(book);
        //Books.bookWrite();
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
        //Books.bookWrite();
        //buy multiple
    }
    
}
