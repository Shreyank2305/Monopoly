package com.example.android.monopoly;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private int someVarA;
    private String someVarB;
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("someVarA", someVarA);
        outState.putString("someVarB", someVarB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        someVarA = savedInstanceState.getInt("someVarA");
        someVarB = savedInstanceState.getString("someVarB");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.createnewgame :
                Intent i = new Intent(this, CreateNewGame.class);
                startActivity(i);
                //Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show();
                break;
            case R.id.joingame :
                Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show();
                break;
            case R.id.savedgames :
                Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help :
                Toast.makeText(this, "Saale isme kya help :)", Toast.LENGTH_LONG).show();
                break;
            case R.id.about :
                Toast.makeText(this, "Abhi toh party shuru hui hai", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
    public void callbanker(View v){
        Intent i = new Intent(this, Banker.class);
        startActivity(i);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public void callplayer(View v){
        Intent i = new Intent(this, Player.class);
        startActivity(i);
    }
}
