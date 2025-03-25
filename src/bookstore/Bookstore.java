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
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author e225wong
 */
public class Bookstore extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("login button pressed");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(loginBtn);
        
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Windowww");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
