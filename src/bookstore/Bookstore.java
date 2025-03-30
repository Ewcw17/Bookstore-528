/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package bookstore;

import java.io.BufferedReader;
import bookstore.Book;
import bookstore.Customer;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
import java.util.*;
import javafx.scene.paint.Color;

/**
 *
 * @author e225wong
 */

public class Bookstore extends Application {
    
    String title = "Bookstore App";
    
    Owner owner = new Owner("admin", "admin");
    
    @Override
        //-----------------------LOGIN SCREEN-----------------------------------
    public void start(Stage primaryStage){
        GridPane loginRoot = new GridPane();
        loginRoot.setAlignment(Pos.CENTER);
        Scene loginScreen = new Scene(loginRoot, 600, 400);
        
        Label introMessage = new Label("Welcome to the Chinese Bookstore");
        Label invalid = new Label("");
        GridPane.setMargin(invalid, new Insets(10, 0, 20, 0));
        
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
        loginRoot.add(introMessage, 3, 3, 2, 1);
        loginRoot.add(username, 3, 5);
        loginRoot.add(usernameTF, 4, 5);
        loginRoot.add(password, 3, 6);
        loginRoot.add(passwordTF, 4, 6);
        loginRoot.add(loginBtn, 4, 7);
        loginRoot.add(invalid, 4, 9, 2, 1);

        //Controls what the login button does
        loginBtn.setOnAction((ActionEvent event) -> {
            System.out.println("login button pressed");
            System.out.println(usernameTF.getText());
            if(usernameTF.getText().equals(owner.getUsername()) && passwordTF.getText().equals(owner.getPassword())){
                ownerStartScreen(primaryStage);
            }else{
                for(Customer c : Customers.customerList){
                    if(c.getUsername().equals(usernameTF.getText()) && c.getPassword().equals(passwordTF.getText())){
                        customerStartScreen(primaryStage, c);
                        break;
                    }
                }
                invalid.setText("Unrecognised login");
                invalid.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
            }
        });
        loginScreen.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println("The 'ENTER' key was pressed");
                if(usernameTF.getText().equals("admin")){
                    ownerStartScreen(primaryStage);
                }else{
                    for(Customer c : Customers.customerList){
                        if(c.getUsername().equals(usernameTF.getText()) && c.getPassword().equals(passwordTF.getText())){
                            customerStartScreen(primaryStage, c);
                            break;
                        }
                    }
                    invalid.setText("Unrecognised login");
                    invalid.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                }
            }

        });
        
        primaryStage.setTitle(title);
        primaryStage.setScene(loginScreen);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(event -> {
            try{
                Books.bookWrite();
                Customers.customerWrite();
            }catch (Exception e){
                System.out.println("Write failed");
            }
        });
        
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
        booksBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        Button customerBtn = new Button();
        customerBtn.setText("Customers");
        customerBtn.setPrefWidth(200);
        customerBtn.setPrefHeight(50);
        customerBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
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
        
        primaryStage.setOnCloseRequest(event -> {
            try{
                Books.bookWrite();
                Customers.customerWrite();
            }catch (Exception e){
                System.out.println("Write failed");
            }
        });
        
    }
        //-----------------------Owner Start Screen-----------------------------
        
        
        //-----------------------Customer Start Screen--------------------------
    public void customerStartScreen(Stage primaryStage, Customer customer){
        //Setting up the screens to display the information on
        VBox customerMenuRoot = new VBox(5);
        customerMenuRoot.setAlignment(Pos.CENTER);
        Scene customerMenu = new Scene(customerMenuRoot, 600, 400);
        
        //creating the welcome text
        Label welcomeMessage = new Label("Welcome " + customer.getUsername() + ", you have " + customer.getPoints() + " points. Your status is: " + customer.getState().getStatus() + ".");
        VBox.setMargin(welcomeMessage, new Insets(25, 15, 0, 15));
        
        //Creating error message
        Label invalid = new Label("");
        VBox.setMargin(invalid, new Insets(0, 0, 20, 0));
        
        //creating a container to hold the table within
        HBox customerStartScreenHB = new HBox();
        
        //Making the tables and columns for the table of books
        TableView customerBooksTable = new TableView();
        customerBooksTable.setPrefWidth(520);
        TableColumn<User, String> nameCustColumn = new TableColumn<>("Book Name");
        nameCustColumn.setPrefWidth(customerBooksTable.getPrefWidth()*0.6);
        TableColumn<User, String> priceCustColumn = new TableColumn<>("Book Price");
        priceCustColumn.setPrefWidth(customerBooksTable.getPrefWidth()*0.2);
        TableColumn<User, String> selectColumn = new TableColumn<>("Select");
        selectColumn.setPrefWidth(customerBooksTable.getPrefWidth()*0.2);
        
        //Determining what instance variables go into each column
        nameCustColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCustColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));
        
        customerBooksTable.getItems().addAll(Books.bookList);
        
        //adding the columsn to the table
        customerBooksTable.getColumns().addAll(nameCustColumn, priceCustColumn, selectColumn);
        
        //adding the table to the container
        customerStartScreenHB.getChildren().add(customerBooksTable);
        customerStartScreenHB.setAlignment(Pos.CENTER);
        
        //making a container to contain the buy and redeem buttons
        HBox buyRedeemHB = new HBox(5);
        
        //Making the different buttons
        Button buyBtn = new Button();
        buyBtn.setText("Buy");
        buyBtn.setPrefWidth(100);
        buyBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        Button buyRBtn = new Button();
        buyRBtn.setText("Redeem Points & Buy");
        buyRBtn.setPrefWidth(170);
        buyRBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        
        //addign the buttons to the container
        buyRedeemHB.getChildren().addAll(buyBtn, buyRBtn);
        buyRedeemHB.setAlignment(Pos.CENTER);
        VBox.setMargin(customerStartScreenHB, new Insets(15, 15, 15, 15));
        
        //makign the logout button
        Button logoutCBtn = new Button();
        logoutCBtn.setText("Logout");
        logoutCBtn.setPrefWidth(100);
        logoutCBtn.setStyle("-fx-background-color: #EA3B52; -fx-background-radius: 100;");
        VBox.setMargin(logoutCBtn, new Insets(15, 15, 15, 15));
        
        //Logic and control for the buttons
        buyBtn.setOnAction((ActionEvent event) -> {
            ObservableList<Book> selectedBooks = FXCollections.observableArrayList();
            for(Book b : Books.bookList){
                if(b.getSelect().isSelected())
                    selectedBooks.add(b);
            }
            if(selectedBooks.isEmpty()){
                invalid.setText("You must select 1 or more books");
                invalid.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                System.out.println("Nothign selected");
            }else{
                System.out.println("Buy Button Pressed");
                customerCostScreen(primaryStage, customer, selectedBooks, false);
            }
        });
        
        buyRBtn.setOnAction((ActionEvent event) -> {
            ObservableList<Book> selectedBooks = FXCollections.observableArrayList();
            for(Book b : Books.bookList){
                if(b.getSelect().isSelected())
                    selectedBooks.add(b);
            }
            if(selectedBooks.isEmpty()){
                invalid.setText("You must select 1 or more books");
                invalid.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                System.out.println("Nothign selected");
            }else{
                System.out.println("Buy and redeem Button Pressed");
                customerCostScreen(primaryStage, customer, selectedBooks, true);
            }
        });
        logoutCBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Logout Button on Customer start Pressed");
            start(primaryStage);
        });
        
        //placing the containers on screen
        customerMenuRoot.getChildren().add(welcomeMessage);
        customerMenuRoot.getChildren().add(customerStartScreenHB);
        customerMenuRoot.getChildren().add(buyRedeemHB);
        customerMenuRoot.getChildren().add(logoutCBtn);
        customerMenuRoot.getChildren().add(invalid);
        
        //adding the screen to the window
        primaryStage.setTitle(title);
        primaryStage.setScene(customerMenu);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(event -> {
            try{
                Books.bookWrite();
                Customers.customerWrite();
            }catch (Exception e){
                System.out.println("Write failed");
            }
        });
        
    }
        //-----------------------Customer Start Screen--------------------------
        
        
        //-----------------------Customer Cost Screen---------------------------
    public void customerCostScreen(Stage primaryStage, Customer currentCustomer, ObservableList<Book> selected, boolean Redeem){
        //Setting up the screen
        VBox customerCostRoot = new VBox(10);
        customerCostRoot.setAlignment(Pos.CENTER);
        Scene customerCost = new Scene(customerCostRoot, 600, 400);
        
        //Making the variables 
        int totalCost = 0;
        int originalCost = 0;
        String costBreakdown = "";
        
        for(Book b : selected){
            if(Redeem){
                totalCost += currentCustomer.redeemBuy(b);
                originalCost += b.getPrice();
            }else{
                totalCost += currentCustomer.buy(b);
            }
            costBreakdown = costBreakdown + (selected.indexOf(b)+1) +": " + b.getName() + " for $" + b.getPrice() + "\n";
        }
        //labels displaying the cost
        Label intro = new Label("Thank you for shopping with us "+ currentCustomer.getUsername() +", here is the breakdown of your purchase: ");
        Label breakdown = new Label(costBreakdown);
        VBox.setMargin(breakdown, new Insets(0, 0, 20, 0));
        Label redemption = new Label((originalCost-totalCost)*100 + " points were used to discount your purchase by $" + (originalCost-totalCost) +".");
        Label costL = new Label("Total Cost: $" + totalCost);
        Label pointsL = new Label("Points: " + currentCustomer.getPoints() + ", Status: " + currentCustomer.getState().getStatus() + ".");
        
        //creating button
        Button logoutCCBtn = new Button();
        logoutCCBtn.setText("Logout");
        logoutCCBtn.setStyle("-fx-background-color: #EA3B52; -fx-background-radius: 100;");
        logoutCCBtn.setPrefWidth(100);
        logoutCCBtn.setPrefHeight(50);
        
        //Logic for button
        logoutCCBtn.setOnAction((ActionEvent event) -> {
            for(Book b : Books.bookList)
                b.resetCheck();
            System.out.println("Logout Button on Customer Cost Pressed");
            start(primaryStage);
        });
        
        //placing the elements on screen
        customerCostRoot.getChildren().add(intro);
        customerCostRoot.getChildren().add(breakdown);
        if(Redeem) customerCostRoot.getChildren().add(redemption);
        customerCostRoot.getChildren().add(costL);
        customerCostRoot.getChildren().add(pointsL);
        customerCostRoot.getChildren().add(logoutCCBtn);
        
        //Placing the screen on the window
        primaryStage.setTitle(title);
        primaryStage.setScene(customerCost);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(event -> {
            try{
                Books.bookWrite();
                Customers.customerWrite();
            }catch (Exception e){
                System.out.println("Write failed");
            }
        });
        
    }
        //-----------------------Customer Cost Screen---------------------------
        
        
        //-----------------------Owner Books Screen-----------------------------
    public void ownerBooksScreen(Stage primaryStage){
        
        VBox ownerBooksRoot = new VBox(10);
        ownerBooksRoot.setAlignment(Pos.CENTER);
        Scene ownerBooks = new Scene(ownerBooksRoot, 600, 400);
        
        //Creating error message
        Label invalid = new Label("");
        VBox.setMargin(invalid, new Insets(10, 0, 20, 0));
        
        //Container to put the table into so it doesn't stretch the whole screen
        HBox tableHB = new HBox();
        
        //Creating table
        TableView bookTable = new TableView();
        bookTable.setPrefWidth(400);
        
        //Creating columns for the table
        TableColumn<User, String> nameColumn = new TableColumn<>("Book Name");
        nameColumn.setPrefWidth(300);
        TableColumn<User, String> priceColumn = new TableColumn<>("Book Price");
        priceColumn.setPrefWidth(100);
        
        //filling the table's columns using the "getName()" & "getPrice() & getSelect()" 
        //methods from the Book class
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        bookTable.getItems().addAll(Books.bookList);
        
        //adds the columns to the table, and then the table to the container
        bookTable.getColumns().addAll(nameColumn, priceColumn);
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
        ownerBooksRoot.getChildren().add(invalid);
        
        //Control for the buttons
        addBtn.setOnAction((ActionEvent event) -> {
            try{
                if(bookNameTF.getText().equals("") || bookPriceTF.getText().equals("")) throw new Exception();
                //Checking for duplicates
                for(Book b : Books.bookList){
                    if(bookNameTF.getText().equals(b.getName())){
                        throw new Exception();
                    }
                }
                owner.addBook(bookNameTF.getText(), Integer.parseInt(bookPriceTF.getText()));
                ownerBooksScreen(primaryStage);
            }catch (Exception e){
                invalid.setText("Invalid Input");
                invalid.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                System.out.println("INVALID ARGUMENT");
            }
        });
        
        deleteBtn.setOnAction((ActionEvent event) -> {
            try{
            owner.deleteBook(bookTable.getSelectionModel().getSelectedIndex());
            ownerBooksScreen(primaryStage);
            System.out.println("Delete Button Pressed");
            }catch(Exception e){
                invalid.setText("You must select something to delete");
                invalid.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                System.out.println("Nothign selected");
            }
        });
        backBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Back Button Pressed");
            for(Book b : Books.bookList){
                b.resetCheck();
            }
            ownerStartScreen(primaryStage);
        });
        
        //displaying the screen
        primaryStage.setTitle(title);
        primaryStage.setScene(ownerBooks);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(event -> {
            try{
                Books.bookWrite();
                Customers.customerWrite();
            }catch (Exception e){
                System.out.println("Write failed");
            }
        });
        
    }
        //-----------------------Owner Books Screen-----------------------------
        
        
        //-----------------------Owner Customers Screen-------------------------
    public void ownerCustomersScreen(Stage primaryStage){
        //Setting up scenes
        VBox ownerCustomersRoot = new VBox(10);
        Scene ownerCustomers = new Scene(ownerCustomersRoot, 600, 400);
        
        //Error message for invalid input
        Label invalid = new Label("");
        VBox.setMargin(invalid, new Insets(10, 0, 20, 0));
        
        //Containter to hold the table
        HBox tableCHB = new HBox();
        
        //Setting up the table and its columns
        TableView customerTable = new TableView();
        TableColumn<Customer, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setPrefWidth(200);
        TableColumn<Customer, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setPrefWidth(100);
        TableColumn<Customer, String> pointsColumn = new TableColumn<>("Points");
        pointsColumn.setPrefWidth(100);
        
        //Choosing which instance variables from Customer to put into the columns
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        
        //Adds the actual instances of custoemrs to the table
        customerTable.getItems().addAll(Customers.customerList);
        
        //adds the columns to the table
        customerTable.getColumns().addAll(usernameColumn, passwordColumn, pointsColumn);
        
        //adds the table to the container, and styles it a bit
        tableCHB.getChildren().add(customerTable);
        tableCHB.setAlignment(Pos.CENTER);
        VBox.setMargin(tableCHB, new Insets(20, 0, 10, 0));
        
        //a container for the text fields
        HBox textFieldCHB = new HBox(10);
        textFieldCHB.setAlignment(Pos.CENTER);
        
        //labels for the fields
        Label customerName = new Label("Username:");
        Label customerPassword = new Label("Password:");
        
        //the text fields
        TextField customerNameTF = new TextField();
        TextField customerPasswordTF = new TextField();
        
        //Making the add button
        Button addCBtn = new Button();
        addCBtn.setText("Add");
        addCBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        
        //adding labels, textfields and the add button to the container
        textFieldCHB.getChildren().add(customerName);
        textFieldCHB.getChildren().add(customerNameTF);
        textFieldCHB.getChildren().add(customerPassword);
        textFieldCHB.getChildren().add(customerPasswordTF);
        textFieldCHB.getChildren().add(addCBtn);
        VBox.setMargin(textFieldCHB, new Insets(20, 0, 10, 0));
        
        //container for back and delete buttons
        HBox backDeleteCHB = new HBox(30);
        textFieldCHB.setAlignment(Pos.CENTER);
        
        //making delete and back buttons
        Button deleteCBtn = new Button();
        deleteCBtn.setText("Delete");
        deleteCBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        Button backCBtn = new Button();
        backCBtn.setText("Back");
        backCBtn.setStyle("-fx-background-color: #C8A2C8; -fx-background-radius: 100;");
        
        //adding buttons to container
        backDeleteCHB.getChildren().add(deleteCBtn);
        backDeleteCHB.getChildren().add(backCBtn);
        backDeleteCHB.setAlignment(Pos.CENTER);
        VBox.setMargin(backDeleteCHB, new Insets(10, 0, 20, 0));
        
        //Adding all 3 containers to the screen
        ownerCustomersRoot.getChildren().add(tableCHB);
        ownerCustomersRoot.getChildren().add(textFieldCHB);
        ownerCustomersRoot.getChildren().add(backDeleteCHB);
        ownerCustomersRoot.getChildren().add(invalid);
        ownerCustomersRoot.setAlignment(Pos.CENTER);
        
        //Control for the buttons
        addCBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Add button Pressed");
            try{
                if(customerNameTF.getText().equals("") || customerPasswordTF.getText().equals("")) throw new Exception();
                owner.addCustomer(customerNameTF.getText(), customerPasswordTF.getText());
                ownerCustomersScreen(primaryStage);
            }catch (Exception e){
                invalid.setText("Username or Password cannot be empty");
                invalid.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                System.out.println("INVALID ARGUMENT");
            }
        });
        
        deleteCBtn.setOnAction((ActionEvent event) -> {
            try{
                owner.deleteCustomer(customerTable.getSelectionModel().getSelectedIndex());
                ownerCustomersScreen(primaryStage);
                System.out.println("Delete Button Pressed");
            }catch(Exception e){
                invalid.setText("You must select something to Delete");
                invalid.setTextFill(Color.color(Math.random(), Math.random(), Math.random()));
                System.out.println("Nothign selected");
            }
        });
        backCBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Back button Pressed");
            ownerStartScreen(primaryStage);
        });
        
        //Setting the window and adding the screen to the window
        primaryStage.setTitle(title);
        primaryStage.setScene(ownerCustomers);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(event -> {
            try{
                Books.bookWrite();
                Customers.customerWrite();
            }catch (Exception e){
                System.out.println("Write failed");
            }
        });
        
    }
        //-----------------------Owner Customers Screen-------------------------

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "Books.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String title = parts[0].trim();
                    int price = Integer.parseInt(parts[1].trim());  
                    Book newBook = new Book(title, price);
                    Books.bookList.add(newBook);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        
        fileName = "Customers.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    int points = Integer.parseInt(parts[2].trim());  
                    Customer newCustomer = new Customer(username, password, points);
                    Customers.customerList.add(newCustomer);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        
//        System.out.println(Books.bookList.size());
//        
//        for(int i = 0; i < Books.bookList.size(); i++){
//            System.out.println(Books.bookList.get(i).getName());
//        }
        
        launch(args);
    }
    
}
