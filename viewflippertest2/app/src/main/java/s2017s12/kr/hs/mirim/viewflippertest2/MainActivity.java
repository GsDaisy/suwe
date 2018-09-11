package s2017s12.kr.hs.mirim.viewflippertest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);

        flipper = findViewById(R.id.flipper);
        flipper.setFlipInterval(1000);

        btnStart.setOnClickListener(btnHandler);
        btnStop.setOnClickListener(btnHandler);
    }

    View.OnClickListener btnHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_start:
                    flipper.startFlipping();
                    break;
                case R.id.btn_stop:
                    flipper.stopFlipping();
                    break;

            }

        }
    };
}
/*
    float downX;
    float upX;
    boolean flag;


    View.OnTouchListener touchHandler = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downX = v.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    upX = v.getX();
                    flag = true;
                    break;
            }
            if (flag) {
                if (downX > upX) {
                    flipper.showNext();
                } else {
                    flipper.showPrevious();
                    flag = false;
                }

            }
            return true;
        }


    };
}
*/