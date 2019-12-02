package com.bawei.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView m_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_list = findViewById(R.id.m_list);
        Netutil.getInstance().get("http://172.17.8.100/small/commodity/v1/commodityList", new Netutil.MyChback() {
            @Override
            public void Doget(String s) {
               Ljson.ResultBean.RxxpBean list = new Gson().fromJson(s, Ljson.class).getResult().getRxxp();
          List<Ljson.ResultBean.RxxpBean.CommodityListBean> commodityList = list.getCommodityList();
            m_list.setAdapter(new Myadapter(commodityList));
            }

            @Override
            public void Failure(String e) {

            }
        });

    }
}
