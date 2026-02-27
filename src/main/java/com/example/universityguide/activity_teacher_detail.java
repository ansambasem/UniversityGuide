package com.example.universityguide;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// تم تغيير اسم الكلاس ليتطابق مع المعايير (أول حرف كبير وبدون underscores)
// تأكدي أن اسم الملف في أندرويد ستوديو هو TeacherDetailActivity.java
public class activity_teacher_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);

        // 1. تعريف العناصر من الـ XML
        TextView tvName = findViewById(R.id.tvTeacherNameDetail);
        TextView tvInfo = findViewById(R.id.tvTeacherInfo);
        ImageView imgProfile = findViewById(R.id.imgTeacherProfile);
        Button btnBack = findViewById(R.id.btnBackFromDetail);

        // 2. استلام الاسم المرسل من صفحة القائمة (TeachersActivity)
        String teacherName = getIntent().getStringExtra("teacher_name");

        // 3. عرض البيانات بناءً على الاسم المستلم
        if (teacherName != null) {
            tvName.setText(teacherName);

            // حركة ذكية: نغير الوصف بناءً على الأستاذ المختار
            if (teacherName.contains("محمد")) {
                tvInfo.setText("التخصص: هندسة برمجيات\nالمكتب: طابق 3 - غرفة 302\nالساعات: 10ص - 12م");
            } else if (teacherName.contains("سارة")) {
                tvInfo.setText("التخصص: ذكاء اصطناعي\nالمكتب: طابق 2 - غرفة 205\nالساعات: 1م - 3م");
            } else {
                tvInfo.setText("التخصص: قسم تكنولوجيا المعلومات\nالمكتب: مبنى مجمع القاعات\nالساعات: حسب الجدول");
            }
        }

        // 4. برمجة زر الرجوع
        btnBack.setOnClickListener(v -> finish());
    }
}