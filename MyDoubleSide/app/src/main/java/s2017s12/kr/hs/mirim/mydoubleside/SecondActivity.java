package s2017s12.kr.hs.mirim.mydoubleside;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        sum = intent.getIntExtra("num1", 0) + intent.getIntExtra("num2",0);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(backHandler);

    }

    View.OnClickListener backHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("sum", sum);
            setResult(RESULT_OK, intent);
            finish();
        }
    };

}
