package com.bodyfit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/login/login.fxml"));
        Font.loadFont(getClass().getResourceAsStream("fonts/Khand-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Khand-Bold.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Khand-Light.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Raleway-Bold.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Raleway-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Raleway-Thin.ttf"), 14);
        primaryStage.setTitle("BodyFit");
        primaryStage.setScene(new Scene(root, 768, 450));
        primaryStage.setMinHeight(720);
        primaryStage.setMinWidth(450);
        primaryStage.setResizable(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
