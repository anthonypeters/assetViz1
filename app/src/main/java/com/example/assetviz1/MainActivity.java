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
    int cash;
    int cryptos;
    int stocks;
    int bonds;
    int comMoney;
    int realEstate;
    int land;
    int vehicles;

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


                cashString = cashInput.getText().toString();
                if (cashString.equals("")){
                    cash = 0;
                } else {
                    cash = Integer.valueOf(cashInput.getText().toString());
                }
                cryptosString = cryptosInput.getText().toString();
                if (cryptosString.equals("")){
                    cryptos = 0;
                } else {
                    cryptos = Integer.valueOf(cryptosInput.getText().toString());
                }
                stocksString = stocksInput.getText().toString();
                if (stocksString.equals("")){
                    stocks = 0;
                } else {
                    stocks = Integer.valueOf(stocksInput.getText().toString());
                }
                bondsString = bondsInput.getText().toString();
                if (bondsString.equals("")){
                    bonds = 0;
                } else {
                    bonds = Integer.valueOf(bondsInput.getText().toString());
                }
                comMoneyString = comMoneyInput.getText().toString();
                if (comMoneyString.equals("")){
                    comMoney = 0;
                } else {
                    comMoney = Integer.valueOf(comMoneyInput.getText().toString());
                }
                realEstateString = realEstateInput.getText().toString();
                if (realEstateString.equals("")){
                    realEstate = 0;
                } else {
                    realEstate = Integer.valueOf(realEstateInput.getText().toString());
                }
                landString = landInput.getText().toString();
                if (landString.equals("")){
                    land = 0;
                } else {
                    land = Integer.valueOf(landInput.getText().toString());
                }
                vehiclesString = vehiclesInput.getText().toString();
                if (vehiclesString.equals("")){
                    vehicles = 0;
                } else {
                    vehicles = Integer.valueOf(vehiclesInput.getText().toString());
                }

                setContentView(R.layout.activity_main);

                //pieChart = (PieChart) findViewById(R.id.idPieChart);
                //pieChart.setDescription();


            }
        });
    }



}