package s2017s12.kr.hs.mirim.mybmi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultAtivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_ativity);
        Intent intent  = getIntent();
        String name = intent.getStringExtra("name");
        String weight = intent.getStringExtra("weight");
        String height = intent.getStringExtra("height");

        double bmi = calcBMI(Double.parseDouble(weight), Double.parseDouble(height));
        String bmiStr = bmiweight(bmi);
        TextView textResult1 = findViewById(R.id.text_result1);
        TextView textResult2 = findViewById(R.id.text_result2);
        textResult1.setText(name+"님의 BMI 지수는 "+String.format("%.2f",bmi)+"kg/㎡ 입니다.");
        textResult2.setText(name+"님의 체중은 BMI 지수 결과에 따라서 ["+bmiStr+"]체중입니다.");
        int resId = R.drawable.2;

        switch (bmiStr){
            case "저":
                resId=R.drawable.1;
                break;
            case "정상":
                resId=R.drawable.2;
                break;
            case "과":
                resId=R.drawable.3;
                break;
                case "비만":
                resId=R.drawable.4;
                break;
            case "고도비만":
                resId=R.drawable.5;
                break;

        }
        ImageView imgV=findViewById(R.id.imgv);
        imgV.setImageResource(resId);

        Button btnBack=findViewById(R.id.btn_back);
        btnBack.setOnClickListener(handler);

    }

    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };



    public double calcBMI(double weight, double height){
        double bmi = weight/(Math.pow(height/100, 2));

        return bmi;
    }


    public String bmiweight(double bmi){
        String result="";

        if(bmi<18.5) result="저";
        else if(bmi<25) result="정상";
        else if(bmi<30) result="과";
        else if(bmi<40) result="비만";
        else result="고도비만";


        return result;


    }


}
