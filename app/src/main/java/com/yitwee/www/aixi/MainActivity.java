package com.yitwee.www.aixi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
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
    }


    @Override
    public void onClick(View v) {
        mMenu.toggle();
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
