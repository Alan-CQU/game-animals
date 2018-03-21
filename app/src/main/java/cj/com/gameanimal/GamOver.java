package cj.com.gameanimal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by CJ on 2018/3/20.
 */

public class GamOver extends AppCompatActivity implements View.OnClickListener {

    private Button bt_exit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);

        bt_exit = (Button) findViewById(R.id.bt_exit);
        bt_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_exit:
                startActivity(new Intent(GamOver.this,MainActivity.class));
                finish();
        }
    }
}
