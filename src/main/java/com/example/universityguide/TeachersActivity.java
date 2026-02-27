package com.example.universityguide;

import android.content.Intent; // لا تنسي استيراد الـ Intent
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class TeachersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

        // 1. تعريف العناصر
        ListView listView = findViewById(R.id.teachersListView);
        Button btnBack = findViewById(R.id.btnBackFromTeachers);

        // 2. قائمة الأساتذة
        String[] teachers = {
                "د. محمد أحمد",
                "د. سارة محمود",
                "م. خالد علي",
                "د. ريم حسن"
        };

        // 3. الـ Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                teachers
        );
        listView.setAdapter(adapter);

        // 4. التعديل الجوهري: الانتقال لصفحة التفاصيل عند الضغط
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // استخراج اسم المدرس الذي تم اختياره
                String selectedTeacher = teachers[position];

                // إنشاء Intent لفتح صفحة TeacherDetailActivity
                Intent intent = new Intent(TeachersActivity.this, activity_teacher_detail.class);

                // إرسال الاسم إلى الصفحة الثانية
                intent.putExtra("teacher_name", selectedTeacher);

                // تشغيل الواجهة الجديدة
                startActivity(intent);
            }
        });

        // 5. برمجة زر العودة
        btnBack.setOnClickListener(v -> finish());
    }
}