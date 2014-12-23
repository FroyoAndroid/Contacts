package com.contacts.test.contacts;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nirajkumar.chauhan on 12/23/2014.
 */
public class SkillActivity extends Activity {
    TextView tvPupilName;
    String[] competencies ;
    List<TextView> textViews;
    List<RatingBar> ratingViews;
    LinearLayout llCompetency,llRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textViews = new ArrayList<TextView>();
        ratingViews = new ArrayList<RatingBar>();
        setContentView(R.layout.contact_skills_main);
        competencies = getResources().getStringArray(R.array.competency);
        tvPupilName= (TextView) findViewById(R.id.tvPupilName);
        tvPupilName.setText(competencies[0]);
        llCompetency = (LinearLayout) findViewById(R.id.llCompetency);
        llRating =(LinearLayout) findViewById(R.id.llRating);
        for (int i=0; i<competencies.length; i++){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);



            /*
            TextView tempCompTV = new TextView(SkillActivity.this);
            RatingBar temp_ratingView = new RatingBar(SkillActivity.this);
            temp_ratingView.setLayoutParams(params);
            tempCompTV.setLayoutParams(params);
            tempCompTV.setTextSize(20);
            tempCompTV.setText(competencies[i].toString());
            llCompetency.addView(tempCompTV);
            llRating.addView(temp_ratingView);
            textViews.add(tempCompTV);
            ratingViews.add(temp_ratingView);*/
            TextView tv = new TextView(this);
            tv.setLayoutParams(params);
            tv.setText(competencies[i]);
            llCompetency.addView(tv);

            RatingBar rv = new RatingBar(this);

            rv.setLayoutParams(params);
            llRating.addView(rv);
            rv.setNumStars(5);
            rv.setStepSize(1.0f);
            textViews.add(tv);
            ratingViews.add(rv);


        }
    }
}
