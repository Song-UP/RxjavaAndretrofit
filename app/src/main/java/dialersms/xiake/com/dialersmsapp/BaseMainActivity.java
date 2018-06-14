package dialersms.xiake.com.dialersmsapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dialersms.xiake.com.dialersmsapp.base.BaseActivity;
import dialersms.xiake.com.dialersmsapp.base.BaseFragment;
import dialersms.xiake.com.dialersmsapp.fragment.FragmentFour;
import dialersms.xiake.com.dialersmsapp.fragment.FragmentOne;
import dialersms.xiake.com.dialersmsapp.fragment.FragmentThree;
import dialersms.xiake.com.dialersmsapp.fragment.FragmentTwo;

public class BaseMainActivity extends BaseActivity {
    @BindView(R.id.viewpage) ViewPager viewpage;
    @BindView(R.id.tabLayout) TabLayout tabLayout;

    private String[] tabText = new String[]{"联系人","客户","短信记录","个人中心"};
    private int[] tabUnSelImagId = new int[]{R.drawable.ic_launcher,R.drawable.ic_launcher,
            R.drawable.ic_launcher,R.drawable.ic_launcher};

    private int[] tabSelImagId = new int[]{R.drawable.ic_bar_home_selected,R.drawable.ic_bar_home_selected,
            R.drawable.ic_bar_home_selected,R.drawable.ic_bar_home_selected};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    public void initView(){
        SampleFragmengPage pagerAdapter = new SampleFragmengPage(this, getSupportFragmentManager());
        viewpage.setAdapter(pagerAdapter);
        viewpage.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewpage);
        for (int i = 0; i<tabLayout.getTabCount(); i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null)
                tab.setCustomView(pagerAdapter.getTabView(i));
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View layout = tab.getCustomView();
                ImageView imageView = layout.findViewById(R.id.iv_tab);
                TextView textView = layout.findViewById(R.id.tv_tab);
                imageView.setImageResource(tabSelImagId[tab.getPosition()]);
                textView.setTextColor(getResources().getColor(R.color.tv_color_tab_sel));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View layout = tab.getCustomView();
                ImageView imageView = layout.findViewById(R.id.iv_tab);
                TextView textView = layout.findViewById(R.id.tv_tab);
                imageView.setImageResource(tabUnSelImagId[tab.getPosition()]);
                textView.setTextColor(getResources().getColor(R.color.tv_color_tab_unsel));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }




    public class SampleFragmengPage extends FragmentPagerAdapter{
        Context context;

        View getTabView(int position) {
            View v = LayoutInflater.from(BaseMainActivity.this).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) v.findViewById(R.id.tv_tab);
            tv.setText(tabText[position]);
            ImageView img = (ImageView) v.findViewById(R.id.iv_tab);
            img.setImageResource(tabUnSelImagId[position]);
            return v;
        }



        public SampleFragmengPage(Context context, FragmentManager fm) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = new FragmentOne();
            switch (position){
                case 0:
                    break;
                case 1:
                    fragment = new FragmentTwo();
                    break;
                case 2:
                    fragment = new FragmentThree();
                    break;
                case 3:
                    fragment = new FragmentFour();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return tabText.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabText[position];
        }
    }



}
