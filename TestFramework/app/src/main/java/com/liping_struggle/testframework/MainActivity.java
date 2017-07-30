package com.liping_struggle.testframework;

import com.liping_struggle.framework.base.activity.MvpActivity;
import com.liping_struggle.framework.base.presenter.IBasePresenter;

public class MainActivity extends MvpActivity {


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initData() {

    }

    @Override
    public IBasePresenter createPresenter() {
        return null;
    }
}
