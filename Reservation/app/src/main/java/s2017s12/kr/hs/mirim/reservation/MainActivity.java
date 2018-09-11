package s2017s12.kr.hs.mirim.reservation;

import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono1;
    RadioGroup rgSet;
    RadioButton rbDate, rbTime;
    CalendarView calendar1;
    TimePicker time1;
    TextView textResult;
    int year, month, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnDone = findViewById(R.id.btn_done);
        chrono1 = findViewById(R.id.chronometer1);
        rgSet = findViewById(R.id.rg_set);
        rbDate = findViewById(R.id.radio_date);
        rbTime = findViewById(R.id.radio_time);
        calendar1 = findViewById(R.id.calendar1);
        time1 = findViewById(R.id.time1);
        textResult = findViewById(R.id.text_result);

        rbDate.setOnClickListener(radioHandler);
        rbTime.setOnClickListener(radioHandler);

        btnStart.setOnClickListener(buttonHandler);
        btnDone.setOnClickListener(buttonHandler);

        calendar1.setOnDateChangeListener(calendarHandler);
    }

    View.OnClickListener radioHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calendar1.setVisibility(View.INVISIBLE);
            time1.setVisibility(View.INVISIBLE);

            switch(rgSet.getCheckedRadioButtonId()) {
                case R.id.radio_date:
                    calendar1.setVisibility(View.VISIBLE);
                    break;
                case R.id.radio_time:
                    time1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener buttonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_start :
                    chrono1.setTextColor(Color.BLUE);
                    chrono1.setBase(SystemClock.elapsedRealtime());
                    chrono1.start();
                    break;
                case R.id.btn_done :
                    chrono1.setTextColor(Color.RED);
                    chrono1.stop();
                    textResult.setText(year + "년 " + month + "월 " + date + "일 " +
                            time1.getCurrentHour() + ":" + time1.getCurrentMinute() + "에 예약완료됨");
                    break;
            }
        }
    };

    CalendarView.OnDateChangeListener calendarHandler = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            MainActivity.this.year = year;
            MainActivity.this.month = month + 1;
            date = dayOfMonth;
        }
    };

}