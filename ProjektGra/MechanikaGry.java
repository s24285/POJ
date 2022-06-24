package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class MechanikaGry extends JPanel implements ActionListener {

    //wspolrzedne
    final int x [] = new int [JEDNOSTKI];
    final int y [] = new int [JEDNOSTKI];

    //parametry okna
    static final int SZEROKOSC = 500;
    static final int WYSOKOSC = 500;
    static final int PIXELE = 25;
    static final int JEDNOSTKI = (SZEROKOSC * WYSOKOSC)/PIXELE;
    static final int OPOZNIENIE = 120;

    //parametry wezyka i jedzenia
    int dlugoscWezyka = 6;
    int zjedzone;
    int jedzenieX;
    int jedzenieY;

    //ruch poczatkowy
    boolean ruszaSie = false;
    boolean wLewo = false;
    boolean wPrawo = true;
    boolean doGory = false;
    boolean wDol = false;

    Random random;
    Timer timer;

    MechanikaGry() {

        this.addKeyListener(new Klawisz());
        this.setBackground(Color.darkGray);
        this.setFocusable(true); //musi byc ustawione na true, zeby program sluchal polecen z klawiatury; w jpanel nie jest to ustawione w defaulcie

        random = new Random();
        this.setPreferredSize(new Dimension(SZEROKOSC, WYSOKOSC));

        poczatekGry();
    }

    public void poczatekGry () {
        noweJedzenie();
        ruszaSie = true;
        timer = new Timer (OPOZNIENIE,this);
        timer.start();
    }

    public void rysowanie (Graphics grafika) {

        //linie pionowe i poziome na planszy
        for (int i = 0; i < WYSOKOSC / PIXELE; i++) {
            grafika.drawLine(i * PIXELE, 0, i * PIXELE, WYSOKOSC);
            grafika.drawLine(0, i * PIXELE, SZEROKOSC, i * PIXELE);
        }

        if (ruszaSie) {

           //rysowanie jedzenia
           grafika.setColor(Color.red);
           grafika.fillRect(jedzenieX, jedzenieY, PIXELE, PIXELE);

           //rysowanie wezyka i
           for (int i = 0; i < dlugoscWezyka; i++) {
               if (i == 0) {
                    grafika.setColor(Color.blue);
                    grafika.fillOval(x[i], y[i], PIXELE, PIXELE);
               } else {
                    grafika.setColor(Color.yellow);
                    grafika.fillOval(x[i], y[i], PIXELE, PIXELE);
               }
            }
        } else {
            koniecGry (grafika);
        }
    }

    public void poruszanie () {

        for (int i=dlugoscWezyka; i > 0; --i) {
            x[i] = x[(i-1)];
            y[i] = y[(i-1)];
        }
            if (wLewo)
                x[0] -= PIXELE;
            if (wPrawo)
                x[0] += PIXELE;
            if (doGory)
                y[0] -= PIXELE;
            if (wDol)
                y[0] += PIXELE;

    }

    //mechanizm zjadania
    public void jedzenie () {
        if ((x[0] == jedzenieX) && (y[0] == jedzenieY)) {
            dlugoscWezyka++;
            zjedzone++;
            noweJedzenie();
        }
    }

    //mechanizm losowego umieszczania nowego jedzenia na planszy
    public void noweJedzenie () {
        jedzenieX = random.nextInt((int) (SZEROKOSC/PIXELE))*PIXELE;
        jedzenieY = random.nextInt((int) (WYSOKOSC/PIXELE))*PIXELE;
    }

    public void zderzenia () {
        //sprawdza, czy glowa wezyka zderza sie z ogonem
        for (int i=dlugoscWezyka; i > 0; i--) {
            if ((i>4) && (x[0] == x [i]) && (y[0] == y [i])) {
                ruszaSie = false;
            }
        }

        //sprawdza, czy glowa zderza sie z lewa sciana
        if (x[0] < 0)
            ruszaSie = false;

        //sprawdza, czy glowa zderza sie z prawa sciana
        if (x[0] >= SZEROKOSC)
            ruszaSie = false;

        //sprawdza, czy glowa zderza sie z gorna sciana
        if (y[0] < 0)
            ruszaSie = false;

        //sprawdza, czy glowa zderza sie z dolna sciana
        if (y[0] >= WYSOKOSC)
            ruszaSie = false;


        if (ruszaSie==false) {
            timer.stop();
        }
    }

    public void koniecGry (Graphics grafika) {

        //napis na zakonczenie gry
        String napis = "Koniec gry!";
        Font czcionka = new Font("Arial", Font.BOLD, 45);
        FontMetrics metr = getFontMetrics(czcionka);
        grafika.setColor(Color.red);
        grafika.setFont(czcionka);
        grafika.drawString(napis, (SZEROKOSC - metr.stringWidth(napis)) / 2, WYSOKOSC / 2 -80);

        //wypisanie zdobytych punktow
        String napisPkt = "Zdobyłes: ";
        grafika.drawString(napisPkt + zjedzone + " pkt", (SZEROKOSC - metr.stringWidth(napisPkt + zjedzone)) / 2 - 50, WYSOKOSC/2 + 80);
    }

    public void paintComponent (Graphics grafika) {
        super.paintComponent(grafika);
        rysowanie(grafika);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (ruszaSie) {
            poruszanie();
            jedzenie();
            zderzenia();

        }
        repaint();

    }

    //klasa wewnetrzna
    public class Klawisz extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e)  {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (wPrawo == false) {
                        wLewo = true;
                        doGory = false;
                        wDol = false;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (wLewo == false) {
                        wPrawo = true;
                        doGory = false;
                        wDol = false;
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (wDol == false) {
                        doGory = true;
                        wPrawo = false;
                        wLewo = false;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (doGory == false) {
                        wDol = true;
                        wPrawo = false;
                        wLewo = false;
                    }
                    break;
            }
        }
    }

}
