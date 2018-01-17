package com.nsun.tiwall.tiwallandroidsdk.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nsun.tiwall.tiwallandroidsdk.R;

import java.util.ArrayList;
import java.util.List;

import models.PageModel;

/**
 * Created by 110 on 14/01/2018.
 */

public class newsArrayAdapter extends ArrayAdapter<PageModel> {
    private Context context;
    private ArrayList<PageModel> newsArrayList;
    private static LayoutInflater inflater = null;

    public newsArrayAdapter(Context context, int resource, ArrayList<PageModel> newsArrayList) {
        super(context, resource, newsArrayList);
        try {
            this.context = context;
            this.newsArrayList = newsArrayList;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e) {

        }
    }
    public int getCount() {
        return newsArrayList.size();
    }

    public PageModel getItem(PageModel position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolder {
        public TextView title;
        public TextView rootitr;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;

        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.news_adapter, null);
                holder = new ViewHolder();
                holder.title = (TextView) vi.findViewById(R.id.title_id);
                holder.rootitr = (TextView) vi.findViewById(R.id.rootitr_id);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

            holder.title.setText("tilte:" + newsArrayList.get(position).title);
           // holder.rootitr.setText(newsArrayList.get(position).urn);




        } catch (Exception e) {

        }
        return vi;
    }

}
