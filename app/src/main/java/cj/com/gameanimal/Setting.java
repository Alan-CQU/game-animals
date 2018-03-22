package cj.com.gameanimal;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.io.IOException;

/**
 * Created by CJ on 2018/3/21.
 */

public class Setting extends AppCompatActivity {
    private Button bt_explain;
    private Switch turnMusic;
    private boolean isPlaying;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        Log.d("test-oncreate","OnCreate.");


        isPlaying =true;


        bt_explain = (Button) findViewById(R.id.explain);
        bt_explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Setting.this);
                dialog.setTitle("Game Rules");
                dialog.setMessage("Choose the picture that matches the text in Button");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.
                        OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                dialog.show();

            }
        });

        turnMusic =(Switch) findViewById(R.id.bg_music);
        turnMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Intent intent = new Intent(Setting.this,BgMusicService.class);
                    startService(intent);
                    isPlaying=true;
                    Log.d("test-clickon","播放器的状态是"+isPlaying);
                }else {
                    Intent intent = new Intent(Setting.this,BgMusicService.class);
                    stopService(intent);
                    isPlaying=false;
                    Log.d("test-clickdown","播放器的状态是"+isPlaying);
                }
            }
        });

    }


    @Override
    protected void onStart(){
        Log.d("test-start","播放器的状态是"+isPlaying);
        super.onStart();
        if(isPlaying){
            turnMusic.setChecked(true);
            Log.d("Message","第二次进入，主动打开开关");
        }
    }

    @Override
    protected void onResume(){
        Log.d("test-resume","播放器的状态是"+isPlaying);
        super.onResume();



    }

    @Override
    protected void onStop(){
        Log.d("test-stop","播放器的状态是"+isPlaying);
        super.onStop();

    }

    @Override
    protected void onRestart(){
        Log.d("test-restart","播放器的状态是"+isPlaying);
        super.onRestart();

    }
    @Override
    protected void onPause(){
        Log.d("test-pause","播放器的状态是"+isPlaying);
        super.onPause();

    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("test-destroy","播放器的状态是"+isPlaying);
    }
}
