package com.bodyfit.controller.circuit;

import com.bodyfit.model.Card;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CircuitListItemController {

    @FXML
    private TextField name;

    @FXML
    private TextField series;

    @FXML
    private TextField repetitions;

    @FXML
    private TextField weight;



    public void start(VBox parent) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getClassLoader().getResource("view/components/createCircuit-item/createCircuitItem.fxml"));
            loader.setController(this);

            HBox root = loader.load();
            parent.getChildren().add(root);
        } catch (Exception ex) {
            System.out.println("Não foi possível criar o item: " + ex);
        }
    }

    public Card toCards() throws IOException {
        return new Card(name.getText(),Integer.parseInt(series.getText()),
                Integer.parseInt(repetitions.getText()),
                Double.parseDouble(weight.getText()));
    }

}
