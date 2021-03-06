package chart.qing.com.lightui.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by dell on 2016/9/12.
 */
public class MyWebClient extends WebViewClient {
    private Activity context;
    private LightWebView.WebViewPageFinished callback;
    public MyWebClient(Activity context, LightWebView.WebViewPageFinished callback){
        this.context=context;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("tel:")){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
            return true;
        }
        return super.shouldOverrideUrlLoading(view,url);

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if(callback!=null){
            callback.onFinished(view, url);
        }
        super.onPageFinished(view, url);
    }
}
