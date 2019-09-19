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
			msj = "No se encontro ningun personaje repetido";
			addTechniqueInfuencer(e);
		}
		
		return msj;
	}

	@Override
	public int compareTo(Samurai o1) {
		// TODO Auto-generated method stub
		return nameCharacter.compareToIgnoreCase(o1.getNameCharacter()) ;
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
	
	public void ordenar() {
		
		boolean t;
		
		do {
		Technique c = tech;
		Technique c1 = null;
		Technique sig = tech.getNext();
		 t = false;
		while(sig != null) {
			if(c.getName().compareTo(sig.getName()) > 0) {
				t = true;
				if(c1 != null) {
					Technique siguiente = sig.getNext();
					c1.setNext(sig);
					sig.setNext(c);
					c.setNext(siguiente);
				}else {
					
					Technique siguiente = sig.getNext();
					tech = sig;
					sig.setNext(c);
					c.setNext(siguiente);
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
