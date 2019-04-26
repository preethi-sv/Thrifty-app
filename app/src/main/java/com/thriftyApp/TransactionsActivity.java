package com.thriftyApp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TransactionsActivity extends AppCompatActivity  {

    boolean flagFloatingButton;
    FloatingActionButton floatingActionButton;
    Button scan, take, pay;

    public void FloatingButtonToggle (View view) {

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

        setContentView (R.layout.activity_transactions);

        flagFloatingButton = false;

        scan = (Button) findViewById (R.id.scanButtonT);
        take = (Button) findViewById (R.id.takeButtonT);
        pay = (Button) findViewById (R.id.payButtonT);
        scan.setVisibility (View.INVISIBLE);
        take.setVisibility (View.INVISIBLE);
        pay.setVisibility (View.INVISIBLE);


        TextView alert = (TextView) findViewById (R.id.alertTextViewT);
        TextView home = (TextView) findViewById (R.id.homeTextViewT);


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


        alert.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext (), AlertsActivity.class);
                startActivity (intent);
            }
        });

        home.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext (), AlertsActivity.class);
                startActivity (intent);
            }
        });

    }

}
