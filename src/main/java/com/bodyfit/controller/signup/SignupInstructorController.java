package com.bodyfit.controller.signup;

import com.bodyfit.controller.instructor.InstructorListController;
import com.bodyfit.dao.InstructorDAO;
import com.bodyfit.model.Instructor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class SignupInstructorController {
    private Instructor user;
    private Stage stage;

    @FXML
    private VBox backButton;

    private InstructorDAO instructorDAO;

    public SignupInstructorController() { instructorDAO = new InstructorDAO(); }

    public void start(Stage stage, Instructor instructor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/signup/instructorSignup.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("Bodyfit");
        stage.setScene(new Scene(root));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();
        this.user = instructor;
        this.stage = stage;

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    InstructorListController instructorListController = new InstructorListController();
                    instructorListController.start(stage, instructor);
                } catch (Exception ex) {
                    System.out.println("Erro ao voltar para tela de funcionários");
                }
            }

        });
    }
}
