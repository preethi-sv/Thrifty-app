package com.thriftyApp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlertsActivity extends AppCompatActivity {

    boolean flagFloatingButton;
    FloatingActionButton floatingActionButton;
    Button reminderAdd, budgetAdd ;

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
                Intent intent = new Intent(getApplicationContext (), scanActivity.class);
                startActivity (intent);
            }
        });

        budgetAdd.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), TakeActivity.class);
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
