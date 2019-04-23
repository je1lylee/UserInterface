package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class adapter_spinner extends AppCompatActivity {
    private Spinner courseSpinner;
    private TextView courseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_spinner);
        courseSpinner = findViewById(R.id.spinner1);
        courseTV = findViewById(R.id.tv_spinner1);
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

    }
}
