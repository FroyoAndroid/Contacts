package com.contacts.test.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.contacts.test.util.Pupil;

import java.util.List;

/**
 * Created by CHAUHAN on 12/23/14.
 */
public class EditPupilActivity extends Activity {
    Button back,clear,setDate,savePupil,resetRadioBtns;
    RadioButton isFacebookFriend, isTheoryPassed, isTestBooked;
    boolean isFBFriend,isPassed,isBooked;
    EditText houseStreet,town,postcode,contact;
    TextView date;
    List<Pupil> pupils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_pupil);
        Bundle b = getIntent().getBundleExtra("pupil");
        String pupilName = b.getString("pupil_name");
        String pupilContact = b.getString("pupil_contact");
        pupils = Pupil.findWithQuery(Pupil.class,"Select * from Pupil where name =? AND contact=?",pupilName,pupilContact);
        isFacebookFriend = (RadioButton) findViewById(R.id.radiobtnfacebook);
        isTheoryPassed = (RadioButton) findViewById(R.id.radiobtnTheoryPassed);
        isTestBooked = (RadioButton) findViewById(R.id.radiobtnTestBooked);
        back = (Button)findViewById(R.id.backButton);
        resetRadioBtns = (Button) findViewById(R.id.resetRadioBtns);
        resetRadioBtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFacebookFriend.setChecked(false);
                isTheoryPassed.setChecked(false);
                isTestBooked.setChecked(false);
            }
        });
       if(pupils.get(0).getIsFacebookFriend() == true){
            isFacebookFriend.setChecked(true);
        }else{
            isFacebookFriend.setChecked(false);
        }
        if(pupils.get(0).getIsTheoryPassed() == true){
            isTheoryPassed.setChecked(true);
        }else{
            isTheoryPassed.setChecked(false);
        }
        if(pupils.get(0).getIsTestBooked()==true){
            isTestBooked.setChecked(true);
        }else{
            isTestBooked.setChecked(false);
        }


        clear = (Button)findViewById(R.id.btnClear);
        setDate = (Button)findViewById(R.id.setDate);
        savePupil = (Button)findViewById(R.id.btnSave);
        houseStreet = (EditText) findViewById(R.id.txtHouseStreet);
        houseStreet.setText(pupils.get(0).getHouseStreet());
        town = (EditText) findViewById(R.id.txtTown);
        town.setText(pupils.get(0).getTown());
        postcode = (EditText) findViewById(R.id.txtPostcode);
        postcode.setText(pupils.get(0).getPostcode());
        contact = (EditText) findViewById(R.id.txtContactNumber);
        contact.setText(pupils.get(0).getContact());
        date =(TextView) findViewById(R.id.dateEdit);
        date.setText(pupils.get(0).getTestBookedDate());
        /**
         * Back button code
         *
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /**
         * Clear button code
         *
         */
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
         * Save btn code goes here
         */
        savePupil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pupils.get(0).setHouseStreet(houseStreet.getText().toString());
                pupils.get(0).setTown(town.getText().toString());
                pupils.get(0).setPostcode(postcode.getText().toString());
                pupils.get(0).setContact(contact.getText().toString());
                Log.d("is Facebook friend",isFacebookFriend.isChecked()+" ");
                pupils.get(0).setIsFacebookFriend(isFacebookFriend.isChecked());
                pupils.get(0).setIsTestBooked(isTestBooked.isChecked());
                pupils.get(0).setIsTheoryPassed(isTheoryPassed.isChecked());
                pupils.get(0).setTestBookedDate(date.getText().toString());
                pupils.get(0).save();

            }
        });
    }
}
