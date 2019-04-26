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
    Button scan, take, pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_alerts);

        flagFloatingButton = false;
        floatingActionButton = (FloatingActionButton) findViewById (R.id.floatingActionButton);

        scan = (Button) findViewById (R.id.scanButton2);
        take = (Button) findViewById (R.id.takeButton2);
        pay = (Button) findViewById (R.id.payButton2);

        scan.setVisibility (View.INVISIBLE);
        take.setVisibility (View.INVISIBLE);
        pay.setVisibility (View.INVISIBLE);

        scan.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), scanActivity.class);
                startActivity (intent);
            }
        });

        take.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), TakeActivity.class);
                startActivity (intent);
            }
        });


        pay.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), PayActivity.class);
                startActivity (intent);
            }
        });
        TextView home = (TextView) findViewById (R.id.homeTextView2);

        home.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext (), Dashboard.class);
                startActivity (intent);
            }
        });

    }

    public void FloatingButtonToggle(View view) {

        if (flagFloatingButton) {

            flagFloatingButton = false;
            scan.setVisibility (View.INVISIBLE);
            take.setVisibility (View.INVISIBLE);
            pay.setVisibility (View.INVISIBLE);
        }
        else {

            flagFloatingButton = true;
            scan.setVisibility (View.VISIBLE);
            take.setVisibility (View.VISIBLE);
            pay.setVisibility (View.VISIBLE);
        }

    }
}
