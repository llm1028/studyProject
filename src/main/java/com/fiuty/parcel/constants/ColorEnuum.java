package com.fiuty.parcel.constants;

/**
 * 车油漆颜色
 * @author Fiuty
 */
public enum ColorEnuum {

    WHITE("白色"),BLACK("黑色"),RED("红色");

    String color;

    ColorEnuum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
