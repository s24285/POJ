package com.company;

public class Buzka implements PrzedstawiaEmocje, Rysowalny, Skalowalny {

    char c;

    public Buzka(char c) {
    }


    public void draw() {
        System.out.println(":-" + c);
    }

    @Override
    public boolean czySieUsmiecha() {
        return true;
    }

    @Override
    public void przestanSieUsmiechac() {
        System.out.println(c);;
    }

    public void draw(int i) {

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        return true;
    }

    public String toString() {
        return ":-(";
    }
}
