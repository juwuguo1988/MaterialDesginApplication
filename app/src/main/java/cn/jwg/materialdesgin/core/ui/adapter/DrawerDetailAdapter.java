package cn.jwg.materialdesgin.core.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jwg.materialdesgin.core.R;
import cn.jwg.materialdesgin.core.common.bean.DrawerBean;
import java.util.List;


public class DrawerDetailAdapter extends BaseAdapter {

    private Context mContext;
    private List<DrawerBean> mDrawerBeen;

    public DrawerDetailAdapter(Context mContext, List<DrawerBean> mDrawerBeen) {
        this.mContext = mContext;
        this.mDrawerBeen = mDrawerBeen;
    }

    @Override
    public int getCount() {
        return mDrawerBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return mDrawerBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrawerBean mDrawerBean = mDrawerBeen.get(position);
        ViewContentHolder vcholder;
        if (convertView == null) {
            vcholder = new ViewContentHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_drawer_layout, null);
            vcholder.tv_menu_content = (TextView) convertView.findViewById(R.id.tv_menu_content);
            vcholder.iv_menu_icon = (ImageView) convertView.findViewById(R.id.iv_menu_icon);
            convertView.setTag(vcholder);
        } else {
            vcholder = (ViewContentHolder) convertView.getTag();
        }
        vcholder.iv_menu_icon.setImageResource(mDrawerBean.image);
        vcholder.tv_menu_content.setText(mDrawerBean.name);
        return convertView;
    }

    static class ViewContentHolder {

        TextView tv_menu_content;
        ImageView iv_menu_icon;

    }
}
