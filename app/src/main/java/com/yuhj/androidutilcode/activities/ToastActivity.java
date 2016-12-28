package com.yuhj.androidutilcode.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yuhj.androidutilcode.R;
import com.yuhj.utilcode.utils.ToastUtils;

public class ToastActivity extends Activity
        implements View.OnClickListener {

    private boolean  isJumpWhenMore;
    private TextView tvAboutToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        isJumpWhenMore = false;

        tvAboutToast = (TextView) findViewById(R.id.tv_about_toast);

        findViewById(R.id.btn_is_jump_when_more).setOnClickListener(this);
        findViewById(R.id.btn_show_short_toast_safe).setOnClickListener(this);
        findViewById(R.id.btn_show_long_toast_safe).setOnClickListener(this);
        findViewById(R.id.btn_show_short_toast).setOnClickListener(this);
        findViewById(R.id.btn_show_long_toast).setOnClickListener(this);
        findViewById(R.id.btn_cancel_toast).setOnClickListener(this);

        tvAboutToast.setText(String.format("Is Jump When More: %b", isJumpWhenMore));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_is_jump_when_more:
                ToastUtils.init(isJumpWhenMore = !isJumpWhenMore);
                break;
            case R.id.btn_show_short_toast_safe:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showShortToastSafe("show_short_toast_safe");
                    }
                }).start();
                break;
            case R.id.btn_show_long_toast_safe:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showLongToastSafe("show_long_toast_safe");
                    }
                }).start();
                break;
            case R.id.btn_show_short_toast:
                ToastUtils.showShortToast("show_short_toast");
                break;
            case R.id.btn_show_long_toast:
                ToastUtils.showShortToast("show_long_toast");
                break;
            case R.id.btn_cancel_toast:
                ToastUtils.cancelToast();
                break;
        }
        tvAboutToast.setText(String.format("Is Jump When More: %b", isJumpWhenMore));
    }
}
