package com.liping_struggle.framework.base.presenter;

import com.liping_struggle.framework.base.view.IBaseView;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);

    void dettachView();
}
