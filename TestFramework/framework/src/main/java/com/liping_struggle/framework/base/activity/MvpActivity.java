package com.liping_struggle.framework.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;
import com.liping_struggle.framework.support.delegate.activity.ActivityDelegateImpl;
import com.liping_struggle.framework.support.delegate.activity.IActivityDelegateCallback;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public  abstract class MvpActivity<V extends IBaseView,P extends IBasePresenter<V>> extends BaseActivity implements IActivityDelegateCallback<V,P> {


    private P mPresenter;
    private ActivityDelegateImpl<V,P> mMvpDelegateProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }


    public ActivityDelegateImpl<V, P> getMvpDelegate() {
        if (mMvpDelegateProxy == null) {
            mMvpDelegateProxy = new ActivityDelegateImpl<V, P>(this);
        }
        return mMvpDelegateProxy;
    }


    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();
    }


    @Nullable
    @Override
    public Object getLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    public V getMvpView() {
        return (V) this;
    }

    @Override
    protected void onDestroy() {
        getMvpDelegate().onDestroy();
        super.onDestroy();
    }


}
