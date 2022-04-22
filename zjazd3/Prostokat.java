package com.company;

import java.util.Objects;

public class Prostokat implements MoznaWyznaczycWielokrotnoscPrzekatnej, MoznaWyznaczycWysokosc {

    private int b;
    private int p;

    public Prostokat(int b, int p) {
        this.b = b;
        this.p = p;
    }

    public Prostokat(int b) {
        this.b = b;
    }


    @Override
    public double wielokrotnoscPrzekatnej(double wielokrotnosc) {
        return wielokrotnosc * przekatna();
    }

    @Override
    public int wielokrotnoscPrzekatnej(int wielokrotnosc) {
        return (int) (wielokrotnosc * przekatna());
    }

    @Override
    public double podstawa() {
        return this.b;
    }

    @Override
    public double katNachylenia() {
        return Math.PI / 2;
    }

    @Override
    public double bok() {
        return this.p;
    }


    @Override
    public double przekatna() {
        return Math.sqrt((bok() * bok()) + (podstawa() * podstawa()) + (2 * bok() * podstawa() * Math.cos(katNachylenia())));
    }

    @Override
    public double wysokosc() {
        return bok();
    }

    @Override
    public String toString() {
        return "prostokat";
    }

}
