package com.example.ericbell.saveddata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LgonActivity extends AppCompatActivity {
    Button btlogin;
    EditText etusername;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lgon);


        btlogin = (Button) findViewById(R.id.btlogin);
        etusername = (EditText) findViewById(R.id.etusername);
        pref = getSharedPreferences("Notes",MODE_PRIVATE);
    }


    public void login(View view) {
        if (etusername.getText().toString().length() <= 3 ) {
           etusername.setError("Must be At Least 3 Charcters");
            return;
        }

        SharedPreferences.Editor editor = pref.edit();
       String userName = etusername.getText().toString();
        editor.putString("UserName", userName);
        editor.commit();

        Intent intenttologin = new Intent(this, MainActivity.class);
        startActivity(intenttologin);

    }
}
