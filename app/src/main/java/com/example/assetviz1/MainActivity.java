package com.example.assetviz1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
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
    String otherString;

    float cash;
    float cryptos;
    float stocks;
    float bonds;
    float comMoney;
    float realEstate;
    float land;
    float vehicles;
    float other;

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
    EditText otherInput;

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
        otherInput = (EditText) findViewById(R.id.otherInput);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                setContentView(R.layout.activity_main);

                PieChart pieChart = findViewById(R.id.idPieChart);
                List<PieEntry> entries = new ArrayList<>();


                cashString = cashInput.getText().toString();
                if (cashString.equals("0")){
                    cash = 0;
                } else {
                    cash = Float.valueOf(cashInput.getText().toString());
                }

                cryptosString = cryptosInput.getText().toString();
                if (cryptosString.equals("0")){
                    cryptos = 0;
                } else {
                    cryptos = Float.valueOf(cryptosInput.getText().toString());
                }

                stocksString = stocksInput.getText().toString();
                if (stocksString.equals("0")){
                    stocks = 0;
                } else {
                    stocks = Float.valueOf(stocksInput.getText().toString());
                }

                bondsString = bondsInput.getText().toString();
                if (bondsString.equals("0")){
                    bonds = 0;
                } else {
                    bonds = Float.valueOf(bondsInput.getText().toString());
                }

                comMoneyString = comMoneyInput.getText().toString();
                if (comMoneyString.equals("0")){
                    comMoney = 0;
                } else {
                    comMoney = Float.valueOf(comMoneyInput.getText().toString());
                }

                realEstateString = realEstateInput.getText().toString();
                if (realEstateString.equals("0")){
                    realEstate = 0;
                } else {
                    realEstate = Float.valueOf(realEstateInput.getText().toString());
                }

                landString = landInput.getText().toString();
                if (landString.equals("0")){
                    land = 0;
                } else {
                    land = Float.valueOf(landInput.getText().toString());
                }

                vehiclesString = vehiclesInput.getText().toString();
                if (vehiclesString.equals("0")){
                    vehicles = 0;
                } else {
                    vehicles = Float.valueOf(vehiclesInput.getText().toString());
                }

                float sumCategories;

                sumCategories = (cash + cryptos + stocks + bonds + comMoney + realEstate + land + vehicles);

                float percentCash = (cash/sumCategories);
                float percentCryptos = (cryptos/sumCategories);
                float percentStocks = (stocks/sumCategories);
                float percentBonds = (bonds/sumCategories);
                float percentcomMoney = (comMoney/sumCategories);
                float percentrealEstate = (realEstate/sumCategories);
                float percentLand = (land/sumCategories);
                float percentVehicles= (vehicles/sumCategories);

                float[] assets = {percentCash, percentCryptos, percentStocks, percentBonds, percentcomMoney, percentrealEstate, percentLand, percentVehicles};
                for (int i = 0; i < 8; i++){
                    float x = assets[i];
                    if (x != 0){
                        if (i == 0){
                            entries.add(new PieEntry(percentCash*100, "Cash"));
                        } else if (i == 1){
                            entries.add(new PieEntry(percentCryptos*100, "Crypto's"));
                        } else if (i == 2){
                            entries.add(new PieEntry(percentStocks*100, "Stocks"));
                        } else if (i == 3){
                            entries.add(new PieEntry(percentBonds*100, "Bonds"));
                        } else if (i == 4){
                            entries.add(new PieEntry(percentcomMoney*100, "Gold/Silver/etc."));
                        } else if (i == 5){
                            entries.add(new PieEntry(percentrealEstate*100, "Real Estate"));
                        } else if (i == 6){
                            entries.add(new PieEntry(percentLand*100, "Land"));
                        } else if (i == 7){
                            entries.add(new PieEntry(percentVehicles*100, "Vehicles"));
                        }
                    }
                }

                PieDataSet set = new PieDataSet(entries, "Legend");
                PieData data = new PieData(set);
                pieChart.setData(data);

                int[] PASTEL_COLORS = {
                        Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162),
                        Color.rgb(191, 134, 134), Color.rgb(179, 48, 80), Color.rgb(165, 137, 193),
                        Color.rgb(255, 237, 81), Color.rgb(240, 232, 205)
                };
                
                set.setColors(ColorTemplate.createColors(PASTEL_COLORS));

                pieChart.animateY(3000);

                pieChart.setCenterText("Asset Portfolio");


                pieChart.invalidate();




            }
        });
    }



}