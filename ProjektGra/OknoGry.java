package com.company;

import javax.swing.*;

public class OknoGry extends JFrame {

    OknoGry () {

        MechanikaGry mechanika = new MechanikaGry();
        this.add(mechanika);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}
