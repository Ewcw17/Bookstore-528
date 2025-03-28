/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package bookstore;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
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
        loginRoot.setAlignment(Pos.CENTER);
        VBox ownerMenuRoot = new VBox(20);
        ownerMenuRoot.setAlignment(Pos.CENTER);
        VBox customerMenuRoot = new VBox(5);
        customerMenuRoot.setAlignment(Pos.CENTER);
        VBox customerCostRoot = new VBox(5);
        customerCostRoot.setAlignment(Pos.CENTER);
        VBox ownerBooksRoot = new VBox(10);
        ownerBooksRoot.setAlignment(Pos.CENTER);
        VBox ownerCustomersRoot = new VBox(10);
        
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
        TextField usernameTF = new TextField();
        usernameTF.setPromptText("Username");
        PasswordField passwordTF = new PasswordField();
        passwordTF.setPromptText("Password");
        
        //Login button
        Button loginBtn = new Button();
        loginBtn.setText("Login");
        loginBtn.setPrefWidth(100);
        loginBtn.setStyle("-fx-background-color: #C8A2C8");
        
        loginRoot.setMargin(usernameTF, new Insets(15, 15, 15, 15));
        loginRoot.setMargin(passwordTF, new Insets(15, 15, 15, 15));
        loginRoot.setMargin(loginBtn, new Insets(15, 15, 15, 15));
        
        //placing the elements on screen
        loginRoot.add(username, 3, 5);
        loginRoot.add(usernameTF, 4, 5);
        loginRoot.add(password, 3, 6);
        loginRoot.add(passwordTF, 4, 6);
        loginRoot.add(loginBtn, 4, 7);
        
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
        loginScreen.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("The 'ENTER' key was pressed");
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
        booksBtn.setPrefWidth(200);
        booksBtn.setPrefHeight(50);
        Button customerBtn = new Button();
        customerBtn.setText("Customers");
        customerBtn.setPrefWidth(200);
        customerBtn.setPrefHeight(50);
        Button logoutBtn = new Button();
        logoutBtn.setText("Logout");
        logoutBtn.setPrefWidth(200);
        logoutBtn.setPrefHeight(50);
        
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
        
        HBox tableHB = new HBox();
        
        //Creating table
        TableView bookTable = new TableView();
        bookTable.setPrefWidth(300);
        
        Book books[] = {new Book("The Bible", 0), new Book("The Quran", 100000)};
        TableColumn<Book, String> nameBooksColumn = new TableColumn<>("Book Name");
        nameBooksColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        //ObservableList<Book> bookss = FXCollections.observableArrayList()
        bookTable.getItems().add(new Book("The Bible", 0));
   
        
        bookTable.getColumns().addAll(nameBooksColumn, priceColumn, selectColumn);
        tableHB.setAlignment(Pos.CENTER);
        tableHB.getChildren().add(bookTable);
        ownerBooksRoot.setMargin(tableHB, new Insets(10, 0, 20, 0));
        
        //This is a new container to put the text boxes and the add button 
        //in the same row on screen
        HBox addingBooksHB = new HBox(10);
        //labels for the fields
        Label bookName = new Label("Book Name:");
        Label bookPrice = new Label("Book Price:");
        addingBooksHB.setMargin(bookPrice, new Insets(0, 0, 0, 20));
        //Textfields
        TextField bookNameTF = new TextField();
        bookNameTF.setPrefWidth(100);
        bookNameTF.setAlignment(Pos.CENTER);
        TextField bookPriceTF = new TextField();
        bookPriceTF.setPrefWidth(100);
        bookPriceTF.setAlignment(Pos.CENTER);
        Button addBtn = new Button();
        addBtn.setText("Add");
        addBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        addingBooksHB.setMargin(addBtn, new Insets(0, 0, 0, 20));
        
        addingBooksHB.getChildren().add(bookName);
        addingBooksHB.getChildren().add(bookNameTF);
        addingBooksHB.getChildren().add(bookPrice);
        addingBooksHB.getChildren().add(bookPriceTF);
        addingBooksHB.getChildren().add(addBtn);
        addingBooksHB.setAlignment(Pos.CENTER);
        
        HBox backDeleteHB = new HBox(40);
        //Creating the buttons
        Button deleteBtn = new Button();
        deleteBtn.setText("Delete");
        deleteBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(bookNameTF.getText());
                primaryStage.setScene(ownerMenu);
            }
        });
        backDeleteHB.getChildren().add(deleteBtn);
        backDeleteHB.getChildren().add(backBtn);
        backDeleteHB.setAlignment(Pos.CENTER);
        ownerBooksRoot.setMargin(backDeleteHB, new Insets(10, 0, 20, 0));
        
        ownerBooksRoot.getChildren().add(tableHB);
        ownerBooksRoot.getChildren().add(addingBooksHB);
        ownerBooksRoot.getChildren().add(backDeleteHB);
        //---------------------------Owner Books Screen-------------------------
        
        
        //---------------------------Owner Customers Screen---------------------
        
        HBox tableCHB = new HBox();
        
        TableView customerTable = new TableView();
        TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        priceColumn.setPrefWidth(100);
        TableColumn<User, String> passwordColumn = new TableColumn<>("Password");
        priceColumn.setPrefWidth(100);
        TableColumn<User, String> pointsColumn = new TableColumn<>("Points");
        priceColumn.setPrefWidth(100);
        customerTable.getColumns().addAll(usernameColumn, passwordColumn, pointsColumn, selectColumn);
        
        tableCHB.getChildren().add(customerTable);
        tableCHB.setAlignment(Pos.CENTER);
        
        HBox textFieldCHB = new HBox(10);
        textFieldCHB.setAlignment(Pos.CENTER);
        
        //labels for the fields
        Label customerName = new Label("Username:");
        Label customerPassword = new Label("Password:");
        
        //the text fields
        TextField customerNameTF = new TextField();
        TextField customerPasswordTF = new TextField();
        
        Button addCBtn = new Button();
        addCBtn.setText("Add");
        addCBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        
        textFieldCHB.getChildren().add(customerName);
        textFieldCHB.getChildren().add(customerNameTF);
        textFieldCHB.getChildren().add(customerPassword);
        textFieldCHB.getChildren().add(customerPasswordTF);
        textFieldCHB.getChildren().add(addCBtn);
        ownerCustomersRoot.setMargin(textFieldCHB, new Insets(20, 0, 10, 0));
        
        HBox backDeleteCHB = new HBox(30);
        textFieldCHB.setAlignment(Pos.CENTER);
        
        
        Button deleteCBtn = new Button();
        deleteCBtn.setText("Delete");
        deleteCBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        Button backCBtn = new Button();
        backCBtn.setText("Back");
        backCBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        backCBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Back button Pressed");
                primaryStage.setScene(ownerMenu);
            }
        });
        
        backDeleteCHB.getChildren().add(deleteCBtn);
        backDeleteCHB.getChildren().add(backCBtn);
        backDeleteCHB.setAlignment(Pos.CENTER);
        ownerCustomersRoot.setMargin(backDeleteCHB, new Insets(10, 0, 20, 0));
        
        ownerCustomersRoot.getChildren().add(tableCHB);
        ownerCustomersRoot.getChildren().add(textFieldCHB);
        ownerCustomersRoot.getChildren().add(backDeleteCHB);
        ownerCustomersRoot.setAlignment(Pos.CENTER);
        //---------------------------Owner Customers Screen---------------------
        
        primaryStage.setTitle("Windowww");
        primaryStage.setScene(ownerCustomers);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
