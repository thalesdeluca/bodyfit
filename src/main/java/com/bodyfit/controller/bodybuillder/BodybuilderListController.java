package com.bodyfit.controller.bodybuillder;

import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.dao.BodyBuilderListDAO;
import com.bodyfit.dto.BodyBuilderDTO;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;
import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class BodybuilderListController {

    private Instructor user;

    private BodyBuilderListDAO bodyBuilderListDAO;

    @FXML
    private VBox backButton;

    @FXML
    private VBox bodybuilderList;

    @FXML
    private HBox bodybuilderListItem;

    public BodybuilderListController() { bodyBuilderListDAO = new BodyBuilderListDAO();}

    public void start(Stage stage, Instructor instructor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/lists/bodybuilderList.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root, 768, 450));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();

        this.user = instructor;

        try {
            ArrayList<Bodybuilder> bodybuilder = bodyBuilderListDAO.getAll();
        } catch (Exception ex) {
            System.out.println("Erro no getAll:" + ex);
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
}
