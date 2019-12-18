package progetto.entity;

public class Prenotazione {
	
	private String idAppello;
	private String matricola;
	private String nome;
	private String cognome;
	private String esame;
	
	public Prenotazione(String idApp, String mat, String nome, String cognome, String esame) {
		this.idAppello = idApp;
		this.matricola = mat;
		this.nome = nome;
		this.cognome = cognome;
		this.esame = esame;
	}
	
	public String getIdAppello() {
		return this.idAppello;
	}
	
	public String getMatricola() {
		return this.matricola;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String getEsame() {
		return this.esame;
	}	
	
}
