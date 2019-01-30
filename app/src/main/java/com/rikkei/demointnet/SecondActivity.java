package com.rikkei.demointnet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_URL = "url";

    private EditText etUrl;

    public static Intent getSecondIntent(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        etUrl = findViewById(R.id.edit_url);
        findViewById(R.id.button_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String url = etUrl.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_URL, url);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
