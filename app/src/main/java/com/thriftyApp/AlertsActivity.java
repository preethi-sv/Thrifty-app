package com.thriftyApp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class AlertsActivity extends AppCompatActivity {

    boolean flagFloatingButton;
    FloatingActionButton floatingActionButton;
    Button reminderAdd, budgetAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_alerts);

        flagFloatingButton = false;
        floatingActionButton = (FloatingActionButton) findViewById (R.id.floatingActionButtonA);

        reminderAdd = (Button) findViewById (R.id.remAddButton);
        budgetAdd = (Button) findViewById (R.id.budgetAddButton);

        reminderAdd.setVisibility (View.INVISIBLE);
        budgetAdd.setVisibility (View.INVISIBLE);

        reminderAdd.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), AddReminderActivity.class);
                startActivity (intent);
            }
        });

        budgetAdd.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), AddBudgetActivity.class);
                startActivity (intent);
            }
        });


        TextView home = (TextView) findViewById (R.id.homeTextViewA);
        TextView thrifty = (TextView) findViewById (R.id.thriftyTitleA);
        home.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext (), Dashboard.class);
                startActivity (intent);
            }
        });

        thrifty.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext (), Dashboard.class);
                startActivity (intent);
            }
        });

        ListView myListView = (ListView) findViewById(R.id.alertsList);


        final ArrayList<String> myFriends = new ArrayList<String>(asList("Varsha","Samyuktha","Tejaswini","Sivakami","Ashu","Atsh", "Dhak", "Bhava","Prash","Kavin"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText (AlertsActivity.this,"Hi " + myFriends.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }


    public void FloatingButtonToggle(View view) {

        if (flagFloatingButton) {

            flagFloatingButton = false;
            reminderAdd.setVisibility (View.INVISIBLE);
            budgetAdd.setVisibility (View.INVISIBLE);
        }
        else {

            flagFloatingButton = true;
            reminderAdd.setVisibility (View.VISIBLE);
            budgetAdd.setVisibility (View.VISIBLE);
        }

    }
}
