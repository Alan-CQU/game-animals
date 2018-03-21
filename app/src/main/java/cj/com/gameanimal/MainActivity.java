package cj.com.gameanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btPlay;
    private Button btSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        btPlay = (Button) findViewById(R.id.btn_play);
        btSetting = (Button) findViewById(R.id.btn_setting);
        btPlay.setOnClickListener(this);
        btSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_play:
                startActivity(new Intent(MainActivity.this,Task1.class));
                finish();
                break;
            case R.id.btn_setting:
                startActivity(new Intent(MainActivity.this,Setting.class));
                break;
            default:
                break;
        }
    }
}
