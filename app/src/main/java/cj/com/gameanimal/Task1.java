package cj.com.gameanimal;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CJ on 2018/3/20.
 */

public class Task1 extends AppCompatActivity implements View.OnClickListener {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;

    private TextView tvCnt;
    private String strState="";
    private Button btAccept;

    private boolean isCat =true;
    private boolean isFish=true;
    private boolean isHoney=true;
    private boolean isBird=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task1);

        img1 = (ImageView) findViewById(R.id.img_1);
        img2 = (ImageView) findViewById(R.id.img_2);
        img3 = (ImageView) findViewById(R.id.img_3);
        img4 = (ImageView) findViewById(R.id.img_4);
        tvCnt = (TextView) findViewById(R.id.tv_cnt);

        btAccept = (Button)findViewById(R.id.bt_accept);
        btAccept.setOnClickListener(this);
    }

    private void clearSelectStatus(View v){

        if(strState.equals("")){

        }

        if(strState.equals("bird")){
            if(!isBird){
                return;
            }
            img1.setImageResource(R.drawable.birdartboard256);
        }
        if(strState.equals("cat")){
            if(!isCat){
                return;
            }
            img2.setImageResource(R.drawable.catartboard256);
        }
        if(strState.equals("fish")){
            if(!isFish){
                return;
            }
            img3.setImageResource(R.drawable.fishartboard256);
        }
        if(strState.equals("honey")){
            if(!isHoney){
                return;
            }
            img4.setImageResource(R.drawable.honeyartboard256);
        }

    }

    @Override
    public void onClick(View v){
        if(strState.equalsIgnoreCase("honey")){
            //进入下一个页面
            int iHeartNum = Integer.valueOf(tvCnt.getText().toString());
            Intent intent = new Intent(Task1.this,Task2.class);
            intent.putExtra("HeartNum",iHeartNum);
            startActivity(intent);
            finish();
        }else {

            int cnt=  Integer.valueOf(tvCnt.getText().toString())-1;
            if(cnt<=0){
                tvCnt.setText(String.valueOf(cnt));
                Intent intent = new Intent(Task1.this,GamOver.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "选择失败，你还有"+ cnt + "次机会", Toast.LENGTH_SHORT).show();
                tvCnt.setText(String.valueOf(cnt));
            }

            turnGery();
        }
    }

    public void turnGery(){
        //选中的图片变成灰色
        if(strState.equals("bird")){
            img1.setImageResource(R.drawable.bird_no_artboard256);
            isBird=false;
        }
        if(strState.equals("fish")){
            img3.setImageResource(R.drawable.fish_noartboard256);
            isFish=false;
        }
        if(strState.equals("cat")){
            img2.setImageResource(R.drawable.cat_noartboard256);
            isCat=false;
        }
    }

    public void selected(View v){

        switch (v.getId()){
            case R.id.img_1:
                if(isBird){
                    clearSelectStatus(v);
                    img1.setImageResource(R.drawable.bird_ok_artboard256);
                    strState="bird";
                }

                break;
            case R.id.img_2:
                if(isCat){
                    clearSelectStatus(v);
                    img2.setImageResource(R.drawable.cat_okartboard256);
                    strState="cat";
                }

                break;

            case R.id.img_3:
                if(isFish){
                    clearSelectStatus(v);
                    img3.setImageResource(R.drawable.fish_okartboard256);
                    strState="fish";
                }

                break;
            case R.id.img_4:
                if(isHoney){
                    clearSelectStatus(v);
                    img4.setImageResource(R.drawable.honey_okartboard256);
                    strState="honey";
                }

                break;
            default:
                break;
        }

    }
}
