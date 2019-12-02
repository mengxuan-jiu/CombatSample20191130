package com.bawei.combatsample.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;

import com.bawei.combatsample.R;
import com.bawei.combatsample.base.BaseActivity;
import com.bawei.combatsample.contract.IModelCallback;
import com.bawei.combatsample.model.bean.Lawyer;
import com.bawei.combatsample.present.HomePresent;
import com.bawei.combatsample.view.adapter.MyAdapter;

public class MainActivity extends BaseActivity implements IModelCallback.IView {

    private GridView rl;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        rl = findViewById(R.id.m_rl);
    }

    @Override
    protected void initDate() {
        HomePresent homePresent = new HomePresent();
        homePresent.getHomeDarte(this);
    }

    @Override
    public void onSuccess(Lawyer lawyer) {
rl.setAdapter(new MyAdapter(lawyer.getListdata()));
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
