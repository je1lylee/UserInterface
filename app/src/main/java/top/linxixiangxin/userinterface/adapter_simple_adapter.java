package top.linxixiangxin.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private static final String TAG = "dialog";
    /**
     * 组织数据
     */
    private void initData(){
        //初始化数据，创建一个长度为10的列表
        dataList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0;i<10;i++){
            HashMap<String,Object> hashMap = new HashMap<String,Object>();
            hashMap.put("image",R.drawable.apple_pic);
            hashMap.put("info","第"+i+"个苹果");
            hashMap.put("cbx",(i<5? true:false));//设置前五项为选中状态
            dataList.add(hashMap);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_simple_adapter);

        initData();//初始化数据
        listView = findViewById(R.id.lv_simpleadapter);
        simpleAdapter = new SimpleAdapter(//创建SimpleAdapter
                this,//上下文
                dataList,//数据源
                R.layout.simple_item,//布局
                new String[]{"image","info","cbx"},//布局中的控件名
                new int[]{R.id.img_simple,R.id.tv_content,R.id.cbx}){//寻找控件ID
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.simple_item,parent,false);//获得创建在页面中的自定义VIEW
                TextView textView = view.findViewById(R.id.tv_content);//寻找控件 并设置控件的内容和初始状态。
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
        listView.setAdapter(simpleAdapter);//绑定适配器
        listView.setOnItemClickListener(this);//绑定监听
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dataList.remove(position);//点谁谁从datalist中消失
        simpleAdapter.notifyDataSetChanged();//读datalist刷新view
    }

    /**
     * 一次删除所有被勾选的Items
     * @param view
     */
    public void onDeleteAllSelected(View view){
        for(int i=0;i<dataList.size();i++){
            HashMap<String,Object> hashMap = dataList.get(i);
            Log.d(TAG, "OUT I"+i);
            if ((Boolean) hashMap.get("cbx")){
                dataList.remove(i--);
                Log.d(TAG, "I.VALUE: "+i);
            }
        }
        simpleAdapter.notifyDataSetChanged();//刷新view
    }
}
