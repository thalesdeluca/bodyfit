package com.bodyfit.controller.bodybuilder;

import com.bodyfit.controller.circuit.CircuitController;
import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.controller.instructor.InstructorListController;
import com.bodyfit.dao.BodybuilderDAO;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Evaluation;
import com.bodyfit.model.Instructor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;

public class BodybuilderDataController {

    private Stage stage;

    private Instructor user;

    @FXML
    private Button createEvaluation;

    @FXML
    private Button confirmEvaluation;

    @FXML
    private Button createCircuit;

    @FXML
    private AnchorPane createEvaluationModal;

    @FXML
    private VBox backButton;

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

    @FXML
    private TextField dateButton;

    @FXML
    private TextField hourButton;

    private BodybuilderDAO bodybuilderDAO;

    public BodybuilderDataController() {
        bodybuilderDAO = new BodybuilderDAO();
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

            backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        InstructorListController instructorListController = new InstructorListController();
                        instructorListController.start(stage, instructor);
                    } catch (Exception ex) {
                        System.out.println("Erro ao voltar para dashboard");
                    }
                }
            });

            createEvaluation.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        createEvaluationModal.setVisible(true);
                    } catch (Exception ex) {
                        System.out.println("Erro ao voltar para dashboard");
                    }
                }
            });

            confirmEvaluation.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        String date = dateButton.getText();
                        String hour = hourButton.getText();
                        Integer id = bodybuilder.getId();

                        boolean res = bodybuilderDAO.createEvaluation(id, date, hour);

                        if(res == true) {
                            createEvaluationModal.setVisible(false);
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Erro!");
                            alert.setHeaderText("Erro.");
                            alert.setContentText("Nao foi registrado com sucesso");
                            alert.showAndWait();
                        }
                    } catch (Exception ex) {
                        System.out.println("Erro ao voltar para dashboard");
                    }
                }
            });

            createCircuit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    CircuitController circuitController = new CircuitController();
                    try {
                        circuitController.start(stage, instructor);
                    } catch (Exception ex) {
                        System.out.println("Não foi posśível criar a tela de adicionar circuito!" + ex);
                    }
                }
            });

        } catch (Exception exception) {
            System.out.println("Erro ao carregar item" + exception);
        }
    }
}