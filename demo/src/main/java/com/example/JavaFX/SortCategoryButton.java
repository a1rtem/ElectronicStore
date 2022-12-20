package com.example.JavaFX;

import com.example.StoreFront;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SortCategoryButton implements EventHandler<ActionEvent> {
    private StoreFront storeFront;
    private ToggleGroup categoryTg;
    private ToggleGroup orderTg;

    /**
     * Constructor for the sortCategory Button
     * 
     * @param storeFront
     * @param categoryTg
     * @param orderTg
     */
    public SortCategoryButton(StoreFront storeFront, ToggleGroup categoryTg, ToggleGroup orderTg) {
        this.storeFront = storeFront;
        this.categoryTg = categoryTg;
        this.orderTg = orderTg;
    }

    @Override
    public void handle(ActionEvent e) {
        storeFront.sortProducts(((RadioButton) categoryTg.getSelectedToggle()).getText(),
                ((RadioButton) orderTg.getSelectedToggle()).getText());
    }
}
