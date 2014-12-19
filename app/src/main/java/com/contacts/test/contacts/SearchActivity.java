package com.contacts.test.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import com.contacts.test.util.Pupil;
/**
 * Created by nirajkumar.chauhan on 12/18/2014.
 */
public class SearchActivity extends Activity {
    List<Pupil> pupil;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_pupil);
        try{
         pupil = Pupil.findWithQuery(Pupil.class, "Select * from Pupil","");
        }catch(Exception e){
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            Log.d("database",pupil.toString());
        }
    }
}
