package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class adapter_simple_adapter extends AppCompatActivity {
    private ListView listView;
    private List<HashMap<String,Object>> dataList;
    private void initData(){
        dataList = new ArrayList<HashMap<String, Object>>();
        for(int i = 0;i<10;i++){
            HashMap<String,Object> hashMap = new HashMap<String,Object>();
            hashMap.put("img",R.drawable.apple_pic);
            hashMap.put("info","第"+i+"个苹果");
            hashMap.put("cbx",(i%2==0?true:false));
            dataList.add(hashMap);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_simple_adapter);
        listView = findViewById(R.id.lv_simpleadapter);
        initData();
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this,dataList,
                R.layout.simple_item,new String[]{"img","info","cbx"},
                new int[]{R.id.img_simple,R.id.tv_content,R.id.cbx});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dataList.remove(i);
                simpleAdapter.notifyDataSetChanged();//重新映射List
            }
        });

    }
    public void onDeleteAllSelected(View view){
        for(int i = 0;i<dataList.size();i++){
            HashMap<String,Object> hashMap = dataList.get(i);
            if((boolean)hashMap.get("cbx")){
                dataList.remove(i--);
            }
        }
    }
}
