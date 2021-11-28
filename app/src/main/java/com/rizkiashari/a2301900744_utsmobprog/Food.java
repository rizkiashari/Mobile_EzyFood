package com.rizkiashari.a2301900744_utsmobprog;

import java.io.Serializable;

public class Food  implements Serializable {

    private String title;
    private String image;
    private String desc;
    private Double fee;
    private int numberInCard;

    public Food(String title, String image, String desc, Double fee) {
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.fee = fee;
    }

    public Food(String title, String image, String desc, Double fee, int numberInCard) {
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.fee = fee;
        this.numberInCard = numberInCard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
