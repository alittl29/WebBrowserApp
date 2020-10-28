package edu.temple.webbrowserapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;


public class PageViewerFragment extends Fragment {

    View l;
    Context context;
    WebView webView;
    pageViewerInterface parentActivity;
    WebViewClient webclient;
    public PageViewerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof pageViewerInterface)
        {
            parentActivity = (pageViewerInterface) context;
        }
        else
        {
            throw new RuntimeException("must Implement ItemCLickedInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l =  inflater.inflate(R.layout.fragment_page_viewer, container, false);

        context = l.getContext();
        webView = l.findViewById(R.id.myWebView);
        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });


        return l;
    }




    public String getURL()
    {
        String urlString =  webView.getUrl();
        return urlString;
    }

    public void loadPage(String urlString)
    {
        if(!urlString.contains("https://"))
        {
            String urlFixed = "https://" + urlString;
            urlString = urlFixed;
        }

        try {
            URL url = new URL(urlString);
            webView.loadUrl(url.toString());
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    return super.shouldOverrideUrlLoading(view, request);
                }
            });
            parentActivity.pageChanged();
        }
        catch (MalformedURLException e)
        {
            Toast.makeText(context,"Invalid URL",Toast.LENGTH_SHORT).show();
        }
    }

    public void backButtonPressed()
    {
        if(webView.canGoBack())
        {
            webView.goBack();
        }

    }
    public void forwardButtonPressed()
    {
        if(webView.canGoForward())
        {
            webView.goForward();
        }

    }

    interface pageViewerInterface
    {
        void pageChanged();
    }
}