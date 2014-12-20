package com.contacts.test.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.contacts.test.util.Pupil;
import com.contacts.test.util.PupilListAdapter;

import java.util.List;

/**
 * Created by nirajkumar.chauhan on 12/18/2014.
 */
public class SearchActivity extends Activity {
    SearchView searchView;
    ListView pupilList;
    List<Pupil> pupil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_pupil);
        pupilList = (ListView)findViewById(R.id.pupilList);
        searchView =(SearchView) findViewById(R.id.searchPupil);

        pupil = Pupil.listAll(Pupil.class);
        Log.d("Database",pupil.size()+"");

        PupilListAdapter adapter = new PupilListAdapter(this,R.layout.pupil_list_item,pupil);
        pupilList.setAdapter(adapter);
    }


}
