package com.company;

public class Usmiech extends Buzka implements Skalowalny, Rysowalny, PrzedstawiaEmocje {

    public Usmiech(char c) {
        super(c);
    }

    public Usmiech() {
        super(')');
    }

    @Override
    public boolean czySieUsmiecha() {
        return true;
    }

    @Override
    public void przestanSieUsmiechac() {
        System.out.println();;
    }



    @Override
    public void draw() {
    }

    @Override
    public void draw(int i) {

    }
}
