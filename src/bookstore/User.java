/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

/**
 *
 * @author elchoi
 */
<<<<<<< HEAD
public class User {
    protected String username;
=======
public abstract class User {
    private String username;
>>>>>>> 76cdb2e9215bee8d9ed2aebe351091fb98a70402
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    void login() {
        
    }
    
    void logout() {
        
    }

}
