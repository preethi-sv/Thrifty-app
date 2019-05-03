package com.thriftyApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddBudgetActivity extends AppCompatActivity {

    EditText budgetEdit, dateEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_budget);

        budgetEdit = (EditText) findViewById (R.id.describeBudAmountEditText);
        dateEdit = (EditText) findViewById (R.id.dateBudEditText);

        budgetEdit.setText (Utils.budget);

        findViewById(R.id.close_addbud).setOnClickListener(
                new View.OnClickListener () {

                    @Override
                    public void onClick(View arg0) {
                        finish();

                    }
                });

        findViewById (R.id.floatingActionButtonAddBud).setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                if(budgetEdit.getText ().toString ().equals ("") || dateEdit.getText ().toString ().equals (""))
                {
                    Toast.makeText (getApplicationContext (),"Enter valid budget amount and end date.",Toast.LENGTH_SHORT).show ();
                }
                else {
                    Toast.makeText (getApplicationContext ( ), "Added Budget", Toast.LENGTH_SHORT).show ( );
                    Intent intent = new Intent (getApplicationContext ( ), AlertsActivity.class);
                    startActivity (intent);
                    finish ( );
                }
            }
        });
    }
}
