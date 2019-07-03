package com.bodyfit.dao;

import com.bodyfit.dto.ChargeListDTO;
import com.bodyfit.helper.Request;
import com.bodyfit.model.Charge;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javafx.scene.control.Alert;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

import java.util.List;

public class ChargeDAO {
    public List<Charge> getAllCharges () {
        HttpResponse httpResponse = null;
        try {
            httpResponse = Request.get("https://app-bodyfit.herokuapp.com/charge/getAll");
        } catch (Exception err) {
            System.out.println("Erro");
        }

        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao carregar Dados");
            alert.setHeaderText("Ocorreu um erro ao tentar carregar as mensalidades!");
            alert.setContentText("Tente novamente mais tarde!");
            alert.showAndWait();

            return null;
        } else {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

            String res = "";
            try {
                res = EntityUtils.toString(httpResponse.getEntity());
            } catch (Exception exception) {
                System.out.println("Erro na conversão de json");
            }

            ChargeListDTO chargeListDTO = gson.fromJson(res, ChargeListDTO.class);
            return chargeListDTO.getCharges();
        }
    }

    public void payCharge (Integer id) {
        HttpResponse httpResponse = null;
        JsonObject json = new JsonObject();
        json.addProperty("id_charge", id);
        try {
            httpResponse = Request.post("https://app-bodyfit.herokuapp.com/charge/pay", json);
        } catch (Exception err) {
            System.out.println("Erro");
        }

        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao pagar Mensalidade");
            alert.setHeaderText("Ocorreu um erro ao tentar pagar mensalidades!");
            alert.setContentText("Tente novamente mais tarde!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Mensalidade paga com sucesso");
            alert.setContentText("Tente novamente mais tarde!");
            alert.showAndWait();
        }
    }
}
