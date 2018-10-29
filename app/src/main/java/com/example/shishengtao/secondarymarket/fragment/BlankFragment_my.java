package com.example.shishengtao.secondarymarket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shishengtao.secondarymarket.my_turn.LoginActivity;
import com.example.shishengtao.secondarymarket.R;

public class BlankFragment_my extends Fragment {

    ImageView user_login;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }


    //活动创建之后才能对fragment中的控件进行实例化，对控件的实例化、对控件的操作都要在这个活动中完成
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        user_login=(ImageView)getActivity().findViewById(R.id.my_login);
        user_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });


    }

}
