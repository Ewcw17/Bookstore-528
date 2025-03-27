/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package bookstore;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
        ownerMenuRoot.setAlignment(Pos.CENTER);
        VBox customerMenuRoot = new VBox();
        customerMenuRoot.setAlignment(Pos.CENTER);
        VBox customerCostRoot = new VBox();
        customerCostRoot.setAlignment(Pos.CENTER);
        GridPane ownerBooksRoot = new GridPane();
        GridPane ownerCustomersRoot = new GridPane();
        
        Scene loginScreen = new Scene(loginRoot, 600, 400);
        Scene ownerMenu = new Scene(ownerMenuRoot, 600, 400);
        Scene customerMenu = new Scene(customerMenuRoot, 600, 400);
        Scene customerCost = new Scene(customerCostRoot, 600, 400);
        Scene ownerBooks = new Scene(ownerBooksRoot, 600, 400);
        Scene ownerCustomers = new Scene(ownerCustomersRoot, 600, 400);
        
        
        //-----------------------LOGIN SCREEN-----------------------------------
        //Labels for the textfields
        Label username = new Label("Username:");
        Label password = new Label("Password:");
        
        //The textFields
        TextField usernameTF = new TextField("Username:");
        PasswordField passwordTF = new PasswordField();
        
        //Login button
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        loginBtn.setPrefWidth(100);
        
        //placing the elements on screen
        loginRoot.add(username, 3, 5);
        loginRoot.add(usernameTF, 4, 5);
        loginRoot.add(password, 3, 6);
        loginRoot.add(passwordTF, 4, 6);
        loginRoot.add(loginBtn, 3, 7);
        
        //Controls what the login button does
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("login button pressed");
                System.out.println(usernameTF.getText());
                if(usernameTF.getText().equals("Owner")){
                    primaryStage.setScene(ownerMenu);
                }else if(usernameTF.getText().equals("Customer")){
                    primaryStage.setScene(customerMenu);
                }
            }
        });
        //-----------------------LOGIN SCREEN-----------------------------------
        
        
        //-----------------------Owner Start Screen-----------------------------
        //Creating buttons for the page
        Button booksBtn = new Button();
        booksBtn.setText("Books");
        booksBtn.setPrefWidth(100);
        Button customerBtn = new Button();
        customerBtn.setText("Customers");
        customerBtn.setPrefWidth(100);
        Button logoutBtn = new Button();
        logoutBtn.setText("Logout");
        logoutBtn.setPrefWidth(100);
        
        //Placing the buttons on screen
        ownerMenuRoot.getChildren().add(booksBtn);
        ownerMenuRoot.getChildren().add(customerBtn);
        ownerMenuRoot.getChildren().add(logoutBtn);
        
        //Controlling what the buttons do
        customerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Customers button Pressed");
                primaryStage.setScene(ownerCustomers);
            }
        });
        booksBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Books Button Pressed");
                primaryStage.setScene(ownerBooks);
            }
        });
        logoutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Logout Button on owner Pressed");
                primaryStage.setScene(loginScreen);
            }
        });
        //-----------------------Owner Start Screen-----------------------------
        
        
        //--------------------------Customer Start Screen-----------------------
        //Making variables and creating the welcome text
        String name = "Ernest";
        int points = 19;
        String status = "Bub";
        Label welcomeMessage = new Label("Welcome " + name + ", you have " + points + " points. Your status is: " + status + ".");
        
        //Making the tables and columns for the table of books
        TableView tableView = new TableView();
        TableColumn<User, String> nameColumn = new TableColumn<>("Book Name");
        nameColumn.setPrefWidth(100);
        TableColumn<User, String> priceColumn = new TableColumn<>("Book Price");
        priceColumn.setPrefWidth(100);
        TableColumn<User, String> selectColumn = new TableColumn<>("Select");
        tableView.getColumns().addAll(nameColumn, priceColumn, selectColumn);
        
        //Making the different buttons
        Button buyBtn = new Button();
        buyBtn.setText("Buy");
        buyBtn.setPrefWidth(100);
        Button buyRBtn = new Button();
        buyRBtn.setText("Redeem Points & Buy");
        buyRBtn.setPrefWidth(100);
        Button logoutCBtn = new Button();
        logoutCBtn.setText("Logout");
        logoutCBtn.setPrefWidth(100);
        
        //Logic and control for the buttons
        buyBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Buy Button Pressed");
                primaryStage.setScene(customerCost);
            }
        });
        buyRBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Buy and Redeem button Pressed");
                primaryStage.setScene(customerCost);
            }
        });
        logoutCBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Logout Button on Customer start Pressed");
                primaryStage.setScene(loginScreen);
            }
        });
        
        //placing the elements on screen
        customerMenuRoot.getChildren().add(welcomeMessage);
        customerMenuRoot.getChildren().add(tableView);
        //CHEKCBOX STILL MISSINGSDPFIJFSPDOFJSODPFJOFJSPDFOJSODFJ
        customerMenuRoot.getChildren().add(buyBtn);
        customerMenuRoot.getChildren().add(buyRBtn);
        customerMenuRoot.getChildren().add(logoutCBtn);
        
        //--------------------------Customer Start Screen-----------------------
        
        
        //-----------------------Customer Cost Screen---------------------------
        //Making the variable 
        double totalCost = 0;
        
        //labels displaying the cost
        Label costL = new Label("Total Cost: " + totalCost);
        Label pointsL = new Label("Points: " + points + ", Status: " + status + ".");
        
        //creating button
        Button logoutCCBtn = new Button();
        logoutCCBtn.setText("Logout");
        
        //Logic for button
        logoutCCBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Logout Button on Customer Cost Pressed");
                primaryStage.setScene(loginScreen);
            }
        });
        
        //placing the elements on screen
        customerCostRoot.getChildren().add(costL);
        customerCostRoot.getChildren().add(pointsL);
        customerCostRoot.getChildren().add(logoutCCBtn);
        //-----------------------Customer Cost Screen---------------------------
        
        
        //---------------------------Owner Books Screen-------------------------
        //Creating table
        TableView bookTable = new TableView();
        bookTable.getColumns().addAll(nameColumn, priceColumn);
        
        //labels for the fields
        Label bookName = new Label("Book Name:");
        Label bookPrice = new Label("Book Price:");
        
        //the text fields
        TextField bookNameTF = new TextField();
        TextField bookPriceTF = new TextField();
        
        //Creating the buttons
        Button addBtn = new Button();
        addBtn.setText("Add");
        Button deleteBtn = new Button();
        deleteBtn.setText("Delete");
        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Back button Pressed");
                primaryStage.setScene(ownerMenu);
            }
        });
        
        ownerBooksRoot.add(bookTable, 1, 0);
        ownerBooksRoot.add(bookName, 0, 1);
        ownerBooksRoot.add(bookNameTF, 1, 1);
        ownerBooksRoot.add(bookPrice, 0, 2);
        ownerBooksRoot.add(bookPriceTF, 1, 2);
        ownerBooksRoot.add(addBtn, 0, 3);
        ownerBooksRoot.add(deleteBtn, 0, 4);
        ownerBooksRoot.add(backBtn, 0, 5);
        //---------------------------Owner Books Screen-------------------------
        
        
        //---------------------------Owner Customers Screen---------------------
        TableView customerTable = new TableView();
        TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        priceColumn.setPrefWidth(100);
        TableColumn<User, String> passwordColumn = new TableColumn<>("Password");
        priceColumn.setPrefWidth(100);
        TableColumn<User, String> pointsColumn = new TableColumn<>("Points");
        priceColumn.setPrefWidth(100);
        customerTable.getColumns().addAll(usernameColumn, passwordColumn, pointsColumn);
        
        //labels for the fields
        Label customerName = new Label("Username:");
        Label customerPassword = new Label("Password:");
        
        //the text fields
        TextField customerNameTF = new TextField();
        TextField customerPasswordTF = new TextField();
        
        Button addCBtn = new Button();
        addCBtn.setText("Add");
        Button deleteCBtn = new Button();
        deleteCBtn.setText("Delete");
        Button backCBtn = new Button();
        backCBtn.setText("Back");
        backCBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Back button Pressed");
                primaryStage.setScene(ownerMenu);
            }
        });
        
        ownerCustomersRoot.add(customerTable, 1, 0);
        ownerCustomersRoot.add(customerName, 0, 1);
        ownerCustomersRoot.add(customerNameTF, 1, 1);
        ownerCustomersRoot.add(customerPassword, 0, 2);
        ownerCustomersRoot.add(customerPasswordTF, 1, 2);
        ownerCustomersRoot.add(addCBtn, 0, 3);
        ownerCustomersRoot.add(deleteCBtn, 0, 4);
        ownerCustomersRoot.add(backCBtn, 0, 5);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Back button Pressed");
                primaryStage.setScene(ownerMenu);
            }
        });
        //---------------------------Owner Customers Screen---------------------
        
        primaryStage.setTitle("Windowww");
        primaryStage.setScene(loginScreen);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
