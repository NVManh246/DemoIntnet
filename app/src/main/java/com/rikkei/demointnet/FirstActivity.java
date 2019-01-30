package com.rikkei.demointnet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int URL_REQUEST_CODE = 111;

    private TextView tvUrl;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {
        findViewById(R.id.button_input_url).setOnClickListener(this);
        findViewById(R.id.button_open_url).setOnClickListener(this);
        tvUrl = findViewById(R.id.text_url);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == URL_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            url = data.getStringExtra(SecondActivity.EXTRA_URL);
            tvUrl.setText(url);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_input_url:
                Intent intent = SecondActivity.getSecondIntent(this);
                startActivityForResult(intent, URL_REQUEST_CODE);
                break;
            case R.id.button_open_url:
                openBrowser(url);
                break;
        }
    }

    private void openBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(url));
        startActivity(browserIntent);
    }
}
