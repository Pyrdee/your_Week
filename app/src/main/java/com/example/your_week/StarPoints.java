package com.example.your_week;

public class StarPoints {
    private int value;
    private int star;

    /**
     * @param value
     * @param star
     */


    public StarPoints(int value, int star) {
        this.value = value;
        this.star = star;
    }

    //Nollaa koko saldon
    public void reset() {
        this.value = 0;
    }

    public int getValue() {
        return this.value;
    }

    //Lisää tähden verran pisteitä saldoon
    public void plusStar() {
        this.value = this.value + this.star;
    }

}
