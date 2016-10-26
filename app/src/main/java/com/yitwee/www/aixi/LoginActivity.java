package com.yitwee.www.aixi;

import android.content.Intent;
//import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_number;
    private EditText et_password;
    private Button bt_forgetword;
    private Button bt_login;
    private Button bt_newuser;
//    private SharedPreferences.Editor editor;
    private String number;
    private String password;
//    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bmob.initialize(this, "a3ee653345dbc5cd52f8e1c628845955");

        et_number= (EditText) findViewById(R.id.et_login_phonenumber);
        et_password= (EditText) findViewById(R.id.et_login_password);
        bt_forgetword= (Button) findViewById(R.id.bt_login_forgetpassword);
        bt_login= (Button) findViewById(R.id.bt_login_login);
        bt_newuser= (Button) findViewById(R.id.bt_login_newuser);
//        sharedPreferences=getSharedPreferences("myPref", MODE_PRIVATE);
//        editor=sharedPreferences.edit();
//        editor.putString("cjb","123456");
//        editor.putString("zt","123456");
//        editor.putString("wdh","123456");
//        editor.commit();
        bt_forgetword.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        bt_newuser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_login_forgetpassword:
                startActivity(new Intent(LoginActivity.this,PasswordActivity.class));
                break;
            case R.id.bt_login_login:
                number=et_number.getText().toString().trim();
                password=et_password.getText().toString().trim();
                if(number.isEmpty()|| password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"账号或密码不能为空！",Toast.LENGTH_SHORT).show();
                    break;
                }else{
                    //登陆
                    BmobUser.loginByAccount(number, password, new LogInListener<MyUser>() {
                        @Override
                        public void done(MyUser user, BmobException e){
                            if(user!=null){
                                Toast.makeText(LoginActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            }else{
                                Toast.makeText(LoginActivity.this,"登陆失败！请检查用户名和密码",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
            case R.id.bt_login_newuser:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:break;
        }
    }
}