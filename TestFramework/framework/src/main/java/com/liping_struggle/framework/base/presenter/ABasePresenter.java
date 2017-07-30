package com.liping_struggle.framework.base.presenter;

import android.content.Context;

import com.liping_struggle.framework.base.view.IBaseView;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public abstract class ABasePresenter<V extends IBaseView> implements IBasePresenter<V>{

    private V mProxy;
    private WeakReference<V> mVWeak;

    public ABasePresenter(Context context) {

    }

    public V getView() {
        return mProxy;
    }

    private boolean isAttachView(){
        if (mVWeak!=null && mVWeak.get()!=null){
            return true;
        }
        return false;
    }

    @Override
    public void attachView(final V view) {
        mVWeak = new WeakReference<V>(view);
        //动态代理实现非空判断
        mProxy = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (isAttachView()) {
                    return method.invoke(view,args);
                }
                return null;
            }
        });
    }

    @Override
    public void dettachView(){
        this.mProxy = null;
    }




}
