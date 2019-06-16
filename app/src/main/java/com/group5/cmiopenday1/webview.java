package com.group5.cmiopenday1;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class webview extends menu_Activity {

    ProgressBar superProgressBar;
    ImageView superImageView;
    WebView superWebView;
    LinearLayout superLinearLayout;
    SwipeRefreshLayout superSwipeLayout;
    String myCurrentPage;

    @SuppressLint("SetJavaScriptEnabled")

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);

        superSwipeLayout = findViewById(R.id.mySwapLayout);
        superLinearLayout = findViewById(R.id.myLinearLayout);
        superProgressBar = findViewById(R.id.myProgressBar);
        superImageView = findViewById(R.id.myImageView);
        superWebView = findViewById(R.id.myWebView);

        superProgressBar.setMax(100);

        superWebView.loadUrl("https://www.hogeschoolrotterdam.nl/samenwerking/instituten/instituut-voor-communicatie-media-en-informatietechnologie/introductie/");
        superWebView.getSettings().setJavaScriptEnabled(true);
        superWebView.setWebViewClient(new WebViewClient(){


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                superLinearLayout.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                superLinearLayout.setVisibility(View.GONE);
                superSwipeLayout.setRefreshing(false);
                super.onPageFinished(view, url);
                myCurrentPage = url;
            }
        });
        superWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                superProgressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                superImageView.setImageBitmap(icon);
            }
        });

        superSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                superWebView.reload();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.webview_super_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_back:
                onBackPressed();
                break;

            case R.id.menu_forward:
                onForwardPressed();
                break;

            case R.id.menu_refresh:
                superWebView.reload();
                break;
            case R.id.menu_exit:
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }



    public void onForwardPressed(){
        if(superWebView.canGoForward()){
            superWebView.goForward();
        } else{
            Toast.makeText(this,"kan niet verder!",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed(){
        if(superWebView.canGoBack()){
            superWebView.goBack();
        } else{
            finish();
        }
    }
}
