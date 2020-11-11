package edu.temple.webbrowserapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PagerFragment extends Fragment{

    View l;
    Context context;
    ViewPager viewPager;
    ArrayList<PageViewerFragment> arrayList;

    public PagerFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       l = inflater.inflate(R.layout.fragment_pager_frament, container, false);

       context = l.getContext();
       arrayList = new ArrayList<>();
       viewPager = l.findViewById(R.id.viewPager);

       viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
           @NonNull
           @Override
           public Fragment getItem(int position) {
               return arrayList.get(position);
           }

           @Override
           public int getCount() {
               return arrayList.size();
           }
       });


       return l;
    }

    public void addPage()
    {
        arrayList.add(new PageViewerFragment());
        viewPager.getAdapter().notifyDataSetChanged();

    }

    public String getURL()
    {
        return arrayList.get(viewPager.getCurrentItem()).getURL();
    }

    public void loadPage(String URL)
    {
        arrayList.get(viewPager.getCurrentItem()).loadPage(URL);
    }

    public void backButtonPressed()
    {
        arrayList.get(viewPager.getCurrentItem()).backButtonPressed();
    }

    public void forwardButtonPressed()
    {
        arrayList.get(viewPager.getCurrentItem()).forwardButtonPressed();
    }
}