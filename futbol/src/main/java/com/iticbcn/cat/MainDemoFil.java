package com.iticbcn.cat;

public class MainDemoFil{
    public static void main(String[] args) {
            /* Ús del mètode currentThread per obtenir el fil actual*/
            Thread filActual = Thread.currentThread();

            /*Nom de la classe i mètode */
            System.out.println("MainDemoFil.main:");
            
            /*Ús del mètode getPriority per obtenir la prioritat*/
            System.out.println("Prioritat -> " + filActual.getPriority());
            
            /*Ús del mètode getPriority per obtenir el nom del fil*/
            System.out.println("Nom -> " + filActual.getName());
            
            /*Ús del mètode toString per obtenir la representació en String del fil*/
            System.out.println("toString() -> " + filActual.toString());
    }
}
