package com.yitwee.www.aixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt_info_sure;
    private ImageButton ib_info_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ib_info_back= (ImageButton) findViewById(R.id.ib_info_back);
        bt_info_sure= (Button) findViewById(R.id.bt_info_sure);
        ib_info_back.setOnClickListener(this);
        bt_info_sure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_info_back:
                startActivity(new Intent(InfoActivity.this,PersonalActivity.class));
                break;
            case R.id.bt_info_sure:

                startActivity(new Intent(InfoActivity.this,PersonalActivity.class));
                break;
            default:break;
        }
    }
}
