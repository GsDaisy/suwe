package s2017s12.kr.hs.mirim.viewflippertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPrev = findViewById(R.id.btn_prev);
        Button btnNext = findViewById(R.id.btn_next);
        flipper = findViewById(R.id.flipper);

        btnPrev.setOnClickListener(btnHandler);
        btnNext.setOnClickListener(btnHandler);
    }

    View.OnClickListener btnHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_prev:
                    flipper.showPrevious();
                    break;
                case R.id.btn_next:
                    flipper.showNext();
                    break;

            }

        }
    };
}
