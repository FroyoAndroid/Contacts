package com.contacts.test.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.contacts.test.contacts.R;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by nirajkumar.chauhan on 12/24/2014.
 */
public class RatingAdapter extends BaseAdapter {
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    Context context;
    Skill listSkill;
    int layoutResource;
    HashMap skill;
    String[] skillNames = new String[]{"Bay Parking", "Cockpit Drill", "Crossroads", "Defensive Driving", "Dual Carriageways",
            "Eco Driving", "Left Reverse", "Emergency Stop", "Mock Tests", "Meeting Situations", "Moving Away", "Show Tell",
            "One Way Streets", "Parallel Parking", "Round Abouts", "Pedestarian Crossing", "Stopping", "Turning Right", "Turning Left",
            "T Junction", "Using Mirrors", "Turn In The Road"
    };


    public RatingAdapter(Context context, int resource, Skill object) {
        //super(context, resource, object);
        this.context = context;
        this.listSkill = object;
        this.layoutResource = resource;
        skill = new HashMap();
        skill.put("Bay Parking", object.getBayParking());
        skill.put("Cockpit Drill", object.getCockpitDrill());
        skill.put("Crossroads", object.getCrossroads());
        skill.put("Defensive Driving", object.getDefensiveDriving());
        skill.put("Dual Carriageways", object.getDualCarriageways());
        skill.put("Eco Driving", object.getEcoDriving());
        skill.put("Left Reverse", object.getLeftReverse());
        skill.put("Emergency Stop", object.getEmergencyStop());
        skill.put("Mock Tests", object.getMockTests());
        skill.put("Meeting Situations", object.getMeetingSituations());
        skill.put("Moving Away", object.getMovingAway());
        skill.put("Show Tell", object.getShowAndTell());
        skill.put("One Way Streets", object.getOneWayStreets());
        skill.put("Parallel Parking", object.getParallelParking());
        skill.put("Round Abouts", object.getRoundabouts());
        skill.put("Pedestarian Crossing", object.getPedestarianCrossing());
        skill.put("Stopping", object.getStopping());
        skill.put("Turning Right", object.getTurningRight());
        skill.put("Turning Left", object.getTurningLeft());
        skill.put("T Junction", object.gettJunction());
        skill.put("Using Mirrors", object.getUsingMirrors());
        skill.put("Turn In The Road", object.getTurnInTheRoad());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);


        if(convertView == null){
            //inflate  the layout
            LayoutInflater infaltor = ((Activity) context).getLayoutInflater();
            convertView = infaltor.inflate(layoutResource, parent, false);
        }

        TextView tvskillName = (TextView)convertView.findViewById(R.id.skillListViewItemName);
        tvskillName.setText(skillNames[position].toUpperCase());
        RatingBar skillRating = (RatingBar)convertView.findViewById(R.id.ratingBar);
        skillRating.setRating(Float.parseFloat(skill.get(skillNames[position]).toString()));
        return convertView;
    }
}
