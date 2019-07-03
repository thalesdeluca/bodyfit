package com.bodyfit.controller.instructor;

import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.controller.signup.SignupInstructorController;
import com.bodyfit.dao.InstructorDAO;
import com.bodyfit.model.Instructor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class InstructorListController {

    private Instructor user;

    private Stage stage;

    private InstructorDAO instructorDAO;

    @FXML
    private VBox backButton;

    @FXML
    private VBox instructorList;

    @FXML
    private Button addListButton;

    public InstructorListController() {
        instructorDAO = new InstructorDAO();
    }

    public void start(Stage stage, Instructor instructor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/lists/instructorList.fxml"));
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

        ArrayList<Instructor> instructors = instructorDAO.getAll();

        for (int i = 0; i < instructors.size(); i++) {
            InstructorListItemController bodybuilderListItemController = new InstructorListItemController(stage, instructorList, instructors.get(i));
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
    public void addNewInstructorButton(ActionEvent event) throws IOException {
        try {
            SignupInstructorController signupInstructorController = new SignupInstructorController();
            signupInstructorController.start(stage, user);
        } catch (Exception ex) {
            System.out.println("Erro ao abrir cadastro de instrutor");
        }
    }
}
