package com.liping_struggle.framework.support.delegate.activity;

import android.os.Bundle;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;
import com.liping_struggle.framework.support.delegate.MvpDelegateProxy;
import com.liping_struggle.framework.support.delegate.IActivityDelegate;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public class ActivityDelegateImpl<V extends IBaseView, P extends IBasePresenter<V>> implements IActivityDelegate<V, P> {

    private IActivityDelegateCallback<V, P> mActivityMvpDelegateCallback;
    private MvpDelegateProxy<V, P> mMvpDelegateProxy;


    public ActivityDelegateImpl(IActivityDelegateCallback<V, P> mvpDelegateProxy) {
        mActivityMvpDelegateCallback = mvpDelegateProxy;
    }

    public MvpDelegateProxy<V, P> getMvpDelegate() {
        if (mMvpDelegateProxy == null) {
            mMvpDelegateProxy = new MvpDelegateProxy<V, P>(mActivityMvpDelegateCallback);
        }
        return mMvpDelegateProxy;
    }

    @Override
    public void onCreate(Bundle bundle) {
        getMvpDelegate().createPresenter();
        getMvpDelegate().onAttachView();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle onRestoreInstanceState) {

    }

    @Override
    public void onDestroy() {
        getMvpDelegate().onDettachView();

    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }
}
