package com.bodyfit.dao;

import com.bodyfit.controller.circuit.CircuitListItemController;
import com.bodyfit.dto.CircuitDTO;
import com.bodyfit.dto.IntensityDTO;
import com.bodyfit.helper.Request;
import com.bodyfit.model.Card;
import com.bodyfit.model.Intensity;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javafx.scene.control.Alert;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

public class CircuitDAO {

    public ArrayList<Intensity> getIntensity() {
        HttpResponse httpResponse = null;
        try {
            httpResponse = Request.post("https://app-bodyfit.herokuapp.com/intensity/getAll");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            return null;
        } else {
            String res = "";
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            try {
                res = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("foi gravado: " + res);
            } catch (Exception ex) {
                System.out.println("Erro na conversão para json");
            }
            IntensityDTO intensityDTO = gson.fromJson(res, IntensityDTO.class);
            return intensityDTO.getIntensities();

        }
    }

    public Boolean save(ArrayList<CircuitListItemController> list, Integer instructorId, Integer bodybuilderId,
            Integer intensityId) {
        ArrayList<Card> cards = new ArrayList<>();

        for (CircuitListItemController exItem : list) {
            try {
                cards.add(exItem.toCards());
            } catch (IOException io) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro ao salvar Treino");
                alert.setHeaderText("Ocorreu um erro ao tentar Salvar!");
                alert.setContentText("Verifique os campos e tente novamente!");
                alert.showAndWait();
                return false;
            }

        }

        CircuitDTO circuitDTO = new CircuitDTO(instructorId, bodybuilderId, intensityId, cards);

        HttpResponse httpResponse = null;
        Gson gson = new Gson();
        String json = gson.toJson(circuitDTO);

        try {
            System.out.println(json);
            httpResponse = Request.post("https://app-bodyfit.herokuapp.com/workout/create", json);
            if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao salvar Treino");
            alert.setHeaderText("Ocorreu um erro ao tentar Salvar!");
            alert.setContentText("Verifique os campos e tente novamente!");
            alert.showAndWait();
        }

        return true;
    }
}
