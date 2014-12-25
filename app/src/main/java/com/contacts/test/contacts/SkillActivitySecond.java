package com.contacts.test.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.contacts.test.util.Pupil;
import com.contacts.test.util.RatingAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nirajkumar.chauhan on 12/24/2014.
 */
public class SkillActivitySecond extends Activity {
    Spinner spinnerPupil;
    List<Pupil> listPupil;
    List<String> listPupilName;
    ListView skilListView;
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
        RatingAdapter adapter = new RatingAdapter(this,R.layout.rating_skill_item,listPupil.get(0).getSkill());
        skilListView.setAdapter(adapter);
    }
}
