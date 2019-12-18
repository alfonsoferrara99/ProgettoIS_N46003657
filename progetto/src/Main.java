import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import progetto.control.Gestore;
import progetto.entity.Appello;
import progetto.entity.Corso;
import progetto.entity.Prova;
import progetto.entity.Studente;
import progetto.entity.TipoProva;


public class Main {

	public static void main(String[] args) {
		
		Gestore gestore = new Gestore();
		
		// INSERIMENTO DI CORSI
		System.out.println("****INSERIMENTO DI CORSI****\n");
		
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		
		
		nome_corso = "ELETTRONICA GENERALE I";
		nome_docente = "Luca Maresca";
		num_cfu = 6;
		
		Corso c2 = new Corso(nome_corso, nome_docente, num_cfu);
		
		//aggiungo i corsi alla lista tramite il metodo aggiungiCorso (definito nella classe control)
		gestore.aggiungiCorso(c1);
		gestore.aggiungiCorso(c2);
		
		//stampo la lista di corsi per verificare di averli correttamente aggiunti
		gestore.stampaCorsi();
		
		//CREAZIONE DI UN APPELLO RELATIVO A UN CORSO
		System.out.println("\n****CREAZIONE DI UN APPELLO RELATIVO A UN CORSO****\n");
		
		//creo una lista di prove
		ArrayList<Prova> prove1 = new ArrayList<Prova>();
				
		//creo delle prove
		LocalDate data_prova = LocalDate.of(2018, Month.SEPTEMBER, 19);
		String aula = "SG-I2";
				
		Prova p1 = new Prova(data_prova, TipoProva.CALCOLATORE, aula);
		
		data_prova = LocalDate.of(2018, Month.SEPTEMBER, 22);
		aula = "SG-T1";
				
		Prova p2 = new Prova(data_prova, TipoProva.ORALE, aula);
		
		//aggiungo le prove alla lista
		prove1.add(p1);
		prove1.add(p2);
		
		//creo un appello (mi serve corso e id, la lista di prove ce l'ho già)
		String corso = c1.getNome();
		String id = "ISapp001";
		
		Appello a1 = new Appello(corso, id, prove1);
		
		gestore.creaAppello(a1); //creo effettivamente l'appello (lo aggiungo alla lista di appelli tramite l'apposita funzione di Gestore)
		gestore.stampaAppelli(); //verifico di aver inserito correttamente l'appello
		gestore.stampaProve(a1); //verifico di trovare nell'appello le prove inserite prima
		
		//PRENOTAZIONE DI UNO STUDENTE A UN APPELLO
		
		//creo degli studenti
		String nome = "Mario";
		String cognome = "Balotelli";
		String matricola = "N46002390";
				
		Studente s1 = new Studente(nome, cognome, matricola);
		
		nome = "Michael";
		cognome = "Buble' ";
		matricola = "N46004455";
				
		Studente s2 = new Studente(nome, cognome, matricola);
		
		nome = "Charles";
		cognome = "Dickens";
		matricola = "N43006105";
				
		Studente s3 = new Studente(nome, cognome, matricola);
		
		
		//li faccio prenotare all'appello desiderato
		gestore.prenotazione(s1, a1);
		gestore.prenotazione(s2, a1);
		gestore.prenotazione(s3, a1);
		
		//CONSULTAZIONE STUDENTI PRENOTATI A UN APPELLO
		System.out.println("\n****CONSULTAZIONE STUDENTI PRENOTATI A UN APPELLO****\n");
		
		gestore.visualizzaPrenotati(a1);
		
			
		
		
		
		
		
		
	}

}