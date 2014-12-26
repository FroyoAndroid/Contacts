package com.contacts.test.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.contacts.test.util.Pupil;
import com.contacts.test.util.RatingAdapter;
import com.contacts.test.util.RatingHashMapAdapter;
import com.contacts.test.util.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nirajkumar.chauhan on 12/24/2014.
 */
public class SkillActivitySecond extends Activity {
    Spinner spinnerPupil;
    List<Pupil> listPupil;
    List<String> listPupilName;
    ListView skilListView;
    Skill object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_skills_second);
        spinnerPupil = (Spinner) findViewById(R.id.spinnerPupil);
        skilListView = (ListView)findViewById(R.id.ratingList);
        listPupil = new ArrayList<Pupil>();
        listPupil = Pupil.listAll(Pupil.class);
        List<String> list = new ArrayList<String>();
        for(int i=0;i<listPupil.size();i++){
            list.add(listPupil.get(i).getName());
        }
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinnerPupil.setAdapter(myAdapter);
        object = listPupil.get(0).getSkill();
        HashMap<String,Integer> skill = new HashMap<String,Integer>();
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
       /* RatingAdapter adapter = new RatingAdapter(this,R.layout.rating_skill_item,listPupil.get(0).getSkill());
        skilListView.setAdapter(adapter);*/
        RatingHashMapAdapter adapter = new RatingHashMapAdapter(this,skill);
        skilListView.setAdapter(adapter);
    }
}
