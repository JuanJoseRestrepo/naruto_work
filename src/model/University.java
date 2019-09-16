package model;

import java.io.*;
import java.util.ArrayList;

public class University implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Clan> clanes;
	private String archives;
	public University(String archives) {
		this.archives = archives;
		clanes = new ArrayList<Clan>();
		deserializableClan();
	}
	
	public ArrayList<Clan> getClanes() {
		return clanes;
	}

	public void setClanes(ArrayList<Clan> clanes) {
		this.clanes = clanes;
	}

	public String getArchives() {
		return archives;
	}

	public void setArchives(String archives) {
		this.archives = archives;
	}
	
	public void serializableClan() {
		
		try {
			File fl = new File(archives);
			
			FileOutputStream fos = new FileOutputStream(fl);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(clanes);
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deserializableClan() {
		
		ArrayList<Clan> clanesitos;
		try {
			File fl = new File(archives);
			
			FileInputStream fis = new FileInputStream(fl);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			clanesitos = (ArrayList<Clan>) ois.readObject();
			setClanes(clanesitos);
			
			ois.close();
			
		}catch(IOException e) {
			e.getMessage();
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}
		
		
	}


}
