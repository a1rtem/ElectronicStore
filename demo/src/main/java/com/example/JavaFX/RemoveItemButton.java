package com.example.JavaFX;

import java.util.List;

import com.example.Cart;
import com.example.Coupons.Coupon;
import com.example.Products.Product;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RemoveItemButton implements EventHandler<ActionEvent> {
    private Cart cart;
    private Product product;
    private VBox listCartVBox;
    private Text totalText;
    private List<Coupon> selectedCoupons;

    public RemoveItemButton(Cart cart, Product product, VBox listCartVBox, Text totalText,
            List<Coupon> selectedCoupons) {
        this.cart = cart;
        this.product = product;
        this.listCartVBox = listCartVBox;
        this.totalText = totalText;
        this.selectedCoupons = selectedCoupons;
    }

    @Override
    public void handle(ActionEvent e) {
        cart.removeItem(product);

        int index = -1;
        for (Node node : listCartVBox.getChildren()) {
            if (node instanceof Text) {
                if (((Text) node).getText().equals(cart.printCartItem(product))) {
                    index = listCartVBox.getChildren().indexOf(node);
                }
            }
        }
        totalText.setText("Total: " + cart.calculateTotal(selectedCoupons) + "$");
        listCartVBox.getChildren().remove(index);
        listCartVBox.getChildren().remove(index);
    }
}
