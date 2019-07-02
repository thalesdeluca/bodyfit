package com.bodyfit.dao;

import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class InstructorDAO {

    public ArrayList<Instructor> getAll() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        HttpGet request = null;
        try {
            request = new HttpGet("https://app-bodyfit.herokuapp.com/instructor/getAll");
            response = client.execute(request);
        } catch (Exception ex) {
            System.out.println("Não deu");
        }

        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            System.out.println("Codigo != de 200");
            return null;
        } else {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            String res = "";
            try {
                res = EntityUtils.toString(response.getEntity());
            } catch (Exception ex) {
                System.out.println("Erro na conversão do json");
            }

            JSONObject jsonObject = new JSONObject(res);
            JSONArray jsonArray = jsonObject.getJSONArray("instructors");

            ArrayList<Instructor> arrayInstructor = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                Integer id = obj.getInt("id");
                String name = obj.getString("name");
                String cpf = obj.getString("cpf");
                String birth_date = "";
                try {
                    birth_date = obj.getString("birth_date");
                } catch (Exception ex) {
                }
                String cref = obj.getString("cref");
                String code = obj.getString("code");

                Instructor instructor = new Instructor(id, name, cpf, birth_date, cref, code);
                arrayInstructor.add(instructor);
            }
            return arrayInstructor;
        }
    }
}
