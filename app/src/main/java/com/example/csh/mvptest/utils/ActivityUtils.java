package com.example.csh.mvptest.utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.csh.mvptest.R;


/**
 * <p/>作者： lxg
 * <p/>创建时间: 18/01/02 17:32.
 */

public final class ActivityUtils {
    private ActivityUtils() {
    }

    public static void addFragment(FragmentManager fragmentManager, int contentId, Fragment fragment) {
        getAnimorTransaction(fragmentManager).add(contentId, fragment).commit();
    }

    public static void replaceFragment(FragmentManager fragmentManager, int contentId, Fragment newFragment) {
        replaceFragment(fragmentManager, contentId, newFragment, false);
    }

    /**
     * 需要保存视图状态
     *
     * @param fragmentManager
     * @param contentId
     * @param oldFragment
     * @param newFragment
     */
    public static void replaceFragment(FragmentManager fragmentManager, int contentId, Fragment oldFragment, Fragment newFragment) {
        FragmentTransaction transaction = getAnimorTransaction(fragmentManager);
        transaction.hide(oldFragment);
        transaction.add(contentId, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * 不需要保存视状态
     *
     * @param fragmentManager
     * @param contentId
     * @param newFragment
     * @param addToBackStack
     */
    public static void replaceFragment(FragmentManager fragmentManager, int contentId, Fragment newFragment, boolean addToBackStack) {
        FragmentTransaction transaction = getAnimorTransaction(fragmentManager);
        transaction.replace(contentId, newFragment, newFragment.getClass().getSimpleName());
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


    public static FragmentTransaction getAnimorTransaction(FragmentManager fragmentManager) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(
                R.animator.fragment_slide_left_enter,
                R.animator.fragment_slide_left_exit,
                R.animator.fragment_slide_right_enter,
                R.animator.fragment_slide_right_exit);
        return transaction;
    }
}
