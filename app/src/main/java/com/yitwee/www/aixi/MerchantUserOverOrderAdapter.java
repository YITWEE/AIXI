package com.yitwee.www.aixi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cjb on 2016/11/1.
 */

public class MerchantUserOverOrderAdapter extends BaseAdapter {
    private List<Merchant_user_over_Order> over_order_list;
    private Context context;
    private LayoutInflater inflater;

    public MerchantUserOverOrderAdapter(List<Merchant_user_over_Order> over_order_list, Context context ){
        this.over_order_list=over_order_list;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return over_order_list.size();
    }

    @Override
    public Object getItem(int position) {
        return over_order_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        MerchantUserOverOrderAdapter.viewholder holder;
        if(convertView==null)
        {
            holder=new MerchantUserOverOrderAdapter.viewholder();
            convertView=inflater.inflate(R.layout.merchant_order_over_layout,null);
            holder.textView_content= (TextView) convertView.findViewById(R.id.tv_merchant_order_over_content);
            holder.textView_price=(TextView) convertView.findViewById(R.id.tv_merchant_order_over_price);
            holder.textView_time= (TextView) convertView.findViewById(R.id.tv_merchant_order_over_time);
            convertView.setTag(holder);
        }
        else
        {
            holder= (MerchantUserOverOrderAdapter.viewholder) convertView.getTag();
        }
        holder.textView_content.setText(over_order_list.get(position).order_content);
        holder.textView_price.setText(over_order_list.get(position).order_price);
        holder.textView_time.setText(over_order_list.get(position).order_time);
        return convertView;
    }
    public class viewholder{
        private TextView textView_content;
        private TextView textView_price;
        private TextView textView_time;
    }
}
