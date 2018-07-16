package com.example.hp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HeadlineFragment extends Fragment {

    TextView headline;
    String news;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.headline_frag,container,false);

        headline = view.findViewById(R.id.fragment);

        Bundle bundle=getArguments();
        headline.setText ((CharSequence) headline);

        String headline=bundle.getString("headline");

        return view;
    }



    public void setOnClickListener(View.OnClickListener news) {
    }
}
