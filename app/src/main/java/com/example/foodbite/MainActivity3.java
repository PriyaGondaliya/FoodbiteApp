package com.example.foodbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class MainActivity3 extends AppCompatActivity {
    TextView txt,desc;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigationCat) {
//                    Toast.makeText(getApplicationContext(),"categories selected",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity3.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId() == R.id.navigationAll){
//                    Toast.makeText(getApplicationContext(),"All selected",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity3.this,AllActivityMainActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        Intent intent = getIntent();
        int position = intent.getIntExtra("POSITION",0);
        int image = intent.getIntExtra("IMAGE",0);
        String title = intent.getStringExtra("TITLE");
        // Capture the layout's TextView and set the string as its text
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(image);
//        txt = findViewById(R.id.title);
//        txt.setText(title);
        desc =  findViewById(R.id.desc);

        String string = "";
        StringBuilder stringBuilder = new StringBuilder();

//        InputStream is = this.getResources().openRawResource('R.raw.'+title.toLowerCase());
        InputStream is = getResources().openRawResource(
                getResources().getIdentifier(title.toLowerCase(),
                        "raw", getPackageName()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (true) {
            try {
                if ((string = reader.readLine()) == null) break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(string).append("\n");
            desc.setText(stringBuilder);
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if(title.equals("Samosa")){
//            desc.setText("piyapiya.................................");
//        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }
}