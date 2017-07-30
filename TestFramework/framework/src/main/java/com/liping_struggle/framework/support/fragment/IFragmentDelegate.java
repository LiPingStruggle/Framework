package com.liping_struggle.framework.support.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public interface IFragmentDelegate<V extends IBaseView,P extends IBasePresenter<V>> {

    void onAttach(Context activity);

    void onCreate(Bundle savedInstanceState);

    void onViewCreated(View view, Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroyView();

    void onDestroy();

    void onDetach();

}
