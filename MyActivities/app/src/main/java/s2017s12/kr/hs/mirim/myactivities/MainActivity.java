package s2017s12.kr.hs.mirim.myactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.btn_start);
        group=findViewById(R.id.rg);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class type = SecondActivity.class;
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.radio_second:
                        type = SecondActivity.class;
                        break;

                    case R.id.radio_third:
                        type = ThirdActivity.class;
                        break;

                }
                Intent intent = new Intent(getApplicationContext(),type);
                startActivity(intent);
            }
        });


    }
}
