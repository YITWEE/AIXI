package com.yitwee.www.aixi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cjb on 2016/10/19.
 */

public class MyMenuAdapter extends BaseAdapter {
    private List<MyMenuAdapteruni> mlist;
    private Context context;
    private LayoutInflater inflater;

    public MyMenuAdapter(List<MyMenuAdapteruni> mlist, Context context){
        this.mlist=mlist;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        viewholder holder;
        if(convertView==null)
        {
            holder=new viewholder();
            convertView=inflater.inflate(R.layout.my_submenu,null);
            holder.imageView= (ImageView) convertView.findViewById(R.id.iv_mysubmenu1);
            holder.textView= (TextView) convertView.findViewById(R.id.tv_mysubmenu1);
            convertView.setTag(holder);
        }
        else
        {
            holder= (viewholder) convertView.getTag();
        }

        holder.imageView.setImageResource(mlist.get(position).imageViewid);
        holder.textView.setText(mlist.get(position).textView);
        //holder.imageView.setImageResource(R.drawable.user);
     //   holder.textView.setText(R.string.app_name);
        return convertView;
    }
    public class viewholder{
        public ImageView imageView;
        public TextView textView;
    }
}
