package com.example.JavaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StoreApplication extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.BLACK);
        Stage stage = new Stage();

        Text text = new Text();
        text.setText("a");
    }

}
