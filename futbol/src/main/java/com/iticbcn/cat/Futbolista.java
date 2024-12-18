package com.iticbcn.cat;

public class Futbolista extends Thread {
    public static final int NUM_JUGADOR = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista (int ngols, int ntirades) {
        this.ngols = 0;
        this.ntirades = 0;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }
    
}
