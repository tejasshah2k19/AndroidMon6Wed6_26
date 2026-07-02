package com.royal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //bind
        edtEmail = findViewById(R.id.edtLoginEmail);
        edtPassword = findViewById(R.id.edtLoginPassword);


        SharedPreferences sharedPreferences = getSharedPreferences("ITR_CALC",MODE_PRIVATE);
        String email = sharedPreferences.getString("email","");
        String password = "demo";

        edtEmail.setText(email);

        try {
            // store email in internal storage
            FileOutputStream fos = openFileOutput("myData.txt", MODE_PRIVATE);
            fos.write(email.getBytes());
            fos.write('\n');
            fos.write(password.getBytes());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            //read
            FileInputStream fis = openFileInput("myData.txt");
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(reader);//read entire line

            String fileEmail = br.readLine();
            Log.i("fileData",fileEmail);
            String filePwd = br.readLine();
            Log.i("fileData",filePwd);//demo
//
//            while(true){
//                String line = br.readLine();
//                if(line == null){
//                    break;;
//                }else{
//                    Log.i("line ",line);
//                }
//            }

        }catch (Exception e){

        }

        try{

            // /data/data/com.royal/files/
            File file = new File(getFilesDir(),"myData.txt");//
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();




        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}