package com.yuhj.androidutilcode.activities;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yuhj.androidutilcode.R;
import com.yuhj.utilcode.utils.CleanUtils;

import java.io.File;


public class CleanActivity extends Activity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);

        Button btnCleanInternalCache = (Button) findViewById(R.id.btn_clean_internal_cache);
        Button btnCleanInternalFiles = (Button) findViewById(R.id.btn_clean_internal_files);
        Button btnCleanInternalDbs = (Button) findViewById(R.id.btn_clean_internal_databases);
        Button btnCleanInternalSP = (Button) findViewById(R.id.btn_clean_internal_sp);
        Button btnCleanExternalCache = (Button) findViewById(R.id.btn_clean_external_cache);

        btnCleanInternalCache.setOnClickListener(this);
        btnCleanInternalFiles.setOnClickListener(this);
        btnCleanInternalDbs.setOnClickListener(this);
        btnCleanInternalSP.setOnClickListener(this);
        btnCleanExternalCache.setOnClickListener(this);

        btnCleanInternalCache.setText(getCacheDir().getPath());
        btnCleanInternalFiles.setText(getFilesDir().getPath());
        btnCleanInternalDbs.setText(getFilesDir().getParent() + File.separator + "databases");
        btnCleanInternalSP.setText(getFilesDir().getParent() + File.separator + "shared_prefs");
        btnCleanExternalCache.setText(getExternalCacheDir().getPath());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_internal_cache:
                Log.d("cleanInternalCache", "" + CleanUtils.cleanInternalCache());
                break;
            case R.id.btn_clean_internal_files:
                Log.d("cleanInternalFiles", "" + CleanUtils.cleanInternalFiles());
                break;
            case R.id.btn_clean_internal_databases:
                Log.d("cleanInternalDbs", "" + CleanUtils.cleanInternalDbs());
                break;
            case R.id.btn_clean_internal_sp:
                Log.d("cleanInternalSP", "" + CleanUtils.cleanInternalSP());
                break;
            case R.id.btn_clean_external_cache:
                Log.d("cleanExternalCache", "" + CleanUtils.cleanExternalCache());
                break;
        }
    }
}
