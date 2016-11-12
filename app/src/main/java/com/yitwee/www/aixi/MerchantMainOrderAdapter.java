package com.yitwee.www.aixi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by cjb on 2016/11/1.
 */

public class MerchantMainOrderAdapter extends BaseAdapter {
    private List<Merchant_Customer_Order> Merchant_Customer_order_list;
    private Context context;
    private SideslipListView order_listview;
    private LayoutInflater inflater;

    public MerchantMainOrderAdapter(List<Merchant_Customer_Order> Merchant_Customer_order_list,SideslipListView order_listview,Context context ){
        this.Merchant_Customer_order_list=Merchant_Customer_order_list;
        this.context=context;
        this.order_listview=order_listview;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return Merchant_Customer_order_list.size();
    }

    @Override
    public Object getItem(int position) {
        return Merchant_Customer_order_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        MerchantMainOrderAdapter.viewholder holder;
        if(convertView==null)
        {
            holder=new MerchantMainOrderAdapter.viewholder();
            convertView=inflater.inflate(R.layout.merchant_customer_order_layout,null);
            holder.textView_style= (TextView) convertView.findViewById(R.id.merchant_customer_order_style);
            holder.textView_time= (TextView) convertView.findViewById(R.id.et_merchant_customer_order_time);
            holder.textView_content= (TextView) convertView.findViewById(R.id.tv_merchant_customer_order_content);
            holder.textView_remark= (TextView) convertView.findViewById(R.id.tv_merchant_customer_order_remark);
            holder.textView_price= (TextView) convertView.findViewById(R.id.tv_merchant_customer_order_price);
            holder.textView_receive= (TextView) convertView.findViewById(R.id.tv_merchant_customer_order_receive);
            holder.textView_delete= (TextView) convertView.findViewById(R.id.tv_merchant_customer_order_delete);
            convertView.setTag(holder);
        }
        else
        {
            holder= (MerchantMainOrderAdapter.viewholder) convertView.getTag();
        }
        final int pos = position;
        holder.textView_style.setText(Merchant_Customer_order_list.get(position).order_style);
        holder.textView_time.setText(Merchant_Customer_order_list.get(position).order_time);
        if(Merchant_Customer_order_list.get(position).order_style.equals("即时订单"))
            holder.textView_time.setVisibility(View.GONE);
        holder.textView_content.setText(Merchant_Customer_order_list.get(position).order_content);
        holder.textView_remark.setText(Merchant_Customer_order_list.get(position).order_remark);
        holder.textView_price.setText(Merchant_Customer_order_list.get(position).order_price);
        holder.textView_receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"您接受了第"+ (pos+1)+"条订单",Toast.LENGTH_SHORT).show();
                Merchant_Customer_order_list.remove(pos);
                notifyDataSetChanged();
                order_listview.turnNormal();
            }
        });
        holder.textView_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"第"+ (pos+1)+"条订单被删除了",Toast.LENGTH_SHORT).show();
                Merchant_Customer_order_list.remove(pos);
                notifyDataSetChanged();
                order_listview.turnNormal();
            }
        });
        return convertView;
    }
    public class viewholder{
        public TextView textView_style;
        private TextView textView_time;
        private TextView textView_content;
        private TextView textView_price;
        private TextView textView_remark;
        private TextView textView_delete;
        private TextView textView_receive;
    }
}
