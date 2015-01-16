package com.contacts.test.contacts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.contacts.test.util.Pupil;
import com.contacts.test.util.RatingAdapter;
import com.contacts.test.util.RatingHashMapAdapter;
import com.contacts.test.util.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by nirajkumar.chauhan on 12/24/2014.
 */
public class SkillActivitySecond extends Activity {
    RatingHashMapAdapter adapter;
    Spinner spinnerPupil, testPassed, lessonHad;
    List<Pupil> listPupil;
    List<String> listPupilName;
    ListView skilListView;
    Button saveData;
    Skill object;
    Pupil currentPupil;
    List<String> lessonHadArray;
    ArrayAdapter<String> lessonHadAdapter;
    /* HashMap<String,Integer> skill;*/
    LinkedHashMap<String, Integer> skill;
    ArrayAdapter<CharSequence> testPassedAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_skills_second);
        spinnerPupil = (Spinner) findViewById(R.id.spinnerPupil);
        testPassed = (Spinner) findViewById(R.id.testPassed);
        lessonHad = (Spinner) findViewById(R.id.lessonsHad);
        skilListView = (ListView) findViewById(R.id.ratingList);
        saveData = (Button) findViewById(R.id.btnSaveData);
        listPupil = new ArrayList<Pupil>();
        listPupil = Pupil.listAll(Pupil.class);
        if (listPupil.size() == 0) {
            Toast.makeText(this.getApplicationContext(), "No Contacts in database!!!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(SkillActivitySecond.this, MainActivity.class);
            startActivity(i);
            this.finish();
            /*AlertDialog.Builder builder = new AlertDialog.Builder(SkillActivitySecond.this);
            // Add the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                    Intent i = new Intent(SkillActivitySecond.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
            builder.setMessage("No Cotacts!!!").setTitle("Alert");
                // Create the AlertDialog
            AlertDialog dialog = builder.create();
            dialog.show();*/
        } else {
            lessonHadArray = new ArrayList<String>();
            for (int i = 0; i <= 100; i++) {
                lessonHadArray.add("" + i);
            }
            testPassedAdapter = ArrayAdapter.createFromResource(this, R.array.testPassed, android.R.layout.simple_spinner_item);
            testPassedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            testPassed.setAdapter(testPassedAdapter);
            lessonHadAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lessonHadArray);
            lessonHadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            lessonHad.setAdapter(lessonHadAdapter);
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < listPupil.size(); i++) {
                list.add(listPupil.get(i).getName());
            }
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
            spinnerPupil.setAdapter(myAdapter);
            //current object of the selected person skill
            object = listPupil.get(0).getSkill();
            currentPupil = listPupil.get(0);
            lessonHad.setSelection(lessonHadAdapter.getPosition(currentPupil.getLessonHad().toString()));
            testPassed.setSelection(testPassedAdapter.getPosition(currentPupil.getTestPassed().toString()));

      /*  skill = new HashMap<String,Integer>();*/
            skill = new LinkedHashMap<String, Integer>();
            skill = getCurrentHashMap(object);
        /*skill.put("Bay Parking", object.getBayParking());
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
        skill.put("Turn In The Road", object.getTurnInTheRoad());*/
            adapter = new RatingHashMapAdapter(this, skill);
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
                    adapter = new RatingHashMapAdapter(SkillActivitySecond.this, skill);
                    skilListView.setAdapter(adapter);
                    lessonHad.setSelection(lessonHadAdapter.getPosition(currentPupil.getLessonHad().toString()));
                    testPassed.setSelection(testPassedAdapter.getPosition(currentPupil.getTestPassed().toString()));
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
                    try {
                        skill = adapter.getHashMap();
                        object.setCockpitDrill(skill.get("Cockpit Drill"));
                        object.setMovingAway(skill.get("Moving Away"));
                        object.setStopping(skill.get("Stopping"));
                        object.setTurningLeft(skill.get("Turning Left"));
                        object.setTurningRight(skill.get("Turning Right"));
                        object.settJunction(skill.get("T Junction"));
                        object.setCrossroads(skill.get("Crossroads"));
                        object.setRoundabouts(skill.get("Round Abouts"));
                        object.setPedestarianCrossing(skill.get("Pedestarian Crossing"));
                        object.setEmergencyStop(skill.get("Emergency Stop"));
                        object.setUsingMirrors(skill.get("Using Mirrors"));
                        object.setDualCarriageways(skill.get("Dual Carriageways"));
                        object.setOneWayStreets(skill.get("One Way Streets"));
                        object.setMeetingSituations(skill.get("Meeting Situations"));
                        object.setDefensiveDriving(skill.get("Defensive Driving"));
                        object.setEcoDriving(skill.get("Eco Driving"));
                        object.setTurnInTheRoad(skill.get("Turn In The Road"));
                        object.setParallelParking(skill.get("Parallel Parking"));
                        object.setLeftReverse(skill.get("Left Reverse"));
                        object.setBayParking(skill.get("Bay Parking"));
                        object.setShowAndTell(skill.get("Independent Driving"));
                        object.setMockTests(skill.get("Mock Tests"));
                        currentPupil.setTestPassed(testPassed.getSelectedItem().toString());
                        currentPupil.setLessonHad(lessonHad.getSelectedItem().toString());
                        object.save();
                        currentPupil.save();
                        Toast.makeText(getApplicationContext(), "Ratings saved successfully!!!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error while writing to database.", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }

    public LinkedHashMap<String, Integer> getCurrentHashMap(Skill pSkill) {
        LinkedHashMap<String, Integer> mHashMap = new LinkedHashMap<String, Integer>();

        mHashMap.put("Cockpit Drill", pSkill.getCockpitDrill());
        mHashMap.put("Moving Away", pSkill.getMovingAway());
        mHashMap.put("Stopping", pSkill.getStopping());
        mHashMap.put("Turning Left", pSkill.getTurningLeft());
        mHashMap.put("Turning Right", pSkill.getTurningRight());
        mHashMap.put("T Junction", pSkill.gettJunction());
        mHashMap.put("Crossroads", pSkill.getCrossroads());
        mHashMap.put("Round Abouts", pSkill.getRoundabouts());
        mHashMap.put("Pedestarian Crossing", pSkill.getPedestarianCrossing());
        mHashMap.put("Emergency Stop", pSkill.getEmergencyStop());
        mHashMap.put("Using Mirrors", pSkill.getUsingMirrors());
        mHashMap.put("Dual Carriageways", pSkill.getDualCarriageways());
        mHashMap.put("One Way Streets", pSkill.getOneWayStreets());
        mHashMap.put("Meeting Situations", pSkill.getMeetingSituations());
        mHashMap.put("Defensive Driving", pSkill.getDefensiveDriving());
        mHashMap.put("Eco Driving", pSkill.getEcoDriving());
        mHashMap.put("Turn In The Road", pSkill.getTurnInTheRoad());
        mHashMap.put("Parallel Parking", pSkill.getParallelParking());
        mHashMap.put("Left Reverse", pSkill.getLeftReverse());
        mHashMap.put("Bay Parking", pSkill.getBayParking());
        mHashMap.put("Independent Driving", pSkill.getShowAndTell());
        mHashMap.put("Mock Tests", pSkill.getMockTests());
        return mHashMap;
    }
}
