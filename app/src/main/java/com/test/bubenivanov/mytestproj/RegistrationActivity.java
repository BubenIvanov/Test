package com.test.bubenivanov.mytestproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button register_button;
    private TextView backToLogin;
    private EditText regEmail, regPass, regName;
    private DbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db = new DbHelper(this);
        register_button = (Button) findViewById(R.id.register);
        backToLogin=(TextView) findViewById(R.id.backtolog);
        regName = (EditText) findViewById(R.id.regname);
        regPass = (EditText) findViewById(R.id.regpassword);
        regEmail = (EditText) findViewById(R.id.regemail);
        backToLogin.setOnClickListener(this);
        register_button.setOnClickListener(this);
    }




    private void register() {
        String name = regName.getText().toString();
        String pass = regPass.getText().toString();
        String email = regEmail.getText().toString();
        if ((name.isEmpty()) || (pass.isEmpty())) {
            displayToast("Not full user info");
        } else {
            db.addUser(email, name, pass);
            displayToast("User registered");
            finish();
        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.register:
                register();
                break;
            case R.id.backtolog:
                startActivity(new Intent(RegistrationActivity.this,CameraCompass.class));
                finish();
                break;
            default:
    }
}
}
