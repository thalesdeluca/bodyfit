package com.bodyfit.controller.evaluation;

import com.bodyfit.model.Evaluation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class EvaluationItemController {

    @FXML
    private Label name;

    @FXML
    private Label date;

    @FXML
    private Label time;


    public EvaluationItemController(VBox parent, Evaluation evaluation) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/components/evaluation-item/evaluation-item.fxml"));
            loader.setController(this);
            AnchorPane root = loader.load();

            name.setText(evaluation.getName());
            date.setText(evaluation.getDateTime());

            parent.getChildren().add(root);
        } catch(Exception exception) {
            System.out.println("Erro ao carregar item");
        }
    }
}
