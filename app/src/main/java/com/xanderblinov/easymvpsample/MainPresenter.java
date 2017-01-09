package com.xanderblinov.easymvpsample;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import easymvp.AbstractPresenter;

/**
 * Date: 09/01/17
 *
 * @author Alexander Blinov
 */

class MainPresenter extends AbstractPresenter<MainView> {

    private static String TAG = "MainPresenter";

    public MainPresenter() {

        new Handler(Looper.getMainLooper()).postDelayed(new MainRunnable(0), 1000);
    }

    private class MainRunnable implements Runnable {

        int mCount;

        MainRunnable(int count) {
            mCount = count;
        }

        @Override
        public void run() {
            Log.e(TAG, "view attached : " + isViewAttached());
            MainView view = getView();

            if (view == null) {
                Log.e(TAG, "CAN NOT execute on null view");
                return;
            }

            view.showResult(String.valueOf(mCount));

            new Handler(Looper.getMainLooper()).postDelayed(new MainRunnable(mCount + 1), 1000);
        }
    }
}
