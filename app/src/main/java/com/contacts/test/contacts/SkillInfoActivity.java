package com.contacts.test.contacts;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_info);
        mContext = this;
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

        //Log.d("Size",""+hashMap.size());
        adapter = new SkillInfoAdapter(hashMap,this);
        skillListView.setAdapter(adapter);

        //Skill ListView Item Click Listener
        skillListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Competency Info",hashMap.get(skills[position]));
                final Dialog dialog = new Dialog(mContext);
                dialog.setTitle("Description...");

                //setting the custom dialog component
                EditText skillInfoDetailText = (EditText)dialog.findViewById(R.id.skillInfoDetail);
                skillInfoDetailText.setText(hashMap.get(skills[position]),null);
                ImageView skilImage = (ImageView) dialog.findViewById(R.id.skillInfoImage);
                Button dialogClose = (Button) dialog.findViewById(R.id.dialogClose);
                dialogClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }

    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }
}
