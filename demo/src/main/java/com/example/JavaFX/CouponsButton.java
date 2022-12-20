package com.example.JavaFX;

import java.util.List;

import com.example.StoreFront;
import com.example.Coupons.Coupon;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CouponsButton implements EventHandler<ActionEvent> {
    private StoreFront storeFront;
    private HBox listContainer;
    private VBox productList = new VBox();
    private VBox infoBar = new VBox();
    private ViewCouponsButton viewCoupons;
    private List<Coupon> selectedCoupons;

    /**
     * Constructor for the couponsButton
     * 
     * @param storeFront
     * @param listContainer
     * @param selectedCoupons
     */
    public CouponsButton(StoreFront storeFront, HBox listContainer, List<Coupon> selectedCoupons) {
        this.storeFront = storeFront;
        this.listContainer = listContainer;
        this.selectedCoupons = selectedCoupons;
    }

    @Override
    public void handle(ActionEvent e) {
        List<Coupon> coupons = storeFront.getCoupons();
        productList.getChildren().clear();
        for (Coupon coupon : coupons) {
            Button button = new Button(coupon.getType());
            viewCoupons = new ViewCouponsButton(coupon, infoBar, selectedCoupons);
            button.setOnAction(viewCoupons);
            productList.getChildren().add(button);
        }
        listContainer.getChildren().clear();
        listContainer.getChildren().addAll(productList, viewCoupons.getInfoBar());
    }
}
