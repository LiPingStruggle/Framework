package com.liping_struggle.framework.base.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.support.delegate.IMvpDelegateCallback;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public abstract class MvpLinearLayout<V extends IBaseView,P extends IBasePresenter> extends LinearLayout implements IMvpDelegateCallback<V,P>,ActionBarDrawerToggle.DelegateProvider {

    private P mPresenter;

    public MvpLinearLayout(Context context) {
        super(context);
    }

    public MvpLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mPresenter==null){
            mPresenter = createPresenter();
        }
        if (mPresenter!=null && getMvpView()!=null){
            mPresenter.attachView(getMvpView());
        }
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public V getMvpView() {
        return (V) this;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPresenter!=null){
            mPresenter.dettachView();
        }
    }
}
