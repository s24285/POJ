package com.company;

public class Prostokat {
    private double bok1;
    private double bok2;

    public Prostokat (double bok1, double bok2) {
        this.bok1 = bok1;
        this.bok2 = bok2;
    }

    public Prostokat() {
    }

    public void setBok1 (double bok1) {
        this.bok1 = bok1;
    }

    public void setBok2 (double bok2) {
        this.bok2 = bok2;
    }

    public double getBok1 () {
        return this.bok1;
    }

    public double getBok2 () {
        return this.bok2 = bok2;
    }

    public double przekatna (double param1) {
        return (Math.sqrt((bok1 * bok1) + (bok2 * bok2)) * 2.5);
    }

    public double przekatna () {
        return Math.sqrt((bok1 * bok1) + (bok2 * bok2));
    }

    public int przekatna (int param2) {
        return (int) (przekatna() * 2);
    }

}
