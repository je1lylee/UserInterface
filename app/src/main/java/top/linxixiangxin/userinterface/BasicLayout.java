package top.linxixiangxin.userinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BasicLayout extends AppCompatActivity {
    private Button btnLinear,btnRelative,btnFrame,btnGrid,btnTable,btnAbsolute,btnCostraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_layout);
        //Find view
        btnLinear = findViewById(R.id.btn_Linear);
        btnRelative = findViewById(R.id.btn_Relative);
        btnFrame = findViewById(R.id.btn_Frame);
        btnGrid = findViewById(R.id.btn_Grid);
        btnTable = findViewById(R.id.btn_Table);
        btnAbsolute = findViewById(R.id.btn_absolute);
        btnCostraint = findViewById(R.id.btn_constraint);
        //Set listener
        btnLinear.setOnClickListener(new MyClickListener());
        btnRelative.setOnClickListener(new MyClickListener());
        btnFrame.setOnClickListener(new MyClickListener());
        btnGrid.setOnClickListener(new MyClickListener());
        btnTable.setOnClickListener(new MyClickListener());
        btnAbsolute.setOnClickListener(new MyClickListener());
        btnCostraint.setOnClickListener(new MyClickListener());



    }
    class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intentx = new Intent();
            switch (view.getId()){
                case R.id.btn_Linear:
                    Toast.makeText(BasicLayout.this, "#暂时不可用#", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_Relative:
                    intentx.setClass(BasicLayout.this,RelativeLayout.class);
                    startActivity(intentx);
                    break;
                case R.id.btn_Frame:
                    intentx.setClass(BasicLayout.this,FrameLayout.class);
                    startActivity(intentx);
                    break;
                case R.id.btn_Grid:
                    intentx.setClass(BasicLayout.this,grid_activity.class);
                    startActivity(intentx);
                    break;
                case R.id.btn_Table:
                    Toast.makeText(BasicLayout.this, "#暂时不可用#", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_absolute:
                    Toast.makeText(BasicLayout.this, "#暂时不可用#", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_constraint:
                    Toast.makeText(BasicLayout.this, "#暂时不可用#", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
