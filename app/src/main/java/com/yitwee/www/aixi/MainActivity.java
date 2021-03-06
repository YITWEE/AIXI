package com.yitwee.www.aixi;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private static boolean isExit = false;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    private MyMainViewPager main_content_mViewPaper;
    private FragmentPagerAdapter main_content_mAapter;
    private List<Fragment> main_content_mDatas;
    private List<String> off_online_statedata;

    private Button bt_main_exit,bt_main_setting;
    private ImageButton ib_menu_main_userlogo;
    private Spinner sp_main_head_online;
    private ArrayAdapter<String> sp_main_head_online_arr_adapter;

    private ImageView iv_main_bottom_home,iv_main_bottom_order,iv_main_bottom_user;
    private TextView tv_main_head_bar_title,tv_main_head_bar_switcher;

    private View vi_main_bottom_home,vi_main_bottom_order,vi_main_bottom_user;

    private int[] Img_submenu={R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user
            ,R.drawable.user,R.drawable.user};
    private String[] tv_submenu={"i洗衣","i打印","i叫水","i交换","i推送","i校园","i出行"};
    private MySlidingMenu mMenu ;
    private LinearLayout ll_main_menu;
    private ImageButton ib_main_menu;
    private List<MyMenuAdapteruni> mMenulist;
    private ListView lv_menu;
    private MyMenuAdapter myMenuAdapter;

    private Space sp_main_menu_right_free;

    private int currentpapernumber,peoplerole=0;
    //0代表顾客 1代表商家  默认为0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenu = (MySlidingMenu) findViewById(R.id.MyMenu_main);
        ll_main_menu= (LinearLayout) findViewById(R.id.ll_main_menu);
        ll_main_menu.setVisibility(View.GONE);

        sp_main_menu_right_free= (Space) findViewById(R.id.sp_main_menu_right_free);
        ib_main_menu= (ImageButton) findViewById(R.id.ib_main_menu);
        lv_menu= (ListView) findViewById(R.id.lv_mainmenu);
        ib_main_menu.setOnClickListener(this);
        sp_main_menu_right_free.setOnClickListener(this);
        mMenulist=getMenulist();
        myMenuAdapter=new MyMenuAdapter(mMenulist,MainActivity.this);
        lv_menu.setAdapter(myMenuAdapter);

        bt_main_exit= (Button) findViewById(R.id.bt_mainmenu_exit);
        bt_main_setting= (Button) findViewById(R.id.bt_mainmenu_setting);
        ib_menu_main_userlogo= (ImageButton) findViewById(R.id.ib_mainmenu_userlogo);
        sp_main_head_online= (Spinner) findViewById(R.id.sp_main_head_online);

        iv_main_bottom_home= (ImageView) findViewById(R.id.iv_main_bottom_home);
        iv_main_bottom_order= (ImageView) findViewById(R.id.iv_main_bottom_order);
        iv_main_bottom_user= (ImageView) findViewById(R.id.iv_main_bottom_user);
        vi_main_bottom_home=findViewById(R.id.vi_main_bottom_home);
        vi_main_bottom_order=findViewById(R.id.vi_main_bottom_order);
        vi_main_bottom_user=findViewById(R.id.vi_main_bottom_user);

        tv_main_head_bar_title= (TextView) findViewById(R.id.tv_main_head_bar_title);
        tv_main_head_bar_switcher= (TextView) findViewById(R.id.tv_main_head_bar_switcher);

       // mMenu.setVisibility(View.GONE);
        initView();
        off_online_statedata=new ArrayList<String>();
        off_online_statedata.add("在线");off_online_statedata.add("离线");
        sp_main_head_online_arr_adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, off_online_statedata);
        sp_main_head_online_arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_main_head_online.setAdapter(sp_main_head_online_arr_adapter);

        bt_main_exit.setOnClickListener(this);
        bt_main_setting.setOnClickListener(this);
        ib_menu_main_userlogo.setOnClickListener(this);
        iv_main_bottom_home.setOnClickListener(this);
        iv_main_bottom_order.setOnClickListener(this);
        iv_main_bottom_user.setOnClickListener(this);
        tv_main_head_bar_switcher.setOnClickListener(this);
    }

    private void initView() {
        main_content_mViewPaper= (MyMainViewPager) findViewById(R.id.vp_main_paper);
        main_content_mViewPaper.setMenu(mMenu,mMenu.menu);
        main_content_mDatas=new ArrayList<Fragment>();
        Main_Home_Fragment home=new Main_Home_Fragment();
        Main_Order_Fragment order=new Main_Order_Fragment();
        Main_User_Fragment user=new Main_User_Fragment();

        Merchant_Main_Home_Fragment merchant_home=new Merchant_Main_Home_Fragment();
        Merchant_Main_Order_Fragment merchant_order=new Merchant_Main_Order_Fragment();
        Merchant_Main_User_Fragment merchant_user=new Merchant_Main_User_Fragment();

        main_content_mDatas.add(home);main_content_mDatas.add(order);main_content_mDatas.add(user);
        main_content_mDatas.add(merchant_home);main_content_mDatas.add(merchant_order);main_content_mDatas.add(merchant_user);

        main_content_mAapter=new FragmentPagerAdapter(getSupportFragmentManager()){
            @Override
            public Fragment getItem(int position) {
                return main_content_mDatas.get(position);
            }

            @Override
            public int getCount() {
                return main_content_mDatas.size();
            }
        };
        main_content_mViewPaper.setAdapter(main_content_mAapter);
        main_content_mViewPaper.setScanScroll(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_mainmenu_exit:
                BmobUser.logOut();
                Toast.makeText(MainActivity.this,"当前用户已退出！",Toast.LENGTH_SHORT).show();
                finish();
              //  startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.ib_main_menu:
                ll_main_menu.setVisibility(View.VISIBLE);
                mMenu.toggle();
                break;
            case R.id.ib_mainmenu_userlogo:
                startActivity(new Intent(MainActivity.this,PersonalActivity.class));
                break;
            case R.id.iv_main_bottom_home:
                main_content_mViewPaper.setCurrentItem(0+peoplerole*3);
                currentpapernumber=0;
                tv_main_head_bar_title.setText("");
                vi_main_bottom_home.setVisibility(View.VISIBLE);
                vi_main_bottom_order.setVisibility(View.INVISIBLE);
                vi_main_bottom_user.setVisibility(View.INVISIBLE);
                break;
            case R.id.iv_main_bottom_order:
                main_content_mViewPaper.setCurrentItem(1+peoplerole*3);
                currentpapernumber=1;
                tv_main_head_bar_title.setText("我的订单");
                vi_main_bottom_home.setVisibility(View.INVISIBLE);
                vi_main_bottom_order.setVisibility(View.VISIBLE);
                vi_main_bottom_user.setVisibility(View.INVISIBLE);
                break;
            case R.id.iv_main_bottom_user:
                main_content_mViewPaper.setCurrentItem(2+peoplerole*3);
                currentpapernumber=2;
                tv_main_head_bar_title.setText("");
                vi_main_bottom_home.setVisibility(View.INVISIBLE);
                vi_main_bottom_order.setVisibility(View.INVISIBLE);
                vi_main_bottom_user.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_main_head_bar_switcher:
                if(peoplerole==1)peoplerole=0;
                else peoplerole=1;
                main_content_mViewPaper.setCurrentItem(currentpapernumber+peoplerole*3);
                break;
            case R.id.sp_main_menu_right_free:
                mMenu.toggle();
                mMenu.setVisibility(View.GONE);
            default:break;
        }
    }

/*    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("tag","MyMain--------onTouch");
        return super.onTouchEvent(event);
    }*/

    public List<MyMenuAdapteruni> getMenulist() {

        List<MyMenuAdapteruni> menulist=new ArrayList<>();
        for (int i=0;i<tv_submenu.length;i++)
        {
            menulist.add(new MyMenuAdapteruni(Img_submenu[i],tv_submenu[i]));
        }
        return menulist;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(mMenu.getisOpen()){
            mMenu.closeMenu();
            return false;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            MyApplication mApp= (MyApplication) getApplication();
            mApp.setExit(true);
            finish();
        }
    }

}

