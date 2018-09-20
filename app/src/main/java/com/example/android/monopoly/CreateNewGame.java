package com.example.android.monopoly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;

public class CreateNewGame extends AppCompatActivity {
float sa;
    int numberofplayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_game);
        Spinner s1 = (Spinner)findViewById(R.id.numberofplayers);
        List<String> number = new ArrayList<>();
        number.add("2");
        number.add("3");
        number.add("4");
        number.add("5");
        number.add("6");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, number);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);

    }
    public void createnewgame(View view){
        EditText startamount = (EditText)findViewById(R.id.startamount);
        Spinner s1 = (Spinner)findViewById(R.id.numberofplayers);

        int j = s1.getSelectedItemPosition();
        numberofplayers = j + 2;


        if (startamount.getText().toString().equals("")){
            sa = 0;
        }
        else{
            sa = parseFloat(startamount.getText().toString());
        }

        SharedPreferences mysf = getSharedPreferences("shared",0);
        SharedPreferences.Editor editor = mysf.edit();

        editor.putInt("numberofplayers",numberofplayers);
        editor.commit();
        Intent i = new Intent(this, Banker.class);
        i.putExtra("startsa",sa);
        i.putExtra("numberofplayers",numberofplayers);
        startActivity(i);

    }
}
