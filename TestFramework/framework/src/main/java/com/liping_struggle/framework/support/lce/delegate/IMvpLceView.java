package com.liping_struggle.framework.support.lce.delegate;

import android.view.View;

import com.liping_struggle.framework.base.view.IBaseView;
import com.liping_struggle.framework.support.lce.ILceAnimator;

/**
 * 目标接口
 * Created by struggle_liping on 2017/7/30.
 */

public interface IMvpLceView<M> extends IBaseView{

    void initView(View view);
    void showLoading(boolean pullTorefresh);
    void showError();
    void showContent();
    void loadData(boolean pullToRefresh);
    void bindData(M data);
    void setAnimator(ILceAnimator lceAnimator);
    void setErrorOnClickListener(View.OnClickListener onClickListener);
}
