package top.linxixiangxin.userinterface;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FruitDialog extends Dialog {
    private static final String TAG = "FruitDialog";
    private int dialogLayoutId;//使用的布局ID
    private Button btn_ok,btn_cancel;
    private EditText item,weight;
    private Context context;
    private String fruitname;

    /**
     * 构造一个水果对话框
     * @param context 上下文
     * @param themeResId 自定义主题
     * @param layoutId 自定义布局
     */
    public FruitDialog(Context context, int themeResId,int layoutId) {
        super(context, themeResId);
        dialogLayoutId = layoutId;//暂存值
        Log.d(TAG, "FruitDialog: 构造方法已调用");
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(dialogLayoutId);
        btn_ok = findViewById(R.id.okbtn);
        btn_cancel = findViewById(R.id.cancle);
        item = findViewById(R.id.dtv);
        weight = findViewById(R.id.econtent);
        item.setText(fruitname);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取水果名称和重量，并展示;
                String name = item.getText().toString().trim();
                String Weight = weight.getText().toString().trim();
                if(name != null && !name.equals("") && Weight != null && !Weight.equals("")){
                    Toast.makeText(context,"购买了"+name+",重量是："+Weight+"Kg", Toast.LENGTH_SHORT).show();
                }

                dismiss();

            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
    public void setFruitname(String furitName){
        this.fruitname = furitName;
    }
}
