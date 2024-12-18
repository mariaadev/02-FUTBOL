package com.iticbcn.cat;

public class Futbolista extends Thread {
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista (String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    /*Execució de les tirades */
    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            this.ntirades++;
            /*Math.random genera un num aleatori entre 0.0 i 1.0 */
            /*El jugador té un 50% de possibilitats de marcar un gol ja que el valor de probabilitat es un 0.5*/
            if (Math.random() < PROBABILITAT) {
                this.ngols++;
            }
        }
    }
}
