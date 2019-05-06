package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wechat_final_moment extends AppCompatActivity {
    private ListView listView;
    private wechat_moment listaAdapter;
    private List<Map<String, Object>> listItems;
    private Integer[] imgIDs = {R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng};
    private String[] userNName = {
            "亦桉"
            ,"張"
            ,"陆锡"
            ,"陆锡"
            ,"宠溺"
            ,"陆锡"
            ,"宠溺"
    };
    private String[] content = {
            "又到了新一天的投票的时候了/捂脸/捂脸"
            ,"[音乐分享] 街道办，春娇与志明"
            ,"MQ,有想法的拿图私聊"
            ,"A锥1集合，喜欢拿图私聊"
            ,"沙发 椅子 桌子 墙角 家人 友情 爱情 自己"
            ,"有想法的拿图找我！"
            ,"【钢铁侠】 爱你三千遍纪念品 扫码添加/转发参与/免费领取/GTX047"
    };
    private String[] sendTime = {
            "23分钟前"
            ,"8小时前 网易云音乐"
            ,"9小时前"
            ,"9小时前"
            ,"9小时前"
            ,"10小时前"
            ,"10小时前"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_final_moment);
        listView = findViewById(R.id.momentList);
        listItems = getContentItems();
        listaAdapter = new wechat_moment(this,listItems);
        listView.setAdapter(listaAdapter);
    }


    private List<Map<String,Object>>getContentItems(){
        List<Map<String,Object>>listItems = new ArrayList<Map<String,Object>>();
        for(int i = 0;i<userNName.length;i++){
            Map<String,Object>map = new HashMap<String, Object>();
            map.put("image",imgIDs[i]);
            map.put("username",userNName[i]);
            map.put("usercontent",content[i]);
            map.put("sendtime",sendTime[i]);
            listItems.add(map);
        }
        return listItems;
    }
}
