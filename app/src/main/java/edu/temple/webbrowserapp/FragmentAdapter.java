package edu.temple.webbrowserapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {


    ArrayList<PageViewerFragment> arrayList;

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<PageViewerFragment> arrayList) {
        super(fragmentManager, lifecycle);

        this.arrayList = arrayList;
    }

    public void addFragment(PageViewerFragment fragment)
    {
        arrayList.add(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
