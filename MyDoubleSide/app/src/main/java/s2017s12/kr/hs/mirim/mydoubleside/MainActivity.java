package s2017s12.kr.hs.mirim.mydoubleside;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        Button btnPlus = findViewById(R.id.btn_plus);
        btnPlus.setOnClickListener(plusHandler);
    }

    View.OnClickListener plusHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("num1", Integer.parseInt(edit1.getText().toString()));
            intent.putExtra("num2", Integer.parseInt(edit2.getText().toString()));
            startActivityForResult(intent, 0);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(resultCode==RESULT_OK){

            int sum = intent.getIntExtra("sum", 0);
            Toast.makeText(this, "합계 : "+sum, Toast.LENGTH_LONG).show();
        }
    }
}
