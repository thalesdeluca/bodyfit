package com.bodyfit.controller.charge;

import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.dao.ChargeDAO;
import com.bodyfit.model.Charge;
import com.bodyfit.model.Instructor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChargeListController {
    private ChargeDAO chargeDAO;
    private List<Charge> charges;

    @FXML
    private VBox backButton;

    @FXML
    private VBox chargeBox;

    @FXML
    private Instructor user;

    public ChargeListController() {
        chargeDAO = new ChargeDAO();
        charges = chargeDAO.getAllCharges();
    }

    public void start(Stage stage, Instructor instructor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/mensalidades/mensalidades.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();

        user = instructor;

        for(Charge charge : charges) {
            ChargeListItemController chargeListItem = new ChargeListItemController(charge, chargeBox);
        }

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                try {
                    DashboardController dashboardController = new DashboardController();
                    dashboardController.start(stage, user);
                } catch(IOException ex) {
                    System.out.println("Erro ao trocar de tela");

                }

            }
        });
    }

}
