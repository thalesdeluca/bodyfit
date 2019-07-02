package com.bodyfit.controller.evaluation;

import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.dao.EvaluationDAO;
import com.bodyfit.model.Evaluation;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EvaluationController {

    private EvaluationDAO evaluationDAO;
    private ArrayList<Evaluation> evaluations = new ArrayList<>();

    @FXML
    private VBox evaluationBox;

    @FXML
    private VBox backButton;

    public EvaluationController() {
        evaluationDAO = new EvaluationDAO();
        evaluations = evaluationDAO.getEvaluations();
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/avaliacoes/avaliacoes.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();

        for (Evaluation ev : evaluations) {
            EvaluationItemController evaluationItemController = new EvaluationItemController(evaluationBox, ev);
        }

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                DashboardController dashboardController = new DashboardController();
                dashboardController.start(stage, user);
            }
        });

    }

}
