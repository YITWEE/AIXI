package com.yitwee.www.aixi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjb on 2016/10/29.
 */

public class Merchant_Main_User_Fragment extends Fragment implements AdapterView.OnItemClickListener {
    private Context context;
    private ListView order_going_listview;
    private ListView order_over_listview;
    private List<Merchant_user_going_Order> goingordersdataList;
    private List<Merchant_user_over_Order>overordersdataList;
    private MerchantUserGoingOrderAdapter merchantUserGoingOrderAdapter;
    private MerchantUserOverOrderAdapter merchantUserOverOrderAdapter;


    public Merchant_Main_User_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.merchant_fragment_main_user,container,false);
        order_going_listview= (ListView) view.findViewById(R.id.lv_merchant_main_user_order_going);
        order_over_listview= (ListView) view.findViewById(R.id.lv_merchant_main_user_order_over);
        initorderlist();
        merchantUserGoingOrderAdapter=new MerchantUserGoingOrderAdapter(goingordersdataList,context);
        merchantUserOverOrderAdapter=new MerchantUserOverOrderAdapter(overordersdataList,context);
        order_going_listview.setAdapter(merchantUserGoingOrderAdapter);
        order_over_listview.setAdapter(merchantUserOverOrderAdapter);
        order_going_listview.setOnItemClickListener(this);
        order_over_listview.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getContext();
    }

    private void initorderlist() {
        String going_order_style,going_order_content,going_order_remark,going_order_phonenumber,going_order_price,going_order_tip;
        String over_order_content,over_order_price,over_order_time;
        goingordersdataList=new ArrayList<>();
        overordersdataList=new ArrayList<>();
        going_order_style="即时订单";
        going_order_content="A区六舍472      水洗x1+洗衣液x1";
        going_order_remark="尽快过来取衣服哟";
        going_order_phonenumber="15310571287 (张同学)";
        going_order_price="4.84";
        going_order_tip="0.60";

        over_order_content="预约订单        水洗x1+洗衣液x1";
        over_order_price="4.84";
        over_order_time="2016-10-21 09:20";
        Merchant_user_going_Order going_order=new Merchant_user_going_Order(going_order_style,going_order_content,going_order_remark,
                going_order_phonenumber,going_order_price,going_order_tip) ;
        Merchant_user_over_Order over_order=new Merchant_user_over_Order(over_order_content,over_order_price,over_order_time);

        goingordersdataList.add(going_order);goingordersdataList.add(going_order);goingordersdataList.add(going_order);
        overordersdataList.add(over_order);overordersdataList.add(over_order);overordersdataList.add(over_order);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.lv_merchant_main_user_order_going:
                Toast.makeText(context,"这是第"+(1+position)+"条going订单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.lv_merchant_main_user_order_over:
                Toast.makeText(context,"这是第"+(1+position)+"条over订单",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }
}
