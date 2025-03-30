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
        if (status.equals("Gold") && status.equals("Silver") == false) {
     // return an error message or something like that
        }
        this.status = status;     
    }
    
    public void manageStatus(int points) {
        if (points >= 1000) {
            this.status = "Gold";
        }
        
        if (points < 1000) {
            this.status = "Silver";
        }
    }
    
    public String getStatus() {
        return this.status;
    }
}
