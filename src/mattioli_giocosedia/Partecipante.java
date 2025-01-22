package mattioli_giocosedia;

class Partecipante extends Thread{
	private final Posto[] sedie;
        private final Scrittore scrittore;

	public Partecipante(Posto sedie[], Scrittore scrittore) {
		this.sedie = sedie;
                this.scrittore = scrittore;
	}

	public void run() {
		try {
			sleep((int) (Math.random() * 1000));
			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
                                        String output = "Sono il Thread "+this.getName()+". Sono riuscito a sedermi sul posto "+i;
                                           scrittore.scrivi(output);
					return;
				}
			}
                        String output ="Sono il Thread "+this.getName()+". Ho perso";
                           scrittore.scrivi(output);

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
