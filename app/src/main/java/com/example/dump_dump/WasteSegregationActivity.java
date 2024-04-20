package com.example.dump_dump;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.ImageButton;

public class WasteSegregationActivity extends AppCompatActivity {
    ImageButton imagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waste_segregation);

        imagebutton = findViewById (R.id.backButton);
        imagebutton.setOnClickListener(v -> openLearnPageActivity());

        imagebutton = findViewById (R.id.button5);
        imagebutton.setOnClickListener(v -> openCompostableActivity());

        imagebutton = findViewById (R.id.button6);
        imagebutton.setOnClickListener(v -> openRecyclableActivity());

        imagebutton = findViewById (R.id.button7);
        imagebutton.setOnClickListener(v -> openNonBioActivity());

        imagebutton = findViewById (R.id.button8);
        imagebutton.setOnClickListener(v -> openHazardousActivity());

        imagebutton = findViewById (R.id.button9);
        imagebutton.setOnClickListener(v -> openMedicalActivity());

        imagebutton = findViewById (R.id.button10);
        imagebutton.setOnClickListener(v -> openHealthCareActivity());
    }

    public void openLearnPageActivity(){
        Intent intent = new Intent(this, LearnPageActivity.class);
        startActivity(intent);
    }

    public void openCompostableActivity(){
        Intent intent = new Intent(this, CompostablePage.class);
        startActivity(intent);
    }

    public void openNonBioActivity(){
        Intent intent = new Intent(this, NonBioPage.class);
        startActivity(intent);
    }

    public void openRecyclableActivity(){
        Intent intent = new Intent(this, RecyclablePage.class);
        startActivity(intent);
    }

    public void openHazardousActivity(){
        Intent intent = new Intent(this, HazardousPage.class);
        startActivity(intent);
    }

    public void openMedicalActivity(){
        Intent intent = new Intent(this, MedicalPage.class);
        startActivity(intent);
    }

    public void openHealthCareActivity(){
        Intent intent = new Intent(this, HealthCarePage.class);
        startActivity(intent);
    }


}
