package top.linxixiangxin.userinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_Layout;
    private Button btn_view;
    private Button btn_dialog;
    private Button btn_toast;
    private Button btn_menu;
    private Button btn_guide;
    private Button btn_adapter;
    private Button btn_brightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_Layout = findViewById(R.id.btn_layout);
        btn_view = findViewById(R.id.btn_view);
        btn_dialog = findViewById(R.id.btn_dialog);
        btn_toast = findViewById(R.id.btn_toast);
        btn_menu = findViewById(R.id.btn_menu);
        btn_guide = findViewById(R.id.btn_guide);
        btn_adapter = findViewById(R.id.btn_adapter);
        btn_brightness = findViewById(R.id.btn_brightness);
        btn_menu.setOnClickListener(new MyClickListener());
        btn_guide.setOnClickListener(new MyClickListener());
        btn_adapter.setOnClickListener(new MyClickListener());
        btn_Layout.setOnClickListener(new MyClickListener());
        btn_view.setOnClickListener(new MyClickListener());
        btn_dialog.setOnClickListener(new MyClickListener());
        btn_toast.setOnClickListener(new MyClickListener());
        btn_menu.setOnClickListener(new MyClickListener());
        btn_guide.setOnClickListener(new MyClickListener());
        btn_adapter.setOnClickListener(new MyClickListener());
        btn_brightness.setOnClickListener(new MyClickListener());
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()){
                case R.id.btn_layout:
                   intent.setClass(MainActivity.this,BasicLayout.class);
                    startActivity(intent);
                    break;
                case R.id.btn_view:
                    intent.setClass(MainActivity.this,viewMain.class);
                    startActivity(intent);
                    break;
                case R.id.btn_dialog:
                    intent.setClass(MainActivity.this,dialog.class);
                    startActivity(intent);
                    break;
                case R.id.btn_toast:
                    Toast.makeText(MainActivity.this, "#暂不可用#", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_menu:
                    Toast.makeText(MainActivity.this, "#暂不可用#", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_guide:
                    Toast.makeText(MainActivity.this, "#暂不可用#", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_adapter:
                    intent.setClass(MainActivity.this,adapter.class);
                    startActivity(intent);
                    break;
                case R.id.btn_brightness:
                    intent.setClass(MainActivity.this,brightnessDemo.class);
                    startActivity(intent);
            }
        }
    }
}
