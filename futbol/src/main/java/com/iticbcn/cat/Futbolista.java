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

    public static void main(String[] args) {
        Futbolista[] jugadors = new Futbolista[Futbolista.NUM_JUGADORS];

        String[] noms = { "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
                          "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé" };

        /*Popular llista de Futbolistes amb els noms*/ 
        for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(noms[i]);
        }

        System.out.println("Inici dels xuts --------------------");

        /*Iniciar fil per cada jugadaor */
        for (Futbolista jugador : jugadors) {
            jugador.start();
        }

        /* Esperar a que el fil de cada jugador acabi */
        for (Futbolista jugador : jugadors) {
            try {
                jugador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts -----------------------");

        /*Mostrar les estadístiques */
        System.out.println("--- Estadístiques ------");
        for (Futbolista jugador : jugadors) {
            /*Utilitzar el mètode getName de la classe Thread de la que hereda Futbolista */
            System.out.println(jugador.getName() + " -> " + jugador.getNgols() + " gols");
        }
    }
}
