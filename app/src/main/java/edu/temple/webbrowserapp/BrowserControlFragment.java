package edu.temple.webbrowserapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;

public class BrowserControlFragment extends Fragment {
    View l;
    ImageButton imageButton;
    browserControlInterface parentActivity;

    public BrowserControlFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof BrowserControlFragment.browserControlInterface)
        {
            parentActivity = (BrowserControlFragment.browserControlInterface) context;
        }
        else
        {
            throw new RuntimeException("must Implement BrowserControlInterface");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_browser_control, container, false);

        imageButton = l.findViewById(R.id.btnNewPage);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            parentActivity.pageAdded();
            }
        });

        return l;
    }

    interface browserControlInterface
    {
        void pageAdded();
    }
}