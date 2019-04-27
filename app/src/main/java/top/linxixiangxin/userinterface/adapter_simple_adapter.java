package top.linxixiangxin.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class adapter_simple_adapter extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<HashMap<String,Object>> dataList;
    /**
     * 组织数据
     */
    private void initData(){
        dataList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0;i<10;i++){
            HashMap<String,Object> hashMap = new HashMap<String,Object>();
            hashMap.put("image",R.drawable.apple_pic);
            hashMap.put("info","第"+i+"个苹果");
            hashMap.put("cbx",(i<5? true:false));
            dataList.add(hashMap);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_simple_adapter);

        initData();
        listView = findViewById(R.id.lv_simpleadapter);
        simpleAdapter = new SimpleAdapter(
                this,
                dataList,
                R.layout.simple_item,
                new String[]{"image","info","cbx"},
                new int[]{R.id.img_simple,R.id.tv_content,R.id.cbx}){
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.simple_item,parent,false);
                TextView textView = view.findViewById(R.id.tv_content);
                CheckBox checkBox = view.findViewById(R.id.cbx);
                textView.setText(dataList.get(position).get("info").toString());
                checkBox.setChecked((Boolean) dataList.get(position).get("cbx"));
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        dataList.get(position).put("cbx",isChecked);
                    }
                });
                return view;
            }
        };
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dataList.remove(position);
        simpleAdapter.notifyDataSetChanged();
    }

    /**
     * 一次删除所有被勾选的Items
     * @param view
     */
    public void onDeleteAllSelected(View view){
        for(int i=0;i<dataList.size();i++){
            HashMap<String,Object> hashMap = dataList.get(i);
            if ((Boolean) hashMap.get("cbx")){
                dataList.remove(i--);
            }
        }
        simpleAdapter.notifyDataSetChanged();
    }
}
