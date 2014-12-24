package com.contacts.test.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.contacts.test.util.Pupil;

import java.util.List;

/**
 * Created by CHAUHAN on 12/23/14.
 */
public class EditPupilActivity extends Activity {
    Button back,clear,setDate,savePupil;
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
        back = (Button)findViewById(R.id.backButton);
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
    }
}
