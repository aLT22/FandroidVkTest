package com.bytebuilding.fandroidvktest.common.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import com.bytebuilding.fandroidvktest.ui.activity.BaseActivity;
import com.bytebuilding.fandroidvktest.ui.fragment.BaseFragment;

import java.util.Stack;

/**
 * Created by Turkin A. on 23.10.17.
 */

public class MyFragmentManager {

    public static final int EMPTY_FRAGMENT_STACK_SIZE = 1;

    private BaseFragment mCurrentFragment;
    private Stack<BaseFragment> mBackStack = new Stack<>();

    private FragmentTransaction createAddTransaction(BaseActivity activity,
                                                     BaseFragment fragment,
                                                     boolean addToBackStack) {
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(fragment.getTag());
        }

        return transaction;
    }

    private void commitAddTransaction(BaseActivity activity,
                                      BaseFragment fragment,
                                      FragmentTransaction transaction,
                                      boolean addToBackStack) {
        if (transaction != null) {
            mCurrentFragment = fragment;

            if (!addToBackStack) {
                mBackStack.clear();
            }

            mBackStack.add(fragment);
        }

        commitTransaction(activity, transaction);
    }

    private void commitTransaction(BaseActivity activity, FragmentTransaction transaction) {
        transaction.commit();

        activity.fragmentOnScreen(mCurrentFragment);
    }

    public boolean isAlreadyContains(BaseFragment fragment) {
        if (fragment == null) {
            return false;
        }

        return mCurrentFragment != null
                && mCurrentFragment.getClass().getName().equals(fragment.getClass().getName());
    }

    public void setFragment(BaseActivity activity,
                            BaseFragment fragment,
                            @IdRes int containerId) {
        if (activity != null
                && !activity.isFinishing()
                && !isAlreadyContains(fragment)) {
            FragmentTransaction transaction = createAddTransaction(activity, fragment, false);
            transaction.add(containerId, fragment);
            commitAddTransaction(activity, fragment, transaction, false);
        }
    }

    public void addFragment(BaseActivity activity,
                            BaseFragment fragment,
                            @IdRes int containerId) {
        if (activity != null
                && !activity.isFinishing()
                && isAlreadyContains(fragment)) {
            FragmentTransaction transaction = createAddTransaction(activity, fragment, true);
            transaction.add(containerId, fragment);
            commitAddTransaction(activity, fragment, transaction, true);
        }
    }

    public boolean removeFragment(BaseActivity activity, BaseFragment fragment) {
        boolean canRemove = fragment != null && mBackStack.size() > EMPTY_FRAGMENT_STACK_SIZE;

        if (canRemove) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

            mBackStack.pop();
            mCurrentFragment = mBackStack.lastElement();

            transaction.remove(fragment);
            commitTransaction(activity, transaction);
        }

        return canRemove;
    }

    public boolean removeCurrentFragment(BaseActivity activity) {
        return removeFragment(activity, mCurrentFragment);
    }

}
