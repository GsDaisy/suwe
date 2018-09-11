package s2017s12.kr.hs.mirim.implicitintent;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="권한";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDial = findViewById(R.id.btn_dia1);
        Button btnHome = findViewById(R.id.btn_home);
        Button btnMap = findViewById(R.id.btn_map);
        Button btnSearch = findViewById(R.id.btn_search);
        Button btnSms = findViewById(R.id.btn_sms);
        Button btnCamera = findViewById(R.id.btn_camera);
        Button btnFinish = findViewById(R.id.btn_finish);

        btnDial.setOnClickListener(btnHandler);
        btnHome.setOnClickListener(btnHandler);
        btnMap.setOnClickListener(btnHandler);
        btnSearch.setOnClickListener(btnHandler);
        btnSms.setOnClickListener(btnHandler);
        btnCamera.setOnClickListener(btnHandler);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }


        });

    }

    View.OnClickListener btnHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            Uri uri = null;
            switch (v.getId()) {
                case R.id.btn_dia1:
                    uri = Uri.parse("tel:010-333-7777");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.btn_home:
                    uri = Uri.parse("http://e-mirim.hs.kr");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_map:
                    uri = Uri.parse("http://maps.google.com/maps?q=37.466571,126.932962");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "임정훈 선생님");
                    break;
                case R.id.btn_sms:
                    uri = Uri.parse("smsto:" + Uri.encode("010-2222-7878"));
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "사랑합니다. 여러분");
                    intent.setData(uri);
                    break;
                case R.id.btn_camera:
                    Log.v("미림", "카메라");
                    boolean isGrantCamera = grantCameraPermission();
                    if(isGrantCamera) {
                        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(intent);
                    }
                    break;
            }
            startActivity(intent);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("액티비티가 종료될 때 : ", "onPause()호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("액티비티가 종료될 때 : ", "onStop()호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("액티비티가 종료될 때 : ", "onDestroy()호출");
    }


    private boolean grantCameraPermission() {
        if (Build.VERSION.SDK_INT >= 23) {

            if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                Log.v(TAG, "Permissoin is granted");
                return true;
            }else{
                Log.v(TAG, "Permissoin is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
                return false;
            }

        }else{
            Toast.makeText(this, "Camera Permission", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Camera Permission is Grant");
            return true;
        }
    }




}
