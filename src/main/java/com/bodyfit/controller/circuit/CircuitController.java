package com.bodyfit.controller.circuit;

import com.bodyfit.dao.CircuitDAO;
import com.bodyfit.dao.InstructorDAO;
import com.bodyfit.model.Instructor;
import com.bodyfit.model.Intensity;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class CircuitController {
    private Stage stage;
    private Instructor user;
    private InstructorDAO instructorDAO;

    ArrayList<Intensity> intensities;


    @FXML
    private ComboBox intensityComboBox;

    @FXML
    private VBox circuitList;

    @FXML
    private Button addNewExerciseButton;

    @FXML
    private HBox circuitListItem;

    public CircuitController() {
        CircuitDAO circuitDAO = new CircuitDAO();
        intensities = circuitDAO.getIntensity();
    }

    public void start(Stage stage, Instructor instructor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/createCircuit/createCircuit.fxml"));
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


        for(int i = 0; i < intensities.size(); i++) {
            intensityComboBox.getItems().add(intensities.get(i).getName());
        }

        addNewExerciseButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CircuitListItemController circuitListItemController = new CircuitListItemController(circuitList);
            }
        });

    }




}
