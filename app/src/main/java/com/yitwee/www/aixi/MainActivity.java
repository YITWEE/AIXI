package com.yitwee.www.aixi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt_main_exit,bt_main_setting;
    private ImageButton ib_menu_main_userlogo;

    private int[] Img_submenu={R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user
            ,R.drawable.user,R.drawable.user};
    private String[] tv_submenu={"i洗衣","i打印","i叫水","i交换","i推送","i校园","i出行"};
    private MySlidingMenu mMenu ;
    private Button bt_text;
    private List<MyMenuAdapteruni> mMenulist;
    private ListView lv_menu;
    private MyMenuAdapter myMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenu = (MySlidingMenu) findViewById(R.id.MyMenu_main_scov);
        bt_text= (Button) findViewById(R.id.bt_text);
        lv_menu= (ListView) findViewById(R.id.lv_mainmenu);
        bt_text.setOnClickListener(this);
        mMenulist=getMenulist();
        myMenuAdapter=new MyMenuAdapter(mMenulist,MainActivity.this);
        lv_menu.setAdapter(myMenuAdapter);

        bt_main_exit= (Button) findViewById(R.id.bt_mainmenu_exit);
        bt_main_setting= (Button) findViewById(R.id.bt_mainmenu_setting);
        ib_menu_main_userlogo= (ImageButton) findViewById(R.id.ib_menu_main_userlogo);

        bt_main_exit.setOnClickListener(this);
        bt_main_setting.setOnClickListener(this);
        ib_menu_main_userlogo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_mainmenu_exit:
                BmobUser.logOut();
                Toast.makeText(MainActivity.this,"当前用户已退出！",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.bt_text:
                mMenu.toggle();
                break;
            case R.id.ib_menu_main_userlogo:
                startActivity(new Intent(MainActivity.this,PersonalActivity.class));
                break;
            default:break;
        }

    }

    public List<MyMenuAdapteruni> getMenulist() {

        List<MyMenuAdapteruni> menulist=new ArrayList<>();
        for (int i=0;i<tv_submenu.length;i++)
        {
            menulist.add(new MyMenuAdapteruni(Img_submenu[i],tv_submenu[i]));
        }
        return menulist;
    }

}

