package com.yitwee.www.aixi;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by cjb on 2016/10/29.
 */

public class Merchant_Main_Home_Fragment extends DialogFragment {
    public Merchant_Main_Home_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.merchant_fragment_main_home,container,false);
        return view;
   }
}
