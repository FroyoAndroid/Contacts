package com.contacts.test.contacts;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by nirajkumar.chauhan on 1/27/2015.
 */
public class SettingActivity extends Activity {
    private Button backupDB,restoreDB,backBtn;
    String packageName = "com.contacts.test.contacts";
    String dbName ="skillContact.db";
    int REQUESTCODE_PICK_DB = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        backupDB = (Button) findViewById(R.id.backupDB);
        restoreDB =(Button) findViewById(R.id.restoreDB);
        backBtn = (Button) findViewById(R.id.back);
        backupDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File sd = Environment.getExternalStorageDirectory();
                    File data = Environment.getDataDirectory();

                    if (sd.canWrite()) {
                        String currentDBPath = "//data//"+ packageName +"//databases//"+dbName;
                        String backupDBPath = "backup.db";
                        File currentDB = new File(data, currentDBPath);
                        File backupDB = new File(sd, backupDBPath);

                        FileChannel src = new FileInputStream(currentDB).getChannel();
                        FileChannel dst = new FileOutputStream(backupDB).getChannel();
                        dst.transferFrom(src, 0, src.size());
                        src.close();
                        dst.close();
                        Toast.makeText(getBaseContext(), backupDB.toString(), Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        //restore db code goes here
        restoreDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent databaseChooseIntent = new Intent(Intent.ACTION_GET_CONTENT);
                databaseChooseIntent.setType("*/*.apk");
               startActivityForResult(databaseChooseIntent,REQUESTCODE_PICK_DB);
            }
        });

        // backBtn ----finish the activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUESTCODE_PICK_DB && resultCode == Activity.RESULT_OK){
            Uri dbUri = data.getData();
            Log.d("Path :",dbUri+"");
        }
    }
}
