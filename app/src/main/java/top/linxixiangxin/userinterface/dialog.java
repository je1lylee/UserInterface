package top.linxixiangxin.userinterface;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dialog extends AppCompatActivity {
    private Button alertdlg,like,radiolg,multilog,viewdlg,progressdlg,diylog;
    private String[] provicesNames={"四川","贵州","广东","福建"};
    private int ChoiceIndex;
    private boolean[] defalutChoice;
    private String[] courseItems = new String[] { "HTML5", "移动应用开发","分布式数据库","测试基础" };
    private boolean[] defaultChoices = {false,true,false,false};
    private static final String TAG = "dialog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        //findView;
        alertdlg = findViewById(R.id.alertdlg);
        like = findViewById(R.id.like);
        radiolg = findViewById(R.id.radiodlg);
        alertdlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dialog.this);
                builder.setIcon(android.R.drawable.star_on);
                builder.setTitle("titel");
                builder.setMessage("你想干啥？");
                builder.setCancelable(false);//点Back不可以关闭对话框 转换为模态对话框
                builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //普通按钮回调clicklistener，但是在dialog中两个参数表示那个对话框的那个按钮。
                        Toast.makeText(dialog.this,""+i, Toast.LENGTH_SHORT).show();
                        //返回-1
                    }
                });
                builder.setNegativeButton("啥也不干", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(dialog.this, ""+i, Toast.LENGTH_SHORT).show();
                        //返回-2
                    }
                });
                builder.create().show();
                /*
                Dialog消失的几种方法
                1.null
                2.dialog.cancel()
                3.dialog.dismiss()
                4.Back button
                 */
            }
        });
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dialog.this);
                builder.setIcon(android.R.drawable.star_on);
                builder.setTitle("titel");
                builder.setMessage("你想干啥？");
                builder.setCancelable(false);//点Back不可以关闭对话框 转换为模态对话框
                builder.setNegativeButton("啊哈",null);
                builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //普通按钮回调clicklistener，但是在dialog中两个参数表示那个对话框的那个按钮。
                        Toast.makeText(dialog.this,""+i, Toast.LENGTH_SHORT).show();
                        //返回-1
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(dialog.this, ""+i, Toast.LENGTH_SHORT).show();
                        //返回-2
                    }
                });
                builder.create().show();
            }
        });
        radiolg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dialog.this);
                builder.setIcon(android.R.drawable.btn_star);
                builder.setTitle("选择省份");
                builder.setSingleChoiceItems(provicesNames, ChoiceIndex, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ChoiceIndex = i;
                        Toast.makeText(dialog.this, provicesNames[ChoiceIndex], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //i代表按钮的标号
                        Toast.makeText(dialog.this, "Final:"+provicesNames[ChoiceIndex], Toast.LENGTH_SHORT).show();

                    }
                });
                builder.create().show();



            }
        });

    }
    public void multiChoice(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.arrow_down_float);
        builder.setTitle("请选择课程");
        builder.setMultiChoiceItems(courseItems, defaultChoices, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // which代表 操作item的index isChecked代表item是选中还是取消
                String state = (isChecked == true)?"选中":"取消";
                Toast.makeText(dialog.this,state+"了"+courseItems[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder sbuilder = new StringBuilder();
                //TODO 怎样拿到所有被选择的课程
                // defaultChoices维护了所有多选框的状态
                for (int i=0;i<defaultChoices.length;i++){
                    Log.d(TAG,"defaultChoices["+i+"]="+defaultChoices[i]);
                    if (defaultChoices[i]){
                        sbuilder.append(" "+courseItems[i]);
                    }
                }
                Log.d(TAG,"最终选择的课程有："+sbuilder.toString());
                Toast.makeText(dialog.this, "最终选择的课程有："+sbuilder.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }


    public void fruitClick(View view) {
    }
}
