package top.linxixiangxin.userinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class adapter extends AppCompatActivity {
    private ListView demolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        demolist = findViewById(R.id.dmeolist);
        ArrayAdapter<String> example_adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_gallery_item,
                getResources().getStringArray(R.array.example_info_array));
        demolist.setAdapter(example_adp);
        //set action listener
        demolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //哪一个adapter,点的哪一个控件，

                Toast.makeText(adapter.this, "您将要学习的是："+((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                switch (i){
                    case 0:
                        intent.setClass(adapter.this,adapter_autocompletetv.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(adapter.this,adapter_spinner.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(adapter.this,adapter_simple_adapter.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.setClass(adapter.this,adapter_base_adapter.class);
                        startActivity(intent);
                        default:
                            Toast.makeText(adapter.this, "#暂不可用#", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}
