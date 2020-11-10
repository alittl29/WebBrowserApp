package edu.temple.webbrowserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PageControlFragment.pageViewerInterface,
        BrowserControlFragment.browserControlInterface, PageViewerFragment.pageViewerInterface {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    PageControlFragment pageControlFragment;
    PagerFragment pagerFragment;
    BrowserControlFragment browserControlFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageControlFragment = new PageControlFragment();
        pagerFragment = new PagerFragment();
        browserControlFragment = new BrowserControlFragment();

        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(!(getSupportFragmentManager().findFragmentById(R.id.page_control) instanceof PageControlFragment))
        {
            fragmentTransaction.add(R.id.page_control,pageControlFragment);
        }
        if(!(getSupportFragmentManager().findFragmentById(R.id.page_viewer) instanceof PagerFragment))
        {
            fragmentTransaction.add(R.id.page_viewer,pagerFragment);
        }
        if(!(getSupportFragmentManager().findFragmentById(R.id.browser_control) instanceof BrowserControlFragment))
        {
            fragmentTransaction.add(R.id.browser_control,browserControlFragment);
        }


        fragmentTransaction.commit();
    }

    @Override
    public void forwardButtonClick() {
        //
        //pageViewerFragment.forwardButtonPressed();
    }

    @Override
    public void backButtonClick() {
        //
       // pageViewerFragment.backButtonPressed();
    }

    @Override
    public void searchButtonClick() {
        //
        String urlString =  pageControlFragment.getURLString();
       // pageViewerFragment.loadPage(urlString);
    }


    @Override
    public void pageAdded() {
        //
        pagerFragment.addPage();
    }

    @Override
    public void pageChanged() {

    }
}