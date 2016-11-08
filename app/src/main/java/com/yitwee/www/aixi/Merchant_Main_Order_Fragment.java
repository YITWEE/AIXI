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

public class Merchant_Main_Order_Fragment extends Fragment implements AdapterView.OnItemClickListener {
    private Context context;
    private ListView order_listview;
    private List<Merchant_Customer_Order> ordersdatalist;
    private MerchantMainOrderAdapter merchantMainOrderAdapter;

    public Merchant_Main_Order_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.merchant_fragment_main_order, container, false);
        order_listview = (ListView) view.findViewById(R.id.lv_merchant_main_order_list);
        ordersdatalist = new ArrayList<>();
        initorderlist();
        merchantMainOrderAdapter = new MerchantMainOrderAdapter(ordersdatalist, context);
        order_listview.setAdapter(merchantMainOrderAdapter);
        order_listview.setOnItemClickListener(this);
        return view;
    }

    //初始化要加载的信息
    private void initorderlist() {
        String style, time, content, remark, price;
        style = "即时订单";
        time = "12:30";
        content = "A区六舍472      水洗x1+洗衣液x1";
        remark = "尽快过来取衣服哟";
        price = "5.5";
        Merchant_Customer_Order order = new Merchant_Customer_Order(style, time, content, remark, price);
        ordersdatalist.add(order);
        ordersdatalist.add(order);
        ordersdatalist.add(order);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context,"这是第"+(1+position)+"条订单",Toast.LENGTH_SHORT).show();
    }

}
