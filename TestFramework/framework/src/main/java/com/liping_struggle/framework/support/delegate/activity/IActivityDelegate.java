package com.liping_struggle.framework.support.delegate;

import android.os.Bundle;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public interface IActivityDelegate<V extends IBaseView,P extends IBasePresenter<V>> {
    void onCreate(Bundle bundle);
    void onPause();
    void onResume();
    void onRestart();
    void onStop();
    void onStart();
    void onSaveInstanceState(Bundle outState);
    void onRestoreInstanceState(Bundle onRestoreInstanceState);
    void onDestroy();
    Object onRetainCustomNonConfigurationInstance();
}
