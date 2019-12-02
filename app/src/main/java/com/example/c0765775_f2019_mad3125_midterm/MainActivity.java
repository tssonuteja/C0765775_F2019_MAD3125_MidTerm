package com.example.c0765775_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    EditText  birth;
    EditText  income;
    EditText  RRSP;
    RadioGroup genderGroup;
    RadioButton radioGenderButton;
    Calendar myCalendar = Calendar.getInstance();
    private Calendar calendar;
    int day, month, year;
    private DatePickerDialog datePickerDialog;
    private int remaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sin = (EditText) findViewById(R.id.txtSin);
        firstName = (EditText) findViewById(R.id.txtfirstName);
        lastName = (EditText) findViewById(R.id.txtlastName);
        birth= (EditText) findViewById(R.id.dob);
        income = (EditText) findViewById(R.id.txtIncome);
        RRSP = (EditText) findViewById(R.id.txtRrspContributed);
        genderGroup = (RadioGroup) findViewById(R.id.radioGroup1);



        int selectedId = genderGroup.getCheckedRadioButtonId();
        radioGenderButton = (RadioButton) findViewById(selectedId);
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);



        birth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                birth.setCursorVisible(false);
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year1,
                                                  int monthOfYear, int dayOfMonth) {
                                year = year1;
                                month = monthOfYear;
                                day = dayOfMonth;
                                datePickerDialog.updateDate(year, monthOfYear,
                                        dayOfMonth);
                                birth.setText((month + 1) + "/" + day + "/"
                                        + year);
                            }

                        }, year, month, day);

                datePickerDialog.setTitle("Select Date");
                datePickerDialog.show();

            }

        });


                         findViewById(R.id.btnsubmit).setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                                               if (sin.length() != 0 && birth.length() != 0 && firstName.length() != 0 && lastName.length() != 0 && income.length() != 0 && RRSP.length() != 0) {


                                                                   String sinNum = String.valueOf(sin.getText());
                                                                   String dateofBirth = String.valueOf(birth.getText());
                                                                   final String mAge = String.valueOf(getAge(dateofBirth));
                                                                   String fname = String.valueOf(firstName.getText());
                                                                   String lname = String.valueOf(lastName.getText());
                                                                   String grsinc = String.valueOf(income.getText());
                                                                   String rrspcntr = String.valueOf(RRSP.getText());
                                                                   double grossInc = Double.parseDouble(grsinc);
                                                                   double rrspcntrr = Double.parseDouble(rrspcntr);
                                                                   int ageee = Integer.parseInt(mAge);



        Button submit = (Button) findViewById(R.id.btnsubmit);


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