package model;

public class Character {

	private String nameCharacter;
	private String personality;
	private String creationDate;
	private int power;
	private Character previus;
	private Character next;
	
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

	public void setPrevius(Character previus) {
		this.previus = previus;
	}

	public Character getNext() {
		return next;
	}

	public void setNext(Character next) {
		this.next = next;
	}

	
	
}
