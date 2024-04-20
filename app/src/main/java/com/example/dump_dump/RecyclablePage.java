package com.example.dump_dump;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RecyclablePage extends AppCompatActivity {
    ImageButton imagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclable_page);

        imagebutton = findViewById (R.id.backButton);
        imagebutton.setOnClickListener(v -> openWasteSegregationActivity());
    }

    public void openWasteSegregationActivity(){
        Intent intent = new Intent(this, WasteSegregationActivity.class);
        startActivity(intent);
    }
}
