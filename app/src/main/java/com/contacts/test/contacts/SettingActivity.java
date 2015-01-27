package com.contacts.test.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by nirajkumar.chauhan on 1/27/2015.
 */
public class SettingActivity extends Activity {
    private Button backupDB,restoreDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        backupDB = (Button) findViewById(R.id.backupDB);
    }
}
