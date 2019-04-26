package com.login_signup_screendesign_demo;

import android.content.Intent;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import android.widget.TextView;


public class Dashboard extends AppCompatActivity {

    boolean flagFloatingButton;
    FloatingActionButton floatingActionButton;
    Button scan, take, pay;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dashboard);

        scan = (Button) findViewById (R.id.scanButton);
        take = (Button) findViewById (R.id.takeButton);
        pay = (Button) findViewById (R.id.payButton);
        scan.setVisibility (View.INVISIBLE);
        take.setVisibility (View.INVISIBLE);
        pay.setVisibility (View.INVISIBLE);

        flagFloatingButton = false;
        floatingActionButton = (FloatingActionButton) findViewById (R.id.floatingActionButton2);


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

        TextView showAll = (TextView) findViewById (R.id.showAllTextView);
        showAll.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), TransactionsActivity.class);
                startActivity (intent);
            }
        });

        TextView alert = (TextView) findViewById (R.id.alertTextView);

        alert.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext (), AlertsActivity.class);
                startActivity (intent);
            }
        });



    }
}
