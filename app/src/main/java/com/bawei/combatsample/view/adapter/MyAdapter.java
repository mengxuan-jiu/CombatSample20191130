package com.bawei.combatsample.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bawei.combatsample.model.bean.Lawyer;

import java.util.List;

/**
 * @包名 com.bawei.combatsample.view.adapter
 * @mengxuan
 * @日期2019/12/1
 * @日期2019 : 12:01
 * @项目名CombatSample20191130
 * @类名MyAdapter
 **/
public class MyAdapter extends BaseAdapter {
    private List<Lawyer.ListdataBean> listdata;

    public MyAdapter(List<Lawyer.ListdataBean> listdata) {

        this.listdata = listdata;
    }

    @Override
    public int getCount() {
        return 0;
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
        return null;
    }
}
