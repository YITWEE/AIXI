package com.yitwee.www.aixi;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Wei DH on 2016/10/24.
 */
public class MyUser extends BmobUser {
    //添加用户信息
    private Boolean sex;
//    private String age;
    private String school;
//    private String college;
//    private String grade;
    private BmobFile headicon;
    private BmobFile bgimage;

    public BmobFile getBgimage() {
        return bgimage;
    }

    public void setBgimage(BmobFile bgimage) {
        this.bgimage = bgimage;
    }

    public BmobFile getHeadicon() {
        return headicon;
    }

    public void setHeadicon(BmobFile headicon) {
        this.headicon = headicon;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
//
//    public String getCollege() {
//        return college;
//    }
//
//    public void setCollege(String college) {
//        this.college = college;
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
}