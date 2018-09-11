package s2017s12.kr.hs.mirim.bmitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight, height;
    String result;
    TextView textResult;
    TextView textResult2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight=findViewById(R.id.weight_input);
        height=findViewById(R.id.height_input);
        Button butResult=findViewById(R.id.but_result);

        butResult.setOnClickListener(bmi);
        textResult2=findViewById(R.id.text_bmi);
        textResult=findViewById(R.id.text_result);
    }

    View.OnClickListener bmi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double num1 = Integer.parseInt(weight.getText().toString());
            double num2 = Integer.parseInt(height.getText().toString());
             int lbmi = (int)((num1)/Math.pow(num2/100, 2));

            if(lbmi < 20)
                result = "저체중";
            else if(lbmi < 25)
                result = "정상";
            else if(lbmi < 29.9)
                result = "과체중";
            else if(lbmi < 40)
                result = "비만";
            else
                result = "고도비만";

            textResult2.setText(R.string.text_bmi);
            textResult2.append(lbmi+"");

            textResult.setText(R.string.text_result);
            textResult.append(result+"");
        }
    };
}
