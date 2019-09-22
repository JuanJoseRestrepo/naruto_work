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
			msj = "No se encontro ningun personaje repetido";
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
	
	public void modificarPosicion(int x, Samurai p) {
		
		if(x == 0) {
			Samurai first = charactersFirst;
			Samurai ant = null;
			Samurai siguiente = null;
			siguiente = first.getNext();
			charactersFirst = p;
			p.setNext(siguiente);
			p.setPrevius(ant);
		}else if(x != longitud()-1) {
			Samurai first2 = charactersFirst;
			Samurai ant2 = null;
			Samurai siguiente2 = null;
			
			first2 = indiceElement(x);
			ant2 = first2.getPrevius();
			siguiente2 = first2.getNext();
			
			ant2.setNext(p);
			p.setPrevius(p);
			p.setNext(siguiente2);
			siguiente2.setPrevius(p);
		}else if(x == longitud() -1) {
			Samurai first3= charactersFirst;
			Samurai ant3 = null;
			Samurai siguiente3 = null;
			
			first3 = indiceElement(x);
			ant3 = first3.getPrevius();
			ant3.setNext(p);
			p.setPrevius(ant3);
			p.setNext(siguiente3);
		}
		
	}
	
	
	 public void ordenarSeleccion() {
		 Samurai temp = null;
		 Samurai mayor = null;
		 Samurai temp1 = charactersFirst;
		 int pos = 0;
		 int pos1 = 0;
		 while(temp1 != null) {
			 Samurai menor = indiceElement(pos);
			for(int j = pos+1; j < longitud();j++) {
				mayor = indiceElement(j);
				if(mayor.compareTo(menor) < 0) {
				 menor = mayor;	
				 pos1 = j;
			 }
		 }
		Samurai temp11 = indiceElement(pos);
		modificarPosicion(pos1, menor);
		modificarPosicion(pos, temp11);
		temp1 = temp1.getNext();
		pos++;
	 }
}
	 
	 public void ordenarPorSeleccion1() {
			
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
