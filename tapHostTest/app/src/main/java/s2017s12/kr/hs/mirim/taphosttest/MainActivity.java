package s2017s12.kr.hs.mirim.taphosttest;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();
        ArrayList<TabHost.TabSpec> tabSpecs = new ArrayList<TabHost.TabSpec>();
        String[] texts={"First","Second","Third"};
        for(int i=0;i<3;i++){
            tabSpecs.add(tabHost.newTabSpec("a"+(1+i)).setIndicator(texts[i]+"Tab"));
        }

        int j=0;
        for(TabHost.TabSpec tabSpec:tabSpecs){
            tabSpec.setContent(R.id.linear1+j);
            tabHost.addTab(tabSpec);
            j++;
        }



    }
}
