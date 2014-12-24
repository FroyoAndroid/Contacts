package com.contacts.test.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nirajkumar.chauhan on 12/24/2014.
 */
public class RatingAdapter extends ArrayAdapter<Skill> {

    Context context;
    List<Skill> listSkill;
    int layoutResource;

    public RatingAdapter(Context context, int resource, List<Skill> objects) {
        super(context, resource, objects);
        this.context = context;
        this.listSkill = objects;
        this.layoutResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        if(convertView == null){
            //inflate  the layout
            LayoutInflater infaltor = ((Activity) context).getLayoutInflater();
            convertView = infaltor.inflate(layoutResourceID, parent, false);
        }
        Skill itemSkill = listSkill.get(position);
        TextView pupilName = (TextView)convertView.findViewById(R.id.skillListViewItemName);
        RatingBar skillRating = (RatingBar)convertView.findViewById(R.id.ratingBar);

    }
}
