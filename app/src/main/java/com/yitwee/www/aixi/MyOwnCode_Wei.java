/*package com.yitwee.www.aixi;

import android.util.Log;
import android.widget.Toast;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Wei DH on 2016/10/24.
 */

/*public class MyOwnCode_Wei {


    public void onClick() {

        //首次使用注册登录
        //1.请求发送验证码
        BmobSMS.requestSMSCode("11位手机号码", " reg_aixi", new QueryListener<Integer>() {
            @Override
            public void done(Integer smsId, BmobException ex) {
                if (ex == null) {
                    //验证码发送成功
                    Log.i("smile", "短信id：" + smsId);//用于查询本次短信发送详情
                }
            }
        });
        //2.验证注册登陆
        MyUser user = new MyUser();
        user.setSex(true);    //"sex变量"
        user.setUsername("username变量");
        user.setPassword("password变量");
        user.setMobilePhoneNumber("phonenum变量");
        user.signOrLogin("验证码变量", new SaveListener<MyUser>() {
            @Override
            public void done(MyUser user,BmobException e) {
                if(e==null){
                    //toast("注册或登录成功");
                    Log.i("smile", ""+user.getUsername()+"-"+"-"+user.getObjectId());
                }else{
                    //toast("失败:" + e.getMessage());
                }

            }
        });
        //跳转到首页activity

        //免除登陆
        //MyUser user = BmobUser.getCurrentUser(MyUser.class);
        //使用getXxx方法给各个用户信息变量赋值
        //跳转到首页activity

        //用户登录
        BmobUser.loginByAccount("用户名/11位手机号", "用户密码", new LogInListener<MyUser>() {
            @Override
            public void done(MyUser user, BmobException e) {
                if(user!=null){
                    Log.i("smile","用户登陆成功");
                }
            }
        });
        //使用getXxx方法给各个用户信息变量赋值
        //跳转到首页activity

        //退出登录
        BmobUser.logOut();   //清除缓存用户对象
       //BmobUser currentUser = BmobUser.getCurrentUser(); // 现在的currentUser是null了
        //返回LoginActivity

        //修改个人信息
        BmobUser newUser = new BmobUser();
        newUser.setEmail("xxx@163.com");
        BmobUser bmobUser = BmobUser.getCurrentUser();
        newUser.update(bmobUser.getObjectId(),new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    //Toast("更新用户信息成功");
                }else{
                    //Toast("更新用户信息失败:" + e.getMessage());
                }
            }
        });

        //重置密码
        //1.获取验证码
        BmobSMS.requestSMSCode("11位手机号码", " reg_aixi", new QueryListener<Integer>() {
            @Override
            public void done(Integer smsId, BmobException ex) {
                if (ex == null) {
                    //验证码发送成功
                    Log.i("smile", "短信id：" + smsId);//用于查询本次短信发送详情
                }
            }
        });
        //2.重置密码
        BmobUser.resetPasswordBySMSCode("验证码","重置密码", new UpdateListener() {
            @Override
            public void done(BmobException ex) {
                if(ex==null){
                    Log.i("smile", "密码重置成功");
                }else{
                    Log.i("smile", "重置失败：code ="+ex.getErrorCode()+",msg = "+ex.getLocalizedMessage());
                }
            }
        });
        //返回LoginActivity


        //获取订单
        MyUser user = BmobUser.getCurrentUser(MyUser.class);
        BmobQuery<WushPush> query = new BmobQuery<WushPush>();
        query.addWhereEqualTo("pushUser", user);
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        //query.setLimit(50);
        //执行查询方法
        query.findObjects(new FindListener<WushPush>() {
            @Override
            public void done(List<WushPush> object, BmobException e) {
                if(e==null){
                    toast("查询成功：共"+object.size()+"条数据。");
                    for (WushPush myPush : object) {
                       //获得playerName的信息
                       gameScore.getPlayerName();
                       //获得数据的objectId信息
                       gameScore.getObjectId();
                       //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                       gameScore.getCreatedAt();
                    }
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });



        //添加WashUw订单，删除WashPush订单
        MyUser user = BmobUser.getCurrentUser(MyUser.class);
        WashUw my_underway = new WashUw();
        my_underway.setxxxx(xxxxxxxxxx.ToString());
        my_underway.setGetUser(user);
        my_underway.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Toast.makeText(getContext(),"已成功接单，请尽快处理！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(),"订单接收失败",Toast.LENGTH_SHORT).show();
                }
            }
        };

        WashPush gameScore = new WashPush();
        gameScore.setObjectId("dd8e6aff28");
        gameScore.delete(new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if(e==null){
                    Log.i("bmob","成功");
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });

    }

}
*/