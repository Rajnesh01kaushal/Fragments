package com.example.hp.fragments;


import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONObject;

import java.io.InputStream;

import static com.example.hp.fragments.R.id.fragment2;
import static com.example.hp.fragments.R.id.home;

public class MainActivity extends AppCompatActivity {

    String headline,news;
    Fragment HeadlineFragment,Article;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.news_article);

        

        String json = null;
        try{

            InputStream is = getApplication().getAssets().open("news.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
            Log.d("TEST",json);
            JSONObject object = new JSONObject(json);
            headline=object.getString("headline");
            news=object.getString("news");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        HeadlineFragment headlineFragments =new HeadlineFragment();
        Bundle bundle = new Bundle();
        bundle.putString("headline",headline);
        headlineFragments.setArguments(bundle);


        FragmentManager fragmentManager =getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.fragment, headlineFragments).commit();

        headlineFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArticleFragment articleFragments =new ArticleFragment();
                Bundle bundle=new Bundle();
                bundle.putString("news",news);
                articleFragments.setArguments(bundle);
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment2,articleFragments).commit();

            }
        });
    }
}
