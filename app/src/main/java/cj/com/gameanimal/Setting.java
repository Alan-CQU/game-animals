package cj.com.gameanimal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

/**
 * Created by CJ on 2018/3/21.
 */

public class Setting extends AppCompatActivity {
    private Button bt_explain;
    private Switch turnMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

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
//                dialog.setNegativeButton("Cancel", new DialogInterface.
//                        OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                });
                dialog.show();

            }
        });

        turnMusic =(Switch) findViewById(R.id.bg_music);

    }
}
