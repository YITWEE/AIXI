package com.yitwee.www.aixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_password_phonenumber;
    private EditText et_password_verifycode;
    private EditText et_password_password;
    private EditText et_password_surepassword;
    private Button bt_password_return;
    private Button bt_password_getcode;
    private Button bt_password_commit;
    private Button bt_password_nocode;
    private String phonenumber,verifycode,newpassword,surepassword;  //该界面的四个变量
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
                phonenumber=et_password_phonenumber.getText().toString();
                BmobSMS.requestSMSCode(phonenumber, " reg_aixi", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer smsId, BmobException ex) {
                        if (ex == null) {
                            //验证码发送成功
                            Toast.makeText(PasswordActivity.this,"短信id：" + smsId,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            break;

            case R.id.bt_password_commit:
            {
                verifycode=et_password_verifycode.getText().toString();
                newpassword=et_password_password.getText().toString();
                BmobUser.resetPasswordBySMSCode(verifycode,newpassword, new UpdateListener() {
                    @Override
                    public void done(BmobException ex) {
                        if(ex==null){
                            Toast.makeText(PasswordActivity.this,"密码重置成功",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(PasswordActivity.this,LoginActivity.class));
//                            Log.i("smile", "密码重置成功");
                        }else{
                            Toast.makeText(PasswordActivity.this,"密码重置失败",Toast.LENGTH_SHORT).show();
//                            Log.i("smile", "重置失败：code ="+ex.getErrorCode()+",msg = "+ex.getLocalizedMessage());
                        }
                    }
                });
            }
            break;

            case R.id.bt_password_nocode:
            {
                Toast.makeText(PasswordActivity.this,"Try again!",Toast.LENGTH_SHORT).show();
            }
            break;

            default:
            break;
        }

    }
}
