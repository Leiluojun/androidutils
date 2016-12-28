package com.yuhj.androidutilcode.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.yuhj.androidutilcode.R;
import com.yuhj.utilcode.utils.SDCardUtils;


public class SDCardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);

        TextView tvAboutSdcard = (TextView) findViewById(R.id.tv_about_sdcard);
        tvAboutSdcard.setText("isSDCardEnable: " + SDCardUtils.isSDCardEnable()
               + "\ngetDataPath: " + SDCardUtils.getDataPath()
               + "\ngetSDCardPath: " + SDCardUtils.getSDCardPath()
               + "\ngetFreeSpace: " + SDCardUtils.getFreeSpace()
               + "\ngetSDCardInfo: " + SDCardUtils.getSDCardInfo()
        );
    }
}
