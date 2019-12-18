package progetto.entity;

public class Studente {
	
	String nome;
	String cognome;
	String matricola;
	
	//costruttore senza parametri
	public Studente() {
		this.nome = "NULL";
		this.cognome = "NULL";
		this.matricola = "NULL";
	}
	
	//costruttore con parametri
	public Studente(String nome, String cognome, String matricola) {
		this.nome = new String (nome);
		this.cognome = new String (cognome);
		this.matricola = new String (matricola);
	}
	
	//metodi get
	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}
	
	public String getMatricola() {
		return this.matricola;
	}

	//metodi set
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	
}
