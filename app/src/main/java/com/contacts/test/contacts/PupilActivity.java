package com.contacts.test.contacts;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.contacts.test.util.Pupil;
import com.contacts.test.util.Skill;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class PupilActivity extends Activity {
    private DatePicker datePicker;
    private Calendar calendar;
    private int year,month,day;
    boolean isFBFriend,isPassed,isBooked;
    TextView dateText;
    EditText fullName, houseStreet, town, postcode, contact;
    RadioButton isFacebookFriend, isTheoryPassed, isTestBooked;
    Spinner testPassed, lessonHad;
    Button back, addPupil, clearData,setDate,resetRadioBtns;
    List<String> lessonHadArray;

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id== 999){
            return  new DatePickerDialog(this,myDateListener,year,month,day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            showDate(year,monthOfYear+1,dayOfMonth);
        }
    };

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
        dateText = (TextView)findViewById(R.id.dateEdit);
        isFacebookFriend = (RadioButton) findViewById(R.id.radiobtnfacebook);
        isTheoryPassed = (RadioButton) findViewById(R.id.radiobtnTheoryPassed);
        isTestBooked = (RadioButton) findViewById(R.id.radiobtnTestBooked);
        setDate = (Button)findViewById(R.id.setDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        resetRadioBtns = (Button) findViewById(R.id.resetRadioBtns);
        resetRadioBtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFacebookFriend.setChecked(false);
                isTheoryPassed.setChecked(false);
                isTestBooked.setChecked(false);
            }
        });
        showDate(year, month+1, day);
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
         * Set Date Button Click listener
         */
        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(999);
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

               try {

                   Skill skillObj = new Skill();
                   skillObj.setBayParking(0);
                   skillObj.setCockpitDrill(0);
                   skillObj.setCrossroads(0);
                   skillObj.setDefensiveDriving(0);
                   skillObj.setDualCarriageways(0);
                   skillObj.setEcoDriving(0);
                   skillObj.setEmergencyStop(0);
                   skillObj.setLeftReverse(0);
                   skillObj.setMeetingSituations(0);
                   skillObj.setOneWayStreets(0);
                   skillObj.setUsingMirrors(0);
                   skillObj.setTurnInTheRoad(0);
                   skillObj.setTurningLeft(0);
                   skillObj.setTurningRight(0);
                   skillObj.setMovingAway(0);
                   skillObj.settJunction(0);
                   skillObj.setStopping(0);
                   skillObj.setPedestarianCrossing(0);
                   skillObj.setRoundabouts(0);
                   skillObj.setParallelParking(0);
                   skillObj.setShowAndTell(0);
                   skillObj.setMockTests(0);
                   Pupil object = new Pupil(fullName.getText().toString(), houseStreet.getText().toString(), town.getText().toString(), postcode.getText().toString(), contact.getText().toString(), isFacebookFriend.isChecked(), isTheoryPassed.isChecked(), isTestBooked.isChecked(), dateText.getText().toString(), testPassed.getSelectedItem().toString(), lessonHad.getSelectedItem().toString(),skillObj);
                   object.save();
               }catch(Exception e ){

                   Toast.makeText(getApplicationContext(),"Error while writing it to Database",Toast.LENGTH_LONG).show();

               }
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

    private void showDate(int year,int month, int day){
        dateText.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }
}