package com.example.anthony.piadas;

import android.net.Network;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

public class Util {

    public Dados getInformacao(String end){
        String json;
        Dados retorno;
        json = Json.getJSONFromAPI(end);
        Log.i("Resultado", json);
        retorno = parseJson(json);

        return retorno;
    }

    private Dados parseJson(String json){
        try {
            Dados piada = new Dados();

            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("results");

            JSONObject objArray = array.getJSONObject(0);
            JSONObject obj = objArray.getJSONObject("user");



            JSONObject piadas = obj.getJSONObject("name");
            piada.setId(piadas.getString("first"));
            piada.setPergunta(piadas.getString("middle"));
            piada.setResposta(piadas.getString("last"));


            return piada;

        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }

    }
}
