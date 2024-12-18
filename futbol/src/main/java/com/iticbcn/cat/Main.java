package com.iticbcn.cat;

public class Main {
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
