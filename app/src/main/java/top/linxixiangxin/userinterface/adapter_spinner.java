package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adapter_spinner extends AppCompatActivity {
    private Spinner courseSpinner,ratingSpinner;
    private TextView courseTV,ratingTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_spinner);
        courseSpinner = findViewById(R.id.spinner1);
        courseTV = findViewById(R.id.tv_spinner1);
        ratingSpinner = findViewById(R.id.spinner2);
        ratingTV = findViewById(R.id.tv_spinner2);
        //createFromResource 静态方法
        ArrayAdapter<CharSequence> courseAdapter = ArrayAdapter.createFromResource(this,R.array.courses,android.R.layout.simple_spinner_item);
        courseAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        courseSpinner.setSelection(2);
        courseSpinner.setAdapter(courseAdapter);
        courseSpinner.setPrompt("选择课程");
        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                courseTV.setText("您选择的课程是:"+adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayList<String> dataList = new ArrayList<String>();
        dataList.add("非常满意");dataList.add("满意");dataList.add("一般满意");dataList.add("不满意");
        ArrayAdapter<String> ratingAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dataList);
        ratingAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ratingSpinner.setAdapter(ratingAdapter);
        ratingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(adapter_spinner.this, "您的评分是："+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
                Toast.makeText(adapter_spinner.this, "您对"+courseSpinner.getSelectedItem()+"的评分是"+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
