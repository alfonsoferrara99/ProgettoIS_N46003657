package progetto.control;

import java.util.ArrayList;

import progetto.entity.Appello;
import progetto.entity.Corso;
import progetto.entity.Prenotazione;
import progetto.entity.Studente;

public class Gestore {
	
	private ArrayList<Corso> corsi = new ArrayList<Corso>();
	private ArrayList<Appello> appelli = new ArrayList<Appello>();
	private ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	
	public Gestore() {
	
	}
	
	// 1 RICHIESTA: CREAZIONE DI UN CORSO
	public void aggiungiCorso(Corso c) {
		corsi.add(c);
	}
	
	public void stampaCorsi() {
		for(Corso c : corsi) {
			System.out.println(c.getNome()+", Docente : "+c.getDocente()+", "+c.getCfu()+" cfu.\n");
		}	
	}
	
	// 2 RICHIESTA: CREAZIONE DI UN APPELLO RELATIVO A UN CORSO
	public void creaAppello(Appello nuovoAppello) {
		appelli.add(nuovoAppello);
	}
	
	public void stampaAppelli() {
		for(Appello a : appelli) {
			System.out.println(a.getId()+" "+a.getCorso()+"\n");
		}
	}
	
	public void stampaProve(Appello app) {
		for(Appello a : appelli) {
			System.out.println(a.getProve());
		}
	}
	
	// 3 RICHIESTA: PRENOTAZIONE STUDENTE A UN APPELLO
	public void prenotazione(Studente s, Appello app) {
		boolean trovato = false;
		String esame = null;
			
		for(Appello a : appelli) {
			if(a.getId().equals(app.getId()) ) {   //uso equals per comparare le due stringhe!
				trovato = true;
				esame = a.getCorso();
			}
		}
		
		if(trovato == true) {
			Prenotazione p = new Prenotazione(app.getId(), s.getMatricola(), s.getNome(), s.getCognome(), esame);	
			prenotazioni.add(p);
		}
		
	}
	
	// 4 RICHIESTA: VISUALIZZA PRENOTATI A UN APPELLO
	public ArrayList<Prenotazione> visualizzaPrenotati(Appello app) {
		
		ArrayList<Prenotazione> prenotazioniAppello = new ArrayList<Prenotazione>();

		System.out.println("Studenti prenotati all'appello '"+app.getId()+"' del corso "+app.getCorso()+":");
		
		for(Appello a : appelli) {
			if(app.getId().equals(a.getId()) ) {
				for(Prenotazione p : prenotazioni) {
					if ( a.getId().equals( p.getIdAppello() ) ) {
						System.out.println(p.getMatricola()+" "+p.getNome()+" "+p.getCognome());
						prenotazioniAppello.add(p);
					}
				}
			}
		}
		
		System.out.println("(numero prenotati all'appello : "+ prenotazioniAppello.size()+" )\n");
		return prenotazioniAppello;
	}
		
	
	
	
}
