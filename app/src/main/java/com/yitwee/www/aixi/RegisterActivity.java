package com.yitwee.www.aixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.button1;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_phonenumber;
    private TextView tv_verifycode;
    private Button bt_return;
    private Button bt_getcode;
    private Button bt_next;
    private Button bt_nocode;
    private String phonenumber;
    private String verifycode;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tv_phonenumber= (TextView) findViewById(R.id.et_register_phonenumber);
        tv_verifycode= (TextView) findViewById(R.id.et_register_verifycode);
        bt_return= (Button) findViewById(R.id.bt_register_return);
        bt_getcode= (Button) findViewById(R.id.bt_register_getcode);
        bt_next= (Button) findViewById(R.id.bt_register_next);
        bt_nocode= (Button) findViewById(R.id.bt_register_nocode);
        bt_return.setOnClickListener(this);
        bt_getcode.setOnClickListener(this);
        bt_next.setOnClickListener(this);
        bt_nocode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_register_return:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
            case R.id.bt_register_getcode:
                Toast.makeText(RegisterActivity.this,"验证个毛呀 验证",Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_register_next:
                phonenumber=tv_phonenumber.getText().toString().trim();
                verifycode=tv_verifycode.getText().toString().trim();
                if(phonenumber.isEmpty()|verifycode.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"请输入手机号和验证码",Toast.LENGTH_LONG).show();
                    break;
                }
                Toast.makeText(RegisterActivity.this,"就没有然后啦。。。呆瓜",Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_register_nocode:
                Toast.makeText(RegisterActivity.this,"收不到？？？怪我咯。",Toast.LENGTH_LONG).show();
                break;
            default:break;

        }

    }
}
