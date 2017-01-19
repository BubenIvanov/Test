package com.test.bubenivanov.mytestproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private DbHelper db;
public EditText loginName,Pass;
    private Button Sing_in,Sing_up;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Sing_in = (Button) findViewById(R.id.Sing_in);
        Sing_up = (Button) findViewById(R.id.Sing_up);

        loginName=(EditText) findViewById(R.id.user_name);
        Pass=(EditText) findViewById(R.id.pass);

        Sing_in.setOnClickListener(this);
        Sing_up.setOnClickListener(this);

        db = new DbHelper(this);
        session = new Session(this);

        if( session.loggedin())
       {startActivity(new Intent(MainActivity.this,CameraCompass.class));
           finish();}
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Sing_in:
                login();
                break;

                case  R.id.Sing_up:
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
                break;

            default:
        }
    }

    private void login(){
        String name = loginName.getText().toString();
        String pass = Pass.getText().toString();

        if(db.getUser(name,pass)){
            session.setLoggedin(true);
            startActivity(new Intent(MainActivity.this, CameraCompass.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
}
