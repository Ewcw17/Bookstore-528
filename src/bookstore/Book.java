/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

import javafx.scene.control.CheckBox;
/**
 *
 * @author elchoi
 */
public class Book {
    private String bookName;
    private int bookPrice;
    private CheckBox select;
    
    public Book(String bookName, int bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.select = new CheckBox();
    }
    
    public int getPrice() {
        return bookPrice;
    }
    
    public String getName() {
        return bookName;
    }
    
    public CheckBox getSelect(){
        return select;
    }
    
    public void resetCheck(){
        select.setSelected(false);
    }
}
