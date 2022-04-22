package com.company;

public class Kwadrat extends Prostokat {


    public Kwadrat(int b) {
        super(b);
    }

    public Kwadrat(int b, int p) {
        super(b, p);
    }

    @Override
    public double bok() {
        return super.podstawa();
    }

    @Override
    public String toString() {
        return "kwadrat";
    }


}
