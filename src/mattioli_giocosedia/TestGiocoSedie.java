/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mattioli_giocosedia;

import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author Filippo Mattioli
 */
public class TestGiocoSedie {
    //private final static int NUMSEDIE = 15;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di partecipanti: ");
        int numPartecipanti = scanner.nextInt();
        int numSedie = numPartecipanti - 1;
        
        Scrittore scrittore1 = new Scrittore("Risultato.txt");
     
        Posto sedie[] = new Posto[numSedie];
        
	for (int k = 0; k < sedie.length; k++)
		sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();

	Partecipante array[] = new Partecipante[numPartecipanti];
	for (int i = 0; i < numPartecipanti; i++) {
		array[i] = new Partecipante(sedie, scrittore1, i);
                //System.out.println("Sto facendo partire il thread n." + array[i].getId());
                logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
                array[i].start();
        }
          for (Partecipante partecipante : array) {
            try {
                partecipante.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
      
           System.out.println("Thread avviati per scrivere sui file. \n");
    }
}