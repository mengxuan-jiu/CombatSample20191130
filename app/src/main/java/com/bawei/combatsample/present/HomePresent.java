package com.bawei.combatsample.present;

import com.bawei.combatsample.contract.IModelCallback;
import com.bawei.combatsample.model.HomeModel;
import com.bawei.combatsample.model.bean.Lawyer;
import com.bawei.combatsample.view.activity.MainActivity;

/**
 * @包名 com.bawei.combatsample.present
 * @mengxuan
 * @日期2019/12/1
 * @日期2019 : 12:01
 * @项目名CombatSample20191130
 * @类名HomePresent
 **/
public class HomePresent {
    public void getHomeDarte(final IModelCallback.IView iView) {
        HomeModel homeModel = new HomeModel();
        homeModel.getHomeDarte(new IModelCallback.onModelCallback() {
            @Override
            public void onSuccess(Lawyer lawyer) {
                iView.onSuccess(lawyer);
            }

            @Override
            public void onFailure(Throwable throwable) {
                iView.onFailure(throwable);
            }
        });
    }


}
