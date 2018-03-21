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
 * Created by CJ on 2018/3/20.
 */

public class Task2 extends AppCompatActivity implements View.OnClickListener{

    private ImageView img21;
    private ImageView img22;
    private ImageView img23;
    private ImageView img24;

    private TextView tvCnt2;
    private String strState2="";
    private Button btAccept2;

    private boolean isFlower =true;
    private boolean isSun=true;
    private boolean isHouse=true;
    private boolean isPig=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task2);

        img21 = (ImageView) findViewById(R.id.img_21);
        img22 = (ImageView) findViewById(R.id.img_22);
        img23 = (ImageView) findViewById(R.id.img_23);
        img24 = (ImageView) findViewById(R.id.img_24);
        tvCnt2 = (TextView) findViewById(R.id.tv_cnt2);

        btAccept2 = (Button)findViewById(R.id.bt_accept2);
        btAccept2.setOnClickListener(this);

        //获取上一轮剩余的得分
        Intent intent = getIntent();
        int iHeartNum = intent.getIntExtra("HeartNum",0);
        tvCnt2.setText(String.valueOf(iHeartNum));

    }

    @Override
    public void onClick(View v){
        if(strState2.equalsIgnoreCase("pig")){
            //进入下一个页面
            //进入下一个页面
            int iHeartNum = Integer.valueOf(tvCnt2.getText().toString());
            Intent intent = new Intent(Task2.this,Task3.class);
            intent.putExtra("HeartNum",iHeartNum);
            startActivity(intent);
            finish();

        }else {

            int cnt=  Integer.valueOf(tvCnt2.getText().toString())-1;
            if(cnt<=0){
                tvCnt2.setText(String.valueOf(cnt));
                Intent intent = new Intent(Task2.this,GamOver.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "选择失败，你还有"+ cnt + "次机会", Toast.LENGTH_SHORT).show();
                tvCnt2.setText(String.valueOf(cnt));
            }

            turnGery();
        }
    }

    public void turnGery(){
        //选中的图片变成灰色
        if(strState2.equals("flower")){
            img21.setImageResource(R.drawable.flower_noartboard256);
            isFlower=false;
        }
        if(strState2.equals("sun")){
            img22.setImageResource(R.drawable.sun_noartboard256);
            isSun=false;
        }
        if(strState2.equals("house")){
            img24.setImageResource(R.drawable.house_noartboard256);
            isHouse=false;
        }

    }

    private void clearSelectStatus(View v){

        if(strState2.equals("")){

        }

        if(strState2.equals("flower")){
            if(!isFlower){
                return;
            }
            img21.setImageResource(R.drawable.flowerartboard256);
        }
        if(strState2.equals("sun")){
            if(!isSun){
                return;
            }
            img22.setImageResource(R.drawable.sunartboard256);
        }
        if(strState2.equals("pig")){
            if(!isPig){
                return;
            }
            img23.setImageResource(R.drawable.pigartboard256);
        }
        if(strState2.equals("house")){
            if(!isHouse){
                return;
            }
            img24.setImageResource(R.drawable.houseartboard256);
        }

    }



    public void selected(View v){

        switch (v.getId()){
            case R.id.img_21:
                if(isFlower){
                    clearSelectStatus(v);
                    img21.setImageResource(R.drawable.flower_okartboard256);
                    strState2="flower";
                }

                break;
            case R.id.img_22:
                if(isSun){
                    clearSelectStatus(v);
                    img22.setImageResource(R.drawable.sun_okartboard256);
                    strState2="sun";
                }

                break;

            case R.id.img_23:
                if(isPig){
                    clearSelectStatus(v);
                    img23.setImageResource(R.drawable.pig_okartboard256);
                    strState2="pig";
                }

                break;
            case R.id.img_24:
                if(isHouse){
                    clearSelectStatus(v);
                    img24.setImageResource(R.drawable.house_okartboard256);
                    strState2="house";
                }

                break;
            default:
                break;
        }

    }

}
