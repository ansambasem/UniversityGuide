package com.example.universityguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. زر المواد
        findViewById(R.id.btnSubjects).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, SubjectsActivity.class)));

        // 2. زر الأساتذة
        findViewById(R.id.btnTeachers).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, TeachersActivity.class)));

        // 3. زر الأقسام الجامعية (هذا هو الزر الذي كان ينقصك)
        findViewById(R.id.btnDepts).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, DepartmentsActivity.class)));

        // 4. زر حول التطبيق
        findViewById(R.id.btnAbout).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AboutActivity.class)));

        // 5. زر الخروج (تعديل ليصبح احترافياً بـ AlertDialog)
        findViewById(R.id.btnExit).setOnClickListener(v -> showExitDialog());
    }

    // دالة لإظهار رسالة تأكيد عند الخروج
    private void showExitDialog() {
        new android.app.AlertDialog.Builder(this)
                .setTitle("تأكيد الخروج")
                .setMessage("هل تريد حقاً إغلاق التطبيق؟")
                .setPositiveButton("نعم", (dialog, which) -> finish())
                .setNegativeButton("لا", null)
                .show();
    }
}