package com.example.foodbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigationCat) {
//                    Toast.makeText(getApplicationContext(),"categories selected",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId() == R.id.navigationAll){
//                    Toast.makeText(getApplicationContext(),"All selected",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity2.this,AllActivityMainActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        Intent intent = getIntent();

        String cat = intent.getStringExtra("NAME");
        models = new ArrayList<>();
        switch (cat){
            case "Indian":
                models.add(new Model(R.drawable.pavbhaji,"Pavbhaji"));
                models.add(new Model(R.drawable.samosa3,"Samosa"));
                models.add(new Model(R.drawable.alooparatha2,"AlooParatha"));
                models.add(new Model(R.drawable.idli,"Idli"));
                break;
            case "Chinese":
                models.add(new Model(R.drawable.cfriedrice,"Friedrice"));
                models.add(new Model(R.drawable.cnoodles,"Hakkanoodles"));
                models.add(new Model(R.drawable.cmanchurian,"Manchurian"));
                models.add(new Model(R.drawable.cmomos,"Momos"));
                break;
            case "Japanese":
                models.add(new Model(R.drawable.jcurry,"Curry"));
                models.add(new Model(R.drawable.jrice,"Rice"));
                models.add(new Model(R.drawable.jtempura,"Tempura"));
                models.add(new Model(R.drawable.jtofu,"Tofu"));
                break;
            case "Italian":
                models.add(new Model(R.drawable.i_lasagne,"Lasagne"));
                models.add(new Model(R.drawable.i_panzella,"Panzella"));
                models.add(new Model(R.drawable.ipasta,"Pasta"));
                models.add(new Model(R.drawable.ipizza,"Pizza"));
                break;
            default:
                models.add(new Model(R.drawable.pavbhaji,"Pavbhaji"));
                models.add(new Model(R.drawable.samosa3,"Samosa"));
                models.add(new Model(R.drawable.alooparatha2,"AlooParatha"));
                models.add(new Model(R.drawable.idli,"Idli"));
        }
//

        adapter = new Adapter(models, this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);


//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }
}