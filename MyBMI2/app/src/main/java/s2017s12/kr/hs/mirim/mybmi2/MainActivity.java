package s2017s12.kr.hs.mirim.mybmi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editName, editPhone, editWeight, editHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editPhone = findViewById(R.id.edit_phone);
        editWeight = findViewById(R.id.edit_weight);
        editHeight = findViewById(R.id.edit_height);

        Button btnResult = findViewById(R.id.btn_result);
        Button btnReset=findViewById(R.id.btn_reset);
        btnResult.setOnClickListener(handler);
        btnReset.setOnClickListener(handler);

    }

    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             switch (v.getId()){
                 case R.id.btn_result:
                     Intent intent = new Intent(getApplicationContext(), ResultAtivity.class);
                     intent.putExtra("name", editName.getText().toString());
                     intent.putExtra("phone", editPhone.getText().toString());
                     intent.putExtra("weight", editWeight.getText().toString());
                     intent.putExtra("height", editHeight.getText().toString());
                     startActivity(intent);
                     break;

                 case R.id.btn_reset:
                     editName.setText("");
                     editPhone.setText("");
                     editWeight.setText("");
                     editHeight.setText("");
                     break;
             }
        }
    };


}
