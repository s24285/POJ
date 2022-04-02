package com.company;

public class Kwadrat extends Prostokat {

    private double bok1;
    //private double bok1;

    public Kwadrat (double bok1, double bok2) {
        super(bok1, bok2);
        this.bok1 = bok1;
        this.bok1 = bok1;
    }

    public Kwadrat (double bok1) {
        super();
        this.bok1 = bok1;
    }

    public double przekatna () {
        return Math.sqrt(2*bok1*bok1);
    }
}
