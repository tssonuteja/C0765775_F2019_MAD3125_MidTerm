package com.example.c0765775_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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
        rrsp= (TextView)findViewById(R.id.txtRrspContributed);

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
        }else if (pT >= 10582.01 && pT <= 43906){
            pT = (pT/100)*5.05;
        }else if (pT >= 43906.01 && pT <= 87813){
            pT = (pT/100)*9.15;
        }else if (pT >= 87813.01 && pT<= 150000){
            pT = (pT/100)*11.16;
        }else if (pT >= 150000.01 && pT <= 220000){
            pT = (pT/100)*12.16;
        }else if (pT >= 220000.01){
            pT = (pT/100)*13.16;
        }
        String finalPT = String.valueOf(pT);
        provincialTax.setText(finalPT+"$");
        double cppcontr = getIntent().getDoubleExtra("grossInc",0);
        double contribution = (cppcontr/100)*5.10;

        String finalcfwdcpp = String.valueOf(contribution);
        carryfrdcpp.setText(finalcfwdcpp+"$");
        double rrspcontr = getIntent().getDoubleExtra("rrspContribution",0);
        double rrspContribution = (rrspcontr/100)*18;

        String finalcfwdrrsp = String.valueOf(rrspContribution);
        if (finalcfwdrrsp.startsWith("-")){
            carryfrdcpp.setText(finalcfwdrrsp+"$");
            carryfrdcpp.setTextColor(Color.RED);
        }else {
            carryfrdcpp.setText(finalcfwdrrsp + "$");
        }



        double ttaxPayed = federalTax + pT;
        String tax = String.valueOf(ttaxPayed);

        double tttax = getIntent().getDoubleExtra("grossInc",0);

        if (tttax<=53100){
            eI = tttax/100*1.62;
        }

        String finalEI = String.valueOf(eI);
        pEi.setText(finalEI+"$");

        double ttaxincc = tttax - (contribution + eI + rrspContribution );
        String totaltax = String.valueOf(ttaxincc);
        taxin.setText(totaltax+"$");



    }
}
