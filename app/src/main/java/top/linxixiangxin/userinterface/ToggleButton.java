package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ToggleButton extends AppCompatActivity {
   private CheckBox cb1,cb2,cb3,cb4,cb5;
   private Button btnnn;
   private TextView txv;
   private List<CheckBox>cbxList = new ArrayList<CheckBox>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        cb1 = findViewById(R.id.cbx_a);
        cb2 = findViewById(R.id.cbx_b);
        cb3 = findViewById(R.id.cbx_c);
        cb4 = findViewById(R.id.cbx_d);
        cb5 = findViewById(R.id.cbx_e);
        btnnn = findViewById(R.id.btn_submit);
        txv = findViewById(R.id.tv_cbx_result);

        cbxList.add(cb1);
        cbxList.add(cb2);
        cbxList.add(cb3);
        cbxList.add(cb4);
        cbxList.add(cb5);
        for(final CheckBox cbx:cbxList){
            cbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(isChecked){
                        Toast.makeText(ToggleButton.this, cbx.getText().toString()+"Has checked", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ToggleButton.this, cbx.getText().toString()+"Has cancel", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        btnnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer();
                for(CheckBox cbx:cbxList){
                    if(cbx.isChecked()){
                        sb.append(cbx.getText().toString()+"");
                    }
                }
                if(sb!=null&&"".equals(sb.toString())){
                    Toast.makeText(ToggleButton.this, "请至少选择一项", Toast.LENGTH_SHORT).show();
                }else{
                    txv.setText("Result:"+sb.toString());
                }
            }
        });

    }
}
