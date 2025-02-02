/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mattioli_giocosedia;

import java.util.logging.Logger;

/**
 *
 * @author Filippo Mattioli
 */
public class TestGiocoSedie {
    
    //Dichiara il numero di giocatori, in questo caso 15
    private final static int NUMSEDIE = 15;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scrittore scrittore1 = new Scrittore("Risultato.txt");
        
        Posto sedie[] = new Posto[NUMSEDIE];

	for (int k = 0; k < sedie.length; k++)
		sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();
        
        //il blocco di codice che segue gestisce la "partenza" dei threads
	Partecipante array[] = new Partecipante[NUMSEDIE+1];
	for (int i = 0; i < NUMSEDIE + 1; i++) {
		array[i] = new Partecipante(sedie, scrittore1);
                //System.out.println("Sto facendo partire il thread n." + array[i].getId());
                logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
                array[i].start();
                try {
            array[i].join();
            if (array[i].isAlive()) {
                scrittore1.scrivi("Thread " + array[i].getId() + " si è seduto.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      }
           System.out.println("Thread avviati per scrivere sui file. \n");
    }
}