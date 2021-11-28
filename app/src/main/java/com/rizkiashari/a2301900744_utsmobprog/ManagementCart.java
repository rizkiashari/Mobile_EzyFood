package com.rizkiashari.a2301900744_utsmobprog;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagementCart {

    private Context context;
    private DataSets dataSets;

    public ManagementCart(Context context){
        this.context = context;
        this.dataSets = new DataSets(context);
    }

    public void insertFood(Food item){
        ArrayList<Food> listFood = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++){
            if(listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = i;
                break;
            }
        }
        if(existAlready){
            listFood.get(n).setNumberInCard(item.getNumberInCard());
        }else{
            listFood.add(item);
        }

        dataSets.putListObject("CardList", listFood);
        Toast.makeText(context, "Add To Card Success", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Food> getListCard(){
        return dataSets.getListObject("CardList");
    }

    public void plusNumberFood(ArrayList<Food> listFood, int position, ChangeNumberItemListener changeNumberItemListener ){
        listFood.get(position).setNumberInCard(listFood.get(position).getNumberInCard()+1);
        dataSets.putListObject("CardList", listFood );
        changeNumberItemListener.changed();
    }

    public void MinusNumberFood(ArrayList<Food> listFood, int position, ChangeNumberItemListener changeNumberItemListener){
        if(listFood.get(position).getNumberInCard()==1){
            listFood.remove(position);
        }else{
            listFood.get(position).setNumberInCard(listFood.get(position).getNumberInCard()+1);
        }

        dataSets.putListObject("CardList", listFood);
        changeNumberItemListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<Food>listFood = getListCard();
        double fee = 0;
        for (int i =0; i <listFood.size(); i++){
            fee = fee + (listFood.get(i).getFee() * listFood.get(i).getNumberInCard());
        }
        return fee;
    }


}
