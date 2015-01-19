package com.contacts.test.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.contacts.test.contacts.R;

import java.util.LinkedHashMap;

/**
 * Created by nirajkumar.chauhan on 1/19/2015.
 */
public class SkillInfoAdapter extends BaseAdapter {
    private LinkedHashMap<String, String> mData = new LinkedHashMap<String,String>();
    private String[] mKeys;
    Context context;

    public SkillInfoAdapter(LinkedHashMap<String, String> mData,Context context) {
        this.mData = mData;
        this.mKeys =mData.keySet().toArray(new String[mData.size()]);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String key = mKeys[position];
        LayoutInflater inflator = ((Activity)context).getLayoutInflater();
        convertView = inflator.inflate(R.layout.activity_skill_info_item,parent,false);
        TextView skillName = (TextView)convertView.findViewById(R.id.skillName);
        skillName.setText(key.toUpperCase());

        return convertView;
    }
}
