package com.example.c0765775_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView fullName;
    TextView cAge;
    TextView taxfilingDate;
    TextView federalTax;
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
        federalTax = (TextView)findViewById(R.id.txtfederalTax);
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


    }
}
