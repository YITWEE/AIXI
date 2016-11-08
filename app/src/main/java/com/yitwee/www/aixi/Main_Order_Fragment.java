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

public class Main_Order_Fragment extends Fragment implements AdapterView.OnItemClickListener{
    private Context context;
    private ListView order_listview;
    private List<Customer_Main_Order> ordersdatalist;
    private CustomerMainOrderAdapter customerMainOrderAdapter;
    public Main_Order_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_order,container,false);
        order_listview = (ListView) view.findViewById(R.id.lv_main_order_list);
        ordersdatalist = new ArrayList<>();
        initorderlist();
        customerMainOrderAdapter = new CustomerMainOrderAdapter(ordersdatalist, context);
        order_listview.setAdapter(customerMainOrderAdapter);
        order_listview.setOnItemClickListener(this);
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }
    private void initorderlist() {
        String comment,phonenumber,rate,message,price,time_finish,time_back,time_receive,time_commit;
        comment = "水洗x1+洗衣液x1";
        phonenumber = "15xxxxxxxxx";
        rate = "好评率  100%";
        message = "暂无来自商家的消息";
        price = "5.5";
        time_finish="11:55am";
        time_back="11:55am";
        time_receive="11:55am";
        time_commit="11:55am";
        Customer_Main_Order order = new Customer_Main_Order(comment, phonenumber, rate, message, price, time_finish, time_back, time_receive,time_commit);
        ordersdatalist.add(order);
        ordersdatalist.add(order);
        ordersdatalist.add(order);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (view.findViewById(R.id.ll_customer_main_order_detail).getVisibility()==view.GONE)
            view.findViewById(R.id.ll_customer_main_order_detail).setVisibility(View.VISIBLE);
        else
            view.findViewById(R.id.ll_customer_main_order_detail).setVisibility(View.GONE);
        view.findViewById(R.id.tv_customer_main_order_time_finish).setBackgroundResource(R.drawable.customer_main_order_time_p);
        view.findViewById(R.id.tv_customer_main_order_appraise).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"我要评价",Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(context,"这是第"+(1+position)+"条订单",Toast.LENGTH_SHORT).show();
    }
}
