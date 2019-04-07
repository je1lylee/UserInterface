package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import top.linxixiangxin.userinterface.R;
public class TextView extends AppCompatActivity {
    private EditText name,age,phone;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        //get view
        name = findViewById(R.id.edT1);
        age = findViewById(R.id.edT2);
        phone = findViewById(R.id.edT3);
        btn = findViewById(R.id.btn);
        //set listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TextView.this, "姓名："+name.getText().toString()+";年龄:"+age.getText().toString()+";电话号："+phone.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
