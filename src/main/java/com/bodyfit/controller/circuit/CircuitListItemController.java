package com.bodyfit.controller.circuit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CircuitListItemController {

    @FXML
    private VBox parent;
        public CircuitListItemController(VBox parent) {

            this.parent = parent;
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getClassLoader().getResource("view/components/createCircuit-item/createCircuitItem.fxml"));
                loader.setController(this);

                AnchorPane root = loader.load();
                parent.getChildren().add(root);
            } catch (Exception ex) {
                System.out.println("Não foi possível criar o item: " + ex);
            }
    }
}
