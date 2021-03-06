package com.xanderblinov.easymvpsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

@ActivityView(layout = R.layout.activity_main, presenter = MainPresenter.class)
public class MainActivity extends AppCompatActivity implements MainView {

    private static String TAG = "MainActivity";

    @Presenter
    MainPresenter mMainPresenter;

    @Override
    public void showResult(final String resultText) {
        Log.e(TAG, "RESULT: " + resultText);
    }

    @Override
    public void showError(final String errorText) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.activity_main_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "OnStart: mMainPresenter = " + mMainPresenter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "OnStop: mMainPresenter = " + mMainPresenter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: isFinishing = " + isFinishing());
    }
}
