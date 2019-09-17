package model;

import java.io.Serializable;
import java.util.Comparator;

public class Clan implements Serializable, Comparator<Character>,Comparable<Character> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameClan;
	private Character charactersFirst;
	private Character charactersLast;
	public Clan(String nameClan) {
	this.nameClan = nameClan;	
	}
	public void addCharacter(Character e) {
		Character c = charactersFirst;
		Character c1 = null;
		
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

	//Metodos finales
	public String lookForNotRepeatCharacters(Character e) {
		Character c = charactersFirst;
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
	public int compareTo(Character o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(Character o1, Character o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
