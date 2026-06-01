package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TaxDeductionActivity extends AppCompatActivity {

    TextView tvIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tax_deduction);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        tvIncome = findViewById(R.id.tvDeductionIncome);


        //read all the info which is send by previous activity
        Intent intent = getIntent();

        //name
        String name = intent.getStringExtra("name");
        //income
        int income  = intent.getIntExtra("income",0);
        //regime
        String  regime = intent.getStringExtra("regime");



        tvIncome.setText("Your Total Income : "+income);





    }
}