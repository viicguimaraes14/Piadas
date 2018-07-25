package com.example.anthony.piadas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class Joker extends Activity {

    private TextView resposta;
    private TextView idid;
    private TextView pergunta;

    private ProgressDialog load;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);


        resposta = (TextView) findViewById(R.id.resposta);
        idid = (TextView) findViewById(R.id.idid);
        pergunta = (TextView) findViewById(R.id.pergunta);
        GetJson download = new GetJson();
        download.execute();

    }





    private class GetJson extends AsyncTask<Void, Dados, Dados> {

        protected void onPreExecute(){

            load = ProgressDialog.show(Joker.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected Dados doInBackground(Void... params) {
            Util util = new Util();
            return util.getInformacao("http://us-central1-kivson.cloudfunctions.net/charada-aleatoria/");

        }

        @Override
        protected void onPostExecute(Dados d){
            idid.setText(d.getId().substring(0,1).toUpperCase()+d.getId().substring(1));
            pergunta.setText(d.getPergunta().substring(0,1).toUpperCase()+d.getPergunta().substring(1));
            resposta.setText(d.getResposta().substring(0,1).toUpperCase()+d.getResposta().substring(1));
            load.dismiss();
        }
    }
}
