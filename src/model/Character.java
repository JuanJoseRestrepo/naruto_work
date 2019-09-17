package model;

import java.io.Serializable;
import java.util.Comparator;

public class Character implements Serializable, Comparator<Character>,Comparable<Character>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameCharacter;
	private String personality;
	private String creationDate;
	private int power;
	private Character previus;
	private Character next;
	private Technique tech;
	public Character(String nameCharacter,String personality,String creationDate,int power) {
		
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

	public Character getPrevius() {
		return previus;
	}

	public Technique getTech() {
		return tech;
	}

	public void setTech(Technique tech) {
		this.tech = tech;
	}

	public void setPrevius(Character previus) {
		this.previus = previus;
	}

	public Character getNext() {
		return next;
	}

	public void setNext(Character next) {
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
					tAct = e;
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
			if(e.compare(e, tAct) < 0) {
				e.setNext(tAct);
				tAct = e;
			}else {
				while(tAct != null && tAct.compare(tAct,e) < 0) {
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
				while(!(tAct.getName().equalsIgnoreCase(nameTecnique))) {
					
					tAct = tAct.getNext();
					tempAnt = tAct;
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
				tAct = tech.getNext();
			}	
		}
	}
	
	public void modificarInfoName(String nameTechnique,String otherName) {
		Technique tAct = tech;
		boolean t = false;
		
		while(tAct != null && !t) {
			
		}
		
	}

	public void ordenateInsercion() {
		Technique t = tech;
		
		while(t != null) {
			
			while(t.getNext() != null) {
				if(t.getName().compareToIgnoreCase(t.getNext().getName()) > 0) {
					Technique t1 = t.getNext().getNext();
					tech.setNext(t.getNext());
					t.getNext().setNext(t);
					t.setNext(t1);
				}
			}
			
			
		}
		
		
	}
	@Override
	public int compareTo(Character arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(Character arg0, Character arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	
}
