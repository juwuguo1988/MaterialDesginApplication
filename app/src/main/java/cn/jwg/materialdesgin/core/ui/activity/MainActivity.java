package cn.jwg.materialdesgin.core.ui.activity;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.common.bean.DrawerBean;
import cn.jwg.materialdesgin.core.common.views.ActionBarDrawerToggle;
import cn.jwg.materialdesgin.core.common.views.DrawerArrowDrawable;
import cn.jwg.materialdesgin.core.ui.activity.db.MedicPlanActivity;
import cn.jwg.materialdesgin.core.ui.adapter.DrawerDetailAdapter;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private DrawerLayout mDrawerLayout;
    private ListView lv_drawer_area;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerArrowDrawable drawerArrow;
    private DrawerDetailAdapter mDrawerDetailAdapter;
    private Button btn_to_diag_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);
        btn_to_diag_activity = (Button) findViewById(R.id.btn_to_diag_activity);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        lv_drawer_area = (ListView) findViewById(R.id.lv_drawer_area);
        View convertView = getLayoutInflater().inflate(R.layout.item_user_avatar, null);
        lv_drawer_area.addHeaderView(convertView);

        drawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, drawerArrow, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        List<DrawerBean> mDrawerBeans = createDataList();
        mDrawerDetailAdapter = new DrawerDetailAdapter(this, mDrawerBeans);
        lv_drawer_area.setAdapter(mDrawerDetailAdapter);
        lv_drawer_area.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        //点击头像
                        intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        //我的作品
                        intent = new Intent(MainActivity.this, ProdectDetailActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        //数据库
                        intent = new Intent(MainActivity.this, MedicPlanActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        //QQ登录
                        intent = new Intent(MainActivity.this, RxJavaActivity.class);
                        startActivity(intent);

                        break;
                    case 4:
                        //设置
                        intent = new Intent(MainActivity.this, UserSettingActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });

        btn_to_diag_activity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogDisplayActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<DrawerBean> createDataList() {
        List<DrawerBean> mDrawerBeans = new ArrayList<>();
        mDrawerBeans.add(new DrawerBean("我的作品", R.drawable.menu_video_normal));
        mDrawerBeans.add(new DrawerBean("微信登录", R.drawable.login_wechat_btn_last_normal));
        mDrawerBeans.add(new DrawerBean("QQ登录", R.drawable.login_qq_btn_last_normal));
        mDrawerBeans.add(new DrawerBean("设   置", R.drawable.menu_set_normal));
        return mDrawerBeans;
    }

/*
//关闭抽屉
    private void changeDrawerStatus() {
        if (mDrawerLayout.isDrawerOpen(lv_drawer_area)) {
            mDrawerLayout.closeDrawer(lv_drawer_area);
        } else {
            mDrawerLayout.openDrawer(lv_drawer_area);
        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(lv_drawer_area)) {
                mDrawerLayout.closeDrawer(lv_drawer_area);
            } else {
                mDrawerLayout.openDrawer(lv_drawer_area);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
