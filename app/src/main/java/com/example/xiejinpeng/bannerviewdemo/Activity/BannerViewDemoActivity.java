package com.example.xiejinpeng.bannerviewdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.xiejinpeng.bannerview.BannerView;
import com.example.xiejinpeng.bannerviewdemo.R;
import com.example.xiejinpeng.bannerviewdemo.model.BannerData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BannerViewDemoActivity extends AppCompatActivity {

    @Bind(R.id.bv_demo)
    BannerView bannerView;
    @Bind(R.id.ll_index)
    LinearLayout indexView;
    List<BannerData> bannerDataList;
    BannerView.Listener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_view_demo);
        ButterKnife.bind(this);
        initDefaultData();
        initBannerView();
    }

    private void initDefaultData() {
        BannerData bannerData = new BannerData();
        bannerData.setImageUri("http://apriimagesbucket.s3.amazonaws.com/1447325912.png");
        bannerData.setLinkUri("http://www.yahoo.co.jp");
        BannerData bannerData2 = new BannerData();
        bannerData2.setImageUri("http://apriimagesbucket.s3.amazonaws.com/1447325929.png");
        bannerData2.setLinkUri("http://www.yahoo.co.jp");
        BannerData bannerData3 = new BannerData();
        bannerData3.setImageUri("http://apriimagesbucket.s3.amazonaws.com/1447325943.png");
        bannerData3.setLinkUri("http://www.yahoo.co.jp");
        BannerData bannerData4 = new BannerData();
        bannerData4.setImageUri("http://apriimagesbucket.s3.amazonaws.com/1447325964.png");
        bannerData4.setLinkUri("http://www.yahoo.co.jp");
        BannerData bannerData5 = new BannerData();
        bannerData5.setImageUri("http://apriimagesbucket.s3.amazonaws.com/1447325984.png");
        bannerData5.setLinkUri("http://www.yahoo.co.jp");

        bannerDataList = new ArrayList<>();
        bannerDataList.add(bannerData);
        bannerDataList.add(bannerData2);
        bannerDataList.add(bannerData3);
        bannerDataList.add(bannerData4);
        bannerDataList.add(bannerData5);

    }

    private void initBannerView() {

        listener = new BannerView.Listener() {
            /**
             * 获取图片的imageUrl
             */

            @Override
            public String getImgUrl(int position) {
                return bannerDataList.get(position).getImageUri();
            }

            /**
             *    获取点击后跳转的OnClickUrl
             *    不需要点击事件则返回null即可
             */

            @Override
            public String getOnClickUrl(int position) {
                return bannerDataList.get(position).getLinkUri();
            }
        };

        /**
         * 构造方法参数 控件bannerView的实例,图片个数,用于获取url的接口
         * 可选设置: setAutoScrollPeriod(int period) 滚动的时间间隔
         *          isLoop(boolean isLoop)          是否无限循环
         *          setIndexData(LinearLayout bannerIndexLinearLayout, int SelectedRes, int unSelectedRes, int marginStart, int marginTop, int marginEnd, int marginBottom)
         *                                          放置Index的linearlayout,选中的index图片,未选中的index图片,每个index图片的margin值
         */


        new BannerView.Builder(bannerView, bannerDataList.size(), listener)
                .setAutoScrollPeriod(7000)
                .isLoop(false)
                .setIndexData(indexView, R.mipmap.page_control_on, R.mipmap.page_control_off, 17, 0, 0, 0)
                .create();
    }


}
