package com.yitwee.www.aixi;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.yitwee.www.dataclass.MyUser;
import com.yitwee.www.dataclass.WashPush;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by cjb on 2016/10/29.
 */

public class Main_Home_Fragment extends Fragment implements View.OnClickListener {
    private ImageView ib_main_home_order_setup;
    private Main_Home_Order_Creater_dialog main_home_order_creater_dialog;
    public Main_Home_Fragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_main_home,container,false);
        ib_main_home_order_setup= (ImageView) view.findViewById(R.id.ib_main_home_order_setup);
        ib_main_home_order_setup.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.ib_main_home_order_setup:
                main_home_order_creater_dialog=Main_Home_Order_Creater_dialog.newInstance(1);
                main_home_order_creater_dialog.show(getFragmentManager(),"Main_Home_Order_Creater_dialog");
                main_home_order_creater_dialog.setOnButtonClickListener(new Main_Home_Order_Creater_dialog.OnDialogButtonClickListener() {

                    @Override
                    public void okButtonClick() {

                        MyUser user = BmobUser.getCurrentUser(MyUser.class);
                        WashPush my_push=new WashPush();
                        my_push.setPushUser(user);
                        my_push.save(new SaveListener<String>() {
                            @Override
                            public void done(String s, BmobException e) {
                                if(e==null){
                                    Toast.makeText(getContext(),"已成功发布订单",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getContext(),"订单发布失败",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        Toast.makeText(getContext(),"订单发布成功 水洗："+main_home_order_creater_dialog.Int_num_wash
                                +"干洗："+main_home_order_creater_dialog.Int_num_dry_wash
                                +"脱水："+main_home_order_creater_dialog.Int_num_water
                                +"烘干："+main_home_order_creater_dialog.Int_num_dry
                                +"洗衣粉："+main_home_order_creater_dialog.Int_num_detergent
                                +"洗衣液："+main_home_order_creater_dialog.Int_num_laundry_detergent
                                ,Toast.LENGTH_SHORT).show();
                        Log.i("debug", "ok button click");
                    }
                    @Override
                    public void cancelButtonClick() {
                        Toast.makeText(getContext(),"取消订单发布",Toast.LENGTH_SHORT).show();
                        Log.i("debug", "cancel button click");
                    }
                });
                break;
            default:break;
        }
    }
}
