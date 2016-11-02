package com.yitwee.www.aixi;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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
                        Toast.makeText(getContext(),"订单发布成功",Toast.LENGTH_SHORT).show();
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
