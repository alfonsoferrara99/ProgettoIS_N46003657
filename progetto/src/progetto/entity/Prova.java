package progetto.entity;

import java.time.LocalDate;

public class Prova {

	LocalDate dataProva;
	TipoProva tipoProva;
	String aula;
	
	//costruttore
	public Prova(LocalDate dataProva, TipoProva tipoProva, String aula) {
		this.dataProva = dataProva;
		this.tipoProva = tipoProva;
		this.aula = aula;
	}
	
	//metodi get
	public LocalDate getDataProva() {
		return this.dataProva;
	}
	
	public TipoProva getTipoProva() {
		return this.tipoProva;
	}
	
	public String getAula() {
		return this.aula;
	}
	
	//metodi set
	public void setDataProva(LocalDate data) {
		this.dataProva = data;		
	}
	
	public void setTipoProva(TipoProva tipo) {
		this.tipoProva = tipo;
	}
	
	public void setAula(String aula) {
		this.aula = aula;
	}
	
	
}
