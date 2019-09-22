package model;

import java.io.Serializable;
import java.util.Comparator;

public class Samurai implements Serializable, Comparator<Samurai>,Comparable<Samurai>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameCharacter;
	private String personality;
	private String creationDate;
	private int power;
	private Samurai previus;
	private Samurai next;
	private Technique tech;
	public Samurai(String nameCharacter,String personality,String creationDate,int power) {
		
		this.nameCharacter = nameCharacter;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		
	}
	
	public String getNameCharacter() {
		return nameCharacter;
	}

	public void setNameCharacter(String nameCharacter) {
		this.nameCharacter = nameCharacter;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public Samurai getPrevius() {
		return previus;
	}

	public Technique getTech() {
		return tech;
	}

	public void setTech(Technique tech) {
		this.tech = tech;
	}

	public void setPrevius(Samurai previus) {
		this.previus = previus;
	}

	public Samurai getNext() {
		return next;
	}

	public void setNext(Samurai next) {
		this.next = next;
	}
	
	public void addInicio(Technique e) {
		Technique first = tech;
		
		if(tech == null) {
			tech = e;
		}else {
			
			e.setNext(first);
			tech = e;
		}
		
		
	}
	
	
	public void addTechniqueNameTechnique(Technique e) {
		Technique tAct = tech;
		Technique tempAnt = null;
		if(tech == null) {
			
			tech = e;
			
		}else{
				if(e.getName().compareToIgnoreCase(tAct.getName()) < 0) {
					e.setNext(tAct);
					tech = e;
			    }else {
			    	while(tAct != null && tAct.getName().compareToIgnoreCase(e.getName()) < 0){
			    		tempAnt = tAct;
			    		tAct = tAct.getNext();
			    	}
				    e.setNext(tAct);
				    tempAnt.setNext(e);
			}
		}
			
		}
	
	public void addTechniqueInfuencer(Technique e) {
		Technique tAct = tech;
		Technique tempAnt = null;
		
		if(tech == null) {
			tech = e;
		}else {
			if(e.compare(e, tAct) <= 0) {
				e.setNext(tAct);
				tech = e;
			}else {
				while(tAct != null && tAct.compare(tAct,e) <= 0) {
					tempAnt = tAct;
					tAct = tAct.getNext(); 
				}
				
				e.setNext(tAct);
				tempAnt.setNext(e);
			}
			
		}
		
	}
	
	public void delatedTechniqueNameTechnique(String nameTecnique) {
		Technique tAct = tech;
		Technique tempAnt = null;
		

			if(tAct.getName().equalsIgnoreCase(nameTecnique)) {
				tech = tech.getNext();
			}else {
				while(!(tAct.getName().equalsIgnoreCase(nameTecnique)) && tAct != null) {
					
					tempAnt = tAct;
					tAct = tAct.getNext();
			}
				tempAnt.setNext(tAct.getNext());	
		}
	}
	
	public void modificarInfluencer(String nameTecnique,int numberTechnique) {
		
		Technique tAct = tech;
		boolean t = false;
		while(tAct != null && !t) {
			if(tAct.getName().equalsIgnoreCase(nameTecnique)) {
				tAct.setInfluencer(numberTechnique);
				t = true;
			}else {
				tAct = tAct.getNext();
			}	
		}
	}
	
	public void modificarInfoName(String nameTechnique,String otherName) {
		Technique tAct = tech;
		boolean t = false;
		
		while(tAct != null && !t) {
			if(tAct.getName().equalsIgnoreCase(nameTechnique)) {
				tAct.setName(otherName);
				t = true;
			}else {
				tAct = tech.getNext();
			}
		}
		
	}
	
	//Metodos finales
	public String lookForNotRepeatTechniques(Technique e) {
		Technique c = tech;
		String msj = "";
		boolean t = false;
		
		while(c != null && !t) {
			
		if(c.getName().compareToIgnoreCase(e.getName()) == 0) {
			 msj = "Se encontro un personaje repetido";
			 t = true;
		}else {
			c = c.getNext();
		}	
	}
		if(t == false) {
			msj = "No se encontro ninguna tecnica repetida,se agrego B)";
			addTechniqueInfuencer(e);
		}
		
		return msj;
	}

	@Override
	public int compareTo(Samurai o1) {
		// TODO Auto-generated method stub
		return nameCharacter.compareToIgnoreCase(o1.getNameCharacter()) ;
	}
	
	public int compareToPersonality(Samurai o1) {
		
		return personality.compareToIgnoreCase(o1.getPersonality());
		
	}

	@Override
	public int compare(Samurai o1, Samurai o2) {
		int resul = 0;
		
		if(o1.getPower() > o2.getPower()) {
			resul = 1;
		}else if(o1.getPower() < o2.getPower()) {
			resul = -1;
		}
		
		return resul;
	}
	
	
	public String toString() {
		String msj = "";
		
		msj += "El nombre del personaje es:" + "||" + nameCharacter + "||"; 
		msj += "//" + "La personalidad del personajes es:"+ "||" + personality+ "||"; 	 	
		msj += "//" + "La fecha de creacion es:" + "||" + creationDate + "||";
		msj += "//" + "El poder es:" + "||" + power + "||";
		
		return msj;
	}
	
public void modificarPosicion(int x, Technique p) {
		
		if(x == 0) {
			Technique first = tech;
			Technique ant = null;
			Technique siguiente = null;
			siguiente = first.getNext();
			tech = p;
			p.setNext(siguiente);
		}else if(x != longitud()-1) {
			Technique first2 = tech;
			Technique ant2 = null;
			Technique siguiente2 = null;
			
			first2 = indiceElement(x);
			ant2 = indiceElement(x-1);
			siguiente2 = first2.getNext();
			
			ant2.setNext(p);
			p.setNext(siguiente2);
		}else if(x == longitud() -1) {
			Technique first3= tech;
			Technique ant3 = null;
			Technique siguiente3 = null;
			
			first3 = indiceElement(x);
			ant3 = indiceElement(x-1);
			ant3.setNext(p);
			p.setNext(siguiente3);
		}
		
	}
////////////////////////////////////////////////////////////////////////////////////	
	public void ordenarPorSeleccion() {
		
		 Technique temp = null;
		 Technique mayor = null;
		 Technique temp1 = tech;
		 int pos1 = 0;
		 for(int i = 0; i < longitud();i++) {
			 Technique menor = indiceElement(i);
			for(int j = i+1; j < longitud();j++) {
				mayor = indiceElement(j);
				if(mayor.compareTo(menor) < 0) {
				 menor = mayor;	
				 pos1 = j;
			 }
		 }
			Technique a1 = new Technique(menor.getName(),menor.getInfluencer());
			Technique a2 = new Technique(indiceElement(i).getName(),indiceElement(i).getInfluencer());
			
			if(indiceElement(i) == tech) {
				delatedTechniqueNameTechnique(a2.getName());
				addInicio(a1);
				modificarPosicion(pos1, a2);
			}else {
				insert(menor.getName(), a2);
				delatedTechniqueNameTechnique(menor.getName());
				modificarPosicion(i, menor);
			}
	 }
}
//////////////////////////////////////////////////////////////////////////////
	
	public void insert(String nombreTec,Technique e) {
		Technique first = tech;
		Technique ant = null;
		boolean t = false;
		while(first != null && !t) {
			if(first.getName().compareTo(nombreTec) == 0) {
				ant = first;
				t = true;
			}else {
				first = first.getNext();
			}
		}
		Technique nextNext = ant.getNext();
		ant.setNext(e);
		e.setNext(nextNext);
	}
	
	
	public void addFinal(Technique e) {
		if(tech == null) {
			tech = e;
			
		}else {
		 Technique tAct = tech;
		 while(tAct.getNext() != null) {
			 tAct = tAct.getNext();
		 }
		 tAct.setNext(e);
		}
	}
	
	public int longitud() {
		int resul = 0;
		Technique m = tech;
		
		while(m != null) {
			resul++;
			m = m.getNext();
		}
		
		return resul;
		
	}
	
	public Technique indiceElement(int posicion) {
		Technique samu = tech;
		
		if(posicion != 0) {
			for(int i = 0; i < posicion;i++) {
				
				samu = samu.getNext();
				
			}
		}else {
			
			samu = tech;
			
		}
		
		return samu;
	}
	
public void ordenarPorInsercion() {
		
		Technique m = null;
		int pos = 0;
		for(int j = 1; j < longitud();j++) {
			 m = indiceElement(j);
			 pos = j-1;
			while(indiceElement(pos).compare(indiceElement(pos),m) > 0 && pos > -1) {
				Technique m1 = indiceElement(pos);
				Technique m2 = m;
				
				if(m1 == null) {
					Technique temp1 = m1;
					Technique siguiente = m2.getNext();
					tech = m2;
					m2.setNext(temp1);
					temp1.setNext(siguiente);
				}else {
					Technique temp = m1;
					Technique siguiente1 = m2.getNext();
					Technique ant = indiceElement(pos -1);
					ant.setNext(m2);
					m2.setNext(temp);
					temp.setNext(siguiente1);
				}
				pos--;
			}
			Technique cent = indiceElement(pos +1);
			cent = m;
		}
		
		
	}
	
//	public void ordenarPorSeleccion() {
//		
//	Technique tAct = tech;
//	Technique tAnt = null;
//	Technique siguiente = tech.getNext();
//	
//	while(tAct !=null) {
//		
//		while(siguiente != null) {
//		
//		if(tAct.compare(tAct,siguiente) > 0) {
//			if(tAnt != null) {
//				Technique siguiente1 = siguiente.getNext();
//				tAnt.setNext(siguiente);
//				siguiente.setNext(tAct);
//				tAct.setNext(siguiente1);
//			}else {
//			Technique temp = siguiente.getNext();
//			tech = siguiente;
//			siguiente.setNext(tAct);
//			tAct.setNext(temp);
//			}
//			tAnt = siguiente;
//			siguiente = siguiente.getNext();	
//		}else {
//			tAnt = tAct;
////			tAct = siguiente;
//			siguiente = siguiente.getNext();
//		}
////		siguiente = siguiente.getNext();
//	}
//		tAct = tAct.getNext();
////		siguiente = tAct.getNext();
//}
//		
//		
//	}
	
	public String mostrarInfo() {
		String msj = "";
		Technique tAct = tech;
		
		while(tAct != null) {
			
			msj += tAct.toString() + "\n";
			tAct = tAct.getNext();	
		}
		
		return msj;
	}
	
}
