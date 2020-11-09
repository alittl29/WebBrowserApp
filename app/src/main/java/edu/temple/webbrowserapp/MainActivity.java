package edu.temple.webbrowserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PageControlFragment.pageViewerInterface {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    PageControlFragment pageControlFragment;
    PagerFragment pagerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageControlFragment = new PageControlFragment();
        pagerFragment = new PagerFragment();

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



}