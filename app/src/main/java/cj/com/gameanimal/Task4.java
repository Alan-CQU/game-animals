package cj.com.gameanimal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CJ on 2018/3/21.
 */

public class Task4 extends AppCompatActivity implements View.OnClickListener{

    private ImageView img41;
    private ImageView img42;
    private ImageView img43;
    private ImageView img44;

    private TextView tvCnt4;
    private String strState4="";
    private Button btAccept4;


    private boolean isHouse=true;
    private boolean isPig=true;
    private boolean isHoney=true;
    private boolean isBird =true;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task4);


        img41 = (ImageView) findViewById(R.id.img_41);
        img42 = (ImageView) findViewById(R.id.img_42);
        img43 = (ImageView) findViewById(R.id.img_43);
        img44 = (ImageView) findViewById(R.id.img_44);
        tvCnt4 = (TextView) findViewById(R.id.tv_cnt4);

        btAccept4 = (Button)findViewById(R.id.bt_accept4);
        btAccept4.setOnClickListener(this);

        //获取上一轮剩余的得分
        Intent intent = getIntent();
        int iHeartNum = intent.getIntExtra("HeartNum",0);
        tvCnt4.setText(String.valueOf(iHeartNum));
    }

    @Override
    public void onClick(View view){
        if(strState4.equalsIgnoreCase("house")){
            //进入下一个页面
            int iHeartNum = Integer.valueOf(tvCnt4.getText().toString());
            Intent intent = new Intent(Task4.this,Task5.class);
            intent.putExtra("HeartNum",iHeartNum);
            startActivity(intent);
            finish();

        }else {

            int cnt=  Integer.valueOf(tvCnt4.getText().toString())-1;
            if(cnt<=0){
                tvCnt4.setText(String.valueOf(cnt));
                Intent intent = new Intent(Task4.this,GamOver.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "选择失败，你还有"+ cnt + "次机会", Toast.LENGTH_SHORT).show();
                tvCnt4.setText(String.valueOf(cnt));
            }

            turnGery();
        }
    }

    public void turnGery(){

        //选中的图片变成灰色


        if(strState4.equals("pig")){
            img42.setImageResource(R.drawable.pig_noartboard256);
            isPig=false;
        }

        if(strState4.equals("honey")){
            img43.setImageResource(R.drawable.honey_noartboard256);
            isHoney=false;
        }
        if(strState4.equals("bird")){
            img44.setImageResource(R.drawable.bird_no_artboard256);
            isBird=false;
        }

    }

    private void clearSelectStatus(View v){

        if(strState4.equals("")){

        }

        if(strState4.equals("house")){
            if(!isHouse){
                return;
            }
            img41.setImageResource(R.drawable.houseartboard256);
        }
        if(strState4.equals("pig")){
            if(!isPig){
                return;
            }
            img42.setImageResource(R.drawable.pigartboard256);
        }
        if(strState4.equals("honey")){
            if(!isHoney){
                return;
            }
            img43.setImageResource(R.drawable.honeyartboard256);
        }
        if(strState4.equals("bird")){
            if(!isBird){
                return;
            }
            img44.setImageResource(R.drawable.birdartboard256);
        }

    }



    public void selected(View v){

        switch (v.getId()){
            case R.id.img_41:
                if(isHouse){
                    clearSelectStatus(v);
                    img41.setImageResource(R.drawable.house_okartboard256);
                    strState4="house";
                }

                break;
            case R.id.img_42:
                if(isPig){
                    clearSelectStatus(v);
                    img42.setImageResource(R.drawable.pig_okartboard256);
                    strState4="pig";
                }

                break;

            case R.id.img_43:
                if(isHoney){
                    clearSelectStatus(v);
                    img43.setImageResource(R.drawable.honey_okartboard256);
                    strState4="honey";
                }

                break;
            case R.id.img_44:
                if(isBird){
                    clearSelectStatus(v);
                    img44.setImageResource(R.drawable.bird_ok_artboard256);
                    strState4="bird";
                }

                break;
            default:
                break;
        }

    }

}
