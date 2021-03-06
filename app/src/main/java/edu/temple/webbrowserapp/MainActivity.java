package edu.temple.webbrowserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PageControlFragment.pageViewerInterface,
        PageViewerFragment.pageViewerInterface{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    PageControlFragment pageControlFragment;
    PageViewerFragment pageViewerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageControlFragment = new PageControlFragment();
        pageViewerFragment = new PageViewerFragment();

        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(!(getSupportFragmentManager().findFragmentById(R.id.page_control) instanceof PageControlFragment))
        {
            fragmentTransaction.add(R.id.page_control,pageControlFragment);
        }
        if(!(getSupportFragmentManager().findFragmentById(R.id.page_viewer) instanceof PageViewerFragment))
        {
            fragmentTransaction.add(R.id.page_viewer,pageViewerFragment);
        }


        fragmentTransaction.commit();
    }

    @Override
    public void forwardButtonClick() {
        //
        pageViewerFragment.forwardButtonPressed();
    }

    @Override
    public void backButtonClick() {
        //
        pageViewerFragment.backButtonPressed();
    }

    @Override
    public void searchButtonClick() {
        //
        String urlString =  pageControlFragment.getURLString();
        pageViewerFragment.loadPage(urlString);
    }

    @Override
    public void pageChanged() {
        //
        String urlString =  pageViewerFragment.getURL();
        pageControlFragment.setText(urlString);
    }


}