package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wechat_final_moment extends AppCompatActivity {
    private static final String TAG = "dialog";
    private ListView listView;
    private wechat_moment listaAdapter;
    private List<Map<String, Object>> listItems;
    //构造数据源
    private Integer[] imgIDs = {R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng
            , R.drawable.tangseng};
    private String[] userNName = {
            "亦桉"
            , "張"
            , "陆锡"
            , "陆锡"
            , "宠溺"
            , "陆锡"
            , "宠溺"
    };
    private String[] content = {
            "又到了新一天的投票的时候了/捂脸/捂脸"
            , "[音乐分享] 街道办，春娇与志明"
            , "MQ,有想法的拿图私聊"
            , "A锥1集合，喜欢拿图私聊"
            , "沙发 椅子 桌子 墙角 家人 友情 爱情 自己"
            , "有想法的拿图找我！"
            , "【钢铁侠】 爱你三千遍纪念品 扫码添加/转发参与/免费领取/GTX047"
    };
    private String[] sendTime = {
            "23分钟前"
            , "8小时前 网易云音乐"
            , "9小时前"
            , "9小时前"
            , "9小时前"
            , "10小时前"
            , "10小时前"
    };
    private Integer[] img1 = {
            R.drawable.baigujing,
            R.drawable.guanyin,
            R.drawable.zhubajie,
            R.drawable.baigujing,
            R.drawable.guanyin,
            R.drawable.zhubajie,
            0
    };
    private Integer[] img2 = {
            R.drawable.baigujing,
            R.drawable.guanyin,
            R.drawable.zhubajie,
            R.drawable.baigujing,
            R.drawable.guanyin,
            0,
            0
    };
    private Integer[] img3 = {
            R.drawable.baigujing,
            R.drawable.guanyin,
            R.drawable.zhubajie,
            R.drawable.baigujing,
            0,
            0,
            0
    };
    private Integer[] img4 = {
            R.drawable.baigujing,
            R.drawable.guanyin,
            R.drawable.zhubajie,
            0,
            0,
            0,
            0
    };
    private Integer[] img5 = {
            R.drawable.baigujing,
            R.drawable.guanyin,
            0,
            0,
            0,
            0,
            0
    };
    private Integer[] img6 = {
            R.drawable.baigujing,
            R.drawable.baigujing,
            0,
            0,
            0,
            0,
            0
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_final_moment);
        listView = findViewById(R.id.momentList);
        listItems = getContentItems();
        listaAdapter = new wechat_moment(this, listItems); //填充数据
        listView.setAdapter(listaAdapter);
        this.setTitle("朋友圈");
    }


    private List<Map<String, Object>> getContentItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < userNName.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imgIDs[i]);
            map.put("username", userNName[i]);
            map.put("usercontent", content[i]);
            map.put("sendtime", sendTime[i]);
            map.put("img1", img1[i]);
            map.put("img2", img2[i]);
            map.put("img3", img3[i]);
            map.put("img4", img4[i]);
            map.put("img5", img5[i]);
            map.put("img6", img6[i]);
            listItems.add(map);
        }
        return listItems;
    }
}
