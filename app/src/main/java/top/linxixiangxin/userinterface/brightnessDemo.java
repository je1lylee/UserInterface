package top.linxixiangxin.userinterface;

import android.content.ContentResolver;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class brightnessDemo extends AppCompatActivity {
    private TextView temp;
    private ToggleButton toggleButton;
    private SeekBar seekBarr,normalbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness_demo);
        //FindView
        toggleButton = findViewById(R.id.togglebutton);
        seekBarr = findViewById(R.id.brightseek);
        normalbar = findViewById(R.id.appseekbar);
        toggleButton.setTextOn("自动调节");//1
        toggleButton.setTextOff("手动调节");//0
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        Toast.makeText(brightnessDemo.this, "开", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(brightnessDemo.this, "关", Toast.LENGTH_SHORT).show();

                    }
            }
        });
        try {
           seekBarr.setProgress(Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS));//设置seebar位置
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
//设置seebar滑动监听
        seekBarr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS,progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
