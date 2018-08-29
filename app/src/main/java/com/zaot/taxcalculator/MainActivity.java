package com.zaot.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText salary = findViewById(R.id.salary);
        final Button calculate = findViewById(R.id.calculate);
        final Switch toggle = findViewById(R.id.isReform);
        final TextView result = findViewById(R.id.result);
        final TextView reformStatus = findViewById(R.id.reformStatus);


        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    reformStatus.setText(R.string.switchOn);
                } else {
                    reformStatus.setText(R.string.switchOff);
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (salary.getText() == null || TextUtils.isEmpty(salary.getText().toString())) {
                    result.setText(R.string.error);
                } else {
                    result.setText(CalculatorHelper.calculate(Float.parseFloat(salary.getText().toString()),
                                                              toggle.isChecked()));
                }
            }
        });
    }
}
