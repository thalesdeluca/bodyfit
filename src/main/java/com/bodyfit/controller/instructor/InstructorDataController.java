package com.bodyfit.controller.instructor;

import com.bodyfit.controller.bodybuilder.BodybuilderListController;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class InstructorDataController {

    private Stage stage;

    private Instructor user;

    @FXML
    private VBox backButton;

    @FXML
    private Label name;

    @FXML
    private Label cpf;

    @FXML
    private Label cref;

    @FXML
    private Label birth_date;

    public InstructorDataController() {

    }

    public void start(Stage stage, Instructor instructor) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getClassLoader().getResource("view/personalData/instructorData.fxml"));
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

            name.setText(instructor.getName());
            cpf.setText(instructor.getCpf());
            birth_date.setText(instructor.getBirthDate());
            cref.setText(instructor.getCref());

            backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        BodybuilderListController bodybuilderListController = new BodybuilderListController();
                        bodybuilderListController.start(stage, instructor);
                    } catch (Exception ex) {
                        System.out.println("Erro ao voltar para dashboard");
                    }
                }
            });

        } catch (Exception exception) {
            System.out.println("Erro ao carregar item" + exception);
        }
    }
}