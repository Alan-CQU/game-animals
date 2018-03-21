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

public class Task3 extends AppCompatActivity implements View.OnClickListener{

    private ImageView img31;
    private ImageView img32;
    private ImageView img33;
    private ImageView img34;

    private TextView tvCnt3;
    private String strState3="";
    private Button btAccept3;
    
    
    private boolean isFish=true; 
    private boolean isSun=true;   
    private boolean isCat=true;
    private boolean isFlower =true;
   
 
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task3);

        img31 = (ImageView) findViewById(R.id.img_31);
        img32 = (ImageView) findViewById(R.id.img_32);
        img33 = (ImageView) findViewById(R.id.img_33);
        img34 = (ImageView) findViewById(R.id.img_34);
        tvCnt3 = (TextView) findViewById(R.id.tv_cnt3);

        btAccept3 = (Button)findViewById(R.id.bt_accept3);
        btAccept3.setOnClickListener(this);

        //获取上一轮剩余的得分
        Intent intent = getIntent();
        int iHeartNum = intent.getIntExtra("HeartNum",0);
        tvCnt3.setText(String.valueOf(iHeartNum));
        
    }

    @Override
    public void onClick(View v){
        if(strState3.equalsIgnoreCase("sun")){
            //进入下一个页面
            int iHeartNum = Integer.valueOf(tvCnt3.getText().toString());
            Intent intent = new Intent(Task3.this,Task4.class);
            intent.putExtra("HeartNum",iHeartNum);
            startActivity(intent);
            finish();

        }else {

            int cnt=  Integer.valueOf(tvCnt3.getText().toString())-1;
            if(cnt<=0){
                tvCnt3.setText(String.valueOf(cnt));
                Intent intent = new Intent(Task3.this,GamOver.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "选择失败，你还有"+ cnt + "次机会", Toast.LENGTH_SHORT).show();
                tvCnt3.setText(String.valueOf(cnt));
            }

            turnGery();
        }
    }

    public void turnGery(){
        //选中的图片变成灰色
        if(strState3.equals("fish")){
            img31.setImageResource(R.drawable.fish_noartboard256);
            isFish=false;
        }

        if(strState3.equals("cat")){
            img33.setImageResource(R.drawable.cat_noartboard256);
            isCat=false;
        }
        if(strState3.equals("flower")){
            img34.setImageResource(R.drawable.flower_noartboard256);
            isFlower=false;
        }

    }

    private void clearSelectStatus(View v){

        if(strState3.equals("")){

        }

        if(strState3.equals("fish")){
            if(!isFish){
                return;
            }
            img31.setImageResource(R.drawable.fishartboard256);
        }
        if(strState3.equals("sun")){
            if(!isSun){
                return;
            }
            img32.setImageResource(R.drawable.sunartboard256);
        }
        if(strState3.equals("cat")){
            if(!isCat){
                return;
            }
            img33.setImageResource(R.drawable.catartboard256);
        }
        if(strState3.equals("flower")){
            if(!isFlower){
                return;
            }
            img34.setImageResource(R.drawable.flowerartboard256);
        }

    }



    public void selected(View v){

        switch (v.getId()){
            case R.id.img_31:
                if(isFish){
                    clearSelectStatus(v);
                    img31.setImageResource(R.drawable.fish_okartboard256);
                    strState3="fish";
                }

                break;
            case R.id.img_32:
                if(isSun){
                    clearSelectStatus(v);
                    img32.setImageResource(R.drawable.sun_okartboard256);
                    strState3="sun";
                }

                break;

            case R.id.img_33:
                if(isCat){
                    clearSelectStatus(v);
                    img33.setImageResource(R.drawable.cat_okartboard256);
                    strState3="cat";
                }

                break;
            case R.id.img_34:
                if(isFlower){
                    clearSelectStatus(v);
                    img34.setImageResource(R.drawable.flower_okartboard256);
                    strState3="flower";
                }

                break;
            default:
                break;
        }

    }
    
}
