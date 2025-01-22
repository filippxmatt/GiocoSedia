package mattioli_giocosedia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filippo Mattioli
 */

public class Scrittore{

    String nomeFile;
    
    public Scrittore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     * @param Id
     * @param Posto
     */
    public synchronized void scrivi(String contenuto){
        BufferedWriter br=null;
        try {
            br = new BufferedWriter(new FileWriter(nomeFile, true));
            br.write(contenuto);
            br.write("\n\r");
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}