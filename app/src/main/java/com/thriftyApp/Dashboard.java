package com.thriftyApp;

import android.content.Intent;

import android.graphics.Color;
import android.graphics.Typeface;
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

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class Dashboard extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    boolean flagFloatingButton;
    FloatingActionButton floatingActionButton;
    Button scan, take, pay;
    PieChart pieChart;
    TextView income, expense;

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

        income = (TextView) findViewById (R.id.income);
        expense = (TextView) findViewById (R.id.expense);

        scan = (Button) findViewById (R.id.scanButton);
        take = (Button) findViewById (R.id.takeButton);
        pay = (Button) findViewById (R.id.payButton);
        scan.setVisibility (View.INVISIBLE);
        take.setVisibility (View.INVISIBLE);
        pay.setVisibility (View.INVISIBLE);

        databaseHelper = new DatabaseHelper (this);
        flagFloatingButton = false;
        floatingActionButton = (FloatingActionButton) findViewById (R.id.floatingActionButtonD);
        pieChart = (PieChart) findViewById (R.id.pieChart);

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

        getTList();
        getTChart();
    }

    public void getTList() {
        ListView myListView = (ListView) findViewById(R.id.transactionsListDash);

        ArrayList<String> transact = databaseHelper.getTransactions (Utils.userId );
        List<String> transactMini = new ArrayList<> ();
        transactMini.add (transact.get(0));
        transactMini.add (transact.get(1));
        if (transact == null) {
            Toast.makeText (Dashboard.this, "No reminders yet.", Toast.LENGTH_LONG).show ( );

        } else {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,transactMini);

            myListView.setAdapter (arrayAdapter);

            myListView.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText (Dashboard.this,"Tap *Show All* to view all transactions.", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void getTChart() {

        pieChart.setHoleRadius (15f);
        pieChart.setTransparentCircleRadius (15f);

        List<PieEntry> value = new ArrayList<>();
        value.add (new PieEntry (Utils.expense, "Expenses" ));
        value.add (new PieEntry (Utils.income, "Income" ));

        PieDataSet pieDataSet = new PieDataSet (value, "Transactions") ;
        PieData pieData = new PieData (pieDataSet);
        pieChart.setData (pieData);

        pieChart.setContentDescription (null);
        pieChart.getLegend ().setEnabled (false);
        pieChart.getDescription ().setEnabled (false);
        pieChart.setEntryLabelTextSize (10f);
        pieChart.animateXY (1000,1000);

        pieDataSet.setColors (ColorTemplate.JOYFUL_COLORS);
    }
}