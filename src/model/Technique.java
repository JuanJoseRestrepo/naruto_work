package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;

public class Technique implements Serializable, Comparator<Technique>,Comparable<Technique>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int influencer;
	private Technique next;
	public Technique(String name, int influencer) {
		this.name = name;
		this.influencer = influencer;
	}
	
	public Technique getNext() {
		return next;
	}
	public void setNext(Technique next) {
		this.next = next;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInfluencer() {
		return influencer;
	}
	public void setInfluencer(int influencer) {
		this.influencer = influencer;
	}

	@Override
	public int compareTo(Technique o) {
		// TODO Auto-generated method stub 
		return name.compareTo(o.getName());
	}
	
	public String toString() {
		String msj = "";
		
		msj += "El nombre es:" + "||" + name + "||"; 
		msj += "El influenciador de poder:" + "||" + influencer + "||"; 
		
		return msj;
	}

	@Override
	public int compare(Technique o1, Technique o2) {
		int k = 0;
		
		if(o1.getInfluencer() > o2.getInfluencer()) { 
			k = 1;
		}else if(o1.getInfluencer() < o2.getInfluencer()) {
			k = -1;
		}
		
		return k;
	}
	
}
