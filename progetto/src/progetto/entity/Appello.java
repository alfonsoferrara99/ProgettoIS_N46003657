package progetto.entity;

import java.time.LocalDate;
import java.util.ArrayList;


public class Appello {
	
	private String corso;
	private String id;
	private ArrayList<Prova> prove = new ArrayList<Prova>();
	
	//costruttore
	public Appello(String corso, String id, ArrayList<Prova> prove) {
		this.corso = corso;
		this.id = id;
		this.prove = prove;
	}
	
	//metodi get
	public String getCorso() {
		return this.corso;
	}

	public String getId() {
		return this.id;
	}
	
	public String getProve() {  //dato un appello, mi visualizza tutte le prove con relative info (tipo, aula, data)
		
		StringBuffer buf = new StringBuffer();
		
		buf.append("APPELLO : "+id+" di "+corso+"\n");
		
		for(Prova p : prove) {
			buf.append("  PROVA: "+p.getTipoProva()+", aula "+p.getAula()+", "+p.getDataProva()+"\n");
		}
		
		return buf.toString();
	}
	
	//metodi set
	public void setCorso(String corso) {
		this.corso = corso;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setProve(ArrayList<Prova> prove, LocalDate data, TipoProva tipo, String aula) {
		for(Prova p : prove) {
			p.setDataProva(data);
			p.setTipoProva(tipo);
			p.setAula(aula);
		}
	}


	
}
