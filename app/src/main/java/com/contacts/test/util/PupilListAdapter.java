package com.contacts.test.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.contacts.test.contacts.R;

import java.util.List;

/**
 * Created by CHAUHAN on 12/20/14.
 */
public class PupilListAdapter extends ArrayAdapter<Pupil> {

    Context context;
    List<Pupil> pupil;
    ;
    int layoutResourceID;

    public PupilListAdapter(Context context, int resource, List<Pupil> objects) {
        super(context, resource, objects);
        this.context = context;
        this.pupil = objects;
        this.layoutResourceID = resource;
    }

    @Override
    public Pupil getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        if (convertView == null) {
            //inflate the layout
            LayoutInflater infaltor = ((Activity) context).getLayoutInflater();
            convertView = infaltor.inflate(layoutResourceID, parent, false);
        }
        Pupil obj = pupil.get(position);
        TextView textView = (TextView) convertView.findViewById(R.id.listitemTextView);
        ImageButton editButton = (ImageButton) convertView.findViewById(R.id.editButton);
        ImageButton deleteButton = (ImageButton) convertView.findViewById(R.id.deleteButton);
        textView.setText(obj.getName());
        /**
         * setTag is used to passed the object ....
         */
        editButton.setTag(obj);
        deleteButton.setTag(obj);
        return convertView;

    }

}
