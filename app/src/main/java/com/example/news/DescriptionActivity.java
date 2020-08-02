package com.example.news;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        webView = findViewById(R.id.webView);

        Bundle bundle = getIntent().getExtras();
        webView.loadUrl(bundle.getString("url"));
    }
}