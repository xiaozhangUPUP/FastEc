package com.zq.latte_ec.main;


public class RgbValue {

    private int red;

    private int green;
    private int blue;

    public RgbValue(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public static RgbValue create(int red, int green, int blue) {
        return new RgbValue(red, green, blue);
    }
}
