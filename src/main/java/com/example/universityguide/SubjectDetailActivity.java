package com.example.universityguide;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SubjectDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);

        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvDesc = findViewById(R.id.tvDescription);
        Button btnBack = findViewById(R.id.btnBack);

        String subject = getIntent().getStringExtra("subject_name");

        if (subject != null) {
            tvName.setText(subject);

            // حركة فخمة: تغيير الوصف حسب اسم المادة
            if (subject.contains("أندرويد")) {
                tvDesc.setText("تعد هذه المادة بوابتك للاحتراف في عالم تطبيقات الجوال، حيث ستتعلم كيفية بناء واجهات المستخدم المتقدمة، والتعامل مع قواعد البيانات المحلية والسحابية باستخدام أحدث لغات البرمجة.");
            } else if (subject.contains("بيانات")) {
                tvDesc.setText("مساق حيوي يركز على تنظيم وهيكلة المعلومات لضمان أداء برمجي عالٍ وسريع، وهو حجر الزاوية لكل مبرمج يسعى لفهم كيفية عمل الأنظمة الضخمة بكفاءة.");
            }
        }

        btnBack.setOnClickListener(v -> finish());
    }
}