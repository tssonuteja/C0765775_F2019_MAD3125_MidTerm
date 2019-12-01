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

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_check = (Button) findViewById(R.id.btn_check);
        //final MaskEditText edit_s = (MaskEditText) findViewById(R.id.txt_sin);
        final EditText edit_s = (EditText) findViewById(R.id.txtSin);
        tvw=(TextView)findViewById(R.id.textView1);
        eText=(EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            final Calendar cldr = Calendar.getInstance();
            int day = cldr.get(Calendar.DAY_OF_MONTH);
            int month = cldr.get(Calendar.MONTH);
            int year = cldr.get(Calendar.YEAR);
            // date picker dialog
            DatePickerDialog picker = new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                    }, year, month, day);
            picker.show();
        }
    });
    btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvw.setText("Selected Date: "+ eText.getText());
        }
    });


        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkNo(edit_s.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Valid 9-Digit Sin Number",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sin Number is Valid",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
        EditText ed =(EditText)findViewById(R.id.txtSin);





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
//test2