package com.example.c0765775_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_check = (Button) findViewById(R.id.btn_check);
        //final MaskEditText edit_s = (MaskEditText) findViewById(R.id.txt_sin);
        final EditText edit_s = (EditText) findViewById(R.id.txtSin);

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