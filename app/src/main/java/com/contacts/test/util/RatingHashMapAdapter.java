package com.contacts.test.util;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.contacts.test.contacts.R;
import com.contacts.test.contacts.SkillActivitySecond;

import java.util.LinkedHashMap;

/**
 * Created by nirajkumar.chauhan on 12/26/2014.
 */
public class RatingHashMapAdapter extends BaseAdapter {
    private LinkedHashMap<String, Integer> mData = new LinkedHashMap<String, Integer>();
    private String[] mKeys;
    Context mContext;

    public RatingHashMapAdapter(Context pContext, LinkedHashMap<String,Integer> data){
        mData = data;
        mKeys = mData.keySet().toArray(new String[data.size()]);
        mContext = pContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(mKeys[position]);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public LinkedHashMap<String, Integer> getHashMap(){
      return  mData;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String key = mKeys[position];
        float ratingValue = Float.parseFloat(getItem(position).toString());
        /*Log.d("Value",ratingValue+"");*/
        LayoutInflater inflator = ((Activity) mContext).getLayoutInflater();
        convertView = inflator.inflate(R.layout.rating_skill_item, parent, false);
        TextView tvskillName = (TextView)convertView.findViewById(R.id.skillListViewItemName);
        tvskillName.setText(key.toUpperCase());
        RatingBar skillRating = (RatingBar)convertView.findViewById(R.id.ratingBar);
        skillRating.setRating(ratingValue);
        skillRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mData.put(mKeys[position],Math.round(rating));
            }
        });
        return convertView;
    }
}
