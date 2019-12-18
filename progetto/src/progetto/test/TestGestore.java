package progetto.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import progetto.control.Gestore;
import progetto.entity.*;

public class TestGestore {

	Gestore gestore;
	
	@Before
	public void setUp() throws Exception {
		gestore = new Gestore();
	}

	@After
	public void tearDown() throws Exception {
		gestore = null;
	}

	@Test
	public void test01() {
		//1 APPELLO, NESSUNO STUD PRENOTATO AD ESSO. O/A: 0 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		Appello a1 = new Appello(corso, id, prove);
		
		gestore.creaAppello(a1);
		
		//non creo nessuno studente perche' tanto nessuno si prenoterebbe all'appello
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		
		assertEquals(0, ris.size() );
		
	}
	
	@Test
	public void test02() {
		//1 APPELLO, 1 STUD PRENOTATO AD ESSO. O/A: 1 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		
		Appello a1 = new Appello(corso, id, prove);
		
		gestore.creaAppello(a1);
		
		String nome = "Mario";
		String cognome = "Balotelli";
		String matricola = "N46002390";
				
		Studente s1 = new Studente(nome, cognome, matricola);
		
		gestore.prenotazione(s1, a1);
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		
		assertEquals(1, ris.size() );
		
	}
	
	
	
	@Test
	public void test03() {
		//1 APPELLO, PIU' STUD PRENOTATI AD ESSO (3). O/A: 3 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		
		Appello a1 = new Appello(corso, id, prove);
		
		gestore.creaAppello(a1);
		
		String nome = "Mario";
		String cognome = "Balotelli";
		String matricola = "N46002390";
		Studente s1 = new Studente(nome, cognome, matricola);
		
		nome = "Michael";
		cognome = "Buble' ";
		matricola = "N39004455";
		Studente s2 = new Studente(nome, cognome, matricola);
		
		nome = "Charles";
		cognome = "Dickens ";
		matricola = "N43006105";
		Studente s3 = new Studente(nome, cognome, matricola);
		
		
		gestore.prenotazione(s1, a1);
		gestore.prenotazione(s2, a1);
		gestore.prenotazione(s3, a1);
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		
		assertEquals(3, ris.size() );
		
	}
	
	
	
	@Test
	public void test04() {
		//0 APPELLI, 0 STUDENTI PRENOTATI.  O/A: 0 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		
		Appello a1 = new Appello(corso, id, prove);
		
		//non creo l'appello con gestore.creaAppello(a1);
				
		a1 = null;		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		
		//dovrebbe essere 0
		assertEquals(0, ris.size() );
		
	}
	
	
	
	
	@Test
	public void test05() {
		//0 APPELLI, 1 STUD SI PRENOTA A UN APPELLO INESISTENTE. O/A: 0 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		
		Appello a1 = new Appello(corso, id, prove);
		
		//non uso gestore.creaAppello(a1) perchè non voglio crearlo!
		
		String nome = "Mario";
		String cognome = "Balotelli";
		String matricola = "N46002390";
				
		Studente s1 = new Studente(nome, cognome, matricola);
		
		gestore.prenotazione(s1, a1);
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		
		//mi aspetto 0 perchè la prenotazione dovrebbe essere rifiutata (l'appello non esiste)
		assertEquals(0, ris.size() );
		
	}
	
	
	
	@Test
	public void test06() {
		//2 APPELLI PER 1 STESSO CORSO: 1 STUD PRENOTATO AL PRIMO, 0 AL SECONDO. O/A: 1 RIS, 0 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		Appello a1 = new Appello(corso, id, prove);
		
		id = "ISapp002";
		Appello a2 = new Appello(corso, id, prove);
		
		gestore.creaAppello(a1);
		gestore.creaAppello(a2);
		
		String nome = "Mario";
		String cognome = "Balotelli";
		String matricola = "N46002390";
		Studente s1 = new Studente(nome, cognome, matricola);
		
		gestore.prenotazione(s1, a1);
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		//mi aspetto 1 prenotato all'appello a1
		assertEquals(1, ris.size() );
		
		ris = gestore.visualizzaPrenotati(a2);
		//e 0 prenotati all'appello a2
		assertEquals(0, ris.size());
		
	}
	
	
	
	@Test
	public void test07() {
		//2 APPELLI PER 2 CORSI DIVERSI: 1 STUD PRENOTATO AL PRIMO, 1 AL SECONDO. O/A: 1 RIS, 1 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		nome_corso = "ELETTRONICA GENERALE I";
		nome_docente = "Luca Maresca";
		num_cfu = 6;
		Corso c2 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c2);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		Appello a1 = new Appello(corso, id, prove);
		
		corso = c2.getNome();
		id = "EGapp001";
		Appello a2 = new Appello(corso, id, prove);
		
		gestore.creaAppello(a1);
		gestore.creaAppello(a2);
		
		String nome = "Mario";
		String cognome = "Balotelli";
		String matricola = "N46002390";
		Studente s1 = new Studente(nome, cognome, matricola);
		
		nome = "Michael";
		cognome = "Buble' ";
		matricola = "N39004455";
		Studente s2 = new Studente(nome, cognome, matricola);
		
		
		gestore.prenotazione(s1, a1);
		gestore.prenotazione(s2, a2);
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		//mi aspetto 1 prenotato all'appello a1
		assertEquals(1, ris.size() );
		
		ris = gestore.visualizzaPrenotati(a2);
		//e 1 prenotati all'appello a2
		assertEquals(1, ris.size());
	
	}
	
	
	
	@Test
	public void test08() {
		//2 APPELLI PER 1 STESSO CORSO, 1 STUD PRENOTATO AD ENTRAMBI. O/A: 1 RIS, 1 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		Appello a1 = new Appello(corso, id, prove);
		
		id = "ISapp002";
		Appello a2 = new Appello(corso, id, prove);
		
		gestore.creaAppello(a1);
		gestore.creaAppello(a2);
		
		String nome = "Mario";
		String cognome = "Balotelli";
		String matricola = "N46002390";
		Studente s1 = new Studente(nome, cognome, matricola);
		
		
		gestore.prenotazione(s1, a1);
		gestore.prenotazione(s1, a2);
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		//mi aspetto 1 prenotato all'appello a1
		assertEquals(1, ris.size() );
		
		ris = gestore.visualizzaPrenotati(a2);
		//e 1 prenotato all'appello a2
		assertEquals(1, ris.size());
		
	}
	
	
	
	@Test
	public void test09() {
		//3 APPELLI, DI CORSI DIVERSI, NESSUN PRENOTATO AD ESSI. O/A: 0 RIS, 0 RIS, 0 RIS
		String nome_corso = "INGEGNERIA DEL SOFTWARE";
		String nome_docente = "Roberto Natella";
		int num_cfu = 9;
		Corso c1 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c1);
		
		nome_corso = "ELETTRONICA GENERALE I";
		nome_docente = "Luca Maresca";
		num_cfu = 6;
		Corso c2 = new Corso(nome_corso, nome_docente, num_cfu);
		gestore.aggiungiCorso(c2);
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = c1.getNome();
		String id = "ISapp001";
		Appello a1 = new Appello(corso, id, prove);
		
		corso = c1.getNome();
		id = "ISapp002";
		Appello a2 = new Appello(corso, id, prove);
		
		corso = c2.getNome();
		id = "EGapp001";
		Appello a3 = new Appello(corso, id, prove);
		

		gestore.creaAppello(a1);
		gestore.creaAppello(a2);
		gestore.creaAppello(a3);
		
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		//mi aspetto 0 prenotati all'appello a1
		assertEquals(0, ris.size() );
		
		ris = gestore.visualizzaPrenotati(a2);
		//e 0 prenotati all'appello a2
		assertEquals(0, ris.size());
		
		ris = gestore.visualizzaPrenotati(a3);
		//e 0 prenotati all'appello a2
		assertEquals(0, ris.size());
	
	}
	
	
	@Test
	public void test10() {
		//1 STUDENTE SI PRENOTA A UN APPELLO DI UN CORSO INESISTENTE. O/A: 0 RIS 
		
		ArrayList<Prova> prove = new ArrayList<Prova>();
		
		String corso = null;
		String id = null;
		Appello a1 = new Appello(corso, id, prove);
	
		gestore.creaAppello(a1);
		
		String nome = "Mario";
		String cognome = "Balotelli";
		String matricola = "N46002390";
		Studente s1 = new Studente(nome, cognome, matricola);
		
		gestore.prenotazione(s1, a1);
		
		ArrayList<Prenotazione> ris = gestore.visualizzaPrenotati(a1);
		//mi aspetto 0 prenotati all'appello a1 (appello non creato se il corso non esiste!)
		assertEquals(0, ris.size() );
		
	}
	

	
	
	
}
