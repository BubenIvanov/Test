package com.test.bubenivanov.mytestproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Sing_in = (Button) findViewById(R.id.Sing_in);
        Button Sing_up = (Button) findViewById(R.id.Sing_up);
        final EditText Name=(EditText) findViewById(R.id.editText);
        final EditText Pass=(EditText) findViewById(R.id.editText2);
        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name.setText(" ");

                
            }
        });


    Sing_in.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });


        Sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }





}
