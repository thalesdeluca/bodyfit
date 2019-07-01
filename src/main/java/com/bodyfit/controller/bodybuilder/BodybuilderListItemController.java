package com.bodyfit.controller.bodybuilder;

import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Evaluation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class BodybuilderListItemController {

  @FXML
  private Label name;

  @FXML
  private Label cpf;

  @FXML
  private Label birth_date;

  public BodybuilderListItemController(VBox parent, Bodybuilder bodybuilder) {
    try {
      FXMLLoader loader = new FXMLLoader(
          getClass().getClassLoader().getResource("view/components/list-item/list-item.fxml"));
      loader.setController(this);
      AnchorPane root = loader.load();

      name.setText(bodybuilder.getName());
      cpf.setText(bodybuilder.getCpf());
      birth_date.setText(bodybuilder.getBirth_date());

      parent.getChildren().add(root);
    } catch (Exception exception) {
      System.out.println("Erro ao carregar item");
    }
  }
}
