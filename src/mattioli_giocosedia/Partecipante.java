package mattioli_giocosedia;

class Partecipante extends Thread{
	private final Posto[] sedie;
        //dichiara lo scrittore in questa classe, in modo da poterlo usare per scrivere nel file
        private final Scrittore scrittore;

	public Partecipante(Posto sedie[], Scrittore scrittore) {
		this.sedie = sedie;
                this.scrittore = scrittore;
	}

	public void run() {
		try {
                        //genera le occupazioni delle sedie 
			sleep((int) (Math.random() * 1000));
			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
                                        //scrive quali thread sono riusciti a sedersi sulle sedie
                                        String output = "Sono il Thread "+this.getName()+". Sono riuscito a sedermi sul posto "+i;
                                           scrittore.scrivi(output);
					return;
				}
			}
                        //scrive quale thread non è riuscito a sedersi
                        String output ="Sono il Thread "+this.getName()+". Ho perso";
                           scrittore.scrivi(output);

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
