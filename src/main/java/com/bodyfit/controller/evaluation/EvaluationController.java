package com.bodyfit.controller.evaluation;

import com.bodyfit.dao.EvaluationDAO;
import com.bodyfit.model.Evaluation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.util.ArrayList;

public class EvaluationController {

    private EvaluationDAO evaluationDAO;
    private ArrayList<Evaluation> evaluations = new ArrayList<>();


    @FXML
    private VBox evaluationBox;

    public EvaluationController() {
        evaluationDAO = new EvaluationDAO();
        evaluations = evaluationDAO.getEvaluations();
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/avaliacoes/avaliacoes.fxml"));

        loader.setController(this);
        Parent root = loader.load();

        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root, 768, 450));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);

        HBox[] boxes = new HBox[evaluations.size()];
        Label[] nameLabels = new Label[evaluations.size()];
        Label[] dateLabels = new Label[evaluations.size()];
        Label[] hourLabels = new Label[evaluations.size()];
        String date;
        String hour;
        for (int i = 0; i < evaluations.size(); i++) {
            boxes[i] = new HBox();
            boxes[i].setPadding(new Insets(5, 12, 4, 12));
            boxes[i].setStyle("-fx-background-color: #883f81; -fx-margin-top: 10px;");
            nameLabels[i] = new Label("Nome: " + evaluations.get(i).getName());
            nameLabels[i].setStyle("-fx-background-color: #883f81; -fx-height: 200px; -fx-font-size: 20px;");
            date = evaluations.get(i).getDateTime().split("T")[0];
            hour = evaluations.get(i).getDateTime().split("T")[1].split(".000")[0];
            dateLabels[i] = new Label("Dia: " + date);
            dateLabels[i].setStyle("-fx-background-color: #883f81; -fx-height: 200px; -fx-font-size: 20px;");
            hourLabels[i] = new Label("Horario: " + hour);
            hourLabels[i].setStyle("-fx-background-color: #883f81; -fx-height: 200px; -fx-font-size: 20px;");
            boxes[i].getChildren().addAll(nameLabels[i], dateLabels[i], hourLabels[i]);
            evaluationBox.getChildren().add(boxes[i]);
        }
        stage.show();
    }
}
