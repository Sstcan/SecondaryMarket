package com.example.shishengtao.secondarymarket.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.shishengtao.secondarymarket.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import static com.youth.banner.BannerConfig.*;


public class BlankFragment_page extends Fragment  implements OnBannerListener{

    private ArrayList<Integer> list_path;
    private ArrayList<String> list_title;
    private Banner banner;

    @Override
    public void onStart() {
        super.onStart();
        initView();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);

    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    private void initView() {
        list_path = new ArrayList<>();
        list_title = new ArrayList<>();
        banner = (Banner) getActivity().findViewById(R.id.banner);

      /*加载本地图片*/

        list_path.add(R.drawable.one);
        list_path.add(R.drawable.two);
        list_path.add(R.drawable.three);
        list_path.add(R.drawable.four);
        list_path.add(R.drawable.five);

        /*加载网络图片*/
      /*  list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");*/


        list_title.add("朴华");
        list_title.add("墨伊");
        list_title.add("已然");
        list_title.add("沐橙");
        list_title.add("幕颜");

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImageLoader(new MyLoader());
        banner.setImages(list_path);
        banner.setBannerAnimation(Transformer.Default);
        banner.setBannerTitles(list_title);
        banner.setDelayTime(1500);
        banner.isAutoPlay(true);/*是否自动轮播，默认为true*/
        banner.setViewPagerIsScroll(true);/*设置是否允许手动滑动，默认为true*/
        banner.setIndicatorGravity(CENTER);/*设置指示器的位置*/
        banner.setOnBannerListener(this);
        banner.start();

    }


    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第" + position + "张轮播图");
    }

    /*自定义图片加载器*/
    private class MyLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);


        }

    }

}
