package model;

import java.io.Serializable;
import java.util.Comparator;

import exceptions.SamuraiNotFoundException;

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
	public String getNameClan() {
		return nameClan;
	}


	public void setNameClan(String nameClan) {
		this.nameClan = nameClan;
	}


	public Samurai getCharactersFirst() {
		return charactersFirst;
	}


	public void setCharactersFirst(Samurai charactersFirst) {
		this.charactersFirst = charactersFirst;
	}


	public Samurai getCharactersLast() {
		return charactersLast;
	}


	public void setCharactersLast(Samurai charactersLast) {
		this.charactersLast = charactersLast;
	}


	public void addCharacterFinal(Samurai e) {
		
		if(charactersFirst == null) {
			charactersFirst = e;
			
		}else {
		 Samurai tAct = charactersFirst;
		 while(tAct.getNext() != null) {
			 tAct = tAct.getNext();
		 }
		 
		 tAct.setNext(e);
		 e.setPrevius(tAct);
		}
	
      }
	
	public void delatedSamurai(String nameCharac) {
		Samurai tAct = charactersFirst;
		Samurai tAnt = null;
		while(tAct != null) {
			
			if(tAct.getNameCharacter().equalsIgnoreCase(nameCharac)) {
				if(tAnt == null) {
					charactersFirst = charactersFirst.getNext();
					tAct.setNext(null);
					tAct = charactersFirst;
				}else {
					tAnt.setNext(tAct.getNext());
					tAct.setNext(null);
					tAct = tAnt.getNext();
				}
			}else {
				tAnt = tAct;
				tAct = tAct.getNext();
			}
			
		}
	}

	public String callTheMethodNotRepeatTechniques(String nameSamu,Technique e) throws SamuraiNotFoundException {
		String msj = "";
		Samurai m = charactersFirst;
		boolean t = false;
		while(m != null && !t ) {
			if(m.getNameCharacter().equalsIgnoreCase(nameSamu)) {
				msj += m.lookForNotRepeatTechniques(e);
				t = true;
		}else {
			m = m.getNext();
		}
	}
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro el samurai");
		}
		return msj;
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
			c = c.getNext();
		}	
	}
		if(t == false) {
			msj = "No se encontro ningun personaje repetido,Se agrego B)";
			addCharacterFinal(e);
		}
		
		return msj;
	}
	
	public String mostrarInfo() {
		String msj = "";
		Samurai tAct = charactersFirst;
		
		while(tAct != null) {
			
			msj += tAct.toString() + "\n";
			tAct = tAct.getNext();	
		}
		
		return msj;
	}
	
	public int longitud() {
		int resul = 0;
		Samurai m = charactersFirst;
		
		while(m != null) {
			resul++;
			m = m.getNext();
		}
		
		return resul;
		
	}
	
	public Samurai indiceElement(int posicion) {
		Samurai samu = charactersFirst;
		
		if(posicion != 0) {
			for(int i = 0; i < posicion;i++) {
				
				samu = samu.getNext();
				
			}
		}else {
			
			samu = charactersFirst;
			
		}
		
		return samu;
	}
	
	public void addInicio(Samurai e) {
		Samurai first = charactersFirst;
		
		if(charactersFirst == null) {
			charactersFirst = e;
		}else {
			
			e.setNext(first);
			first.setPrevius(e);
			charactersFirst = e;
		}
		
		
	}
	
	
public void ordenarPorBurbujaMejorada() {
			
			boolean t;
			
			do {
			Samurai c = charactersFirst;
			Samurai c1 = null;
			Samurai sig = charactersFirst.getNext();
			 t = false;
			while(sig != null) {
				if(c.compareTo(sig) > 0) {
					t = true;
					if(c1 != null) {
						Samurai siguiente = sig.getNext();
						c1.setNext(sig);
						sig.setPrevius(c1);
						sig.setNext(c);
						c.setPrevius(sig);
						c.setNext(siguiente);
						}else {
						
						Samurai siguiente = sig.getNext();
						charactersFirst = sig;
						sig.setNext(c);
						c.setPrevius(sig);
						c.setNext(siguiente);
						siguiente.setPrevius(c);
					}
					c1 = sig;
					sig = c.getNext();
				}else {
					c1 = c;
					c = sig;
					sig = sig.getNext();
				}
			}
		}while(t);
	 }
	 
	public String toString() {
		String msj = "";
		
		msj = "El nombre del Clan es:"+ "||" + nameClan + "||";
		
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
