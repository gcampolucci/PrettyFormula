package it.gc.prettyformula;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String testo = "=SE(E([@Stato]<>\"Chiuso\";[@Stato]<>\"Risolto\";O(E([@OdL]<>\"\";O([@Categoria]=\"SDLC Light\";VAL.NUMERO([@OdL])));E([@OdL]=\"\";[@Categoria]<>\"SDLC Light\")));SE([@Age]<>\"\";[@Age]*PesoAge;0)+SE([@[Solleciti SD]]<>\"\";[@[Solleciti SD]]*PesoSolleciti;0)+SE(SINISTRA([@Priorità];1)=\"1\";PesoCritico;SE(SINISTRA([@Priorità];1)=\"2\";PesoAlto;SE(SINISTRA([@Priorità];1)=\"3\";PesoModerato;SE(SINISTRA([@Priorità];1)=\"4\";PesoBasso;PesoPianificato))))+SE(E([@OdL]<>\"\";VAL.NUMERO([@OdL]));OdLStart-[@OdL]*OdLLevel;0)+SE([@Stato]=\"In Progress\";PesoStato;0)+SE(SINISTRA([@Numero];3)=\"INC\";PesoTipo;0);SE(O([@Stato]=\"Chiuso\";[@Stato]=\"Risolto\");-1;SE([@Categoria]=\"SDLC Light\";-2;0)))";
        Prettify(testo);
    }

    public static void Prettify(String formula){
        //char pre_char = '|'; // Variabile tiene in memoria il carattere precedente
        int ind = 0; // Contatore di INDENT
        String new_line = System.getProperty("line.separator"); // In aleternativa al '\n' per uso su più sistemi
        // Trasforma la stringa in un array di caratteri e cicla dal primo all'ultimo
        for (char x:formula.toCharArray()) {
            switch (x) {
                case '(' -> {
                    // Se trova una parentesi tonda aperta
                    // scrive il carattere e va a capo
                    System.out.print(x + new_line);
                    // incrementa l'indicatore di indent
                    ind++;
                    // imposta l'indent e memorizza il carattere come precedente
                    System.out.print(Indent(ind));
                }
                //pre_char = x;
                case ')' -> {
                    // Se trova una parentesi tonda chiusa va a capo
                    System.out.print(new_line);
                    // decrementa l'indicatore di indent
                    ind--;
                    // imposta l'indent e scrive il carattere
                    System.out.print(Indent(ind));
                    System.out.print(x);
                }
                // memorizza il carattere come precedente
                //pre_char = x;
                case ';' -> {
                    // Se trova un punto e virgole lo scrive e va a capo
                    System.out.print(x + new_line);
                    // imposta l'indent
                    System.out.print(Indent(ind));
                }
                // memorizza il carattere come precedente
                //pre_char = x;
                default ->
                        // Scrive il carattere e lo memorizza come precedente
                        System.out.print(x);

                //pre_char = x;
            }
        }
    }

    private static String Indent(int n){
        // Crea variabile da restituire
        // concatena n TAB
        // Restituisce il risultato
        return "\t".repeat(Math.max(0, n))
                // Restituisce il risultato
                ;
    }

}
