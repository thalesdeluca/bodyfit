package com.bodyfit.controller.dashboard;

import com.bodyfit.controller.bodybuillder.BodybuilderListController;
import com.bodyfit.model.Instructor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class DashboardController {
    private Instructor user;

    @FXML
    private VBox bodybuilderBtn;

    @FXML
    private VBox instructorBtn;

    @FXML
    private VBox feeBtn;

    @FXML
    private VBox evaluationBtn;



    public void start(Stage stage, Instructor instructor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/dashboard/dashboard_instructor.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root, 768, 450));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();

        this.user = instructor;

        bodybuilderBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    BodybuilderListController bodybuilderListController = new BodybuilderListController();
                    bodybuilderListController.start(stage, instructor);
                } catch (Exception exception) {
                    System.out.println("Erro ao trocar de tela");
                }
            }
        });

        instructorBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getSource().getClass().getName());
            }
        });

        feeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getSource().getClass().getName());
            }
        });

        evaluationBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getSource().getClass().getName());
            }
        });
    }


}


