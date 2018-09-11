package s2017s12.kr.hs.mirim.adapterlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] heroArr={"아이언맨","닥터스트레인지","스파이더맨","캡틴아메리카","블랙위도우","호크아이","토르","블랙팬서"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list1 = findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, heroArr);
        list1.setAdapter(adapter);


    }

   AdapterView.OnItemClickListener itemHandler = new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           Toast.makeText(getApplicationContext(), heroArr[position]+"선택되었습니다.", Toast.LENGTH_LONG).show();
       }
   };

}
