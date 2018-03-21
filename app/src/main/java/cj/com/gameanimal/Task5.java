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

public class Task5 extends AppCompatActivity implements View.OnClickListener{
    private ImageView img51;
    private ImageView img52;
    private ImageView img53;
    private ImageView img54;

    private TextView tvCnt5;
    private String strState5="";
    private Button btAccept5;


    private boolean isFlower=true;
    private boolean isHoney=true;
    private boolean isCat=true;
    private boolean isHouse =true;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task5);

        img51 = (ImageView) findViewById(R.id.img_51);
        img52 = (ImageView) findViewById(R.id.img_52);
        img53 = (ImageView) findViewById(R.id.img_53);
        img54 = (ImageView) findViewById(R.id.img_54);
        tvCnt5 = (TextView) findViewById(R.id.tv_cnt5);

        btAccept5 = (Button)findViewById(R.id.bt_accept5);
        btAccept5.setOnClickListener(this);

        //获取上一轮剩余的得分
        Intent intent = getIntent();
        int iHeartNum = intent.getIntExtra("HeartNum",0);
        tvCnt5.setText(String.valueOf(iHeartNum));
    }

    @Override
    public void onClick(View view){
        if(strState5.equalsIgnoreCase("cat")){
            //进入下一个页面
            int iHeartNum = Integer.valueOf(tvCnt5.getText().toString());
            Intent intent = new Intent(Task5.this,GameSuccess.class);
            intent.putExtra("HeartNum",iHeartNum);
            startActivity(intent);
            finish();

        }else {

            int cnt=  Integer.valueOf(tvCnt5.getText().toString())-1;
            if(cnt<=0){
                tvCnt5.setText(String.valueOf(cnt));
                Intent intent = new Intent(Task5.this,GamOver.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "选择失败，你还有"+ cnt + "次机会", Toast.LENGTH_SHORT).show();
                tvCnt5.setText(String.valueOf(cnt));
            }

            turnGery();
        }
    }

    public void turnGery() {

        //选中的图片变成灰色

        if (strState5.equals("flower")) {
            img51.setImageResource(R.drawable.flower_noartboard256);
            isFlower = false;
        }

        if (strState5.equals("honey")) {
            img52.setImageResource(R.drawable.honey_noartboard256);
            isHoney = false;
        }

//        if (strState5.equals("honey")) {
//            img53.setImageResource(R.drawable.honey_noartboard256);
//            isHoney = false;
//        }
        if (strState5.equals("house")) {
            img54.setImageResource(R.drawable.house_noartboard256);
            isHouse = false;
        }
    }

    private void clearSelectStatus(View v){

        if(strState5.equals("")){

        }

        if(strState5.equals("flower")){
            if(!isFlower){
                return;
            }
            img51.setImageResource(R.drawable.flowerartboard256);
        }
        if(strState5.equals("honey")){
            if(!isHoney){
                return;
            }
            img52.setImageResource(R.drawable.honeyartboard256);
        }
        if(strState5.equals("cat")){
            if(!isCat){
                return;
            }
            img53.setImageResource(R.drawable.catartboard256);
        }
        if(strState5.equals("house")){
            if(!isHouse){
                return;
            }
            img54.setImageResource(R.drawable.houseartboard256);
        }

    }



    public void selected(View v){

        switch (v.getId()){
            case R.id.img_51:
                if(isFlower){
                    clearSelectStatus(v);
                    img51.setImageResource(R.drawable.flower_okartboard256);
                    strState5="flower";
                }

                break;
            case R.id.img_52:
                if(isHoney){
                    clearSelectStatus(v);
                    img52.setImageResource(R.drawable.honey_okartboard256);
                    strState5="honey";
                }

                break;

            case R.id.img_53:
                if(isHoney){
                    clearSelectStatus(v);
                    img53.setImageResource(R.drawable.cat_okartboard256);
                    strState5="cat";
                }

                break;
            case R.id.img_54:
                if(isHouse){
                    clearSelectStatus(v);
                    img54.setImageResource(R.drawable.house_okartboard256);
                    strState5="house";
                }

                break;
            default:
                break;
        }

    }

}
