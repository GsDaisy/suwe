package com.example.dbstn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private EditText editName;
    private String advs[] = {"예쁜","못생긴","착한","행복한","우울한","못된"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button but = findViewById(R.id.btn_ok);
        editName = findViewById(R.id.edit_name);
        final Random random = new Random();//시간값
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rIndex = random.nextInt(5);
                Toast.makeText(getApplicationContext(),advs[rIndex]+editName.getText()+"입니다.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
