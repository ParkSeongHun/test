package com.example.psh.donga_app2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    final static String reg_url = "http://45.77.26.124/index.php/User/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        final EditText newIdInput = (EditText) findViewById(R.id.newIdInput);
        final EditText newPasswordInput = (EditText) findViewById(R.id.newPasswordInput);
        Button newUserButton = (Button) findViewById(R.id.newUserButton);
        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit client = new Retrofit.Builder().baseUrl(reg_url)
                        .addConverterFactory(GsonConverterFactory.create(gson)).build();
                String id = newIdInput.getText().toString();
                String pw = newPasswordInput.getText().toString();
                Interface_user reg = client.create(Interface_user.class);
                Call<User_VO> call = reg.SignUp(id,pw);
                call.enqueue(new Callback<User_VO>() {
                    @Override
                    public void onResponse(Call<User_VO> call, Response<User_VO> response) {
                        Log.i("성공했나요?","yes");
                       // 이메일 입력 확인
                      if( newIdInput.getText().toString().length() == 0 ) {
                         Toast.makeText(RegisterActivity.this, "Email을 입력하세요!", Toast.LENGTH_SHORT).show();
                         newIdInput.requestFocus();
                         return;
                        }
                     // 비밀번호 입력 확인
                     if( newPasswordInput.getText().toString().length() == 0 ) {
                         Toast.makeText(RegisterActivity.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                         newPasswordInput.requestFocus();
                       return;
                        }
                    }
                    @Override
                    public void onFailure(Call<User_VO> call, Throwable t) {
                        Log.i("성공했나요?","no");
                    }
                });
            }
        });
    }
}