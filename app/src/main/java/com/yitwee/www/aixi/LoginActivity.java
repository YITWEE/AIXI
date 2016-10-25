package com.yitwee.www.aixi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_number;
    private EditText et_password;
    private Button bt_forgetword;
    private Button bt_login;
    private Button bt_newuser;
    private SharedPreferences.Editor editor;
    private String number;
    private String password;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_number= (EditText) findViewById(R.id.et_login_phonenumber);
        et_password= (EditText) findViewById(R.id.et_login_password);
        bt_forgetword= (Button) findViewById(R.id.bt_login_forgetpassword);
        bt_login= (Button) findViewById(R.id.bt_login_login);
        bt_newuser= (Button) findViewById(R.id.bt_login_newuser);
        sharedPreferences=getSharedPreferences("myPref", MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("cjb","123456");
        editor.putString("zt","123456");
        editor.putString("wdh","123456");
        editor.commit();
        bt_forgetword.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        bt_newuser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String numbertemp;
        String passwordtemp;
        switch (v.getId()){
            case R.id.bt_login_forgetpassword:
                Toast.makeText(LoginActivity.this,"对不起！！！ 现在无法解决",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_login_login:
                number=et_number.getText().toString().trim();
                password=et_password.getText().toString().trim();
                if(number.isEmpty()|password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"请输入你的账号和密码",Toast.LENGTH_SHORT).show();
                    break;
                }
                numbertemp=sharedPreferences.getString(number," ");
                if(numbertemp==" ")
                {
                    Toast.makeText(LoginActivity.this, "该账号还未注册，请注册", Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    if(numbertemp.equals(password))
                    {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        Toast.makeText(LoginActivity.this, "欢迎加入！！！", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(LoginActivity.this, "密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_login_newuser:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:break;
        }
    }
}
