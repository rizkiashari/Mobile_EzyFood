package com.rizkiashari.a2301900744_utsmobprog.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rizkiashari.a2301900744_utsmobprog.ChangeNumberItemListener;
import com.rizkiashari.a2301900744_utsmobprog.Food;
import com.rizkiashari.a2301900744_utsmobprog.ManagementCart;
import com.rizkiashari.a2301900744_utsmobprog.R;
import com.rizkiashari.a2301900744_utsmobprog.ShowDetailActivity;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    private ArrayList<Food> foodArrayList;
    private ManagementCart managementCart;
    private ChangeNumberItemListener changeNumberItemListener;

    public CartListAdapter(ArrayList<Food> foodArrayList, Context context, ChangeNumberItemListener changeNumberItemListener) {
        this.foodArrayList = foodArrayList;
        managementCart = new ManagementCart(context);
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(foodArrayList.get(position).getTitle());
        holder.feeSetiapItem.setText(String.valueOf(foodArrayList.get(position).getFee()));
        holder.totalSetiapItem.setText(String.valueOf(Math.round((foodArrayList.get(position).getNumberInCard() * foodArrayList.get(position).getFee()) * 100.0) / 100.0));
        holder.num.setText(String.valueOf(foodArrayList.get(position).getNumberInCard()));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(foodArrayList.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.image);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.plusNumberFood(foodArrayList, position, new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.MinusNumberFood(foodArrayList, position, new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView title, feeSetiapItem;
        ImageView image, plusItem, minusItem;
        TextView totalSetiapItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title2Txt);
            feeSetiapItem = itemView.findViewById(R.id.feeSetiapItem);
            image = itemView.findViewById(R.id.picCart);
            totalSetiapItem = itemView.findViewById(R.id.totalSetiapItem);
            num = itemView.findViewById(R.id.numberItemTxt);
            plusItem = itemView.findViewById(R.id.plusBtn);
            minusItem = itemView.findViewById(R.id.minItem);
        }
    }
}
