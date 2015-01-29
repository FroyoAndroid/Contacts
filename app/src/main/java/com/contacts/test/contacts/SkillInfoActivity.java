package com.contacts.test.contacts;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
   final  Context mContext=this;
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
        skills = new String[]{"cockpitDrill", "movingAway", "stopping", "turningLeft", "turningRight", "tJunction", "crossRoads", "roundAbouts", "pedestrianCrossing", "emergencyStop", "usingMirrors", "dualCarriageways", "oneWayStreets", "meetingSituations", "defensiveDriving", "ecoDriving", "turnInTheRoads", "parallelParking", "leftReverse", "bayParking", "independentDriving", "mockTests"};
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
                Log.d("Competency Info", hashMap.get(skills[position]));
                String skillInfoText = hashMap.get(skills[position]);
                final Dialog dialog = new Dialog(mContext);
                dialog.setTitle("Description...");
                dialog.setContentView(R.layout.dialog_skill_info);
                //setting the custom dialog component
                TextView skillInfoDetailText = (TextView) dialog.findViewById(R.id.skillInfoDetail);
                skillInfoDetailText.setText(skillInfoText);
                Button skillImage = (Button) dialog.findViewById(R.id.dialogShowImage);
                skillImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent scribble = new Intent(SkillInfoActivity.this,ScribbleActivity.class);
                        startActivity(scribble);
                        dialog.dismiss();
                    }
                });
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
