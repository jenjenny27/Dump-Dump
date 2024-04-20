package com.example.dump_dump;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;

public class HomePageActivity extends AppCompatActivity {
    Button button;

    ImageButton imagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        button =  findViewById (R.id.button2);
        button.setOnClickListener(v -> openLearnPageActivity());

        imagebutton = findViewById (R.id.settingButton);
        imagebutton.setOnClickListener(v -> openSettingActivity());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openLearnPageActivity(){
        Intent intent = new Intent(this, LearnPageActivity.class);
        startActivity(intent);
    }

    public void openSettingActivity(){
        Intent intent = new Intent(this, SettingPage.class);
        startActivity(intent);
    }
}