package edu.temple.webbrowserapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class PageViewerFragment extends Fragment {

    View l;
    WebView webView;

    public PageViewerFragment() {
        // Required empty public constructor
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
        webView = l.findViewById(R.id.myWebView);
        webView.loadUrl("https://www.google.com");

        return l;
    }
}