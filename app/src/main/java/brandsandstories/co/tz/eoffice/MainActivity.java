package brandsandstories.co.tz.eoffice;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
//import android.support.v4.widget.SwipeRefreshLayout;

public class MainActivity extends Activity {

    private SwipeRefreshLayout swipeRefresh;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.eOfficeWebView);
        webView.setWebViewClient(new WebClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("http://brandsandstories.co.tz/eoffice/");

        //response to refresh gestures
        swipeRefresh = findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageUpdate();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(swipeRefresh.isRefreshing()) {
                            swipeRefresh.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });

    }

    //operation to to refresh gestures
    public void pageUpdate() {
            webView.loadUrl("http://brandsandstories.co.tz/eoffice/");

    }


    private class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


    }



}

