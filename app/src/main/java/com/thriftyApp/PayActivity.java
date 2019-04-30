package com.thriftyApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.transform.Templates;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pay);

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
    }
}
