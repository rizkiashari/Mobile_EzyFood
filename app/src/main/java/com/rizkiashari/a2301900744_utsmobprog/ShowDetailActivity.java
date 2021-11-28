package com.rizkiashari.a2301900744_utsmobprog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCardBtn;
    private TextView titleText, feeText, descText, numberQtyText;
    private ImageView plusBtn, minBtn, picFood;
    private Food object;
    private int numberQty = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);
        viewContent();
        getBundleContent();

    }

    private void getBundleContent() {

        object = (Food) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getImage(), "drawable", this.getPackageName());

        Glide.with(this).load(drawableResourceId).into(picFood);

        titleText.setText(object.getTitle());
        feeText.setText("$"+object.getFee());
        descText.setText(object.getDesc());
        numberQtyText.setText(String.valueOf(numberQty));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberQty = numberQty +1;
                numberQtyText.setText(String.valueOf(numberQty));
            }
        });

        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberQty > 1){
                    numberQty = numberQty - 1;
                }
                numberQtyText.setText(String.valueOf(numberQty));
            }
        });

        addToCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCard(numberQty);
                managementCart.insertFood(object);
            }
        });
    }

    private void viewContent() {
        addToCardBtn = findViewById(R.id.addToCardBtn);
        titleText = findViewById(R.id.titleText);
        feeText = findViewById(R.id.priceText);
        descText = findViewById(R.id.descTxt);
        numberQtyText = findViewById(R.id.numberQtyTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minBtn = findViewById(R.id.minBtn);
        picFood = findViewById(R.id.foodPic);
    }
}