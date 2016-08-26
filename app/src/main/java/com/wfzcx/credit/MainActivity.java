package com.wfzcx.credit;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.utils.JUtils;
import com.wfzcx.credit.module.interact.InteractFragment;
import com.wfzcx.credit.module.main.Main2Fragment;
import com.wfzcx.credit.module.service.ServiceFragment;
import com.wfzcx.credit.module.user.UserFragment;
import com.wfzcx.credit.ui.FontTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BeamBaseActivity {

    @BindView(R.id.tabHost)
    FragmentTabHost mTabHost;

    private long mLastBackPressTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initTabHost();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long mNowBackPressTime = System.currentTimeMillis();
            if (mNowBackPressTime - mLastBackPressTime > 2000) {
                JUtils.Toast("再次点击退出APP");
                mLastBackPressTime = mNowBackPressTime;
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initTabHost() {

        mTabHost.setup(this, getSupportFragmentManager(), R.id.realContent);
        for (MainTab tab : MainTab.values()) {
            TabHost.TabSpec mTabSpec = mTabHost.newTabSpec(getString(tab.getResName()));

            View mIndicator = LayoutInflater.from(this).inflate(R.layout.main_tab_indicator, null);
            FontTextView mTabIcon = (FontTextView) mIndicator.findViewById(R.id.tab_icon);
            mTabIcon.setText(tab.getResIcon());
            TextView mTabTile = (TextView) mIndicator.findViewById(R.id.tab_title);
            mTabTile.setText(getString(tab.getResName()));


            mTabSpec.setIndicator(mIndicator);
            mTabHost.addTab(mTabSpec, tab.getClz(), null);
            mTabHost.getTabWidget().setShowDividers(TabWidget.SHOW_DIVIDER_NONE);
        }

    }

    public enum MainTab {

        MAIN(0, R.string.main_tab_title_main, R.string.ic_main, Main2Fragment.class),
        SERVICE(1, R.string.main_tab_title_service, R.string.ic_service, ServiceFragment.class),
        INTERACT(2, R.string.main_tab_title_interact, R.string.ic_interact, InteractFragment.class),
        USER(3, R.string.main_tab_title_user, R.string.ic_user, UserFragment.class);

        private int resId;
        private int resName;
        private int resIcon;
        private Class<?> clz;

        private MainTab(int resId, int resName, int resIcon, Class<?> clz) {
            this.resId = resId;
            this.resName = resName;
            this.resIcon = resIcon;
            this.clz = clz;
        }

        public Class<?> getClz() {
            return clz;
        }

        public void setClz(Class<?> clz) {
            this.clz = clz;
        }

        public int getResIcon() {
            return resIcon;
        }

        public void setResIcon(int resIcon) {
            this.resIcon = resIcon;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public int getResName() {
            return resName;
        }

        public void setResName(int resName) {
            this.resName = resName;
        }
    }

}
