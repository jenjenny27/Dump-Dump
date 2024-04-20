package com.example.dump_dump;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;

public class LearnPageActivity extends AppCompatActivity {
    Button button;
    ImageButton imagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_page);

        button = findViewById (R.id.button4);
        button.setOnClickListener(v -> openWasteSegAct());

        imagebutton = findViewById (R.id.homepageButton);
        imagebutton.setOnClickListener(v -> openHomePageActivity());

        button = findViewById (R.id.button3);
        button.setOnClickListener(v -> openWasteManageAct());
    }

    public void openWasteSegAct(){
        Intent intent = new Intent(this, WasteSegregationActivity.class);
        startActivity(intent);
    }

    public void openWasteManageAct(){
        Intent intent = new Intent(this, WasteManagementActivity.class);
        startActivity(intent);
    }

    public void openHomePageActivity(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }


}
