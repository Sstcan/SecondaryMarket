package com.example.shishengtao.secondarymarket.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.shishengtao.secondarymarket.R;



public class BlankFragment_find extends Fragment {
    Button bt_qiugou;
    Button bt_tanwei;
    ImageView add;

    public BlankFragment_find() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    //活动创建之后才能对fragment中的控件进行实例化，对控件的实例化、对控件的操作都要在这个活动中完成
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bt_tanwei=(Button) getActivity().findViewById(R.id.btn_tanwei);
        bt_qiugou=(Button) getActivity().findViewById(R.id.btn_qiugou);
        add=(ImageView) getActivity().findViewById(R.id.find_add);
        bt_tanwei.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


              /*  bt_tanwei.setEnabled(false);
                bt_qiugou.setEnabled(true);*/
                Log.d("BUTN","点击的是摊位按钮");
                bt_tanwei.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                bt_qiugou.setBackgroundDrawable(getResources().getDrawable(R.drawable.find_btnbackg));
               /* view.setFocusable(false);
                view.requestFocus();
                view.requestFocusFromTouch();*/
            }
        });
        bt_qiugou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BUTN","点击的是求购按钮");
              /*  bt_qiugou.setEnabled(false);
                bt_tanwei.setEnabled(true);*/
                bt_qiugou.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                bt_tanwei.setBackgroundDrawable(getResources().getDrawable(R.drawable.find_btnbackg));
               /* view.setFocusable(false);
                view.requestFocus();
                view.requestFocusFromTouch();*/
            }
        });

    }

}
