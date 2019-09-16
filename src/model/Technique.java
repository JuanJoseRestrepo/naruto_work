package model;

public class Technique {
	
	private String name;
	private int influencer;
	public Technique(String name, int influencer) {
		this.name = name;
		this.influencer = influencer;
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
	


}
