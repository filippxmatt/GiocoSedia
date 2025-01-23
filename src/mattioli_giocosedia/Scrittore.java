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
     * @param contenuto
     */
    
    //il synchronized permette di passare il contenuto dato in output da partecipante a questo metodo
    public synchronized void scrivi(String contenuto){
        BufferedWriter br=null;
        try {
            //istanza esplicita br - classe di wrapping
            //BufferedWriter: riga per riga
            //FileWriter: carattere per carattere
            br = new BufferedWriter(new FileWriter(nomeFile, true));
            
            //viene scritto nel file l'output di partecipante
            //salva file sulla RAM
            br.write(contenuto);
            br.write("\n\r");
            //salva file dalla RAM alla memoria
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            //se il file è stato creato ed esiste nella RAM (solo nel caso di errori nel flush())
            //errore di tipo NullPointerException
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