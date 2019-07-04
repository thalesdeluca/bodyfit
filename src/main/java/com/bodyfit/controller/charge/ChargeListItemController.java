package com.bodyfit.controller.charge;

import com.bodyfit.dao.ChargeDAO;
import com.bodyfit.model.Charge;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public class ChargeListItemController {

    @FXML
    private Pane statusBar;

    @FXML
    private Label name;

    @FXML
    private Label dueDate;

    @FXML
    private Label status;

    @FXML
    private AnchorPane container;

    public ChargeListItemController(Charge charge, VBox parent) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getClassLoader().getResource("view/components/fee-item/fee_item.fxml"));
            loader.setController(this);
            AnchorPane root = loader.load();

            name.setText(charge.getName());

            LocalDate date = LocalDate.parse(charge.getDueDate(), DateTimeFormatter.ISO_DATE);

            dueDate.setText("Data: " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            if (LocalDate.now().compareTo(date) < 0) {
                statusBar.setStyle("-fx-background-color: #DF7373");
            } else {
                statusBar.setStyle("-fx-background-color: #76C179");
            }

            status.setText(charge.getPaid() ? "Pago" : "Pendente");

            parent.getChildren().add(root);
        } catch (Exception exception) {
            System.out.println("Erro ao carregar item: " + exception);
        }

        container.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ButtonType sim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
                ButtonType nao = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja marcar como paga?", ButtonType.OK,
                        ButtonType.CANCEL);
                alert.setTitle("Mensalidade");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(nao) == sim) {
                    ChargeDAO chargeDao = new ChargeDAO();
                    chargeDao.payCharge(charge.getId());
                }
            }
        });
    }

    private void openDialog() {

    }

}
