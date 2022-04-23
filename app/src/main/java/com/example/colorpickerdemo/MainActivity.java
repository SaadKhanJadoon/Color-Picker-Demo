package com.example.colorpickerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ColorInterface {

    RecyclerView mainRecyclerView;
    ColorAdapter coloradapter;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRecyclerView = findViewById(R.id.recyclerview);
        textView = findViewById(R.id.textview);
        ColorStateList oldColors =  textView.getTextColors(); //save original colors
        button = findViewById(R.id.button);

        ArrayList<Integer> colorPickerColors = new ArrayList<>();
        String[] colorsTxt = getApplicationContext().getResources().getStringArray(R.array.colors);
        for (String s : colorsTxt) {
            int newColor = Color.parseColor(s);
            colorPickerColors.add(newColor);
        }
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        mainRecyclerView.setLayoutManager(layoutManager1);
        coloradapter = new ColorAdapter(colorPickerColors, MainActivity.this, MainActivity.this );
        mainRecyclerView.setAdapter(coloradapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextColor(oldColors);
            }
        });

    }

    @Override
    public void selectedColor(int colorCode) {
        textView.setTextColor(colorCode);
    }
}