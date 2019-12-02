package com.example.c0765775_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView fullName;
    TextView taxfilingDate;
    TextView federalTax;
    TextView provincialTax;
    TextView carryfrdcpp;
    TextView pEi;
    TextView rrsp;
    TextView taxin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
