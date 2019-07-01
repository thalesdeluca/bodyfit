package com.bodyfit.controller.evaluation;

import com.bodyfit.dao.EvaluationDAO;
import com.bodyfit.model.Evaluation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

        /*
         * TextField textField[] = new TextField[evaluations.size()]; for (int i = 0; i
         * < evaluations.size(); i++) { textField[i] = new TextField("Hello");
         * evaluationBox.setMargin(textField[i], new Insets(5)); }
         */
        stage.show();
    }
}
