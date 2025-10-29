package com.teristit.maxbanyaapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Gravity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Создаем LinearLayout как контейнер
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setBackgroundColor(Color.parseColor("#4A90E2"));
        
        // Создаем TextView для отображения текста
        TextView textView = new TextView(this);
        textView.setText("свой текст");
        textView.setTextSize(24);// СВОЙ ТЕКСТ
        textView.setTextColor(Color.WHITE);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setGravity(Gravity.CENTER);
        
        // Добавляем TextView в layout
        layout.addView(textView);
        
        // Устанавливаем layout как content view
        setContentView(layout);
    }
}