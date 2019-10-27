package com.example.assetviz1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.*;


public class MainActivity extends Activity {

    private static String TAG = "MainActivity";

    private float[] yData = {};
    private float[] xData = {};
    PieChart pieChart;


    //Variables
    String cashString;
    String cryptosString;
    String stocksString;
    String bondsString;
    String comMoneyString;
    String realEstateString;
    String landString;
    String vehiclesString;

    float cash;
    float cryptos;
    float stocks;
    float bonds;
    float comMoney;
    float realEstate;
    float land;
    float vehicles;

    //Button
    Button button;

    //Input boxes
    EditText cashInput;
    EditText cryptosInput;
    EditText stocksInput;
    EditText bondsInput;
    EditText comMoneyInput;
    EditText realEstateInput;
    EditText landInput;
    EditText vehiclesInput;

    public void onCreate (Bundle information){
        super.onCreate(information);
        setContentView(R.layout.content_main);

        cashInput = (EditText) findViewById(R.id.cashInput);
        cryptosInput = (EditText) findViewById(R.id.cryptosInput);
        stocksInput = (EditText) findViewById(R.id.stocksInput);
        bondsInput = (EditText) findViewById(R.id.bondsInput);
        comMoneyInput = (EditText) findViewById(R.id.comMoneyInput);
        realEstateInput = (EditText) findViewById(R.id.realEstateInput);
        landInput = (EditText) findViewById(R.id.landInput);
        vehiclesInput = (EditText) findViewById(R.id.vehiclesInput);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                setContentView(R.layout.activity_main);

                PieChart pieChart = findViewById(R.id.idPieChart);
                List<PieEntry> entries = new ArrayList<>();

                cashString = cashInput.getText().toString();
                if (cashString.equals("")){
                    cash = 0;
                } else {
                    cash = Float.valueOf(cashInput.getText().toString());
                    entries.add(new PieEntry(cash, "Cash"));
                }

                cryptosString = cryptosInput.getText().toString();
                if (cryptosString.equals("")){
                    cryptos = 0;
                } else {
                    cryptos = Float.valueOf(cryptosInput.getText().toString());
                    entries.add(new PieEntry(cryptos, "Crypto's"));
                }

                stocksString = stocksInput.getText().toString();
                if (stocksString.equals("")){
                    stocks = 0;
                } else {
                    stocks = Float.valueOf(stocksInput.getText().toString());
                    entries.add(new PieEntry(stocks, "Stocks"));
                }

                bondsString = bondsInput.getText().toString();
                if (bondsString.equals("")){
                    bonds = 0;
                } else {
                    bonds = Float.valueOf(bondsInput.getText().toString());
                    entries.add(new PieEntry(bonds, "Bonds"));

                }

                comMoneyString = comMoneyInput.getText().toString();
                if (comMoneyString.equals("")){
                    comMoney = 0;
                } else {
                    comMoney = Float.valueOf(comMoneyInput.getText().toString());
                    entries.add(new PieEntry(comMoney, "Gold/Silver/etc."));

                }

                realEstateString = realEstateInput.getText().toString();
                if (realEstateString.equals("")){
                    realEstate = 0;
                } else {
                    realEstate = Float.valueOf(realEstateInput.getText().toString());
                    entries.add(new PieEntry(realEstate, "Real Estate"));

                }

                landString = landInput.getText().toString();
                if (landString.equals("")){
                    land = 0;
                } else {
                    land = Float.valueOf(landInput.getText().toString());
                    entries.add(new PieEntry(land, "Land"));

                }

                vehiclesString = vehiclesInput.getText().toString();
                if (vehiclesString.equals("")){
                    vehicles = 0;
                } else {
                    vehicles = Float.valueOf(vehiclesInput.getText().toString());
                    entries.add(new PieEntry(vehicles, "Vehicles"));

                }

                
                PieDataSet set = new PieDataSet(entries, "Legend");
                PieData data = new PieData(set);
                pieChart.setData(data);

                set.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart.setCenterText("Asset Portfolio");
                pieChart.invalidate();




            }
        });
    }



}