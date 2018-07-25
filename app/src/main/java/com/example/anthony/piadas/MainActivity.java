package com.example.anthony.piadas;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void info(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("JOKER app v1.0").setNeutralButton("Ok", null).show();
    }

    public void newJoke(View view){
        Intent intent = new Intent(this, Joker.class);
        startActivity(intent);
    }


}
