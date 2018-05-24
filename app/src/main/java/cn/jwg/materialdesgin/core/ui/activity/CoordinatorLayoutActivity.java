package cn.jwg.materialdesgin.core.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.utils.ui.UIUtils;

public class CoordinatorLayoutActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.inflateMenu(R.menu.menu_prodect_detail);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_share:
                        UIUtils.createToast(CoordinatorLayoutActivity.this, "分享");
                        break;
                    case R.id.action_settings:
                        UIUtils.createToast(CoordinatorLayoutActivity.this, "举报");
                        break;
                }
                return false;
            }
        });

        CollapsingToolbarLayout collapsingAvatarToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingAvatarToolbar.setBackgroundColor(getResources().getColor(R.color.c_2bb2ba));
        collapsingAvatarToolbar.setExpandedTitleGravity(Gravity.CENTER_VERTICAL);
        collapsingAvatarToolbar.setExpandedTitleColor(getResources().getColor(R.color.c_2bb2ba));


        AppBarLayout appbar = (AppBarLayout)findViewById(R.id.appbar);
        appbar.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        Log.e("============","=================="+verticalOffset);

    }
}
