package top.linxixiangxin.userinterface;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class dialog extends AppCompatActivity {
    private Button alertdlg,like,radiolg,multilog,viewdlg,progressdlg,
    diylog;
    private String[] provicesNames={"四川","贵州","广东","福建"};
    private int ChoiceIndex;
    private boolean[] defalutChoice;

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
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
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
    public void multiChoice(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(dialog.this);
        builder.setIcon(android.R.drawable.btn_star);
        builder.setTitle("TEST");
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                for(int x = 0;x<defalutChoice.length;x++)
                {

                }
            }
        });
        builder.setMultiChoiceItems(provicesNames,null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                String state = (b==true)?"选中":"取消";
                Toast.makeText(dialog.this, state+provicesNames[i], Toast.LENGTH_SHORT).show();

            }
        });
        builder.create().show();
    }

    public void fruitClick(View view) {
    }
}
