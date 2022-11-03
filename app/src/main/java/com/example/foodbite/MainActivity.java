package com.example.foodbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    CardView indian,chinese,japanese,italian;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigationCat) {
//                    Toast.makeText(getApplicationContext(),"categories selected",Toast.LENGTH_LONG).show();
                    return true;
                }
                else if(item.getItemId() == R.id.navigationAll){
//                    Toast.makeText(getApplicationContext(),"All selected",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,AllActivityMainActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        indian = (CardView) findViewById(R.id.indian);
        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("NAME","Indian");
                startActivity(intent);
            }
        });
        chinese = (CardView) findViewById(R.id.chinese);
        chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("NAME","Chinese");
                startActivity(intent);
            }
        });
        italian = (CardView) findViewById(R.id.italian);
        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("NAME","Italian");
                startActivity(intent);
            }
        });
        japanese = (CardView) findViewById(R.id.japanese);
        japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("NAME","Japanese");
                startActivity(intent);
            }
        });
    }


}