/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

/**
 *
 * @author elchoi
 */
public class Book {
    private String bookName;
    private int bookPrice;
    
    public Book(String bookName, int bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }
    
    int getPrice() {
        return bookPrice;
    }
    
    String getName() {
        return bookName;
    }
    
    
}
