package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class adapter_autocompletetv extends AppCompatActivity {
    String[] contents = new String[]{"China1","China2","China3","usa1","usa2","usa3","USA1","USA2","USA3","","","","","","","","","","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_autocompletetv);
    }
}
