package com.rizkiashari.a2301900744_utsmobprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rizkiashari.a2301900744_utsmobprog.Adapter.CartListAdapter;

public class CardListActivity extends AppCompatActivity {

    public RecyclerView.Adapter adapter;
    public RecyclerView recyclerViewList;
    public ManagementCart managementCart;
    public TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    public double tax;
    public ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
        viewList();
        viewContent();
        calculateCard();
    }

    private void viewList() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCard(), this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCard().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    public void calculateCard(){
        double persenTax = 0.05;
        double deliver = 30;

        tax = Math.round((managementCart.getTotalFee() * persenTax) * 100.0) / 100.0;

        double totalPrice = Math.round((managementCart.getTotalFee() + tax + deliver) * 100.0) / 100.0;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100.0) / 100.0;
        totalFeeTxt.setText("$"+itemTotal);
        taxTxt.setText("$" + tax);
        deliveryTxt.setText("$"+deliver);
        totalTxt.setText("$"+totalPrice);
    }

    private void viewContent() {

        recyclerViewList = findViewById(R.id.listCart);
        totalFeeTxt = findViewById(R.id.totalItemTxt);
        taxTxt = findViewById(R.id.TaxText);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView4);

    }












}