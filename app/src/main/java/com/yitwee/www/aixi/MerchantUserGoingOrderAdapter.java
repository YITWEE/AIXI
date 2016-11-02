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

public class MerchantUserGoingOrderAdapter extends BaseAdapter {
    private List<Merchant_user_going_Order> going_order_list;
    private Context context;
    private LayoutInflater inflater;

    public MerchantUserGoingOrderAdapter(List<Merchant_user_going_Order> going_order_list, Context context ){
        this.going_order_list=going_order_list;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return going_order_list.size();
    }

    @Override
    public Object getItem(int position) {
        return going_order_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        MerchantUserGoingOrderAdapter.viewholder holder;
        if(convertView==null)
        {
            holder=new MerchantUserGoingOrderAdapter.viewholder();
            convertView=inflater.inflate(R.layout.merchant_order_going_layout,null);
            holder.textView_style= (TextView) convertView.findViewById(R.id.tv_merchant_order_going_style);
            holder.textView_content= (TextView) convertView.findViewById(R.id.tv_merchant_order_going_content);
            holder.textView_remark= (TextView) convertView.findViewById(R.id.tv_merchant_order_going_remark);
            holder.textView_phonenumber= (TextView) convertView.findViewById(R.id.tv_merchant_order_going_phonenumber);
            holder.textView_price=(TextView) convertView.findViewById(R.id.tv_merchant_order_going_price);
            holder.textView_tip= (TextView) convertView.findViewById(R.id.tv_merchant_order_going_tip);
            convertView.setTag(holder);
        }
        else
        {
            holder= (MerchantUserGoingOrderAdapter.viewholder) convertView.getTag();
        }
        holder.textView_style.setText(going_order_list.get(position).order_style);
        holder.textView_content.setText(going_order_list.get(position).order_content);
        holder.textView_remark.setText(going_order_list.get(position).order_remark);
        holder.textView_phonenumber.setText(going_order_list.get(position).order_phonenumber);
        holder.textView_price.setText(going_order_list.get(position).order_price);
        holder.textView_tip.setText(going_order_list.get(position).order_tip);
        return convertView;
    }
    public class viewholder{
        public TextView textView_style;
        private TextView textView_content;
        private TextView textView_remark;
        private TextView textView_phonenumber;
        private TextView textView_price;
        private TextView textView_tip;
    }
}
