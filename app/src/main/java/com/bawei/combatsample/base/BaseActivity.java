package com.bawei.combatsample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.combatsample.R;

/**
 * @包名 com.bawei.combatsample.base
 * @mengxuan
 * @日期2019/12/1
 * @日期2019 : 12:01
 * @项目名CombatSample20191130
 * @类名BaseActivity
 **/
public abstract class BaseActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initDate();
    }

    protected abstract int layoutId();

    protected abstract void initView();

    protected abstract void initDate();
}
