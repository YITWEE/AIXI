package com.yitwee.www.aixi;

/**
 * Created by cjb on 2016/11/1.
 */

public class Merchant_Customer_Order {
    public String order_style,order_time,order_content,order_remark,order_price;
    public Merchant_Customer_Order(String style,String time,String content,String remark,String price)
    {
        order_style=style;
        order_time=time;
        order_content=content;
        order_remark=remark;
        order_price=price;
    }
}
