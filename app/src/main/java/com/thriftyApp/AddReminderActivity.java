package com.thriftyApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_reminder);


        findViewById(R.id.close_addrem).setOnClickListener(
                new View.OnClickListener () {

                    @Override
                    public void onClick(View arg0) {
                        finish();

                    }
                });

        findViewById (R.id.floatingActionButtonAddRem).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText (getApplicationContext (), "Added Budget",Toast.LENGTH_SHORT).show ();
            }
        });
    }
}
