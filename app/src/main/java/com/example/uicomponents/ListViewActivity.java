package com.example.uicomponents;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {
    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageIds = new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);

        // 获取按钮
        Button backButton = findViewById(R.id.button_back);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView listView = findViewById(R.id.array);
        List<Map<String,Object>> data = new ArrayList<>();

        for(int i=0;i<6;i++){
            Map<String,Object> item = new HashMap<>();
            item.put("text",names[i]);
            item.put("images",imageIds[i]);
            data.add(item);
        }

        // Keys in the map
        String[] from = {"images", "text"};
        // IDs of views in list_item.xml
        int[] to = {R.id.item_image, R.id.item_text};

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
                String text = (String) item.get("text");
                Toast.makeText(ListViewActivity.this, "Selected: " + text, Toast.LENGTH_SHORT).show();
            }
        });

        // 设置按钮点击事件
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动ListViewActivity
                Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
