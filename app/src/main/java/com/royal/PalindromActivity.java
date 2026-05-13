package com.royal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PalindromActivity extends AppCompatActivity {


    //declaration
    EditText edtStr;
    Button btnTest;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_palindrom);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //binding
        edtStr = findViewById(R.id.edtPalindromeStr);//R
        btnTest = findViewById(R.id.btnPalindromeSubmit);
        tvResult = findViewById(R.id.tvPalindromeResult);

        //activate click listener button
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = edtStr.getText().toString();


                Log.i("msg","button clicked.....");
                Log.i("msg","string => "+str);


                StringBuffer sb = new StringBuffer(str);

                String rev = sb.reverse().toString();

                if(str.equals(rev)){
                    //palindrome
                    tvResult.setText("Palindrome");

                }else{
                    tvResult.setText("Not Palindrome");
                }

            }
        });

    }
}