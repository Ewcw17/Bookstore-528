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

import java.io.FileWriter;
import java.io.IOException;

public class Books {
    public static ArrayList<Book> bookList = new ArrayList<Book>();
    
    static void bookWrite() throws IOException {
        FileWriter bookWrite = new FileWriter("Books.txt");
        for (int i = 0; i < bookList.size(); i++) {
            bookWrite.write(bookList.get(i).getName() + "," + bookList.get(i).getPrice() + "\n");
        }
        bookWrite.close();
    }
    
    void booksDisplay() {
        if (bookList == null || bookList.isEmpty()) {
        System.out.println("No books to display.");
        return;
        }
        
        for (int i  = 0; bookList.size() < i; i++) {
            System.out.println(bookList.get(i).getPrice() + "\n" + bookList.get(i).getName());
        }
    }
}
