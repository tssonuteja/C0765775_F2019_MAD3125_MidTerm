package com.example.c0765775_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed =(EditText)findViewById(R.id.txtSin);


    }


    public boolean checkNo(String sn){
        Boolean check = false;
        String no = "\\d*\\d+";
        CharSequence inputStr = sn;
        Pattern pte =Pattern.compile(no,Pattern.CASE_INSENSITIVE);
        Matcher matcher =pte.matcher(inputStr);
        if(matcher.matches())
        {
            check = true;

        }
        return check;

    }
}
//test
//test1