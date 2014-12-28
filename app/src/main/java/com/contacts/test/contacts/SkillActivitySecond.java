package com.contacts.test.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    RatingHashMapAdapter adapter;
    Spinner spinnerPupil;
    List<Pupil> listPupil;
    List<String> listPupilName;
    ListView skilListView;
    Button saveData;
    Skill object;
    Pupil currentPupil;
    HashMap<String,Integer> skill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_skills_second);
        spinnerPupil = (Spinner) findViewById(R.id.spinnerPupil);
        skilListView = (ListView)findViewById(R.id.ratingList);
        saveData = (Button) findViewById(R.id.btnSaveData);
        listPupil = new ArrayList<Pupil>();
        listPupil = Pupil.listAll(Pupil.class);
        List<String> list = new ArrayList<String>();
        for(int i=0;i<listPupil.size();i++){
            list.add(listPupil.get(i).getName());
        }
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinnerPupil.setAdapter(myAdapter);
        //current object of the selected person skill
        object = listPupil.get(0).getSkill();
        currentPupil = listPupil.get(0);

        skill = new HashMap<String,Integer>();
       /* skill = getCurrentHashMap(object);*/
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
        adapter = new RatingHashMapAdapter(this,skill);
        skilListView.setAdapter(adapter);

        /**
         *Spinner onItemClickListener
         */


        /**
         * spinner on item selected listener
         */
        spinnerPupil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                object = listPupil.get(position).getSkill();
                currentPupil = listPupil.get(position);
                skill = getCurrentHashMap(object);
                adapter = new RatingHashMapAdapter(SkillActivitySecond.this,skill);
                skilListView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * Save data click listener;
         */
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skill = adapter.getHashMap();
                object.setBayParking(skill.get("Bay Parking"));
                object.setCockpitDrill(skill.get("Cockpit Drill"));
                object.setCrossroads(skill.get("Crossroads"));
                object.setDefensiveDriving(skill.get("Defensive Driving"));
                object.setDualCarriageways(skill.get("Dual Carriageways"));
                object.setEcoDriving(skill.get("Eco Driving"));
                object.setLeftReverse(skill.get("Left Reverse"));
                object.setEmergencyStop(skill.get("Emergency Stop"));
                object.setMockTests(skill.get("Mock Tests"));
                object.setMeetingSituations(skill.get("Meeting Situations"));
                object.setMovingAway(skill.get("Moving Away"));
                object.setShowAndTell(skill.get("Show Tell"));
                object.setOneWayStreets(skill.get("One Way Streets"));
                object.setParallelParking(skill.get("Parallel Parking"));
                object.setRoundabouts(skill.get("Round Abouts"));
                object.setPedestarianCrossing(skill.get("Pedestarian Crossing"));
                object.setStopping(skill.get("Stopping"));
                object.setTurningRight(skill.get("Turning Right"));
                object.setTurningLeft(skill.get("Turning Left"));
                object.settJunction(skill.get("T Junction"));
                object.setUsingMirrors(skill.get("Using Mirrors"));
                object.setTurnInTheRoad(skill.get("Turn In The Road"));
                object.save();

            }
        });


    }
    
    public HashMap<String , Integer> getCurrentHashMap(Skill pSkill){
        HashMap<String, Integer> mHashMap = new HashMap<String , Integer>();
        mHashMap.put("Bay Parking", pSkill.getBayParking());
        mHashMap.put("Cockpit Drill", pSkill.getCockpitDrill());
        mHashMap.put("Crossroads", pSkill.getCrossroads());
        mHashMap.put("Defensive Driving", pSkill.getDefensiveDriving());
        mHashMap.put("Dual Carriageways", pSkill.getDualCarriageways());
        mHashMap.put("Eco Driving", pSkill.getEcoDriving());
        mHashMap.put("Left Reverse", pSkill.getLeftReverse());
        mHashMap.put("Emergency Stop", pSkill.getEmergencyStop());
        mHashMap.put("Mock Tests", pSkill.getMockTests());
        mHashMap.put("Meeting Situations", pSkill.getMeetingSituations());
        mHashMap.put("Moving Away", pSkill.getMovingAway());
        mHashMap.put("Show Tell", pSkill.getShowAndTell());
        mHashMap.put("One Way Streets", pSkill.getOneWayStreets());
        mHashMap.put("Parallel Parking", pSkill.getParallelParking());
        mHashMap.put("Round Abouts", pSkill.getRoundabouts());
        mHashMap.put("Pedestarian Crossing", pSkill.getPedestarianCrossing());
        mHashMap.put("Stopping", pSkill.getStopping());
        mHashMap.put("Turning Right", pSkill.getTurningRight());
        mHashMap.put("Turning Left", pSkill.getTurningLeft());
        mHashMap.put("T Junction", pSkill.gettJunction());
        mHashMap.put("Using Mirrors", pSkill.getUsingMirrors());
        mHashMap.put("Turn In The Road", pSkill.getTurnInTheRoad());
        return  mHashMap;
    }
}
