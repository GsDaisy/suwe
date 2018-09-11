package s2017s12.kr.hs.mirim.agetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editYear;
    TextView text_result1, text_result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editYear = findViewById(R.id.edit_year);
        text_result1 = findViewById(R.id.text1);
        text_result2 = findViewById(R.id.text2);
        Button butCalc = findViewById(R.id.btn_ok);
        butCalc.setOnClickListener(ageHandler);
        Button butNew = findViewById(R.id.but_new);
        butNew.setOnClickListener(newHandler);
    }

    public String getGeneration(int age){
        String generation;
        if(age<=7){
            generation="유아";
        }
        else if(age<=13){
            generation = "어린이";
        }
        else if(age<=19){
            generation="청소년";
        }
        else
            generation="성인";


        return generation;
    }


    View.OnClickListener ageHandler = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            int birthYear = Integer.parseInt(editYear.getText().toString());
            Calendar cal = Calendar.getInstance();
            int nowYear = cal.get(Calendar.YEAR);
            int age = nowYear-birthYear+1;
            text_result1.setText("나이는 "+age+"세");
            text_result2.setText("당신은 "+getGeneration(age)+"입니다.");

        }
    };

    View.OnClickListener newHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
         Intent intent = new Intent(getApplicationContext(), NewActivity.class);
         startActivity(intent);
        }
    };
    //새로운 엑티비티를 시작하려면 인턴트 객체를 꼭 생성해야해

}
