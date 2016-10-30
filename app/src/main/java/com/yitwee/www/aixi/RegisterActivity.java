package com.yitwee.www.aixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.yitwee.www.dataclass.MyUser;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{
    private Switch st_sex;
    private EditText et_username;
    private EditText et_password;
    private EditText et_school;
    private EditText et_phonenumber;
    private EditText et_verifycode;
    private Button bt_return;
    private Button bt_getcode;
    private Button bt_next;
    private Button bt_nocode;
    private String username,password,school,phonenumber,verifycode;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        st_sex= (Switch) findViewById(R.id.st_register_sex);
        et_username= (EditText) findViewById(R.id.et_register_username);
        et_password= (EditText) findViewById(R.id.et_register_password);
        et_school= (EditText) findViewById(R.id.et_register_school);
        et_phonenumber= (EditText) findViewById(R.id.et_register_phonenumber);
        et_verifycode= (EditText) findViewById(R.id.et_register_verifycode);
        bt_return= (Button) findViewById(R.id.bt_register_return);
        bt_getcode= (Button) findViewById(R.id.bt_register_getcode);
        bt_next= (Button) findViewById(R.id.bt_register_next);
        bt_nocode= (Button) findViewById(R.id.bt_register_nocode);
        bt_return.setOnClickListener(this);
        bt_getcode.setOnClickListener(this);
        bt_next.setOnClickListener(this);
        bt_nocode.setOnClickListener(this);
        st_sex.setOnCheckedChangeListener(this);
    }
    //按钮监听处理函数
    @Override
    public void onClick(View v) {
        username=et_username.getText().toString().trim();
        password=et_password.getText().toString().trim();
        school=et_school.getText().toString().trim();
        phonenumber=et_phonenumber.getText().toString().trim();
        verifycode=et_verifycode.getText().toString().trim();

        switch (v.getId()){
            case R.id.bt_register_return:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
            case R.id.bt_register_getcode:
                BmobSMS.requestSMSCode(phonenumber, " reg_aixi", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer smsId, BmobException ex) {
                        if (ex == null) {
                            //验证码发送成功
                            Toast.makeText(RegisterActivity.this, "已发送，短信id：" + smsId,Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, "发送失败！" ,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.bt_register_next:
                if(phonenumber.isEmpty()|| verifycode.isEmpty()|| username.isEmpty()||username.isEmpty()||password.isEmpty()||school.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"输入信息有误，请检查！",Toast.LENGTH_SHORT).show();
                    break;
                }else{
                    MyUser user = new MyUser();
                    user.setSex(true);    //"sex变量"
                    user.setSchool(school);
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setMobilePhoneNumber(phonenumber);
                    user.signOrLogin(verifycode, new SaveListener<MyUser>() {
                        @Override
                        public void done(MyUser user,BmobException e) {
                            if(e==null){
                                //toast("注册或登录成功");
                                Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
//                                Log.i("smile", ""+user.getUsername()+"-"+"-"+user.getObjectId());
                            }else{
                                Toast.makeText(RegisterActivity.this,"注册失败！",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                break;
            case R.id.bt_register_nocode:
                Toast.makeText(RegisterActivity.this,"收不到？？？怪我咯。",Toast.LENGTH_SHORT).show();
                break;
            default:break;

        }

    }
    //性别选择监听处理函数
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        {
            Toast.makeText(RegisterActivity.this,"你是女生，哥哥的女生。",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(RegisterActivity.this,"你是男生，妹妹的男生。",Toast.LENGTH_SHORT).show();
        }
    }
}
