package com.example.c0765775_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView fullName;
    TextView cAge;
    TextView taxfilingDate;
    TextView federallTax;
    TextView provincialTax;
    TextView carryfrdcpp;
    TextView pEi;
    TextView rrsp;
    TextView taxin;
    private double eI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        fullName = (TextView)findViewById(R.id.txtfullName);
        cAge = (TextView)findViewById(R.id.txtage);
        taxfilingDate = (TextView)findViewById(R.id.taxFilingdate);
        federallTax = (TextView)findViewById(R.id.txtfederalTax);
        provincialTax = (TextView)findViewById(R.id.txtprovincialTax);
        carryfrdcpp = (TextView)findViewById(R.id.txtcarryForwardCpp);
        pEi = (TextView)findViewById(R.id.txteI);
        carryfrdcpp = (TextView)findViewById(R.id.txtcarryForwardCpp);
        taxin = (TextView)findViewById(R.id.txtIncome);

        String fname = getIntent().getStringExtra("fullName");
        String age = getIntent().getStringExtra("age");
        String cdate = getIntent().getStringExtra("currentdate");
        fullName.setText(fname);
        cAge.setText(age);
        taxfilingDate.setText(cdate);
        double federalTax = getIntent().getDoubleExtra("GROSS",0);
        if (federalTax <= 12069){
            federalTax = federalTax;
        }else if (federalTax >= 12069.01 && federalTax <= 47630){
            federalTax = (federalTax/100)*15;
            federalTax = (federalTax/100)*26;
        }else if (federalTax >= 147667.01 && federalTax <= 210371){
            federalTax = (federalTax/100)*29;
        }else if (federalTax >= 210371.01) {
            federalTax = (federalTax / 100) * 33;
        }
            String finalresult = String.valueOf(federalTax);

            federallTax.setText(finalresult+"$");

        double pT = getIntent().getDoubleExtra("grossInc",0);

        if (pT <= 10582){
            pT = pT;



    }
}
