package top.linxixiangxin.userinterface;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class adapter_autocompletetv extends AppCompatActivity {
    String[] contents = new String[]{"China1","China2","China3","usa1","usa2","usa3","USA1","USA2","USA3"
            ,"nsu1","nsu2","nsu3","nsu4"};
    private AutoCompleteTextView autoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_autocompletetv);
        autoText = findViewById(R.id.autotext);
        ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contents);
        autoText.setAdapter(adapter1);
        autoText.setTextColor(Color.BLACK);
        autoText.setThreshold(2);


    }
}
