package com.thriftyApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_take);

        findViewById(R.id.close_take).setOnClickListener(
                new View.OnClickListener () {

                    @Override
                    public void onClick(View arg0) {
                        finish();

                    }
                });

        TextView dateTextView = (TextView) findViewById (R.id.dateTextViewTake);
        String date = new SimpleDateFormat ("MMM dd", Locale.getDefault()).format(new Date ());
        dateTextView.setText (date + ", Income");

        findViewById (R.id.floatingActionButtonTake).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText (getApplicationContext (), "Added Budget",Toast.LENGTH_SHORT).show ();
            }
        });

    }
}
