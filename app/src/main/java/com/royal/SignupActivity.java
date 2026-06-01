package com.royal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSubmit  = findViewById(R.id.btnSignupSubmit);
        edtEmail  = findViewById(R.id.etSignupEmail);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                //sharedpref

                SharedPreferences sharedPreferences = getSharedPreferences("ITR_CALC",MODE_PRIVATE);
                SharedPreferences.Editor s =   sharedPreferences.edit();
                s.putString("email",email);
                s.apply();

                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);



            }
        });
    }
}