package com.contacts.test.contacts;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHAUHAN on 12/16/14.
 */
public class PupilActivity extends Activity {
    Spinner testPassed,lessonHad;
    Button back;
    List<String> lessonHadArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pupil);
        testPassed = (Spinner) findViewById(R.id.testPassed);
        lessonHad =(Spinner) findViewById(R.id.lessonsHad);
        //back button
        back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //end of back button

        lessonHadArray = new ArrayList<String>();
        for(int i=0 ;i<=100;i++){
            lessonHadArray.add(""+i);
        }
        ArrayAdapter<CharSequence> testPassedAdapter = ArrayAdapter.createFromResource(this,R.array.testPassed,android.R.layout.simple_spinner_item);
        testPassedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        testPassed.setAdapter(testPassedAdapter);
        ArrayAdapter<String> lessonHadAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lessonHadArray);
        lessonHadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        lessonHad.setAdapter(lessonHadAdapter);
    }
}