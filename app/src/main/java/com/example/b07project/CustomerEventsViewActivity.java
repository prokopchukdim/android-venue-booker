package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CustomerEventsViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_events_view);

//      TODO - set login class to send data to this activity
        //get data from previous activity (login?)
        Intent intent = getIntent();
        Customer customer = intent.getParcelableExtra("Customer");
        ArrayList<Event> joinedEvents = customer.fetchJoinedEvents();
        ArrayList<Event> scheduledEvents = customer.fetchScheduledEvents();

        LinearLayout llEventsView = findViewById(R.id.llEventsView);

        //displaying scheduled events
        TextView scheduled = new TextView(this);
        scheduled.setText(R.string.scheduled_events);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        scheduled.setLayoutParams(params);
        llEventsView.addView(scheduled);
        for (Event e: scheduledEvents){
            TextView id = new TextView(this);
            id.setText(e.eventID);
            id.setLayoutParams(params);
            llEventsView.addView(id);
            TextView time = new TextView(this);
            time.setText(e.startTime + "-" + e.endTime);
            time.setLayoutParams(params);
            llEventsView.addView(time);
            TextView creator = new TextView(this);
            creator.setText(e.creator);
            creator.setLayoutParams(params);
            llEventsView.addView(creator);
        }

        //displaying joined events
        TextView joined = new TextView(this);
        joined.setText(R.string.joined_events);
        joined.setLayoutParams(params);
        llEventsView.addView(joined);
        for (Event e: scheduledEvents){
            TextView id = new TextView(this);
            id.setText(e.eventID);
            id.setLayoutParams(params);
            llEventsView.addView(id);
            TextView time = new TextView(this);
            time.setText(e.startTime + "-" + e.endTime);
            time.setLayoutParams(params);
            llEventsView.addView(time);
            TextView creator = new TextView(this);
            creator.setText(e.creator);
            creator.setLayoutParams(params);
            llEventsView.addView(creator);
        }


    }

}