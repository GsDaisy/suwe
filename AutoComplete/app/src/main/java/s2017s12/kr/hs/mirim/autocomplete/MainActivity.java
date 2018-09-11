package s2017s12.kr.hs.mirim.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"girlsDay","girlsGeneration","AOA","amog","CBX"};
        AutoCompleteTextView auto = findViewById(R.id.auto_text);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = findViewById(R.id.auto_multi_text);
        MultiAutoCompleteTextView.CommaTokenizer comma = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(comma);
        multi.setAdapter(adapter);
    }
}
