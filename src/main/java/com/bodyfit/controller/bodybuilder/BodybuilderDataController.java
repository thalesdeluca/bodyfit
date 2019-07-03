package com.bodyfit.controller.bodybuilder;

import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Evaluation;
import com.bodyfit.model.Instructor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.HBox;

public class BodybuilderDataController {

    private Stage stage;

    private Instructor user;

    @FXML
    private Label name;

    @FXML
    private Label cpf;

    @FXML
    private Label phone;

    @FXML
    private Label birth_date;

    @FXML
    private Label last_paid;

    public BodybuilderDataController() {

    }

    public void start(Stage stage, Bodybuilder bodybuilder, Instructor instructor) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getClassLoader().getResource("view/personalData/bodybuilderData.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            stage.setTitle("BodyFit");
            stage.setScene(new Scene(root, 768, 450));
            stage.setMinHeight(720);
            stage.setMinWidth(450);
            stage.setResizable(true);
            stage.show();

            this.user = instructor;
            this.stage = stage;

            name.setText(bodybuilder.getName());
            cpf.setText(bodybuilder.getCpf());
            phone.setText(bodybuilder.getPhone());
            birth_date.setText(bodybuilder.getBirth_date());
            last_paid.setText(bodybuilder.getLast_paid());


        } catch (Exception exception) {
            System.out.println("Erro ao carregar item" + exception);
        }
    }
}