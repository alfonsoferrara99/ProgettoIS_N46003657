package progetto.entity;

public class Corso {
	
	String nome;
	String docente;
	int cfu;
	
	//costruttore senza parametri
	public Corso() {
		this.nome = "NULL";
		this.docente = "NULL";
		this.cfu = 0;
	}
	
	//costruttore con parametri
	public Corso(String nome, String docente, int cfu) {
		this.nome = nome;
		this.docente = docente;
		this.cfu = cfu;
	}
	
	//metodi get
	public String getNome() {
		return this.nome;
	}

	public String getDocente() {
		return this.docente;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	//metodi set
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDocente(String docente) {
		this.docente = docente;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	

}
