package com.example.uicomponents;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    private TextView textViewTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);

        textViewTest = findViewById(R.id.textViewTest);

        // 返回主界面按钮
        Button backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(v -> {
            finish(); // 返回到上一个界面（主界面）
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 加载菜单布局文件
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 处理菜单点击事件
        if (item.getItemId() == R.id.font_small) {
            textViewTest.setTextSize(10);
            return true;  // 菜单事件已处理
        } else if (item.getItemId() == R.id.font_medium) {
            textViewTest.setTextSize(16);
            return true;  // 菜单事件已处理
        } else if (item.getItemId() == R.id.font_large) {
            textViewTest.setTextSize(20);
            return true;  // 菜单事件已处理
        } else if (item.getItemId() == R.id.color_red) {
            textViewTest.setTextColor(Color.RED);
            return true;  // 菜单事件已处理
        } else if (item.getItemId() == R.id.color_black) {
            textViewTest.setTextColor(Color.BLACK);
            return true;  // 菜单事件已处理
        } else if (item.getItemId() == R.id.menu_normal) {
            Toast.makeText(this, "普通菜单项", Toast.LENGTH_SHORT).show();
            return true;  // 菜单事件已处理
        }

        // 如果没有处理的菜单项，调用父类的处理
        return super.onOptionsItemSelected(item);
    }

}

