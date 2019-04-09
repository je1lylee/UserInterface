package top.linxixiangxin.userinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import top.linxixiangxin.userinterface.R;
public class viewMain extends AppCompatActivity {
    private Button b_textedit,b_button,b_image,b_toggle,b_barx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_main);
        //find view
        b_textedit = findViewById(R.id.btn_textedit);
        b_button = findViewById(R.id.btn_button);
        b_image = findViewById(R.id.btn_image);
        b_toggle = findViewById(R.id.btn_toggle);
        b_barx = findViewById(R.id.barx);
        //set listener
        b_textedit.setOnClickListener(new MyClickListener());
        b_button.setOnClickListener(new MyClickListener());
        b_image.setOnClickListener(new MyClickListener());
        b_toggle.setOnClickListener(new MyClickListener());
        b_barx.setOnClickListener(new MyClickListener());
    }
    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()){
                case R.id.btn_textedit:
                    intent.setClass(viewMain.this,TextView.class);
                    startActivity(intent);
                    break;
                case R.id.btn_button:
                    Toast.makeText(viewMain.this, "#暂不可用#", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_image:
                    Toast.makeText(viewMain.this, "#暂不可用#", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toggle:
                    intent.setClass(viewMain.this,ToggleButton.class);
                    startActivity(intent);
                    break;
                case R.id.barx:
                    intent.setClass(viewMain.this,progressbarx.class);
                    startActivity(intent);
                    break;
            }

        }
    }
}
