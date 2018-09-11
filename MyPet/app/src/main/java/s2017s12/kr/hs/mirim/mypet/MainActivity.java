package s2017s12.kr.hs.mirim.mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    CheckBox checkStart;
    LinearLayout linear;
    RadioGroup rg;
    ImageView imgV;
    RadioButton rbDog, rbCat, rbRabbit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkStart = findViewById(R.id.check1);
        linear = findViewById(R.id.linear1);

        checkStart.setOnCheckedChangeListener(checkHandler);
//        Button butDone=findViewById(R.id.but_done);
//        butDone.setOnClickListener(butHandler);
        RadioButton rbCat = findViewById(R.id.rb_cat);
        RadioButton rbDog = findViewById(R.id.rb_dog);
        RadioButton rbRabbit = findViewById(R.id.rb_rabbit);

        rbCat.setOnClickListener(butHandler);
        rbDog.setOnClickListener(butHandler);
        rbRabbit.setOnClickListener(butHandler);
        rg = findViewById(R.id.rg_pet);
        imgV = findViewById(R.id.imgv);
    }

    CompoundButton.OnCheckedChangeListener checkHandler = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                  if (checkStart.isChecked()){
                      linear.setVisibility(View.VISIBLE);
                  }
                  else
                      linear.setVisibility(View.INVISIBLE);



        }
    };

    View.OnClickListener butHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
               switch (rg.getCheckedRadioButtonId()){
                   case R.id.rb_cat:
                       imgV.setImageResource(R.drawable.ari);
                       break;
                   case R.id.rb_dog:
                       imgV.setImageResource(R.drawable.ari2);
                       break;
                   case R.id.rb_rabbit:
                       imgV.setImageResource(R.drawable.ari3);
               }
        }
    };

}
