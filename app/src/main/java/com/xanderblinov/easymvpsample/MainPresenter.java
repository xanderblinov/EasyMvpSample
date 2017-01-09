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

    volatile private boolean mIsAlive = true;

    public MainPresenter() {

        new MainRunnable().start();
    }

    @Override
    public void onViewAttached(final MainView view) {
        super.onViewAttached(view);
        Log.e(TAG, "onViewAttached : " + view);

    }

    @Override
    public void onViewDetached() {
        super.onViewDetached();
        Log.e(TAG, "onViewDetached ");
    }

    @Override
    public void onDestroyed() {
        super.onDestroyed();
        Log.e(TAG, "onDestroyed ");
        mIsAlive = false;

    }

    private class MainRunnable extends Thread {

        int mCount;

        @Override
        public void run() {

            while (mIsAlive) {
                Log.e(TAG, "view attached : " + isViewAttached());
                final MainView view = getView();

                if (view != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            view.showResult(String.valueOf(mCount));
                        }
                    });
                }
                mCount++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {

                }
            }


        }
    }
}
