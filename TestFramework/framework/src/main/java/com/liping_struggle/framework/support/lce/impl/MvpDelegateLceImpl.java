package com.liping_struggle.framework.support.lce.impl;

import android.view.View;

import com.liping_struggle.framework.R;
import com.liping_struggle.framework.support.lce.ILceAnimator;
import com.liping_struggle.framework.support.lce.delegate.IMvpLceView;
import com.liping_struggle.framework.support.lce.impl.animator.DefaultAnimator;

/**
 * IMvpLceView ->MvpDelegateLceImpl目标接口实现类
 * Created by struggle_liping on 2017/7/30.
 */

public class MvpDelegateLceImpl<M> implements IMvpLceView<M> {


    private ILceAnimator mLceAnimator;
    private View mLoadingView;
    private View mErrorView;
    private View mContentView;

    public MvpDelegateLceImpl() {
    }

    @Override
    public void initView(View view) {
        if (mLoadingView==null) {
            mLoadingView = view.findViewById(R.id.loadingView);
        }
        if (mContentView==null) {
            mContentView = view.findViewById(R.id.loadingView);
        }
        if (mErrorView==null) {
            mErrorView = view.findViewById(R.id.loadingView);
        }

        if (mLoadingView == null) {
            throw new NullPointerException("loadingview not is null");
        }

        if (mContentView == null) {
            throw new NullPointerException("contentview not is null");
        }

        if (mErrorView == null) {
            throw new NullPointerException("errorgview not is null");
        }
    }

    public ILceAnimator getLceAnimator() {
        if (mLceAnimator == null){
            mLceAnimator = DefaultAnimator.getInstance();
        }
        return mLceAnimator;
    }

    @Override
    public void showLoading(boolean pullTorefresh) {
        getLceAnimator().showLoading(mLoadingView,mContentView,mErrorView);
    }

    @Override
    public void showError() {
        getLceAnimator().showError(mLoadingView,mContentView,mErrorView);
    }

    @Override
    public void showContent() {
        getLceAnimator().showContent(mLoadingView,mContentView,mErrorView);
    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }

    @Override
    public void bindData(M data) {

    }

    @Override
    public void setAnimator(ILceAnimator lceAnimator) {
        mLceAnimator= lceAnimator;
    }

    @Override
    public void setErrorOnClickListener(View.OnClickListener onClickListener) {
        if (mErrorView==null){
            throw  new NullPointerException("errorOnClickListener not is null");
        }
        mErrorView.setOnClickListener(onClickListener);
    }
}
