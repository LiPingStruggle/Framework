package com.liping_struggle.framework.support.delegate;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;

/**
 ** 代理模式－静态代理：目标接口
 * Created by struggle_liping on 2017/7/30.
 */

public interface IMvpDelegateCallback<V extends IBaseView,P extends IBasePresenter<V>> {

    P createPresenter();

    P getPresenter();

    V getMvpView();

}
