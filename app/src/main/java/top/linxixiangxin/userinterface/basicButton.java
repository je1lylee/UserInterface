package top.linxixiangxin.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class basicButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_button);
    }

    public void Buttoner(View view) {
        Toast.makeText(this, "按钮被按下", Toast.LENGTH_SHORT).show();
    }
}
