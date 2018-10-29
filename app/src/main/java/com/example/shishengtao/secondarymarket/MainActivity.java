package com.example.shishengtao.secondarymarket;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.shishengtao.secondarymarket.fragment.BlankFragment_classify;
import com.example.shishengtao.secondarymarket.fragment.BlankFragment_find;
import com.example.shishengtao.secondarymarket.fragment.BlankFragment_my;
import com.example.shishengtao.secondarymarket.fragment.BlankFragment_page;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity /*implements OnBannerListener*/ {

    private TextView mTextMessage;
    private BottomNavigationView bottomNavigationView;
    private ArrayList<Integer> list_path;
    private ArrayList<String> list_title;
    private Banner banner;
    Button user_regist;
    private BlankFragment_page fragment_page;
    private BlankFragment_classify fragment_classify;
    private BlankFragment_find fragment_find;
    private BlankFragment_my fragment_my;
    private int lastfragment;
    private Fragment[] fragments;

    private  void initFragment(){
        fragment_page=new BlankFragment_page();
        fragment_classify=new BlankFragment_classify();
        fragment_find=new BlankFragment_find();
        fragment_my=new BlankFragment_my();
        fragments=new Fragment[]{fragment_page,fragment_classify,fragment_find,fragment_my};
        lastfragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview,fragment_page).show(fragment_page).commit();
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Log.i("test","item.getItemId() is :"+item.getItemId());

            switch (item.getItemId())
            {
                case R.id.navigation_home:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;

                    }

                    return true;
                }
                case R.id.navigation_classify:
                {
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }

                    return true;
                }
                case R.id.navigation_find:
                {
                    if(lastfragment!=2)
                    {
                        switchFragment(lastfragment,2);
                        lastfragment=2;

                    }

                    return true;
                }
                case R.id.navigation_my:
                {
                    if(lastfragment!=3)
                    {
                        switchFragment(lastfragment,3);
                        lastfragment=3;

                    }

                    return true;
                }

            }


            return false;
        }

        private void switchFragment(int lastfragment, int index) {
            FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
            transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
            if(fragments[index].isAdded()==false)
            {
                transaction.add(R.id.mainview,fragments[index]);

            }
            transaction.show(fragments[index]).commitAllowingStateLoss();
        }
    };


    //这里我觉得你的是默认的首页界面，如果必须点击地下的四个按钮才能够设置标题中的文字
    //为“首页”的话，name首次进入是很奇怪的，因为什么都没有提示，所以直接在布局文件中
    //设置title中的文字为“首页”
  /*  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.home_page);
                    return true;
                case R.id.navigation_classify:
                    mTextMessage.setText(R.string.title_classify);
                  *//*  Intent intent=new Intent(MainActivity.this,ClassifyActivity.class);
                    startActivity(intent);*//*
                    return true;
                case R.id.navigation_find:
                    mTextMessage.setText(R.string.title_find);
                    return true;
                case R.id.navigation_my:
                    mTextMessage.setText(R.string.title_my);
                  *//*  Intent intent_my=new Intent(MainActivity.this,My.class);
                    startActivity(intent_my);*//*
                    return true;
            }
            return false;
        }

    };
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        /*initView();*/

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


      //  mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
      /*  navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        // 通过反射机制实现超过3图标时，不能显示文字的问题
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);



    }


}
