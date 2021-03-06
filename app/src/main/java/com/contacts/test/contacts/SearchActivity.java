package com.contacts.test.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.contacts.test.util.Pupil;
import com.contacts.test.util.PupilListAdapter;

import java.util.ArrayList;
import java.util.List;

import com.contacts.test.util.Pupil;

/**
 * Created by nirajkumar.chauhan on 12/18/2014.
 */
public class SearchActivity extends Activity {

    EditText searchView;
    ListView pupilList;
    List<Pupil> pupil;
    PupilListAdapter adapter;
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_pupil);
        pupilList = (ListView) findViewById(R.id.pupilList);
        searchView = (EditText) findViewById(R.id.searchPupil);
        // listView
        pupilList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // This logic need to be chnaged to accomodtae searchList ItemClick
            Bundle b = new Bundle();
            Log.d("Get ID",""+pupil.get(position).getId());
            b.putString("pupil_name",pupil.get(position).getName());
            b.putString("pupil_contact",pupil.get(position).getContact());
                Intent i = new Intent(SearchActivity.this,EditPupilActivity.class);
                i.putExtra("pupil",b);
                startActivity(i);

            }
        });


        pupil = Pupil.listAll(Pupil.class);
        Log.d("Database", pupil.size() + "");

        adapter = new PupilListAdapter(this, R.layout.pupil_list_item, pupil);
        pupilList.setAdapter(adapter);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int textlength = s.length();
                List<Pupil> tempArrayList = new ArrayList<Pupil>();
                for (Pupil p : pupil) {
                    if (textlength <= p.getName().length()) {
                        if (p.getName().toLowerCase().contains(s.toString().toLowerCase())) {
                            tempArrayList.add(p);
                        }
                    }
                }
                adapter = new PupilListAdapter(SearchActivity.this, R.layout.pupil_list_item, tempArrayList);
                pupilList.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    /**
     *   Edit Contact
     */
    public void editContact(View v){
        //Toast.makeText(this,"Edit Contact clicked",Toast.LENGTH_SHORT).show();
        Bundle b = new Bundle();
        //Log.d("Get ID",""+pupil.get(position).getId());
        Pupil itemToEdit= (Pupil) v.getTag();
        b.putString("pupil_name",itemToEdit.getName());
        b.putString("pupil_contact",itemToEdit.getContact());
        Intent i = new Intent(SearchActivity.this,EditPupilActivity.class);
        i.putExtra("pupil",b);
        startActivity(i);
    }
    /**
     * Delete Contact
     */
    public void deleteContact(View v){
        Pupil itemToRemove= (Pupil) v.getTag();
        itemToRemove.delete();
        adapter.remove(itemToRemove);
        adapter.notifyDataSetChanged();
        Toast.makeText(this,"Contact deleted successfully !!!",Toast.LENGTH_SHORT).show();
    }

}
