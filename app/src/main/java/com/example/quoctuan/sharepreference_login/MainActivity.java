package com.example.quoctuan.sharepreference_login;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editName,editPass;
    Button btnLogin,btnExit;
    CheckBox chkCheck;

    String ten = "login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences preferences = getSharedPreferences(ten,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("UserName",editName.getText().toString());
        editor.putString("PassWord",editPass.getText().toString());
        editor.putBoolean("Check",chkCheck.isChecked());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences(ten,MODE_PRIVATE);
        String userName = preferences.getString("UserName","");
        String passWord = preferences.getString("PassWord","");
        boolean check = preferences.getBoolean("Check",false);

        if (check){
            editName.setText(userName);
            editPass.setText(passWord);
        }
    }

    private void addControls() {
        editName = (EditText) findViewById(R.id.editName);
        editPass = (EditText) findViewById(R.id.editPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnExit = (Button) findViewById(R.id.btnExit);
        chkCheck = (CheckBox) findViewById(R.id.chkCheck);
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void handleLogin() {
        Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_LONG).show();
    }
}
