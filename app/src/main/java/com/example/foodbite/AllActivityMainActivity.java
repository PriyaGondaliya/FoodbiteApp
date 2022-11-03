package com.example.foodbite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;



public class AllActivityMainActivity extends AppCompatActivity implements Callback{

    private RecyclerView postRecyclerView;
    private List<PostItem> postItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.all_activity_main);

//        getSupportActionBar().hide();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigationCat) {
//                    Toast.makeText(getApplicationContext(),"categories selected",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AllActivityMainActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId() == R.id.navigationAll){
//                    Toast.makeText(getApplicationContext(),"All selected",Toast.LENGTH_LONG).show();

                    return true;
                }
                return false;
            }
        });
        postRecyclerView = findViewById(R.id.postRecyclerView);

        postItems = new ArrayList<>();
        postItems.add(new PostItem(R.drawable.cnoodles,"Hakka noodles"));
        postItems.add(new PostItem(R.drawable.jtempura,"Tempura"));
        postItems.add(new PostItem(R.drawable.jtofu,"Tofu"));
        postItems.add(new PostItem(R.drawable.idli,"Idli"));
        postItems.add(new PostItem(R.drawable.ipasta,"Pasta"));
        postItems.add(new PostItem(R.drawable.i_lasagne,"Lasagne"));
        postItems.add(new PostItem(R.drawable.samosa3,"Samosa"));
        postItems.add(new PostItem(R.drawable.pavbhaji,"Pavbhaji"));
        postItems.add(new PostItem(R.drawable.cmomos,"Momos"));
        postItems.add(new PostItem(R.drawable.ipizza,"Pizza"));
        postItems.add(new PostItem(R.drawable.jrice,"Rice"));
        postItems.add(new PostItem(R.drawable.cmanchurian,"Manchurian"));
        postItems.add(new PostItem(R.drawable.cfriedrice,"FriedRice"));
        postItems.add(new PostItem(R.drawable.jcurry,"Curry"));
        postItems.add(new PostItem(R.drawable.i_panzella,"Panzella"));
        postItems.add(new PostItem(R.drawable.alooparatha2,"Alooparatha"));

        postRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        postRecyclerView.setAdapter(new PostAdapter(postItems,AllActivityMainActivity.this));


    }


    @Override
    public void onClick(int i) {
//        int value = postItems.get(i).getImage();
//
//        Toast.makeText(this,value,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(AllActivityMainActivity.this,MainActivity3.class);

        intent.putExtra("IMAGE",postItems.get(i).getImage());
        intent.putExtra("POSITION", i);
        intent.putExtra("TITLE",postItems.get(i).getTitle());

        startActivity(intent);

    }
}