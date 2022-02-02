package com.example.fragement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
RecyclerView subject;
    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subject=(RecyclerView) findViewById(R.id.recycle);

        subject.setLayoutManager(new LinearLayoutManager(this));
        //String[] sub={"C","JAVA","C++","PYTHON","C","JAVA","C++","PYTHON","C","JAVA","C++","PYTHON"};
        adapter a=new adapter(MainActivity.this,personNames);
        //subject.setAdapter(new adapter(sub));
        subject.setAdapter(a);

    }
}