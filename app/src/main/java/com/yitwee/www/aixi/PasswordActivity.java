package com.yitwee.www.aixi;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    private ImageButton ib_password_return;
    private Button bt_password_getcode;
    private Button bt_password_commit;
    private Button bt_password_nocode;
    private String phonenumber,verifycode,newpassword,surepassword;  //该界面的四个变量
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        et_password_phonenumber= (EditText) findViewById(R.id.et_password_phonenumber);
        et_password_verifycode= (EditText) findViewById(R.id.et_password_verifycode);
        et_password_password= (EditText) findViewById(R.id.et_password_password);
        et_password_surepassword= (EditText) findViewById(R.id.et_password_surepassword);
        ib_password_return= (ImageButton) findViewById(R.id.ib_password_return);
        bt_password_getcode= (Button) findViewById(R.id.bt_password_getcode);
        bt_password_commit= (Button) findViewById(R.id.bt_password_commit);
        bt_password_nocode= (Button) findViewById(R.id.bt_password_nocode);
        ib_password_return.setOnClickListener(this);
        bt_password_getcode.setOnClickListener(this);
        bt_password_commit.setOnClickListener(this);
        bt_password_nocode.setOnClickListener(this);

        Drawable drawable_phone = getDrawable(R.drawable.mobile_24);
        drawable_phone.setBounds(0,0,48,48);
        et_password_phonenumber.setCompoundDrawables(drawable_phone, null, null, null);//只放左边

        Drawable drawable_password = getDrawable(R.mipmap.login_icon_password);
        drawable_password.setBounds(0,0,48,48);
        et_password_password.setCompoundDrawables(drawable_password, null, null, null);//只放左边
        et_password_surepassword.setCompoundDrawables(drawable_password, null, null, null);//只放左边

        Drawable drawable_key = getDrawable(R.drawable.key_24);
        drawable_key.setBounds(0,0,48,48);
        et_password_verifycode.setCompoundDrawables(drawable_key, null, null, null);//只放左边
    }

    @Override
    public void onClick(View v) {
        verifycode=et_password_verifycode.getText().toString();
        newpassword=et_password_password.getText().toString();
        phonenumber=et_password_phonenumber.getText().toString();
        switch (v.getId())
        {
            case R.id.ib_password_return:
            {
                Intent data=new Intent();
                data.addFlags(0);
                setResult(0,data);
                finish();
                //startActivity(new Intent(PasswordActivity.this,LoginActivity.class));
            }
            break;

            case R.id.bt_password_getcode:
            {
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

                BmobUser.resetPasswordBySMSCode(verifycode,newpassword, new UpdateListener() {
                    @Override
                    public void done(BmobException ex) {
                        if(ex==null){
                            Toast.makeText(PasswordActivity.this,"密码重置成功",Toast.LENGTH_SHORT).show();
                            Intent data=new Intent();
                            data.putExtra("name",phonenumber);
                            setResult(1,data);
                            finish();
                            //startActivity(new Intent(PasswordActivity.this,LoginActivity.class));
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
