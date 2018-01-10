package com.nackademin.foureverhh.temperatureconverter180110_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,TextWatcher {

    RadioGroup unit;
    EditText value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit = (RadioGroup)findViewById(R.id.unit);
        unit.setOnCheckedChangeListener(this);

        value = (EditText)findViewById(R.id.value);
        value.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        calculate();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        calculate();
    }

    protected void calculate()
    {
        TextView degF =(TextView)findViewById(R.id.degF);
        TextView degC =(TextView)findViewById(R.id.degC);
        TextView degA =(TextView)findViewById(R.id.degA);

        double f=0,c=0,a=0;

        if(unit.getCheckedRadioButtonId()==R.id.unitF)
        {
            f=Double.parseDouble(value.getText().toString());
            c=(f-32)*5/9;
            a=c+373.15;
        }else if(unit.getCheckedRadioButtonId()==R.id.unitC)
        {
            c=Double.parseDouble(value.getText().toString());
            f=c*9/5+32;
            a=c+273.15;
        }else if(unit.getCheckedRadioButtonId()==R.id.unitAbsolute)
        {
            a=Double.parseDouble(value.getText().toString());
            c=a-273.15;
            f=f=c*9/5+32;
        }

        if(value.length()==0)
        {
            value.setText("You must input a number here!");
        }else
        {
            degF.setText(String.format("%.1f",c)+" "+getResources().getString(R.string.charC));
            degC.setText(String.format("%.1f",f)+" "+getResources().getString(R.string.charF));
            degA.setText(String.format("%.2f",a));
        }
    }
}
