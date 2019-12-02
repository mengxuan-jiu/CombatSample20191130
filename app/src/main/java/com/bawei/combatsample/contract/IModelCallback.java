package com.bawei.combatsample.contract;

import com.bawei.combatsample.model.bean.Lawyer;

/**
 * @包名 com.bawei.combatsample.contract
 * @mengxuan
 * @日期2019/12/1
 * @日期2019 : 12:01
 * @项目名CombatSample20191130
 * @类名IModelCallback
 **/
public interface IModelCallback {

    interface onModelCallback{
        void onSuccess(Lawyer lawyer);
        void onFailure(Throwable throwable);
    }
    interface IView{
        void onSuccess(Lawyer lawyer);
        void onFailure(Throwable throwable);
    }
}
