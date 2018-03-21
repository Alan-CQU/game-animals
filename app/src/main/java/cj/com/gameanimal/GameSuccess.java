package cj.com.gameanimal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by CJ on 2018/3/21.
 */

public class GameSuccess extends AppCompatActivity implements View.OnClickListener{

    private Button btExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_success);

        btExit = (Button) findViewById(R.id.bt_success_exit);
        btExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_success_exit:
                startActivity(new Intent(GameSuccess.this,MainActivity.class));
                finish();
                break;
        }
    }
}
