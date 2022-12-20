package com.example.JavaFX;

import java.util.List;

import com.example.Cart;
import com.example.StoreFront;
import com.example.Products.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProductsButton implements EventHandler<ActionEvent> {
    private StoreFront storeFront;
    private Cart cart;
    private String category;
    private HBox listContainer;
    private VBox productList = new VBox();
    private VBox infoBar = new VBox();
    private ViewProductButton viewProduct;

    public ProductsButton(StoreFront storeFront, String category, Cart cart, HBox listContainer) {
        this.storeFront = storeFront;
        this.category = category;
        this.cart = cart;
        this.listContainer = listContainer;
    }

    @Override
    public void handle(ActionEvent e) {
        List<Product> products = storeFront.getCategory(category);
        productList.getChildren().clear();
        for (Product product : products) {

            Button button = new Button(product.getTitle());
            viewProduct = new ViewProductButton(cart, product, infoBar);
            button.setOnAction(viewProduct);
            productList.getChildren().add(button);
        }
        listContainer.getChildren().clear();
        listContainer.getChildren().addAll(productList, viewProduct.getInfoBar());
    }
}
