package com.example.JavaFX;

import com.example.Cart;
import com.example.Products.Product;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ViewProductButton implements EventHandler<ActionEvent> {
    private Cart cart;
    private Product product;
    private VBox infoBar;

    /**
     * Constructor for the viewProductButton
     * 
     * @param cart
     * @param product
     * @param infoBar
     */
    public ViewProductButton(Cart cart, Product product, VBox infoBar) {
        this.cart = cart;
        this.product = product;
        this.infoBar = infoBar;
    }

    @Override
    public void handle(ActionEvent e) {
        Text information = new Text(product.toString());
        Button addToCart = new Button("BUY");
        addToCart.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                cart.addItem(product);
            }
        });
        infoBar.getChildren().clear();
        infoBar.getChildren().addAll(information, addToCart);
    }

    public VBox getInfoBar() {
        return infoBar;
    }
}
