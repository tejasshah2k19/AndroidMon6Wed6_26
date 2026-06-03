package com.royal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListViewDemoActivity extends AppCompatActivity {

    ListView lvStudentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_demo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind
        lvStudentList = findViewById(R.id.lvListViewStudentList);

        //data
        //array
        //ArrayList
        ArrayList<String> studentList = new ArrayList<>();

        studentList.add("Ram");
        studentList.add("Shyam");
        studentList.add("RadheShyam");
        studentList.add("Ganshyam");
        studentList.add("Ravan");

        //adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,studentList);
        lvStudentList.setAdapter(adapter);


    }
}