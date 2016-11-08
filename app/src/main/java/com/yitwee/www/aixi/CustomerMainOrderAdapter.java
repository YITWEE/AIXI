package com.yitwee.www.aixi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cjb on 2016/11/1.
 */

public class CustomerMainOrderAdapter extends BaseAdapter {
    private List<Customer_Main_Order> Customer_Main_order_list;
    private Context context;
    private LayoutInflater inflater;

    public CustomerMainOrderAdapter(List<Customer_Main_Order> Customer_Main_order_list, Context context ){
        this.Customer_Main_order_list=Customer_Main_order_list;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return Customer_Main_order_list.size();
    }

    @Override
    public Object getItem(int position) {
        return Customer_Main_order_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        CustomerMainOrderAdapter.viewholder holder;
        if(convertView==null)
        {
            holder=new CustomerMainOrderAdapter.viewholder();
            convertView=inflater.inflate(R.layout.customer_main_order_layout,null);
            holder.textView_comment= (TextView) convertView.findViewById(R.id.tv_customer_main_order_comment);
            holder.textView_phonenumber= (TextView) convertView.findViewById(R.id.tv_customer_main_order_phonenumber);
            holder.textView_rate= (TextView) convertView.findViewById(R.id.tv_customer_main_order_rate);
            holder.textView_message= (TextView) convertView.findViewById(R.id.tv_customer_main_order_message);
            holder.textView_price= (TextView) convertView.findViewById(R.id.tv_customer_main_order_price);
            holder.textView_time_finish= (TextView) convertView.findViewById(R.id.tv_customer_main_order_time_finish);
            holder.textView_time_back= (TextView) convertView.findViewById(R.id.tv_customer_main_order_time_back);
            holder.textView_time_receive= (TextView) convertView.findViewById(R.id.tv_customer_main_order_time_receive);
            holder.textView_time_commit= (TextView) convertView.findViewById(R.id.tv_customer_main_order_time_commit);
            holder.linearLayout_detail= (LinearLayout) convertView.findViewById(R.id.ll_customer_main_order_detail);
            convertView.setTag(holder);
        }
        else
        {
            holder= (CustomerMainOrderAdapter.viewholder) convertView.getTag();
        }
        holder.textView_comment.setText(Customer_Main_order_list.get(position).comment);
        holder.textView_phonenumber.setText(Customer_Main_order_list.get(position).phonenumber);
        holder.textView_rate.setText(Customer_Main_order_list.get(position).rate);
        holder.textView_price.setText(Customer_Main_order_list.get(position).price);
        holder.textView_message.setText(Customer_Main_order_list.get(position).message);
        holder.textView_time_finish.setText(Customer_Main_order_list.get(position).time_finish);
        holder.textView_time_back.setText(Customer_Main_order_list.get(position).time_back);
        holder.textView_time_receive.setText(Customer_Main_order_list.get(position).time_receive);
        holder.textView_time_commit.setText(Customer_Main_order_list.get(position).time_commit);
        holder.linearLayout_detail.setVisibility(View.GONE);
        return convertView;
    }
    public class viewholder{
        public TextView textView_comment;
        private TextView textView_phonenumber;
        private TextView textView_rate;
        private TextView textView_price;
        private TextView textView_message;
        private TextView textView_time_finish;
        private TextView textView_time_back;
        private TextView textView_time_receive;
        private TextView textView_time_commit;
        private LinearLayout linearLayout_detail;
    }
}
