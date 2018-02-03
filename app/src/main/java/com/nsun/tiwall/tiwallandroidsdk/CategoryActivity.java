package com.nsun.tiwall.tiwallandroidsdk;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import agents.CategoryAgent;
import models.CategoryModel;
import params.CategoryListParams;

/**
 * Created by Farzane on 1/17/2018.
 */

public class CategoryActivity extends AppCompatActivity {
    public Context context;
    public CategoryAgent categoryAgent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        categoryAgent=new CategoryAgent(context, new CategoryAgent.TaskListener() {
            @Override
            public void onFinished(ArrayList<CategoryModel> categoryModel) {
                Log.i("category:", categoryModel.get(0).text);
            }
        });
        categoryAgent.get(new CategoryListParams("ticket_store"));
    }

    private void initView(){
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

    }
}
