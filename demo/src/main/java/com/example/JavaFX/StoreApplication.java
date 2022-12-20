package com.example.JavaFX;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Cart;
import com.example.StoreFront;
import com.example.Coupons.Coupon;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class StoreApplication extends Application {

    private Cart cart;
    private StoreFront storeFront;

    // Layout
    private Scene scene;
    private VBox mainContainer;
    private HBox buttonsContainer;
    private HBox listContainer;
    private HBox sortingHBox = new HBox();

    // Radio buttons
    ToggleGroup categoryTg;
    RadioButton priceRb;
    RadioButton titleRb;

    ToggleGroup orderTg;
    RadioButton ascendingRb;
    RadioButton descendingRb;

    // Prompts
    private Text prompt;
    Button sortOrder;
    Button sortCategory;

    // Loader options
    private Button loadFile;
    private Button loadDatabase;

    // Login page
    VBox login;
    TextArea usernameInput;
    TextArea passwordInput;

    // Main Categories
    private Button games;
    private Button electronics;

    // Game options
    private Button gameBackToCategories;
    private Button allGames;
    private Button boardGames;
    private Button videoGameDisks;
    private Button videoGameDigital;

    // Electronics options
    private Button electronicsBackToCategories;
    private Button computer;
    private Button console;

    // Checkout
    Button checkout;
    Button coupon;

    // Products lists
    private ScrollPane sp = new ScrollPane();

    @Override
    public void start(Stage stage) {

        // Starts the session
        cart = new Cart();

        // Sets the welcome text and the prompt
        Text welcomeText = new Text("Welcome to the Entertainment Store of the Century!");
        prompt = new Text("Which source would you like to load our products from?");

        // Sets the buttons and containers to load products
        buttonsContainer = new HBox();

        loadFile = new Button("Load from a file");
        loadFile.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                storeFront = new StoreFront();
                showCategories();
            }
        });

        loadDatabase = new Button("Load from the database");
        loadDatabase.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                databaseLogInPrompt();
            }
        });

        // Sets the initial layout
        buttonsContainer.getChildren().addAll(loadFile, loadDatabase);

        mainContainer = new VBox();
        listContainer = new HBox();

        mainContainer.getChildren().addAll(welcomeText, prompt, buttonsContainer, sortingHBox, listContainer);

        Group root = new Group();
        sp.setContent(root);
        root.getChildren().addAll(mainContainer);

        scene = new Scene(sp, 1024, 600);
        scene.setFill(Color.WHITE);

        stage.setTitle("Entertainment Store");
        stage.setScene(scene);
        stage.show();

        StoreFront storeFront = new StoreFront();
        List<Coupon> selectedCoupons = new ArrayList<>();

        // Sets the buttons to show game categories
        gameBackToCategories = new Button("Back");
        gameBackToCategories.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                buttonsContainer.getChildren().clear();
                listContainer.getChildren().clear();
                showCategories();
            }
        });

        // Sets the checkout button.
        checkout = new Button("Checkout");
        CheckoutButton checkoutButton = new CheckoutButton(cart, listContainer, selectedCoupons);
        checkout.setOnAction(checkoutButton);

        // Sets the coupons button
        coupon = new Button("Coupons");
        CouponsButton couponsButton = new CouponsButton(storeFront, listContainer, selectedCoupons);
        coupon.setOnAction(couponsButton);

        // Sorting
        categoryTg = new ToggleGroup();
        orderTg = new ToggleGroup();

        priceRb = new RadioButton();
        titleRb = new RadioButton();
        ascendingRb = new RadioButton();
        descendingRb = new RadioButton();

        priceRb.setToggleGroup(categoryTg);
        titleRb.setToggleGroup(categoryTg);
        ascendingRb.setToggleGroup(orderTg);
        descendingRb.setToggleGroup(orderTg);

        priceRb.setText("Price");
        titleRb.setText("Title");
        ascendingRb.setText("Ascending");
        descendingRb.setText("Descending");

        priceRb.setUserData("Price");
        titleRb.setUserData("Title");
        ascendingRb.setUserData("Ascending");
        descendingRb.setUserData("Descending");

        SortCategoryButton sortCategoryButton = new SortCategoryButton(storeFront, categoryTg, orderTg);
        sortCategory = new Button("Sort");
        sortCategory.setOnAction(sortCategoryButton);

        sortingHBox.getChildren().addAll(priceRb, titleRb, ascendingRb, descendingRb, sortCategory);

        // Sets the buttons to show categories
        games = new Button("Games");
        games.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                gamesButtonEvent();
            }
        });
        electronics = new Button("Electronics");
        electronics.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                electronicsButtonEvent();
            }
        });

        // Login page
        login = new VBox();

        HBox usernameBox = new HBox();
        Text usernameText = new Text("Enter your database username");
        usernameInput = new TextArea();
        usernameBox.getChildren().addAll(usernameText, usernameInput);

        HBox passwordBox = new HBox();
        Text passwordText = new Text("Enter your database password");
        passwordInput = new TextArea();
        passwordBox.getChildren().addAll(passwordText, passwordInput);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                loadDatabaseEvent(usernameInput.getText(), passwordInput.getText());
            }
        });

        login.getChildren().addAll(usernameBox, passwordBox, loginButton);

        allGames = new Button("All Games");
        ProductsButton allGamesButton = new ProductsButton(storeFront, "all", cart, listContainer);
        allGames.setOnAction(allGamesButton);

        boardGames = new Button("Board Games");
        ProductsButton boardGamesButton = new ProductsButton(storeFront, "board", cart, listContainer);
        boardGames.setOnAction(boardGamesButton);

        videoGameDisks = new Button("Video Games (Hard Copies)");
        ProductsButton vGamesDiskButton = new ProductsButton(storeFront, "disk", cart, listContainer);
        videoGameDisks.setOnAction(vGamesDiskButton);

        videoGameDigital = new Button("Video Games (Digital Copies)");
        ProductsButton vGamesDigitalButton = new ProductsButton(storeFront, "digital", cart, listContainer);
        videoGameDigital.setOnAction(vGamesDigitalButton);

        console = new Button("Consoles");
        ProductsButton consolesButton = new ProductsButton(storeFront, "console", cart, listContainer);
        console.setOnAction(consolesButton);

        computer = new Button("Personal Computers");
        ProductsButton pcButton = new ProductsButton(storeFront, "pc", cart, listContainer);
        computer.setOnAction(pcButton);

        // Sets the buttons to show electronics categories
        electronicsBackToCategories = new Button("Back");
        electronicsBackToCategories.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                buttonsContainer.getChildren().clear();
                listContainer.getChildren().clear();
                showCategories();
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Event to load products from a file.
     */
    public void loadFileEvent() {
        storeFront = new StoreFront();
        showCategories();
    }

    /**
     * Asks user to log in to the database.
     */
    public void databaseLogInPrompt() {
        buttonsContainer.getChildren().clear();
        buttonsContainer.getChildren().add(login);
        prompt.setText("Please log in to the database to proceed");
    }

    /**
     * Event to load products from a database.
     */
    public void loadDatabaseEvent(String username, String password) {
        try {
            storeFront = new StoreFront(username, password);
            buttonsContainer.getChildren().clear();
            showCategories();
        } catch (SQLException e) {
            prompt.setText("Connecting to the database was unsuccessful.");
        }
    }

    /**
     * Shows the main categories
     */
    public void showCategories() {
        buttonsContainer.getChildren().clear();
        buttonsContainer.getChildren().addAll(games, electronics, coupon, checkout);
        prompt.setText("Select the category of products you want to see.");
    }

    /**
     * Shows types of games.
     */
    public void gamesButtonEvent() {
        buttonsContainer.getChildren().clear();
        buttonsContainer.getChildren().addAll(gameBackToCategories, allGames, boardGames, videoGameDisks,
                videoGameDigital, coupon, checkout);
    }

    /**
     * Shows types of electronics.
     */
    public void electronicsButtonEvent() {
        buttonsContainer.getChildren().clear();
        buttonsContainer.getChildren().addAll(electronicsBackToCategories, console, computer, coupon, checkout);
    }
}