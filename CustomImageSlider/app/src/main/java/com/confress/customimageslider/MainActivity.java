package com.confress.customimageslider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends FragmentActivity {

    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.indicator)
    ViewPagerIndicator indicator;

    private List<String> mImagePath= Arrays.asList(
            "http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg");
    private  List<VpSimpleFragment> mContents=new ArrayList<>();
    private FragmentPagerAdapter mAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initDatas();
        indicator.setTabItemImagecator(mImagePath);

        viewpager.setAdapter(mAdpter);
        indicator.setViewPager(viewpager,0);
    }

    private void initDatas() {
        for (String imagepath:mImagePath){
            VpSimpleFragment fragment = VpSimpleFragment.newInstance(imagepath);
            mContents.add(fragment);
        }
        mAdpter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mContents.get(position);
            }

            @Override
            public int getCount() {
                return mContents.size();
            }
        };
    }
}
