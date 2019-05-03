package com.thriftyApp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class TransactionsActivity extends AppCompatActivity  {

    boolean flagFloatingButton;
    Button scan, take, pay, list, graph;
    ListView myListView;
    DatabaseHelper databaseHelper;
    PieChart pieChart;

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
        databaseHelper = new DatabaseHelper (this);
        databaseHelper.getExpenses ();

        pieChart = (PieChart) findViewById (R.id.pieChartExpenses);
        databaseHelper = new DatabaseHelper (this);
        scan = (Button) findViewById (R.id.scanButtonT);
        take = (Button) findViewById (R.id.takeButtonT);
        pay = (Button) findViewById (R.id.payButtonT);

        list = (Button) findViewById (R.id.listViewTab);
        graph = (Button) findViewById (R.id.graphViewTab);

        scan.setVisibility (View.INVISIBLE);
        take.setVisibility (View.INVISIBLE);
        pay.setVisibility (View.INVISIBLE);

        myListView = (ListView) findViewById(R.id.transactionsListViewT);
        TextView alert = (TextView) findViewById (R.id.alertTextViewT);
        TextView home = (TextView) findViewById (R.id.homeTextViewT);

        setTList ();
        scan.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), scanActivity.class);
                startActivity (intent);
                finish ();
            }
        });

        take.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), TakeActivity.class);
                startActivity (intent);
                finish ();
            }
        });


        pay.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext (), PayActivity.class);
                startActivity (intent);
                finish ();
            }
        });


        alert.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext (), AlertsActivity.class);
                startActivity (intent);
                finish ();
            }
        });

        home.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext (), Dashboard.class);
                startActivity (intent);
                finish ();
            }
        });

        pieChart.setOnChartValueSelectedListener (new OnChartValueSelectedListener ( ) {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                    PieEntry pe = (PieEntry) e;
                    Log.i("Chart",pe.getLabel());
                    Snackbar snackbar = Snackbar.make (pieChart, pe.getLabel (), Snackbar.LENGTH_SHORT);
                    snackbar.show ();
            }

            @Override
            public void onNothingSelected() {

            }
        });
/*
        final ArrayList<String> myFriends = new ArrayList<String>(asList("Varsha","Samyuktha","Tejaswini","Sivakami","SPD","Dars","Poor","Kavin"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText (TransactionsActivity.this,"Hi " + myFriends.get(position), Toast.LENGTH_LONG).show();
            }
        });

        */
    }

    public  void setTList() {
        ArrayList<String> transact = databaseHelper.getTransactions (Utils.userId );
        if (transact == null) {
            Toast.makeText (TransactionsActivity.this, "No reminders yet.", Toast.LENGTH_LONG).show ( );

        } else {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, transact);

            myListView.setAdapter (arrayAdapter);

            final ArrayList<String> finalTransact = transact;
            myListView.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText (TransactionsActivity.this, "Transaction  : " + finalTransact.get (position), Toast.LENGTH_LONG).show ( );
                }
            });
        }
    }
    public void graphView (View view) {

        graph.setEnabled (false);
        list.setEnabled (true);
        pieChart.setVisibility (View.VISIBLE);
        myListView.setVisibility (View.INVISIBLE);

        pieChart.setHoleRadius (15f);
        pieChart.setTransparentCircleRadius (15f);

        HashMap<String, Integer> hash = databaseHelper.getExpenses ();

        List<PieEntry> value = new ArrayList<>();
        for (Map.Entry h:hash.entrySet ()) {
            Integer val = (Integer) h.getValue ();
            String label = h.getKey ().toString ();

            value.add (new PieEntry (val, label));
        }

        PieDataSet pieDataSet = new PieDataSet (value, "Expenses") ;
        PieData pieData = new PieData (pieDataSet);
        pieChart.setData (pieData);

        pieChart.getLegend ().setEnabled(false);
        pieChart.getDescription ().setEnabled (false);
        pieChart.setEntryLabelColor (Color.BLACK);
        pieChart.setEntryLabelTextSize (10f);
        pieChart.animateXY (1000,1000);

        pieDataSet.setColors (ColorTemplate.VORDIPLOM_COLORS);
    }

    public void listView (View view) {

        graph.setEnabled (true);
        list.setEnabled (false);
        pieChart.setVisibility (View.INVISIBLE);
        myListView.setVisibility (View.VISIBLE);

    }

}

