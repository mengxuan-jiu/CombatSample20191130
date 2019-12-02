package com.bawei.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @包名 com.bawei.myapplication
 * @mengxuan
 * @日期2019/12/2
 * @日期2019 : 12:02
 * @项目名CombatSample20191130
 * @类名Myadapter
 **/
public class Myadapter extends BaseAdapter {


    private List<Ljson.ResultBean.RxxpBean.CommodityListBean> commodityList;

    public Myadapter(List<Ljson.ResultBean.RxxpBean.CommodityListBean> commodityList) {

        this.commodityList = commodityList;
    }

    @Override
    public int getCount() {
        return commodityList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHord viewHord = new viewHord();
        if(view==null){
           view=View.inflate(viewGroup.getContext(),R.layout.ll,null);
          viewHord.imageView= view.findViewById(R.id.ll_im);
          view.setTag(viewHord);
        }else {
            viewHord= (Myadapter.viewHord) view.getTag();
        }
        Ljson.ResultBean.RxxpBean.CommodityListBean list = commodityList.get(i);
        Netutil.getInstance().getBitmap(list.getMasterPic(),viewHord.imageView);
        return view;
    }

    private class viewHord {
        ImageView imageView;
        TextView textView;
    }
}
