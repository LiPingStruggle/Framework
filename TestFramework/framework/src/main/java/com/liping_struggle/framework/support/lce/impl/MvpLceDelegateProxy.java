package com.liping_struggle.framework.support.lce.impl;

import android.view.View;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.support.lce.ILceAnimator;
import com.liping_struggle.framework.support.lce.delegate.IMvpLceView;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public class MvpLceDelegateProxy<M,V extends IMvpLceView,P extends IBasePresenter> implements IMvpLceView<M> {

    private MvpDelegateLceImpl mMvpDelegateLce;

    public MvpLceDelegateProxy() {
        mMvpDelegateLce = new MvpDelegateLceImpl();

    }

    @Override
    public void initView(View view) {
        mMvpDelegateLce.initView(view);
    }

    @Override
    public void showLoading(boolean pullTorefresh) {
        mMvpDelegateLce.showLoading(pullTorefresh);
    }

    @Override
    public void showError() {
        mMvpDelegateLce.showError();
    }

    @Override
    public void showContent() {
        mMvpDelegateLce.showContent();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        mMvpDelegateLce.loadData(pullToRefresh);
    }

    @Override
    public void setAnimator(ILceAnimator lceAnimator) {
        mMvpDelegateLce.setAnimator(lceAnimator);
    }

    @Override
    public void setErrorOnClickListener(View.OnClickListener onClickListener) {
        mMvpDelegateLce.setErrorOnClickListener(onClickListener);
    }

    @Override
    public void bindData(M data) {
        mMvpDelegateLce.bindData(data);
    }
}
