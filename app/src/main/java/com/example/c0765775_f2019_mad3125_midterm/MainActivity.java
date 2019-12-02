package com.example.c0765775_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText sin;
    EditText firstName;
    EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_check = (Button) findViewById(R.id.btn_check);
        final MaskEditText edit_s = (MaskEditText) findViewById(R.id.txtSin);
        sin = (EditText) findViewById(R.id.txtSin);


        Button submit = (Button) findViewById(R.id.btnSubmit);


        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSin(edit_s.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please Enter Valid 9-Digit Sin Number", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sin Number is Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

        public Boolean checkSin(String sn)
        {
            Boolean check = false;

            String no ="\\d*\\.?\\d+"; //d is considered as [0-9] & .? as Optional decimal point

            CharSequence inputStr = sn;

            Pattern ptn = Pattern.compile(no,Pattern.CASE_INSENSITIVE);
            Matcher matcher = ptn.matcher(inputStr);

            if (matcher.matches()){
                check = true;
            }
            return check;


        }


    }
//test1
//test2