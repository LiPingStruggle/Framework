package com.liping_struggle.framework.support.lce.impl.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;

import com.liping_struggle.framework.R;
import com.liping_struggle.framework.support.lce.ILceAnimator;

/**
 * Created by struggle_liping on 2017/7/30.
 */

public class DefaultAnimator implements ILceAnimator {

    private static volatile DefaultAnimator mDefaultAnimator;

    public static DefaultAnimator getInstance(){
        if (mDefaultAnimator==null){
            synchronized (DefaultAnimator.class){
                if (mDefaultAnimator==null){
                    mDefaultAnimator = new DefaultAnimator();
                }
            }
        }
        return mDefaultAnimator;
    }
    @Override
    public void showLoading(View loadingView, View contentView, View errorView) {
        contentView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(final View loadingView,final View contentView,final View errorView) {
        contentView.setVisibility(View.GONE);

        final Resources resources = loadingView.getResources();
        // Not visible yet, so animate the view in
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator in = ObjectAnimator.ofFloat(errorView, "alpha", 1f);
        ObjectAnimator loadingOut = ObjectAnimator.ofFloat(loadingView,
                "alpha", 0f);

        set.playTogether(in, loadingOut);
        set.setDuration(resources
                .getInteger(R.integer.lce_error_view_show_animation_time));

        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                errorView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                loadingView.setVisibility(View.GONE);
                loadingView.setAlpha(1f); // For future showLoading calls
            }
        });

        set.start();
    }

    @Override
    public void showContent(final View loadingView,final View contentView,final View errorView) {
        if (contentView.getVisibility() == View.VISIBLE) {
            errorView.setVisibility(View.GONE);
            loadingView.setVisibility(View.GONE);
        } else {

            errorView.setVisibility(View.GONE);

            final Resources resources = loadingView.getResources();
            final int translateInPixels = resources
                    .getDimensionPixelSize(R.dimen.lce_content_view_animation_translate_y);
            // Not visible yet, so animate the view in
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator contentFadeIn = ObjectAnimator.ofFloat(contentView,
                    "alpha", 0f, 1f);
            ObjectAnimator contentTranslateIn = ObjectAnimator.ofFloat(
                    contentView, "translationY", translateInPixels, 0);

            ObjectAnimator loadingFadeOut = ObjectAnimator.ofFloat(loadingView,
                    "alpha", 1f, 0f);
            ObjectAnimator loadingTranslateOut = ObjectAnimator.ofFloat(
                    loadingView, "translationY", 0, -translateInPixels);

            set.playTogether(contentFadeIn, contentTranslateIn, loadingFadeOut,
                    loadingTranslateOut);
            set.setDuration(resources
                    .getInteger(R.integer.lce_content_view_show_animation_time));

            set.addListener(new AnimatorListenerAdapter() {

                @Override
                public void onAnimationStart(Animator animation) {
                    contentView.setTranslationY(0);
                    loadingView.setTranslationY(0);
                    contentView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    loadingView.setVisibility(View.GONE);
                    loadingView.setAlpha(1f); // For future showLoading calls
                    contentView.setTranslationY(0);
                    loadingView.setTranslationY(0);
                }
            });

            set.start();
        }
    }

}
