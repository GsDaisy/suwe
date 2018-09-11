package s2017s12.kr.hs.mirim.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butPlus=findViewById(R.id.but_plus);
        Button butMinus=findViewById(R.id.but_minus);
        Button butMultiply=findViewById(R.id.but_multiply);
        Button butDivide=findViewById(R.id.but_divide);
        edit1=findViewById(R.id.edit_input1);
        edit2=findViewById(R.id.edit_input2);

        textResult=findViewById(R.id.text_result);
        butPlus.setOnClickListener(butListener);
        butMinus.setOnClickListener(butListener);
        butMultiply.setOnClickListener(butListener);
        butDivide.setOnClickListener(butListener);

    }


    View.OnClickListener butListener = new View.OnClickListener(){

        @Override
        public  void onClick(View view){
            int num1 = Integer.parseInt(edit1.getText().toString());
            int num2 = Integer.parseInt(edit2.getText().toString());
            int result = 0;

            switch (view.getId()){
                case R.id.but_plus:
                    result = num1 + num2;
                    break;

                case R.id.but_minus:
                    result = num1 - num2;
                    break;

                case R.id.but_multiply:
                    result = num1 * num2;
                    break;

                case R.id.but_divide:
                    result = num1 / num2;
                    break;
            }
            textResult.setText(R.string.text_result);
            textResult.append(result+"");
        }

    };




}
