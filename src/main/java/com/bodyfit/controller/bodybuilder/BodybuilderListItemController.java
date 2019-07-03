package com.bodyfit.controller.bodybuilder;

import com.bodyfit.controller.bodybuilder.BodybuilderDataController;
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

public class BodybuilderListItemController {

  private Stage stage;

  private Instructor user;

  @FXML
  private HBox item;

  @FXML
  private Label name;

  @FXML
  private Label cpf;

  @FXML
  private Label birth_date;

  public BodybuilderListItemController(Stage stage, VBox parent, Bodybuilder bodybuilder, Instructor instructor) {
    try {
      FXMLLoader loader = new FXMLLoader(
          getClass().getClassLoader().getResource("view/components/list-item/list-item.fxml"));
      loader.setController(this);
      Parent root = loader.load();

      this.user = instructor;
      this.stage = stage;

      name.setText(bodybuilder.getName());
      cpf.setText(bodybuilder.getCpf());
      birth_date.setText(bodybuilder.getBirth_date());

      parent.getChildren().add(root);

      item.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
          try {
            BodybuilderDataController bodybuilderDataController = new BodybuilderDataController();
            bodybuilderDataController.start(stage, bodybuilder, instructor);
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
