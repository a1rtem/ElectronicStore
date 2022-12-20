package com.example.JavaFX;

import java.util.List;

import com.example.Coupons.Coupon;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ViewCouponsButton implements EventHandler<ActionEvent> {
    private Coupon coupon;
    private VBox infoBar;
    private List<Coupon> selectedCoupons;

    /**
     * Constructor for the viewCouponsButton
     * 
     * @param coupon
     * @param infoBar
     * @param selectedCoupons
     */
    public ViewCouponsButton(Coupon coupon, VBox infoBar, List<Coupon> selectedCoupons) {
        this.coupon = coupon;
        this.infoBar = infoBar;
        this.selectedCoupons = selectedCoupons;
    }

    @Override
    public void handle(ActionEvent e) {
        Text information = new Text(coupon.toString());
        Button addToCart = new Button("APPLY");
        addToCart.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                selectedCoupons.add(coupon);
            }
        });
        infoBar.getChildren().clear();
        infoBar.getChildren().addAll(information, addToCart);
    }

    public VBox getInfoBar() {
        return infoBar;
    }
}
