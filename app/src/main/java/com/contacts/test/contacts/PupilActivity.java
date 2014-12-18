package com.contacts.test.contacts;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.contacts.test.util.Pupil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PupilActivity extends Activity {
    boolean isFBFriend,isPassed,isBooked;
    EditText fullName, houseStreet, town, postcode, contact;
    RadioButton isFacebookFriend, isTheoryPassed, isTestBooked;
    Spinner testPassed, lessonHad;
    Button back, addPupil, clearData;
    List<String> lessonHadArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pupil);
        fullName = (EditText) findViewById(R.id.txtFullName);
        houseStreet = (EditText) findViewById(R.id.txtHouseStreet);
        town = (EditText) findViewById(R.id.txtTown);
        postcode = (EditText) findViewById(R.id.txtPostcode);
        contact = (EditText) findViewById(R.id.txtContactNumber);
        testPassed = (Spinner) findViewById(R.id.testPassed);
        lessonHad = (Spinner) findViewById(R.id.lessonsHad);
        isFacebookFriend = (RadioButton) findViewById(R.id.radiobtnfacebook);
        isTheoryPassed = (RadioButton) findViewById(R.id.radiobtnTheoryPassed);
        isTestBooked = (RadioButton) findViewById(R.id.radiobtnTestBooked);

        /**
         * back button
         */
        back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /**
         * Clear Button
         */
        clearData =  (Button) findViewById(R.id.btnClear);
        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName.setText("");
                houseStreet.setText("");
                town.setText("");
                postcode.setText("");
                contact.setText("");
                isFacebookFriend.setChecked(false);
                isTheoryPassed.setChecked(false);
                isTestBooked.setChecked(false);

            }
        });
        /**
         * Add Pupil Button
         */
        addPupil = (Button) findViewById(R.id.btnSave);
        addPupil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pupil(String name, String houseStreet, String town, String postcode, String contact, Boolean isFacebookFriend, Boolean isTheoryPassed, Boolean isTestBooked, Date testBookedDate, String testPassed, String lessonHad)
                //String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                Pupil object = new Pupil(fullName.getText().toString(),houseStreet.getText().toString(),town.getText().toString(),postcode.getText().toString(),contact.getText().toString(),isFacebookFriend.isChecked(),isTheoryPassed.isChecked(),isTestBooked.isChecked(),"12/5/2014",testPassed.getSelectedItem().toString(),lessonHad.getSelectedItem().toString());
                object.save();
            }
        });
        lessonHadArray = new ArrayList<String>();
        for (int i = 0; i <= 100; i++) {
            lessonHadArray.add("" + i);
        }
        ArrayAdapter<CharSequence> testPassedAdapter = ArrayAdapter.createFromResource(this, R.array.testPassed, android.R.layout.simple_spinner_item);
        testPassedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        testPassed.setAdapter(testPassedAdapter);
        ArrayAdapter<String> lessonHadAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lessonHadArray);
        lessonHadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        lessonHad.setAdapter(lessonHadAdapter);
    }
}