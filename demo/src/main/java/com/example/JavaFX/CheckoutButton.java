package com.example.JavaFX;

import java.util.List;

import com.example.Cart;
import com.example.Coupons.Coupon;
import com.example.Products.Product;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CheckoutButton implements EventHandler<ActionEvent> {
    private Cart cart;
    private HBox listContainer;
    private VBox formatting = new VBox();
    private VBox listCartVBox = new VBox();
    private Text goodBye = new Text("Thank you for shopping with us. Have a nice day.");
    private Text itemText;
    private Button removeFromCart;
    private List<Coupon> selectedCoupons;
    private Text totalText = new Text();

    /**
     * Constructor for the checkoutButton
     * 
     * @param cart
     * @param listContainer
     * @param selectedCoupons
     */
    public CheckoutButton(Cart cart, HBox listContainer, List<Coupon> selectedCoupons) {
        this.cart = cart;
        this.listContainer = listContainer;
        this.selectedCoupons = selectedCoupons;
    }

    @Override
    public void handle(ActionEvent e) {
        listContainer.getChildren().clear();
        formatting.getChildren().clear();
        listCartVBox.getChildren().clear();

        for (Product cartItem : cart.getCart()) {
            itemText = new Text(cart.printCartItem(cartItem));
            removeFromCart = new Button("REMOVE");
            RemoveItemButton removeItem = new RemoveItemButton(cart, cartItem, listCartVBox, totalText,
                    selectedCoupons);
            removeFromCart.setOnAction(removeItem);
            listCartVBox.getChildren().addAll(itemText, removeFromCart);
        }
        totalText.setText("Total: " + cart.calculateTotal(selectedCoupons) + "$");
        formatting.getChildren().addAll(goodBye, listCartVBox, totalText);
        listContainer.getChildren().add(formatting);
    }
}
