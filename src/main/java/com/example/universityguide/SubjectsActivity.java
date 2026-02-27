package com.example.universityguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class SubjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        ListView listView = findViewById(R.id.subjectsListView);
        Button btnBack = findViewById(R.id.btnBackToMain);

        String[] subjects = {
                "برمجة أندرويد",
                "هياكل بيانات",
                "قواعد بيانات",
                "ذكاء اصطناعي",
                "شبكات الحاسوب",
                "تحليل نظم"
        };

        // --- التعديل الاحترافي هنا ---
        // استخدمنا activated_1 ليعطي خطاً أوضح وتباعداً (Padding) أفضل يتناسب مع الـ Header الجديد
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                subjects
        );
        // -----------------------------

        listView.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSubject = subjects[position];
                Intent intent = new Intent(SubjectsActivity.this, SubjectDetailActivity.class);
                intent.putExtra("subject_name", selectedSubject);
                startActivity(intent);
            }
        });
    }
}