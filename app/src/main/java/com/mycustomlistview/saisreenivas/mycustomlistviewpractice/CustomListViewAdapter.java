package com.mycustomlistview.saisreenivas.mycustomlistviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sai sreenivas on 12/30/2016.
 */

public class CustomListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, String>> books;
    private static LayoutInflater mInflator = null;

    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>> data) {
        mContext = context;
        books = data;
        mInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(convertView == null) {

            view = mInflator.inflate(R.layout.list_row, null);

            TextView title = (TextView) view.findViewById(R.id.row_title);
            TextView author = (TextView) view.findViewById(R.id.row_author);
            TextView pages = (TextView) view.findViewById(R.id.row_pages);
            ImageView image = (ImageView) view.findViewById(R.id.row_image);

            HashMap<String, String> mBook = new HashMap<>();

            mBook = books.get(position);

            title.setText(mBook.get("title"));
            author.setText(mBook.get("author"));
            pages.setText(mBook.get("pages"));
            image.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
        }

        return view;
    }
}
