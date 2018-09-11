package com.example.dbstn.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        Button but = findViewById(R.id.btn_mirim);
//        textFirst = findViewById(R.id.text_first);
//
//        but.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        textFirst.setText(R.string.btn_lbl1);
        textFirst.setTextSize(25);
        textFirst.setBackgroundColor(Color.YELLOW);
    }
//        View.OnClickListener listener = new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                textFirst.setText(R.string.btn_lbl1);
//                textFirst.setTextSize(25);
//                textFirst.setBackgroundColor(Color.YELLOW);
//            }
//        };

}
