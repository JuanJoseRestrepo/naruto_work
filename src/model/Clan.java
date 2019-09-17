package model;

import java.io.Serializable;
import java.util.Comparator;

public class Clan implements Serializable, Comparator<Samurai>,Comparable<Samurai> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameClan;
	private Samurai charactersFirst;
	private Samurai charactersLast;
	public Clan(String nameClan) {
	this.nameClan = nameClan;	
	}
	public void addCharacter(Samurai e) {
		Samurai c = charactersFirst;
		Samurai c1 = null;
		
		if(c == null) {
			charactersFirst = e;
			e.setPrevius(null);
			e.setNext(e);
		}else {
			
			if(e.getNameCharacter().compareToIgnoreCase(c.getNameCharacter()) < 0) {
				
				e.setNext(c);
				c.setPrevius(e);
				c = e;
			}else {
				while(c != null && c.getNameCharacter().compareToIgnoreCase(e.getNameCharacter()) < 0) {
					c1 = c;
					c = charactersFirst.getNext();
			}
				e.setNext(c);
				c.setPrevius(e);
				
				c1.setNext(e);
				e.setPrevius(c1);
		}	
	}
	
}
	
	public void delatedSamurai(String nameCharac) {
		Samurai c = charactersFirst;
		Samurai c1 = null;
		
		if(c.getNameCharacter().equalsIgnoreCase(nameCharac)) {
			charactersFirst = charactersFirst.getNext();
			charactersFirst.setPrevius(null);
		}else {
			while(!(c.getNameCharacter().equalsIgnoreCase(nameCharac)) && c != null) {
				
				c1 = c;
				c = c.getNext();
			}
			c1.setNext(c.getNext());
			c.getNext().setPrevius(c1); 
		}
		
		
	}

	//Metodos finales
	public String lookForNotRepeatCharacters(Samurai e) {
		Samurai c = charactersFirst;
		String msj = "";
		boolean t = false;
		
		while(c != null && !t) {
			
		if(c.getNameCharacter().compareToIgnoreCase(e.getNameCharacter()) == 0) {
			 msj = "Se encontro un personaje repetido";
			 t = true;
		}else {
			c = charactersFirst.getNext();
		}	
	}
		if(t == false) {
			msj = "No se encontro ningun personaje repetido";
			addCharacter(e);
		}
		
		return msj;
	}
	
	
	@Override
	public int compareTo(Samurai o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(Samurai o1, Samurai o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
