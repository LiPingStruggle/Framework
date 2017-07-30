package com.liping_struggle.framework.support.delegate;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;

/**
 *
 * 具体的代理对象－－需要持有目标接口实例
 * Created by struggle_liping on 2017/7/30.
 */

public  class MvpDelegateProxy<V extends IBaseView,P extends IBasePresenter<V>> implements IMvpDelegateCallback<V,P> {



    private IMvpDelegateCallback<V, P> mvpDelegateCallback;

    public MvpDelegateProxy(
            IMvpDelegateCallback<V, P> mvpDelegateCallback) {
        this.mvpDelegateCallback = mvpDelegateCallback;
    }



    @Override
    public P createPresenter() {
      P presenter = mvpDelegateCallback.getPresenter();
        if (presenter==null){
            presenter = mvpDelegateCallback.createPresenter();
        }
        if (presenter==null){
            throw  new NullPointerException("Presenter can't for empty");
        }
        return getPresenter();
    }

    @Override
    public P getPresenter() {
        P presenter = mvpDelegateCallback.getPresenter();
        if (presenter==null){
            throw  new NullPointerException("Presenter can't for empty");
        }
        return mvpDelegateCallback.getPresenter();
    }

    @Override
    public V getMvpView() {
        return mvpDelegateCallback.getMvpView();
    }

    public void onAttachView(){
        getPresenter().attachView(getMvpView());
    }

    public void onDettachView(){
        getPresenter().dettachView();
    }
}
