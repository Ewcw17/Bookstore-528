/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package bookstore;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author e225wong
 */

public class Bookstore extends Application {
    
    String title = "Gamer";
    
//    Customers.customerlist.add(new Customer("Ernest", "404midterm", 15));
//    Customers.customerlist.add(new Customer("Ethan", "141midterm", 20));
//    Customers.customerlist.add(new Customer("Leo", "635midterm", 40));
    
    @Override
        //-----------------------LOGIN SCREEN-----------------------------------
    public void start(Stage primaryStage){
        GridPane loginRoot = new GridPane();
        loginRoot.setAlignment(Pos.CENTER);
        Scene loginScreen = new Scene(loginRoot, 600, 400);
        
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
        loginBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        
        
        GridPane.setMargin(usernameTF, new Insets(15, 15, 15, 15));
        GridPane.setMargin(passwordTF, new Insets(15, 15, 15, 15));
        GridPane.setMargin(loginBtn, new Insets(15, 15, 15, 15));

        //placing the elements on screen
        loginRoot.add(username, 3, 5);
        loginRoot.add(usernameTF, 4, 5);
        loginRoot.add(password, 3, 6);
        loginRoot.add(passwordTF, 4, 6);
        loginRoot.add(loginBtn, 4, 7);

        //Controls what the login button does
        loginBtn.setOnAction((ActionEvent event) -> {
            System.out.println("login button pressed");
            System.out.println(usernameTF.getText());
            if(usernameTF.getText().equals("Owner")){
                ownerStartScreen(primaryStage);
            }else if(usernameTF.getText().equals("Customer")){
                customerStartScreen(primaryStage);
            }
        });
        loginScreen.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("The 'ENTER' key was pressed");
                if(usernameTF.getText().equals("Owner")){
                    ownerStartScreen(primaryStage);
                }else if(usernameTF.getText().equals("Customer")){
                    customerStartScreen(primaryStage);
                }
            }

        });
        
        primaryStage.setTitle(title);
        primaryStage.setScene(loginScreen);
        ownerBooksScreen(primaryStage);
        primaryStage.show();
        
    }
        //-----------------------LOGIN SCREEN-----------------------------------
        
        
        //-----------------------Owner Start Screen-----------------------------
    public void ownerStartScreen(Stage primaryStage){
        
        VBox ownerMenuRoot = new VBox(20);
        ownerMenuRoot.setAlignment(Pos.CENTER);
        Scene ownerMenu = new Scene(ownerMenuRoot, 600, 400);
        
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
        logoutBtn.setStyle("-fx-background-color: #EA3B52; -fx-background-radius: 100;");
        
        //Placing the buttons on screen
        ownerMenuRoot.getChildren().add(booksBtn);
        ownerMenuRoot.getChildren().add(customerBtn);
        ownerMenuRoot.getChildren().add(logoutBtn);
        
        //Controlling what the buttons do
        customerBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Customers button Pressed");
            ownerCustomersScreen(primaryStage);
        });
        booksBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Books Button Pressed");
            ownerBooksScreen(primaryStage);
        });
        logoutBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Logout Button on owner Pressed");
            start(primaryStage);
        });
        
        primaryStage.setTitle(title);
        primaryStage.setScene(ownerMenu);
        primaryStage.show();
        
    }
        //-----------------------Owner Start Screen-----------------------------
        
        
        //-----------------------Customer Start Screen--------------------------
    public void customerStartScreen(Stage primaryStage){
        VBox customerMenuRoot = new VBox(5);
        customerMenuRoot.setAlignment(Pos.CENTER);
        Scene customerMenu = new Scene(customerMenuRoot, 600, 400);
        //Making variables and creating the welcome text
        String name = "Ernest";
        int points = 19;
        String status = "Bub";
        Label welcomeMessage = new Label("Welcome " + name + ", you have " + points + " points. Your status is: " + status + ".");
        VBox.setMargin(welcomeMessage, new Insets(25, 15, 15, 15));
        
        HBox customerStartScreenHB = new HBox();
        
        //Making the tables and columns for the table of books
        TableView customerBooksTable = new TableView();
        TableColumn<User, String> nameCustColumn = new TableColumn<>("Book Name");
        nameCustColumn.setPrefWidth(100);
        TableColumn<User, String> priceCustColumn = new TableColumn<>("Book Price");
        priceCustColumn.setPrefWidth(100);
        TableColumn<User, String> selectColumn = new TableColumn<>("Select");
        
        ObservableList<Book> books2 = FXCollections.observableArrayList();
        books2.add(new Book("The Bible", 0));
        books2.add(new Book("The Quran", 10000));
  
        //selectColumn.setCellFactory(column -> new CheckBoxTableCell<>());
        for(Book book : books2)
            customerBooksTable.getItems().add(book);
        
        nameCustColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCustColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        customerBooksTable.getColumns().addAll(nameCustColumn, priceCustColumn, selectColumn);
        
        customerStartScreenHB.getChildren().add(customerBooksTable);
        customerStartScreenHB.setAlignment(Pos.CENTER);
        
        HBox buyRedeemHB = new HBox(5);
        
        //Making the different buttons
        Button buyBtn = new Button();
        buyBtn.setText("Buy");
        buyBtn.setPrefWidth(100);
        Button buyRBtn = new Button();
        buyRBtn.setText("Redeem Points & Buy");
        buyRBtn.setPrefWidth(170);
        buyRedeemHB.getChildren().addAll(buyBtn, buyRBtn);
        buyRedeemHB.setAlignment(Pos.CENTER);
        VBox.setMargin(customerStartScreenHB, new Insets(15, 15, 15, 15));
        
        Button logoutCBtn = new Button();
        logoutCBtn.setText("Logout");
        logoutCBtn.setPrefWidth(100);
        logoutCBtn.setStyle("-fx-background-color: #EA3B52; -fx-background-radius: 100;");
        VBox.setMargin(logoutCBtn, new Insets(15, 15, 15, 15));
        
        //Logic and control for the buttons
        buyBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Buy Button Pressed");
            customerCostScreen(primaryStage);
        });
        buyRBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Buy and Redeem button Pressed");
            customerCostScreen(primaryStage);
        });
        logoutCBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Logout Button on Customer start Pressed");
            start(primaryStage);
        });
        
        //placing the elements on screen
        customerMenuRoot.getChildren().add(welcomeMessage);
        customerMenuRoot.getChildren().add(customerStartScreenHB);
        //CHEKCBOX STILL MISSINGSDPFIJFSPDOFJSODPFJOFJSPDFOJSODFJ
        customerMenuRoot.getChildren().add(buyRedeemHB);
        customerMenuRoot.getChildren().add(logoutCBtn);
        
        primaryStage.setTitle(title);
        primaryStage.setScene(customerMenu);
        primaryStage.show();
        
    }
        //-----------------------Customer Start Screen--------------------------
        
        
        //-----------------------Customer Cost Screen---------------------------
    public void customerCostScreen(Stage primaryStage){
        VBox customerCostRoot = new VBox(5);
        customerCostRoot.setAlignment(Pos.CENTER);
        Scene customerCost = new Scene(customerCostRoot, 600, 400);
        //Making the variable 
        double totalCost = 0;
        int points = 19;
        String status = "bub";
        //labels displaying the cost
        Label costL = new Label("Total Cost: " + totalCost);
        Label pointsL = new Label("Points: " + points + ", Status: " + status + ".");
        
        //creating button
        Button logoutCCBtn = new Button();
        logoutCCBtn.setText("Logout");
        logoutCCBtn.setStyle("-fx-background-color: #EA3B52; -fx-background-radius: 100;");
        
        //Logic for button
        logoutCCBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Logout Button on Customer Cost Pressed");
            start(primaryStage);
        });
        
        //placing the elements on screen
        customerCostRoot.getChildren().add(costL);
        customerCostRoot.getChildren().add(pointsL);
        customerCostRoot.getChildren().add(logoutCCBtn);
        
        primaryStage.setTitle(title);
        primaryStage.setScene(customerCost);
        primaryStage.show();
        
    }
        //-----------------------Customer Cost Screen---------------------------
        
        
        //-----------------------Owner Books Screen-----------------------------
    public void ownerBooksScreen(Stage primaryStage){
        
        VBox ownerBooksRoot = new VBox(10);
        ownerBooksRoot.setAlignment(Pos.CENTER);
        Scene ownerBooks = new Scene(ownerBooksRoot, 600, 400);
        
        //Container to put the table into so it doesn't stretch the whole screen
        HBox tableHB = new HBox();
        
        //Creating table
        TableView bookTable = new TableView();
        bookTable.setPrefWidth(400);
        
        //Creating columns for the table
        TableColumn<User, String> nameColumn = new TableColumn<>("Book Name");
        nameColumn.setPrefWidth(200);
        TableColumn<User, String> priceColumn = new TableColumn<>("Book Price");
        priceColumn.setPrefWidth(100);
        TableColumn<User, String> selectColumn = new TableColumn<>("Select");
        priceColumn.setPrefWidth(100);
        
        //filling the table's columns using the "getName()" & "getPrice()" 
        //methods from the Book class
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));
        
        bookTable.getItems().add(new Book("Book1", 4));
        
        //adds the columns to the table, and then the table to the container
        bookTable.getColumns().addAll(nameColumn, priceColumn, selectColumn);
        tableHB.setAlignment(Pos.CENTER);
        tableHB.getChildren().add(bookTable);
        VBox.setMargin(tableHB, new Insets(10, 0, 20, 0));
        
        //This is a new container to put the text boxes and the add button 
        //in the same row on screen
        HBox addingBooksHB = new HBox(10);
        //labels for the fields
        Label bookName = new Label("Book Name:");
        Label bookPrice = new Label("Book Price:");
        HBox.setMargin(bookPrice, new Insets(0, 0, 0, 20));
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
        HBox.setMargin(addBtn, new Insets(0, 0, 0, 20));
        
        //Adding everything to the container
        addingBooksHB.getChildren().add(bookName);
        addingBooksHB.getChildren().add(bookNameTF);
        addingBooksHB.getChildren().add(bookPrice);
        addingBooksHB.getChildren().add(bookPriceTF);
        addingBooksHB.getChildren().add(addBtn);
        addingBooksHB.setAlignment(Pos.CENTER);
        
        //Container for the back and delete buttons
        HBox backDeleteHB = new HBox(40);
        
        //Creating the buttons
        Button deleteBtn = new Button();
        deleteBtn.setText("Delete");
        deleteBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        Button backBtn = new Button();
        backBtn.setText("Back");
        backBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        
        //Adding elements to container
        backDeleteHB.getChildren().add(deleteBtn);
        backDeleteHB.getChildren().add(backBtn);
        backDeleteHB.setAlignment(Pos.CENTER);
        VBox.setMargin(backDeleteHB, new Insets(10, 0, 20, 0));
        
        //Adding containers to a bigger container
        ownerBooksRoot.getChildren().add(tableHB);
        ownerBooksRoot.getChildren().add(addingBooksHB);
        ownerBooksRoot.getChildren().add(backDeleteHB);
        
        //Control for the buttons
        addBtn.setOnAction((ActionEvent event) -> {
            System.out.println(bookNameTF.getText());
            ownerStartScreen(primaryStage);
        });
        deleteBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Delete Button Pressed");
        });
        backBtn.setOnAction((ActionEvent event) -> {
            System.out.println(bookNameTF.getText());
            ownerStartScreen(primaryStage);
        });
        
        //displaying the screen
        primaryStage.setTitle(title);
        primaryStage.setScene(ownerBooks);
        primaryStage.show();
        
    }
        //-----------------------Owner Books Screen-----------------------------
        
        
        //-----------------------Owner Customers Screen-------------------------
    public void ownerCustomersScreen(Stage primaryStage){
        
        VBox ownerCustomersRoot = new VBox(10);
        Scene ownerCustomers = new Scene(ownerCustomersRoot, 600, 400);
        
        HBox tableCHB = new HBox();
        
        TableView customerTable = new TableView();
        TableColumn<Customer, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setPrefWidth(100);
        TableColumn<Customer, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setPrefWidth(100);
        TableColumn<Customer, String> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setPrefWidth(100);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        //needs a setItems
        customerTable.getColumns().addAll(usernameColumn, passwordColumn, pointsColumn);
        
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
        VBox.setMargin(textFieldCHB, new Insets(20, 0, 10, 0));
        
        HBox backDeleteCHB = new HBox(30);
        textFieldCHB.setAlignment(Pos.CENTER);
        
        
        Button deleteCBtn = new Button();
        deleteCBtn.setText("Delete");
        deleteCBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        Button backCBtn = new Button();
        backCBtn.setText("Back");
        backCBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        backCBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Back button Pressed");
            ownerStartScreen(primaryStage);
        });
        
        backDeleteCHB.getChildren().add(deleteCBtn);
        backDeleteCHB.getChildren().add(backCBtn);
        backDeleteCHB.setAlignment(Pos.CENTER);
        VBox.setMargin(backDeleteCHB, new Insets(10, 0, 20, 0));
        
        ownerCustomersRoot.getChildren().add(tableCHB);
        ownerCustomersRoot.getChildren().add(textFieldCHB);
        ownerCustomersRoot.getChildren().add(backDeleteCHB);
        ownerCustomersRoot.setAlignment(Pos.CENTER);
        
        primaryStage.setTitle(title);
        primaryStage.setScene(ownerCustomers);
        primaryStage.show();
        
    }
        //-----------------------Owner Customers Screen-------------------------

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
