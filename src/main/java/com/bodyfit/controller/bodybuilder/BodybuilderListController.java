package com.bodyfit.controller.bodybuilder;

import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.controller.signup.SignupBodybuilderController;
import com.bodyfit.dao.BodybuilderDAO;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class BodybuilderListController {

    private Stage stage;
    private Instructor user;
    private BodybuilderDAO bodybuilderDAO;
    public BodybuilderListController() {
        bodybuilderDAO = new BodybuilderDAO();
    }

    @FXML
    private VBox backButton;

    @FXML
    private VBox bodybuilderList;

    @FXML
    private Button addListButton;

    public void start(Stage stage, Instructor instructor) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/lists/bodybuilderList.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();

        this.user = instructor;
        this.stage = stage;

        ArrayList<Bodybuilder> bodybuilder = bodybuilderDAO.getAll();

        for (int i = 0; i < bodybuilder.size(); i++) {
            BodybuilderListItemController bodybuilderListItemController = new BodybuilderListItemController(
                    stage, bodybuilderList, bodybuilder.get(i), instructor);
        }

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    DashboardController dashboardController = new DashboardController();
                    dashboardController.start(stage, instructor);
                } catch (Exception ex) {
                    System.out.println("Erro ao voltar para dashboard");
                }
            }
        });

    }

    @FXML
    public void addNewBodybuilderButton(ActionEvent event) throws IOException {
        try {
            System.out.println("adhasi");
            SignupBodybuilderController signupBodybuilderController = new SignupBodybuilderController();
            signupBodybuilderController.start(stage, user);
        } catch (Exception ex) {
            System.out.println("Erro ao entrar no cadastro de bodybuilder " + ex);
        }
    }
}
