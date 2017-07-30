package com.liping_struggle.framework.support.lce.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.liping_struggle.framework.base.fragment.MvpFragment;
import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.support.lce.delegate.IMvpLceView;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public abstract class MvpLceFragment<M, V extends IMvpLceView<M>, P extends IBasePresenter<V>> extends MvpFragment<V, P> implements IMvpLceView<M> {


    private MvpLceDelegateProxy mMvpDelegateProxy;


    public MvpLceDelegateProxy getLceDelegateProxy() {
        if (mMvpDelegateProxy==null){
            mMvpDelegateProxy = new MvpLceDelegateProxy();
        }
        return mMvpDelegateProxy;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }



    public void initView(View view) {
        getLceDelegateProxy().initView(view);
        getLceDelegateProxy().setErrorOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRetry();
            }
        });
    }

    private void onClickRetry() {
        loadData(false);
    }


    @Override
    public void showLoading(boolean pullTorefresh) {
        getLceDelegateProxy().showLoading(pullTorefresh);

    }

    @Override
    public void showError() {
        getLceDelegateProxy().showError();
    }

    @Override
    public void showContent() {
       getLceDelegateProxy().showContent();
    }

    @Override
    public void bindData(M data) {
        getLceDelegateProxy().bindData(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        getLceDelegateProxy().loadData(pullToRefresh);
    }
}
