package com.yitwee.www.aixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout ll_info_name,ll_info_sex,ll_info_birthday,ll_info_school,ll_info_living,ll_info_sign;
    private Button bt_info_sure,bt_info_name,bt_info_personbg;
    private ImageButton ib_info_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ll_info_name= (LinearLayout) findViewById(R.id.ll_info_name);
        ll_info_sex= (LinearLayout) findViewById(R.id.ll_info_sex);
        ll_info_birthday= (LinearLayout) findViewById(R.id.ll_info_birthday);
        ll_info_school= (LinearLayout) findViewById(R.id.ll_info_school);
        ll_info_living= (LinearLayout) findViewById(R.id.ll_info_living);
        ll_info_sign= (LinearLayout) findViewById(R.id.ll_info_sign);
        ib_info_back= (ImageButton) findViewById(R.id.ib_info_back);
        bt_info_sure= (Button) findViewById(R.id.bt_info_sure);
        bt_info_name= (Button) findViewById(R.id.bt_info_head);
        bt_info_personbg= (Button) findViewById(R.id.bt_info_personbg);
        ll_info_name.setOnClickListener(this);
        ll_info_sex.setOnClickListener(this);
        ll_info_birthday.setOnClickListener(this);
        ll_info_school.setOnClickListener(this);
        ll_info_living.setOnClickListener(this);
        ll_info_sign.setOnClickListener(this);
        ib_info_back.setOnClickListener(this);
        bt_info_sure.setOnClickListener(this);
        bt_info_name.setOnClickListener(this);
        bt_info_personbg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_info_back:

                //修改个人信息
                BmobUser newUser = new BmobUser();
                //newUser.setEmail("xxx@163.com");
                BmobUser bmobUser = BmobUser.getCurrentUser();
                newUser.update(bmobUser.getObjectId(),new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(InfoActivity.this,"编辑成功！",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(InfoActivity.this,"更新失败！",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //finish();
                startActivity(new Intent(InfoActivity.this,PersonalActivity.class));
                break;
            case R.id.bt_info_sure:
                //finish();
                startActivity(new Intent(InfoActivity.this,PersonalActivity.class));
                break;
            default:break;
        }
    }
}
