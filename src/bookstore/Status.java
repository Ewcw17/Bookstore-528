/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore;

/**
 *
 * @author elchoi
 */
public class Status{
    String status;
    public void Status(String status) {
        if (status.equals("gold") && status.equals("silver") == false) {
     // return an error message or some shit like that
        }
        this.status = status;     
    }
    
    public void manageStatus(int points) {
        if (points >= 1000) {
            this.status = "gold";
        }
        
        if (points < 1000) {
            this.status = "silver";
        }
    }
    
    public String getStatus() {
        return this.status;
    }
}
