package com.example.universityguide;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DepartmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // تم حذف EdgeToEdge والأسطر المسببة للخطأ لضمان عمل التطبيق
        setContentView(R.layout.activity_departments);

        // 1. تعريف زر الرجوع من خلال الـ ID الذي وضعناه في الـ XML
        Button btnBack = findViewById(R.id.btnBack);

        // 2. برمجة الزر للعودة للقائمة الرئيسية عند الضغط عليه
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // دالة finish تغلق الواجهة الحالية وتعود بكِ تلقائياً للواجهة السابقة
                finish();
            }
        });
    }
}