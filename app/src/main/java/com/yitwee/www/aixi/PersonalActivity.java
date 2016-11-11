package com.yitwee.www.aixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PersonalActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton ib_personal_back,ib_personal_edit,ib_personal_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        ib_personal_back= (ImageButton) findViewById(R.id.ib_personal_back);
        ib_personal_edit= (ImageButton) findViewById(R.id.ib_personal_edit);
        ib_personal_head= (ImageButton) findViewById(R.id.ib_personal_head);
        ib_personal_back.setOnClickListener(this);
        ib_personal_edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_personal_back:
                startActivity(new Intent(PersonalActivity.this,MainActivity.class));
                break;
            case R.id.ib_personal_edit:
                startActivity(new Intent(PersonalActivity.this,InfoActivity.class));
                break;
        }
    }
}
