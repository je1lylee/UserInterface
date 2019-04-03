package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import  android.widget.TextView;

public class RadioButtonD extends AppCompatActivity {
    private RadioGroup sexChoice;
    private TextView sexResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        sexChoice = findViewById(R.id.radio_sex);
        sexResult = findViewById(R.id.tv_radio_resulttt);
        sexChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                RadioButton choice = findViewById(sexChoice.getCheckedRadioButtonId());
                sexResult.setText("你选择的性别是："+choice.getText().toString());
            }
        });
    }
}
