package s2017s12.kr.hs.mirim.myvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] picTitles = {"푸","피글렛","이요르","티거","무민","스누피","주디","닉","베이맥스"};
    ImageView[] imgvs= new ImageView[picTitles.length];
    int index;
    int[] voteCount = new int[picTitles.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<picTitles.length;i++){
            final int index = i;
            imgvs[i] = findViewById(R.id.img_pic1+i);
            imgvs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),"["+picTitles[index]+"]의 총 투표수는" +
                            voteCount[index] +"표",Toast.LENGTH_SHORT).show();

                }
            });
        }

        Button btnFinish = findViewById(R.id.btn_vote);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VoteActivity.class);
                intent.putExtra("votecount",voteCount);
                intent.putExtra("pictitle",picTitles);
            }
        });

    }
}