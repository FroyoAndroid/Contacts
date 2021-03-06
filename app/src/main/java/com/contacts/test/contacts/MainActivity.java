package com.contacts.test.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class MainActivity extends Activity {
    Button addPupil,editPupil,contactPupil,skillInfo,addEvent,settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addPupil = (Button) findViewById(R.id.mainmenuButton1);
        editPupil = (Button) findViewById(R.id.mainmenubutton2);
        contactPupil = (Button) findViewById(R.id.mainmenubutton3);
        skillInfo = (Button) findViewById(R.id.mainmenubutton5);
        addEvent = (Button) findViewById(R.id.mainmenubutton4);
        settings = (Button) findViewById(R.id.mainmenubutton6);

        //add pupil click listener
        addPupil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),PupilActivity.class);
                startActivity(i);
            }
        });


        // contact pupil click listener
        contactPupil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SkillActivitySecond.class);
                startActivity(i);
            }
        });

        //editPupil click listener
        editPupil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(i);
            }
        });

        //Skill info click listener
        skillInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),SkillInfoActivity.class);
                startActivity(i);
            }
        });

        //add Event
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ACTION_INSERT does not work on all phones
                // use  Intent.ACTION_EDIT in this case
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                startActivity(intent);

            }
        });

        // settings
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}