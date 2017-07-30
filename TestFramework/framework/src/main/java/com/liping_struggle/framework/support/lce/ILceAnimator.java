package com.liping_struggle.framework.support.lce;

import android.view.View;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public interface ILceAnimator {

    void showLoading(View loadingView,View contentView,View errorView);
    void showError(View loadingView,View contentView,View errorView);
    void showContent(View loadingView,View contentView,View errorView);
}
