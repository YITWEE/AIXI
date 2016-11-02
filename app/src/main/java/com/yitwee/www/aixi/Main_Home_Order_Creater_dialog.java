package com.yitwee.www.aixi;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by cjb on 2016/11/2.
 */

public class Main_Home_Order_Creater_dialog extends DialogFragment{
    private int mNum;
    private OnDialogButtonClickListener buttonClickListner;
    TextView button_no,button_yes;
    EditText et_ordercreater_dialog_location,et_ordercreater_dialog_name,et_ordercreater_dialog_remark
    ,et_ordercreater_dialog_phonenumber,et_order_dialog_time;
    static Main_Home_Order_Creater_dialog newInstance(int num) {
        Main_Home_Order_Creater_dialog f = new Main_Home_Order_Creater_dialog();
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);
        return f;
    }

    public interface OnDialogButtonClickListener {
        public void okButtonClick();
        public void cancelButtonClick();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mNum = getArguments().getInt("num");

        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        switch (1) {
            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
            case 2: style = DialogFragment.STYLE_NO_FRAME; break;
            case 3: style = DialogFragment.STYLE_NO_INPUT; break;
            case 4: style = DialogFragment.STYLE_NORMAL; break;
            case 5: style = DialogFragment.STYLE_NORMAL; break;
            case 6: style = DialogFragment.STYLE_NO_TITLE; break;
            case 7: style = DialogFragment.STYLE_NO_FRAME; break;
            case 8: style = DialogFragment.STYLE_NORMAL; break;
        }
        switch (5) {
            case 4: theme = android.R.style.Theme_Holo; break;
            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
            case 6: theme = android.R.style.Theme_Holo_Light; break;
            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
            case 8: theme = android.R.style.Theme_Holo_Light; break;
        }
        setStyle(style, theme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_home_odercreater_dialog, container, false);
        button_no = (TextView) v.findViewById(R.id.tv_home_ordercreater_state_no);
        button_yes = (TextView) v.findViewById(R.id.tv_home_ordercreater_state_yes);
        et_ordercreater_dialog_location= (EditText) v.findViewById(R.id.et_ordercreater_dialog_location);
        et_ordercreater_dialog_name= (EditText) v.findViewById(R.id.et_ordercreater_dialog_name);
        et_ordercreater_dialog_remark= (EditText) v.findViewById(R.id.et_ordercreater_dialog_remark);
        et_ordercreater_dialog_phonenumber= (EditText) v.findViewById(R.id.et_ordercreater_dialog_phonenumber);
        et_order_dialog_time= (EditText) v.findViewById(R.id.et_order_dialog_time);


        button_yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String location=et_ordercreater_dialog_location.getText().toString();
                String name=et_ordercreater_dialog_name.getText().toString();
                String phonenumber=et_ordercreater_dialog_phonenumber.getText().toString();
                String remark=et_ordercreater_dialog_remark.getText().toString();
                String time=et_order_dialog_time.getText().toString();
                if(location.isEmpty()|name.isEmpty()|phonenumber.isEmpty()|remark.isEmpty()|time.isEmpty())
                {
                    Toast.makeText(getContext(),"请完善你的订单信息",Toast.LENGTH_SHORT).show();
                    return;
                }
                buttonClickListner.okButtonClick();
                getDialog().dismiss();
            }
        });
        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickListner.cancelButtonClick();
                getDialog().dismiss();
            }
        });
        return v;
    }

    public void setOnButtonClickListener(OnDialogButtonClickListener listener) {
        this.buttonClickListner = listener;
    }
}
