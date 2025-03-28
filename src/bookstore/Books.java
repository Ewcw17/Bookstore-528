package bookstore;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elchoi
 */
public class Books {
    public static ArrayList<Book> bookList = new ArrayList<Book>();
    
    void booksDisplay() {
        for (int i  = 0; bookList.size() < i; i++) {
            System.out.println(bookList.get(i).getPrice() + "\n" + bookList.get(i).getName());
        }
    }
}
