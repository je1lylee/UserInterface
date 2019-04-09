package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class progressbarx extends AppCompatActivity {
    private TextView textViewx,txv,seekRes,ratingRes;
    private RatingBar rating;
    private ProgressBar bar1,bar2,bar3,bar4;
    private Button btn;
    private int pro;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbarx);
        textViewx = findViewById(R.id.textViewx);
        bar1=  findViewById(R.id.progressBar);
        bar2 = findViewById(R.id.progressBar2);
        bar3 = findViewById(R.id.progressBar3);
        bar4 = findViewById(R.id.progressBar4);
        txv = findViewById(R.id.tev);
        btn = findViewById(R.id.btn);
        seekBar = findViewById(R.id.seekbar);
        seekRes = findViewById(R.id.seekbar_res);
        rating = findViewById(R.id.rating);
        ratingRes = findViewById(R.id.rating_res);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setText("增加进度");
                if(pro==0)
                {
                    bar1.setVisibility(View.VISIBLE);
                    bar2.setVisibility(View.VISIBLE);
                    bar3.setVisibility(View.VISIBLE);
                    bar4.setVisibility(View.VISIBLE);
                }else if(pro<100){
                    bar1.setProgress(pro);
                    bar2.setProgress(pro);
                    bar3.setProgress(pro);
                    bar4.setProgress(pro);
                }else{
                    bar1.setVisibility(View.VISIBLE);
                    bar2.setVisibility(View.VISIBLE);
                    bar3.setVisibility(View.VISIBLE);
                    bar4.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                }
                txv.setText("当前进度为"+pro);
                pro+=10;
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekRes.setText("Progress:"+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(progressbarx.this, "Start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(progressbarx.this, "Stop", Toast.LENGTH_SHORT).show();
            }
        });
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratingRes.setText("Star:"+v);
            }
        });
    }
}
