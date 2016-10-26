package com.yitwee.www.aixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_password_phonenumber;
    private EditText et_password_verifycode;
    private EditText et_password_password;
    private EditText et_password_surepassword;
    private Button bt_password_return;
    private Button bt_password_getcode;
    private Button bt_password_commit;
    private Button bt_password_nocode;
    private String phonenumber,verifycode,password,surepassword;  //该界面的四个变量
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        et_password_phonenumber= (EditText) findViewById(R.id.et_password_phonenumber);
        et_password_verifycode= (EditText) findViewById(R.id.et_password_verifycode);
        et_password_password= (EditText) findViewById(R.id.et_password_password);
        et_password_surepassword= (EditText) findViewById(R.id.et_password_surepassword);
        bt_password_return= (Button) findViewById(R.id.bt_password_return);
        bt_password_getcode= (Button) findViewById(R.id.bt_password_getcode);
        bt_password_commit= (Button) findViewById(R.id.bt_password_commit);
        bt_password_nocode= (Button) findViewById(R.id.bt_password_nocode);
        bt_password_return.setOnClickListener(this);
        bt_password_getcode.setOnClickListener(this);
        bt_password_commit.setOnClickListener(this);
        bt_password_nocode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_password_return:
            {
                startActivity(new Intent(PasswordActivity.this,LoginActivity.class));
            }
            break;

            case R.id.bt_password_getcode:
            {
                Toast.makeText(PasswordActivity.this,"我是验证码",Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.bt_password_commit:
            {
                Toast.makeText(PasswordActivity.this,"我正在提交。。。",Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.bt_password_nocode:
            {
                Toast.makeText(PasswordActivity.this,"我没有得到验证码",Toast.LENGTH_SHORT).show();
            }
            break;

            default:
            break;
        }

    }
}
