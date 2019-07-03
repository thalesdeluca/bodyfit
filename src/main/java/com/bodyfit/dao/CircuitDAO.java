package com.bodyfit.dao;

import com.bodyfit.dto.BodyBuilderDTO;
import com.bodyfit.dto.IntensityDTO;
import com.bodyfit.helper.Request;
import com.bodyfit.model.Intensity;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

public class CircuitDAO {

    public ArrayList<Intensity> getIntensity() {
        HttpResponse httpResponse = null;
        JsonObject json = new JsonObject();
        try {
            httpResponse = Request.post("https://app-bodyfit.herokuapp.com/intensity/getAll", json);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        if(httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
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
}
