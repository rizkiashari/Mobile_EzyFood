package com.rizkiashari.a2301900744_utsmobprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rizkiashari.a2301900744_utsmobprog.Adapter.CategoryAdapter;
import com.rizkiashari.a2301900744_utsmobprog.Adapter.PopularAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter, adapter2;
private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNav();
    }

    private void bottomNav() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CardListActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<Food> foodArrayList  = new ArrayList<>();
        foodArrayList.add(new Food("Ayam Bakar 01","ayambakar", "Ayam bakar version 1", 9.55));
        foodArrayList.add(new Food("Ayam Bakar 02","ayambakar", "Ayam Bakar version 2", 10.11));
        foodArrayList.add(new Food("alpukat","alpukat", "Alpukat yang manis banget", 11.11));
        foodArrayList.add(new Food("Ayam Bakar 05","ayambakar", "", 200.00));
        foodArrayList.add(new Food("Pizza","pizza", "Pizza pakai bahan yang mantap", 11.11));
        foodArrayList.add(new Food("Jus Semangka","jus_semangka", "Semangka Unggulan", 11.15));
        adapter2=new PopularAdapter((foodArrayList));
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<Category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(new Category("Pizza","cat_1"));
        categoryArrayList.add(new Category("Jus Semangka","cat_2"));
        categoryArrayList.add(new Category("Ayam Bakar","cat_3"));
        categoryArrayList.add(new Category("Alpukat Jus","cat_4"));
        categoryArrayList.add(new Category("Ayam Bakar","cat_5"));

        adapter = new CategoryAdapter(categoryArrayList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}