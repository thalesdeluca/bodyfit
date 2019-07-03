package com.bodyfit.controller.instructor;

import com.bodyfit.controller.instructor.InstructorDataController;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class InstructorListItemController {
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

  public InstructorListItemController(Stage stage, VBox parent, Instructor instructor) {
    try {
      FXMLLoader loader = new FXMLLoader(
          getClass().getClassLoader().getResource("view/components/list-item/list-item.fxml"));
      loader.setController(this);
      Parent root = loader.load();

      this.user = instructor;
      this.stage = stage;

      name.setText(instructor.getName());
      cpf.setText(instructor.getCpf());
      birth_date.setText(instructor.getBirthDate());

      parent.getChildren().add(root);

      item.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
          try {
            InstructorDataController instructorDataController = new InstructorDataController();
            instructorDataController.start(stage, instructor);
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
