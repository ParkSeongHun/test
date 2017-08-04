package com.example.psh.donga_app2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by psh on 17. 7. 27.
 */

public class LoginActivity extends Activity {
    final static String url = "http://45.77.26.124/index.php/User/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText idInput = (EditText)findViewById(R.id.idInput);
        EditText passInput = (EditText)findViewById(R.id.passwordInput);
        Button loginButton = (Button)findViewById(R.id.loginButton);
        Button signUpButton = (Button)findViewById(R.id.signUpButton);
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(mainIntent);

            }
        });
    }
}