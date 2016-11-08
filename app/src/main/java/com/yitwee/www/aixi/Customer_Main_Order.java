package com.yitwee.www.aixi;

/**
 * Created by cjb on 2016/11/1.
 */

public class Customer_Main_Order {
    public String comment,phonenumber,rate,message,price,time_finish,time_back,time_receive,time_commit;
    public Customer_Main_Order(String comment,String phonenumber,String rate,
                               String message,String price,String time_finish,String time_back,String time_receive,String time_commit)
    {
        this.comment=comment;
        this.phonenumber=phonenumber;
        this.rate=rate;
        this.message=message;
        this.price=price;
        this.time_finish=time_finish;
        this.time_back=time_back;
        this.time_receive=time_receive;
        this.time_commit=time_commit;
    }
}
