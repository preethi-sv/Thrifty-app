package com.thriftyApp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class PayActivity extends AppCompatActivity {

    EditText pay, tag;
    FloatingActionButton addExpense;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pay);


        databaseHelper = new DatabaseHelper (this);
        pay = (EditText) findViewById (R.id.payEditText);
        tag = (EditText) findViewById (R.id.tagEditText);
        addExpense = (FloatingActionButton) findViewById (R.id.floatingActionButtonPay);

        findViewById(R.id.close_pay).setOnClickListener(
                new View.OnClickListener () {

                    @Override
                    public void onClick(View arg0) {
                        finish();

                    }
                });

        TextView dateTextView = (TextView) findViewById (R.id.dateTextViewPay);
        String date = new SimpleDateFormat("MMM dd", Locale.getDefault()).format(new Date());
        dateTextView.setText (date + ", Expense");

        addExpense.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                if (pay.getText ().toString ().equals ("") || tag.getText ().toString ().equals ("")) {
                    Toast.makeText (getApplicationContext (),"Enter valid amount and tag.",Toast.LENGTH_SHORT).show ();
                }
                else
                    addPay ();
            }
        });

        findViewById (R.id.transportImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Transport");
            }
        });
        findViewById (R.id.travelImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Travel");
            }
        });
        findViewById (R.id.foodImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Food");
            }
        });
        findViewById (R.id.billsImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Bills");
            }
        });
        findViewById (R.id.sportsImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Sports");
            }
        });
        findViewById (R.id.homeImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Home");
            }
        });
        findViewById (R.id.petsImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Pets");
            }
        });
        findViewById (R.id.educationImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Education");
            }
        });
        findViewById (R.id.beautyImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Transport");
            }
        });
        findViewById (R.id.kidsImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Travel");
            }
        });
        findViewById (R.id.healthImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Health Care");
            }
        });
        findViewById (R.id.movieImageViewP).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                tag.setText ("Movies");
            }
        });
    }

    public void addPay () {
        Transactions t = new Transactions ();
        t.setExin (0);
        t.setAmount (Long.parseLong (pay.getText ().toString ()));
        t.setTag (tag.getText ().toString ());
        t.setUid (Integer.parseInt (Utils.userId));
        databaseHelper.insertTransaction (t);
        databaseHelper.getTransactions (Utils.userId);
        Toast.makeText (getApplicationContext (),"Added Expense", Toast.LENGTH_SHORT).show ();
        Intent intent = new Intent (getApplicationContext (), TransactionsActivity.class);
        startActivity (intent);
        finish ();
    }
}