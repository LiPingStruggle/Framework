package com.liping_struggle.framework.support.fragment;

import com.liping_struggle.framework.base.presenter.IBasePresenter;
import com.liping_struggle.framework.base.view.IBaseView;
import com.liping_struggle.framework.support.delegate.IMvpDelegateCallback;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public interface IFragmentDelegateCallback<V extends IBaseView,P extends IBasePresenter<V>> extends IMvpDelegateCallback<V,P> {
}
