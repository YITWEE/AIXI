package com.yitwee.www.aixi;

/**
 * Created by cjb on 2016/11/1.
 */

public class Merchant_user_going_Order {
    public String order_style,order_content,order_remark,order_phonenumber,order_price,order_tip;
    public Merchant_user_going_Order(String style, String content, String remark, String phonenumber,String price,String tip )
    {
        order_style=style;
        order_content=content;
        order_remark=remark;
        order_phonenumber=phonenumber;
        order_price=price;
        order_tip=tip;
    }
}
