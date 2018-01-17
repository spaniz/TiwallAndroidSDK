package com.nsun.tiwall.tiwallandroidsdk;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nsun.tiwall.tiwallandroidsdk.Adapter.newsArrayAdapter;

import java.util.ArrayList;

import agents.PageAgent;
import models.EventSpecModel;
import models.PageModel;
import models.PageSpecModel;
import params.PageDetailParams;
import params.PageListParams;
import params.PaginationParams;

public class MainActivity extends AppCompatActivity {
    public Context context;
    public PageAgent pageAgent;
    ListView listView;
    newsArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        pageAgent = new PageAgent(context, new PageAgent.TaskListener() {
            @Override
            public void onFinished(final ArrayList<PageModel> pageList) {
                Log.e("dataList", pageList.toString());
                arrayAdapter = new newsArrayAdapter(MainActivity.this, 0, pageList);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(), pageList.get(position).title, Toast.LENGTH_SHORT).show();
                        EventSpecModel test=  (EventSpecModel) pageList.get(position).spec;
                          Log.i("titleee", "title" + test.start_date );
                    }
                });
            }

            @Override
            public void onFinished(PageModel page) {

            }
        });
        pageAgent.get(new PaginationParams(20, 1), new PageListParams(1));
        // pageAgents.get(new PageDetailParams(19529));
    }
    private void initView(){
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        listView = (ListView) findViewById(R.id.newslst);
    }
}
