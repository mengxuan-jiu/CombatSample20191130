package com.bawei.combatsample.model;

import com.bawei.combatsample.contract.IModelCallback;
import com.bawei.combatsample.model.bean.Lawyer;
import com.bawei.combatsample.util.NetUtil;
import com.google.gson.Gson;

/**
 * @包名 com.bawei.combatsample.model.bean
 * @mengxuan
 * @日期2019/12/1
 * @日期2019 : 12:01
 * @项目名CombatSample20191130
 * @类名HomeModel
 **/
public class HomeModel {
    public void getHomeDarte(final IModelCallback.onModelCallback onModelCallback) {
        NetUtil.getInstance().getJson("", new NetUtil.MyCallback() {
            @Override
            public void onGetJson(String json) {
                Lawyer lawyer = new Gson().fromJson("http://blog.zhaoliang5156.cn/api/news/lawyer.json", Lawyer.class);
                onModelCallback.onSuccess(lawyer);
            }

            @Override
            public void onError(Throwable throwable) {
                onModelCallback.onFailure(throwable);
            }
        });

    }
}
