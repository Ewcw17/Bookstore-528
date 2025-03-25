/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package bookstore;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author e225wong
 */
public class Bookstore extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane loginRoot = new GridPane();
        VBox ownerMenuRoot = new VBox();
        GridPane customerMenuRoot = new GridPane();
        GridPane customerCostRoot = new GridPane();
        GridPane ownerBooksRoot = new GridPane();
        GridPane ownerCustomersRoot = new GridPane();
        
        Scene loginScreen = new Scene(loginRoot, 600, 400);
        Scene ownerMenu = new Scene(ownerMenuRoot, 600, 400);
        Scene customerMenu = new Scene(customerMenuRoot, 600, 400);
        Scene customerCost = new Scene(customerCostRoot, 600, 400);
        Scene ownerBooks = new Scene(ownerBooksRoot, 600, 400);
        Scene ownerCustomers = new Scene(ownerCustomersRoot, 600, 400);
        
        //labels for the fields
        Label username = new Label("Username:");
        Label password = new Label("Password:");
        
        //the text fields
        TextField usernameTF = new TextField("Username:");
        PasswordField passwordTF = new PasswordField();
        
        //Login button
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        
        //placing the elements on screen
        loginRoot.add(username, 3, 5);
        loginRoot.add(usernameTF, 4, 5);
        loginRoot.add(password, 3, 6);
        loginRoot.add(passwordTF, 4, 6);
        loginRoot.add(loginBtn, 3, 7);
        
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("login button pressed");
            }
        });
        
        //Login button
        Button booksBtn = new Button();
        booksBtn.setText("Books");
        Button customerBtn = new Button();
        customerBtn.setText("Customers");
        Button logoutBtn = new Button();
        logoutBtn.setText("Logout");
        
        //placing the elements on screen
        ownerMenuRoot.getChildren().add(booksBtn);
        ownerMenuRoot.getChildren().add(customerBtn);
        ownerMenuRoot.getChildren().add(logoutBtn);
        
        primaryStage.setTitle("Windowww");
        primaryStage.setScene(ownerMenu);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
