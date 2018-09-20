package com.example.android.monopoly;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.monopoly.R.id.B1;
import static java.lang.Float.parseFloat;

public class Banker extends AppCompatActivity {

    float p1, p2, p3, p4, p5, p6, bank, amount,sa;
    int numberofplayers;
    String P1 = "Player1";
    String P2 = "Player2";
    String P3 = "Player3";
    String P4 = "Player4";
    String P5 = "Player5";
    String P6 = "Player6";

    //String P1, P2, P3, P4, P5, P6;






    List<String> players = new ArrayList<>();
    List<String> players1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banker);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Bundle abc = new Bundle();
        abc = getIntent().getExtras();
        if (abc != null) {
            sa = (abc.getFloat("startsa"));
            //numberofplayers = (abc.getInt("numberofplayers"));
        }
        System.out.println("start amount : "+sa);
        System.out.println("numberofpayers : "+numberofplayers);
        SharedPreferences mysf = getSharedPreferences("shared", 0);
        SharedPreferences.Editor editor = mysf.edit();

        P1 = mysf.getString("player1","");
        P2 = mysf.getString("player2","");
        P3 = mysf.getString("player3","");
        P4 = mysf.getString("player4","");
        P5 = mysf.getString("player5","");
        P6 = mysf.getString("player6","");
        numberofplayers = mysf.getInt("numberofplayers",0);
        if (numberofplayers == 0)
            numberofplayers = 6;
        System.out.println("number of players "+numberofplayers);
        setnewvalue();
        setcustomname();


        Spinner s2 = (Spinner) findViewById(R.id.sender);

        players.add(0,"Sender");
        players.add(1,"Bank");
        players.add(2,""+P1);
        players.add(3,""+P2);
        players.add(4,""+P3);
        players.add(5,""+P4);
        players.add(6,""+P5);
        players.add(7,""+P6);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, players);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(dataAdapter);
        int j = numberofplayers + 1;
        for(int i = 7; i > j; i--){
            players.remove(i);
            System.out.println("player removed was : "+i);
        }


        Spinner s1 = (Spinner) findViewById(R.id.receiver);
        players1.add("Receiver");
        players1.add("Bank");
        players1.add(""+P1);
        players1.add(""+P2);
        players1.add(""+P3);
        players1.add(""+P4);
        players1.add(""+P5);
        players1.add(""+P6);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, players1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataAdapter1);
        for(int i = 7; i > j; i--){
            players1.remove(i);
            System.out.println("player removed was : "+i);
        }

        for(int i = numberofplayers+1; i < 7; i++){

            switch (i){
                case 3 :
                    EditText p3 = (EditText)findViewById(R.id.P3);
                    TextView b3 = (TextView)findViewById(R.id.B3);
                    p3.setVisibility(View.INVISIBLE);
                    b3.setVisibility(View.INVISIBLE);
                    System.out.println("case 3");
                    break;
                case 4 :
                    EditText p4 = (EditText)findViewById(R.id.P4);
                    TextView b4 = (TextView)findViewById(R.id.B4);
                    p4.setVisibility(View.INVISIBLE);
                    b4.setVisibility(View.INVISIBLE);
                    System.out.println("case 4");
                    break;
                case 5 :
                    EditText p5 = (EditText)findViewById(R.id.P5);
                    TextView b5 = (TextView)findViewById(R.id.B5);
                    p5.setVisibility(View.INVISIBLE);
                    b5.setVisibility(View.INVISIBLE);
                    System.out.println("case 5");
                    break;
                case 6 :
                    EditText p6 = (EditText)findViewById(R.id.P6);
                    TextView b6 = (TextView)findViewById(R.id.B6);
                    p6.setVisibility(View.INVISIBLE);
                    b6.setVisibility(View.INVISIBLE);
                    System.out.println("case 6");
                    break;

            }
        }


    }



    public void setnewvalue(){
        SharedPreferences mysf = getSharedPreferences("shared",0);
        SharedPreferences.Editor editor = mysf.edit();
        if (sa == 0) {
            p1 = mysf.getFloat("bal1", 0);
            p2 = mysf.getFloat("bal2", 0);
            p3 = mysf.getFloat("bal3", 0);
            p4 = mysf.getFloat("bal4", 0);
            p5 = mysf.getFloat("bal5", 0);
            p6 = mysf.getFloat("bal6", 0);
            System.out.println("this is : else");
        }
        else {
            p1 = p2 = p3 = p4 = p5 = p6 = sa;
            System.out.println("this is : if");
            System.out.println("this is : "+sa);
            System.out.println("this is : "+p1);
            System.out.println("this is : "+p2);
        }

        TextView b1 = (TextView)findViewById(R.id.B1);
        TextView b2 = (TextView)findViewById(R.id.B2);
        TextView b3 = (TextView)findViewById(R.id.B3);
        TextView b4 = (TextView)findViewById(R.id.B4);
        TextView b5 = (TextView)findViewById(R.id.B5);
        TextView b6 = (TextView)findViewById(R.id.B6);
        b1.setText(""+p1);
        b2.setText(""+p2);
        b3.setText(""+p3);
        b4.setText(""+p4);
        b5.setText(""+p5);
        b6.setText(""+p6);
    }

    float sender(float send) {
        send = send - amount;
        return send;
    }

    float receiver(float receive) {
        receive = receive + amount;
        return receive;
    }

    public void transferto(View v) {
        TextView b1 = (TextView)findViewById(B1);
        TextView b2 = (TextView)findViewById(R.id.B2);
        TextView b3 = (TextView)findViewById(R.id.B3);
        TextView b4 = (TextView)findViewById(R.id.B4);
        TextView b5 = (TextView)findViewById(R.id.B5);
        TextView b6 = (TextView)findViewById(R.id.B6);

        EditText amt = (EditText) findViewById(R.id.amount);
        if(amt.getText().toString().equals(""))
        {
            amount = 0;
        }
        else {
            amount = parseFloat(amt.getText().toString());
        }
        Spinner s1 = (Spinner) findViewById(R.id.sender);
        int pos1 = s1.getSelectedItemPosition();

        switch (pos1) {
            case 0:
                break;
            case 1:
                //bank = sender(bank);
                break;
            case 2:
                p1 = sender(p1);
                if (p1<0){
                    p1 = p1 + amount;
                    Toast.makeText(this, "Insufficient Funds with "+P1, Toast.LENGTH_LONG).show();
                }
                else
                    execute();
                break;
            case 3:
                p2 = sender(p2);
                if (p2<0){
                    p2 = p2 + amount;
                    Toast.makeText(this, "Insufficient Funds with "+P2, Toast.LENGTH_LONG).show();
                }
                else
                    execute();
                break;
            case 4:
                p3 = sender(p3);
                if (p3<0){
                    p3 = p3 + amount;
                    Toast.makeText(this, "Insufficient Funds with "+P3, Toast.LENGTH_LONG).show();
                }
                else
                    execute();
                break;
            case 5:
                p4 = sender(p4);
                if (p4<0){
                    p4 = p4 + amount;
                    Toast.makeText(this, "Insufficient Funds with "+P4, Toast.LENGTH_LONG).show();
                }
                else
                    execute();
                break;
            case 6:
                p5 = sender(p5);
                if (p5<0){
                    p5 = p5 + amount;
                    Toast.makeText(this, "Insufficient Funds with "+P5, Toast.LENGTH_LONG).show();
                }
                else
                    execute();
                break;
            case 7:
                p6 = sender(p6);
                if (p6<0){
                    p6 = p6 + amount;
                    Toast.makeText(this, "Insufficient Funds with "+P6, Toast.LENGTH_LONG).show();
                }
                else
                    execute();
                break;
        }


        b1.setText(""+p1);
        b2.setText(""+p2);
        b3.setText(""+p3);
        b4.setText(""+p4);
        b5.setText(""+p5);
        b6.setText(""+p6);
        amt.setText("");
    }
    public void execute(){
        Spinner s2 = (Spinner) findViewById(R.id.receiver);
        int pos2 = s2.getSelectedItemPosition();
        switch (pos2) {
            case 0:
                break;
            case 1:
                bank = receiver(bank);
                Toast.makeText(this, "Bank Received: "+amount, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                p1 = receiver(p1);
                Toast.makeText(this, "P1 Received: "+amount, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                p2 = receiver(p2);
                Toast.makeText(this, "P2 Received: "+amount, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                p3 = receiver(p3);
                Toast.makeText(this, "P3 Received: "+amount, Toast.LENGTH_SHORT).show();
                break;
            case 5:
                p4 = receiver(p4);
                Toast.makeText(this, "P4 Received: "+amount, Toast.LENGTH_SHORT).show();
                break;
            case 6:
                p5 = receiver(p5);
                Toast.makeText(this, "P5 Received: "+amount, Toast.LENGTH_SHORT).show();
                break;
            case 7:
                p6 = receiver(p6);
                Toast.makeText(this, "P6 Received: "+amount, Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void setcustomname(){
        final EditText play1 = (EditText)findViewById(R.id.P1) ;
        final EditText play2 = (EditText)findViewById(R.id.P2) ;
        final EditText play3 = (EditText)findViewById(R.id.P3) ;
        final EditText play4 = (EditText)findViewById(R.id.P4) ;
        final EditText play5 = (EditText)findViewById(R.id.P5) ;
        final EditText play6 = (EditText)findViewById(R.id.P6) ;
        SharedPreferences mysf = getSharedPreferences("shared",0);

        play1.setText(""+mysf.getString("player1",""));
        play2.setText(""+mysf.getString("player2",""));
        play3.setText(""+mysf.getString("player3",""));
        play4.setText(""+mysf.getString("player4",""));
        play5.setText(""+mysf.getString("player5",""));
        play6.setText(""+mysf.getString("player6",""));

        if (play1.getText().toString().equals("")) {
            play1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    P1 = play1.getText().toString();
                    players.remove(2);
                    players1.remove(2);
                    players.add(2, "" + P1);
                    players1.add(2, "" + P1);
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    play1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            play1.setEnabled(false);
                        }
                    });
                }
            });
        }
        else{
            play1.setEnabled(false);
        }

        if(play2.getText().toString().equals("")) {
            play2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    P2 = play2.getText().toString();
                    players.remove(3);
                    players1.remove(3);
                    players.add(3, "" + P2);
                    players1.add(3, "" + P2);
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    play2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            play2.setEnabled(false);
                        }
                    });
                }
            });
        }
        else {
            play2.setEnabled(false);
        }
        if(play3.getText().toString().equals("")) {
            play3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    P3 = play3.getText().toString();
                    players.remove(4);
                    players1.remove(4);
                    players.add(4, "" + P3);
                    players1.add(4, "" + P3);
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    play3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            play3.setEnabled(false);
                        }
                    });
                }
            });
        }
        else{
            play3.setEnabled(false);
        }
        if (play4.getText().toString().equals("")) {
            play4.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    P4 = play4.getText().toString();
                    players.remove(5);
                    players1.remove(5);
                    players.add(5, "" + P4);
                    players1.add(5, "" + P4);
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    play4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            play4.setEnabled(false);
                        }
                    });
                }
            });
        }
        else{
            play4.setEnabled(false);
        }
        if(play5.getText().toString().equals("")) {
            play5.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    P5 = play5.getText().toString();
                    players.remove(6);
                    players1.remove(6);
                    players.add(6, "" + P5);
                    players1.add(6, "" + P5);
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    play5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            play5.setEnabled(false);
                        }
                    });
                }
            });
        }
        else{
            play5.setEnabled(false);
        }
        if(play6.getText().toString().equals("")) {
            play6.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    P6 = play6.getText().toString();
                    players.remove(7);
                    players1.remove(7);
                    players.add(7, "" + P6);
                    players1.add(7, "" + P6);
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    play6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            play6.setEnabled(false);
                        }
                    });
                }
            });
        }
        else{
            play6.setEnabled(false);
        }

    }


    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences mysf = getSharedPreferences("shared",0);
        SharedPreferences.Editor editor = mysf.edit();
        editor.putString("player1",P1);
        editor.putString("player2",P2);
        editor.putString("player3",P3);
        editor.putString("player4",P4);
        editor.putString("player5",P5);
        editor.putString("player6",P6);
        editor.putFloat("bal1",p1);
        editor.putFloat("bal2",p2);
        editor.putFloat("bal3",p3);
        editor.putFloat("bal4",p4);
        editor.putFloat("bal5",p5);
        editor.putFloat("bal6",p6);
        editor.commit();
    }
    public void exit(View view){
        SharedPreferences mysf = getSharedPreferences("shared",0);
        SharedPreferences.Editor editor = mysf.edit();
        Toast.makeText(this, "attempt to clear", Toast.LENGTH_SHORT).show();
        editor.clear().commit();
        int temp = 6;
        editor.putInt("numberofplayers",temp).commit();

        System.out.println("number of players"+mysf.getInt("numberofplayers",0));
        finish();
        System.exit(0);
    }


}