package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class adapter_base_adapter extends AppCompatActivity {
    private static final String TAG = "dialog";
    private ListView listView;
    private myAdapter listaAdapter;
    private List<Map<String,Object>> ListItems;
    private Integer[] imgeIDs = {R.drawable.baigujing,
            R.drawable.sunwukong,
            R.drawable.zhubajie,
            R.drawable.shaseng,
            R.drawable.guanyin,
            R.drawable.baigujing,
            R.drawable.baigujing,
            R.drawable.baigujing,
            R.drawable.baigujing,
            R.drawable.baigujing,
            R.drawable.baigujing

    };
    //static data for test
    private String[] friendNames = {"女儿国王", "孙悟空",
            "猪八戒", "沙僧", "观音姐姐", "白骨精","东海龙女","龙套1","龙套2","龙套3","龙套4"};

    private String[] msgs = {"御弟哥哥，你好哇","师傅，小心妖怪","师傅，咱歇一歇",
            "师傅，请喝水","你太墨迹了","吃你的肉可以长生？","你想干啥？","What are you 弄啥呢？","What are you 弄啥呢？","What are you 弄啥呢？","What are you 弄啥呢？"};

    private String[] infos = {"相见难,别亦难,怎诉这胸中语万千","孙悟空是我的大徒弟！","猪八戒就是一头懒猪！",
            "沙悟净是个听话的好徒儿！","救苦救难观世音菩萨","白骨精，一直想吃我的肉，可惜你没后台！","小龙女，你在干啥？","你想咋滴？","你想咋滴？","你想咋滴？","你想咋滴？"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_base_adapter);
        listView = findViewById(R.id.friendlist);
        ListItems = getfriendItems();
        listaAdapter = new myAdapter(this,ListItems);
        listView.setAdapter(listaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //选中非选中时点击Item的提示
                if(listaAdapter.hasChecked(i)){
                    Toast.makeText(adapter_base_adapter.this, "你要跟"+ListItems.get(i).get("name")+"唠嗑咩？", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(adapter_base_adapter.this, "点我作甚？", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<Map<String, Object>> getfriendItems() {
        List<Map<String,Object>>ListItems = new ArrayList<Map<String,Object>>();
        for(int i = 0;i < friendNames.length;i++){
            Map<String,Object>mappp = new HashMap<String,Object>();
            mappp.put("image",imgeIDs[i]);
            mappp.put("name",friendNames[i]);
            mappp.put("msg",msgs[i]);
            mappp.put("info",infos[i]);
            ListItems.add(mappp);
        }
        return ListItems;
    }
}
