package com.yitwee.www.dataclass;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by user on 2016/10/30.
 */

public class WashPush extends BmobObject {
    private MyUser pushUser;
//    private String note;
//    private String place;


    public MyUser getPushUser() {
        return pushUser;
    }

    public void setPushUser(MyUser pushUser) {
        this.pushUser = pushUser;
    }
}
