package model;

import java.io.Serializable;
import java.util.Comparator;

import exceptions.SamuraiNotFoundException;
import exceptions.notClanException;
import exceptions.notFoundTechnique;

public class Clan implements Serializable, Comparator<Clan>,Comparable<Clan> {

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
	
	public void callMethodInsercion(String nameSamurai) {
		Samurai m = charactersFirst;
		boolean t = false;
		
		while(m != null && !t) {
			if(m.getNameCharacter().equalsIgnoreCase(nameSamurai)) {
				m.ordenarPorInsercion();
				t = true;
			}else {
			m = m.getNext();
			}
		}
		
	}
	
	public void modificarInfluencerTechnique(String nameCharacter,String nameTechnique,int influencer) throws notFoundTechnique, SamuraiNotFoundException {
		Samurai m = charactersFirst;
		boolean t = false;
		
		while(m != null && !t) {
			if(m.getNameCharacter().equalsIgnoreCase(nameCharacter)) {
				
				m.modificarInfluencer(nameTechnique,influencer);
				t = true;
			}else {
				m = m.getNext();
			}
		}
		
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro un ninja");
		}
		
		
	}
	
	public void modificarNameTechnique(String nameCharacter,String nameTechnique,String nameNewTechnique) throws notClanException, SamuraiNotFoundException, notFoundTechnique {
		Samurai m = charactersFirst;
		boolean t = false;
		
		while(m != null && !t) {
			if(m.getNameCharacter().equalsIgnoreCase(nameCharacter)) {
				
				m.modificarInfoName(nameTechnique,nameNewTechnique);
				t = true;
			}else {
				m = m.getNext();
			}
		}
		
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro un ninja");
		}
		
	}
	
	public void modificarPowerSamurai(String nameCharacter,int powerNew) throws SamuraiNotFoundException {
		Samurai m = charactersFirst;
		boolean t = false;
		
		while(m != null && !t) {
			if(m.getNameCharacter().equalsIgnoreCase(nameCharacter)) {
				
				m.setPower(powerNew);
				t = true;
			}else {
				m = m.getNext();
			}
		}
		
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro un ninja");
		}
		
	}
	
	
	public void modificarDateSamurai(String nameCharacter,String creationDate) throws SamuraiNotFoundException {
		Samurai m = charactersFirst;
		boolean t = false;
		
		while(m != null && !t) {
			if(m.getNameCharacter().equalsIgnoreCase(nameCharacter)) {
				
				m.setCreationDate(creationDate);
				t = true;
			}else {
				m = m.getNext();
			}
		}
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro");
		}
	}	
	
	public void modificarNameInfluencer(String nameCharacter,String nameNewInfluencer) throws SamuraiNotFoundException {
		Samurai m = charactersFirst;
		boolean t = false;
		
		while(m != null && !t) {
			if(m.getNameCharacter().equalsIgnoreCase(nameCharacter)) {
				
				m.setPersonality(nameNewInfluencer);
				t = true;
			}else {
				m = m.getNext();
			}
		}
		
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro");
		}
		
	}
	

	public void modificarNameCharacter(String nameCharacter,String nameNew) throws SamuraiNotFoundException {
		Samurai m = charactersFirst;
		boolean t = false;
		
		while(m != null && !t) {
			if(m.getNameCharacter().equalsIgnoreCase(nameCharacter)) {
				
				m.setNameCharacter(nameNew);
				t = true;
			}else {
				m = m.getNext();
			}
		}
		
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro");
		}
		
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
	
	public String callMethodShowInfo(String namePerso) throws SamuraiNotFoundException {
		String msj = "";
		Samurai m = charactersFirst;
		boolean t = false;
		while(m != null && !t ) {
			if(m.getNameCharacter().equalsIgnoreCase(namePerso)) {
				msj += m.mostrarInfo();
				t = true;
			}else {
				m = m.getNext();
			}
		}
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro");
		}
		
		return msj;
	}
	
	public void callMethodDelatedSamurai(String samuName,String nameTechnique) throws SamuraiNotFoundException{
		Samurai m = charactersFirst;
		boolean t = false;
		
		while(m != null && !t) {
			if(m.getNameCharacter().equalsIgnoreCase(samuName)){
				
				m.delatedTechniqueNameTechnique(nameTechnique);
				t = true;
			}else {
				m = m.getNext();
			}
		}
		if(t == false) {
			throw new SamuraiNotFoundException("No se encontro el samurai");
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
			msj = "No se encontro ningun personaje repetido,Se agrego B)";
			addCharacterFinal(e);
		}
		
		return msj;
	}
	
	public String mostrarInfo() {
		String msj = "";
		Samurai tAct = charactersFirst;
		
		if(tAct == null) {
		
			msj = "No tiene personajes";
			
		}else {
			while(tAct != null) {
			
			msj += tAct.toString() + "\n";
			tAct = tAct.getNext();	
		}
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
	 
public void ordenarPorBurbujaMejorada1() {
	
	boolean t;
	
	do {
	Samurai c = charactersFirst;
	Samurai c1 = null;
	Samurai sig = charactersFirst.getNext();
	 t = false;
	while(sig != null) {
		if(c.compare(c,sig) > 0) {
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
	public int compareTo(Clan o) {
		// TODO Auto-generated method stub
		return nameClan.compareToIgnoreCase(o.getNameClan());
	}
	@Override
	public int compare(Clan o1, Clan o2) {
		// TODO Auto-generated method stub
		return o1.getNameClan().compareToIgnoreCase(o2.getNameClan());
	}
	
}
