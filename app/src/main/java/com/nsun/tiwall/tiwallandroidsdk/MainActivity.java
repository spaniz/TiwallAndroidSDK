package com.nsun.tiwall.tiwallandroidsdk;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import agents.newsAgent;
import models.News;

public class MainActivity extends AppCompatActivity {
    public Context context;
    public newsAgent newsAgents;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getApplicationContext();
        textView=(TextView)findViewById(R.id.texttest);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newsAgents=new newsAgent(getApplicationContext(), new newsAgent.TaskListener() {
                    @Override
                    public void onFinished(News news) {

                    }
                    @Override
                    public void onFinished(ArrayList<News> newsArrayList) {
                        Log.i("testis", newsArrayList.get(0).title+"*****");
                    }
                });
                newsAgents.getNewsList();
            }
        });


    }
}
