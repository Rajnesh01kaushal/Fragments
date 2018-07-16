package com.example.hp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {

    TextView article;
    String news;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.article_frag,container,false);

        article = view.findViewById(R.id.fragment2);

//

        Bundle bundle=getArguments();
        news=bundle.getString("news");
        article.setText(news);

        return view;
    }
}
