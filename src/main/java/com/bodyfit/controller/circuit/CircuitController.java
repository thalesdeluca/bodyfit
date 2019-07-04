package com.bodyfit.controller.circuit;

import com.bodyfit.controller.bodybuilder.BodybuilderDataController;
import com.bodyfit.controller.bodybuilder.BodybuilderListController;
import com.bodyfit.dao.CircuitDAO;
import com.bodyfit.dao.InstructorDAO;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;
import com.bodyfit.model.Intensity;
import javafx.event.ActionEvent;
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

import java.io.IOException;
import java.util.ArrayList;

public class CircuitController {
    private Stage stage;
    private Instructor user;
    private InstructorDAO instructorDAO;
    private ArrayList<Intensity> intensities;
    private ArrayList<CircuitListItemController> exercises;
    private Bodybuilder bodybuilder;

    @FXML
    private ComboBox intensityComboBox;

    @FXML
    private VBox circuitList;

    @FXML
    private VBox backButton;

    @FXML
    private Button addNewExerciseButton;

    @FXML
    private HBox circuitListItem;

    public CircuitController() {
        CircuitDAO circuitDAO = new CircuitDAO();
        intensities = circuitDAO.getIntensity();
        exercises = new ArrayList<>();
    }

    public void start(Stage stage, Instructor instructor, Bodybuilder bodybuilder) throws IOException {
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
        this.bodybuilder = bodybuilder;

        for(int i = 0; i < intensities.size(); i++) {
            intensityComboBox.getItems().add(intensities.get(i).getName());
        }

        addNewExerciseButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CircuitListItemController circuitListItemController = new CircuitListItemController();
                circuitListItemController.start(circuitList);
                exercises.add(circuitListItemController);
            }
        });

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BodybuilderListController bodybuilderListController = new BodybuilderListController();
                try {
                    bodybuilderListController.start(stage, instructor);
                }catch (Exception ex) {
                    System.out.println("não voltou para a tela de lista");
                }

            }
        });
    }

    @FXML
    public void register(ActionEvent event) {
        Button button = (Button) event.getSource();
        button.setDisable(true);

        Integer intensityId = -1;

        for(Intensity intensity : intensities) {
            if(intensity.getName().equals(intensityComboBox.getValue())) {
                intensityId = intensity.getId();
            }
        }

        CircuitDAO circuitDAO = new CircuitDAO();
        Boolean isOk = circuitDAO.save(exercises, user.getId(), bodybuilder.getId(), intensityId);

        if(isOk) {
            BodybuilderDataController bodybuilderDataController = new BodybuilderDataController();
            try {
                bodybuilderDataController.start(stage, bodybuilder, user);
            } catch(Exception ex) {
                System.out.println("Erro ao trocar de tela");
            }

        }

        button.setDisable(false);
    }




}
