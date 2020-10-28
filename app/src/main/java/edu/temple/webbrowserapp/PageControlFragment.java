package edu.temple.webbrowserapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class PageControlFragment extends Fragment {

    View l;
    Context context;
    pageViewerInterface parentActivity;
    ImageButton backButton;
    ImageButton forwardButton;
    ImageButton searchButton;
    TextView searchBox;

    public PageControlFragment() {
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
        l = inflater.inflate(R.layout.fragment_page_control, container, false);

        context = l.getContext();
        forwardButton = l.findViewById(R.id.btnForward);
        backButton = l.findViewById(R.id.btnBack);
        searchButton = l.findViewById(R.id.btnSearch);
        searchBox = l.findViewById(R.id.txtSearch);

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentActivity.forwardButtonClick();
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentActivity.backButtonClick();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentActivity.searchButtonClick();
            }
        });


        return l;
    }

    public String getURLString()
    {
        String urlString;

            urlString = searchBox.getText().toString();

        return urlString;
    }

    public void setText(String theURL)
    {
        searchBox.setText(theURL);
    }

    interface pageViewerInterface
    {
        void forwardButtonClick();
        void backButtonClick();
        void searchButtonClick();

    }

}