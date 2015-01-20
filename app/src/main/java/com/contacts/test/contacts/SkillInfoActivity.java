package com.contacts.test.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.contacts.test.util.SkillInfoAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by nirajkumar.chauhan on 1/19/2015.
 */
public class SkillInfoActivity extends Activity {

    ArrayList<String> linkedHashMapValues;
    LinkedHashMap<String, String> hashMap;
    String[] skills;
    Button backButton;
    ListView skillListView;
    SkillInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_info);
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        skillListView = (ListView) findViewById(R.id.skillInfoListView);
        skills = new String[]{"cockpitDrill", "movingAway", "stopping", "turningLeft", "turningRight", "tJunction", "crossRoads", "roundAbouts", "pedestrianCrossing", "emergencyStop", "usingMirrors", "dualCarriageways", "oneWayStreets", "meetingSituations", "defensiveDriving", "ecoDriving", "turnInTheRoads", "parallelParking", "leftReverse", "bayParking", "showAndTell", "mockTests"};
        hashMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < skills.length; i++) {
           /* Log.d("SKill Info Name",  getStringResourceByName(skills[i]));*/
            hashMap.put(skills[i], getStringResourceByName(skills[i].toString()));
        }

        Log.d("Size",  ""+hashMap.size());
        adapter = new SkillInfoAdapter(hashMap,this);
        skillListView.setAdapter(adapter);

    }

    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }
}
