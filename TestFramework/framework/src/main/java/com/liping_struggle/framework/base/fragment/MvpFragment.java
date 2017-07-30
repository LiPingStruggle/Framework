package com.liping_struggle.framework.base.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;
import com.liping_struggle.framework.support.fragment.FragmentDelegateImpl;
import com.liping_struggle.framework.support.fragment.IFragmentDelegateCallback;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public abstract class MvpFragment<V extends IBaseView,P extends IBasePresenter<V>> extends Fragment implements IFragmentDelegateCallback<V,P> {



    private FragmentDelegateImpl<V,P> mFragmentDelegate;

    public FragmentDelegateImpl<V, P> getFragmentDelegate() {
        if (mFragmentDelegate==null){
            mFragmentDelegate = new FragmentDelegateImpl<V,P>(this);
        }
        return mFragmentDelegate;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getFragmentDelegate().onAttach(context);
    }


    @Override
    public void onDetach() {
        super.onDetach();
       getFragmentDelegate().onDetach();
    }
}
