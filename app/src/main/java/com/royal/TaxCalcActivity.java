package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TaxCalcActivity extends AppCompatActivity {

    EditText edtIncome;
    EditText edtName;
    Button btnNext;
    TextView tvResult;

    RadioGroup rgRegime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tax_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        edtIncome = findViewById(R.id.edtTaxCalcIncome);
        edtName = findViewById(R.id.edtTaxCalcName);
        btnNext = findViewById(R.id.btnTaxCalcNext);
        tvResult  = findViewById(R.id.tvTaxCalcResult);
        rgRegime = findViewById(R.id.rgTaxCalcRegime);


        //click
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int rbId = rgRegime.getCheckedRadioButtonId();// oldRegime newRegime -1
                String n = edtName.getText().toString();
                String inc = edtIncome.getText().toString();
                boolean isError = false;

                if (n.isBlank()) {
                    isError = true;
                    edtName.setError("Please Enter name");
                }
                if (inc.isBlank()) {
                    isError = true;
                    edtIncome.setError("Please Enter Income");
                }

                if(rbId == -1){
                    isError = true;
                    //
                }


                if (isError == false) {

                    String name = edtName.getText().toString();
                    int income = Integer.parseInt(edtIncome.getText().toString());
//                    int taxRate = 0;
                    //Income Tax Slab (₹)Income Tax RateUp to ₹4,00,000Nil₹4,00,001 to ₹8,00,0005%₹8,00,001 to ₹12,00,00010%₹12,00,001 to ₹16,00,00015%₹16,00,001 to ₹20,00,00020%₹20,00,001 to ₹24,00,00025%Above ₹24,00,00030%


                     RadioButton rb =  findViewById(rbId);
                     String regime =  rb.getText().toString();
//
//                     if(regime.toLowerCase().contains("new")) {
//
//                         if (income <= 400000) {
//                             taxRate = 0;
//                         } else if (income >= 400001 && income <= 800000) {
//                             taxRate = 5;
//                         } else if (income >= 800001 && income <= 1200000) {
//                             taxRate = 10;
//                         } else if (income >= 1200001 && income <= 1600000) {
//                             taxRate = 15;
//                         } else if (income >= 1600001 && income <= 2000000) {
//                             taxRate = 20;
//                         } else if (income >= 2000001 && income <= 2400000) {
//                             taxRate = 25;
//                         } else {
//                             taxRate = 30;
//                         }
//                     }else{
//                         //old
//                         if(income <= 250000){
//                             taxRate =0;
//                         }else if(income <=500000){
//                            taxRate = 5;
//                         }else if(income <= 1000000){
//                             taxRate = 20;
//                         }else if(income > 1000000){
//                             taxRate = 30;
//                         }
//                     }
//
//
//                    tvResult.setText("Your tax Rate is : " + taxRate + "%");


                    //navigate to deduction activity
                    Intent intent = new Intent(getApplicationContext(), TaxDeductionActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("income",income);
                    intent.putExtra("regime",regime);
                    startActivity(intent);


                }
            }
        });

    }
}