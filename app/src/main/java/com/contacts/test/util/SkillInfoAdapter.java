package com.contacts.test.util;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
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
    Context mContext;
    LayoutInflater inflator;

    public SkillInfoAdapter(LinkedHashMap<String, String> mData, Context mContext) {
        this.mData = mData;
        this.mKeys =  mData.keySet().toArray(new String[mData.size()]);
        this.mContext = mContext;
        inflator = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;
        if(convertView == null){
            convertView = inflator.inflate(R.layout.activity_skill_info_item,null);
            mViewHolder = new MyViewHolder();
            convertView.setTag(mViewHolder);
        }else{
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        mViewHolder.skillName = (TextView) convertView.findViewById(R.id.skillName);
        String pattern = "(\\w)(\\s+)([\\.,])";
        mViewHolder.skillName.setText(mKeys[position].toUpperCase());
        return convertView;
    }

    private static class MyViewHolder{
        TextView skillName;
    }
}
