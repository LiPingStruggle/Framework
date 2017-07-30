package com.liping_struggle.framework.support.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;
import com.liping_struggle.framework.support.delegate.MvpDelegateProxy;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public class FragmentDelegateImpl<V extends IBaseView,P extends IBasePresenter<V>> implements IFragmentDelegate<V,P> {


    private IFragmentDelegateCallback<V,P> mFragmentDelegateCallback;

    private MvpDelegateProxy<V,P> mMvpDelegateProxy;

    public MvpDelegateProxy<V, P> getMvpDelegateProxy() {
        if (mMvpDelegateProxy==null){
            mMvpDelegateProxy = new MvpDelegateProxy<V,P>(mFragmentDelegateCallback);
        }
        return mMvpDelegateProxy;
    }

    public FragmentDelegateImpl(IFragmentDelegateCallback<V,P> fragmentDelegateCallback) {
        if (fragmentDelegateCallback==null){
            throw  new NullPointerException("IFragmentDelegateCallback can't for empty");
        }
        this.mFragmentDelegateCallback = fragmentDelegateCallback;
    }

    @Override
    public void onAttach(Context activity) {
        getMvpDelegateProxy().createPresenter();
        getMvpDelegateProxy().onAttachView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDetach() {
        getMvpDelegateProxy().onDettachView();
    }
}
