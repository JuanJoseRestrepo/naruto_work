package model;

import java.io.*;
import java.util.ArrayList;

import exceptions.ClanSImilarException;
import exceptions.SamuraiNotFoundException;
import exceptions.notClanException;

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
	
	public void addClan(String nameClan) throws ClanSImilarException {
		
			boolean t = false;
			if(clanes.isEmpty()) {
			clanes.add(new Clan(nameClan));
			}else {
				for(int i = 0; i < clanes.size() && !t;i++) {
					if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
						t = true;
						throw new ClanSImilarException("Hay iguales");
					}
				}
				if(t == false) {
					clanes.add(new Clan(nameClan));
				}
			}
	}
	
	public String infoClan() {
		String msj = "";
		for(int i = 0; i < clanes.size();i++) {
			
			msj += clanes.get(i).toString() + "\n";
			
		}
		return msj;
	}
	
	public String callTheMethodLookForTheNoRepeatSamurai(String nombreClan,Samurai e) throws notClanException {
		String msj = "";
		boolean t= false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(nombreClan.equals(clanes.get(i).getNameClan())) {
				
			msj = clanes.get(i).lookForNotRepeatCharacters(e);
			t = true;	
			}
		}
		
		if(t == false) {
			throw new notClanException("No se encontro el ninja");
		}
		
		return msj;
	}
	
	public String callTheMethodsLookForNotRepeatTechnique(String nombreCaln,String nameSamu,Technique e) throws notClanException, SamuraiNotFoundException {
		String msj = "";
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(nombreCaln.equals(clanes.get(i).getNameClan())) {
				
			msj = clanes.get(i).callTheMethodNotRepeatTechniques(nameSamu,e);
			t = true;	
			}
		}
		
		if(t == false) {
			throw new notClanException("No se encontro el ninja");
		}
		
		return msj;
	}
	
	public String toString() {
		String msj = "";
		
		msj = "El nombre del clan es:";
		
		return msj;
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
	
	public void EliminarClan(String nameClan) throws notClanException {
		
		boolean t = false;
		for (int i = 0; i < clanes.size() && !t; i++) {
			if(clanes.get(i).getNameClan().equals(nameClan)) {
				clanes.remove(i);
				t = true;
			}
		}
		
		if(t == false) {
			throw new notClanException("No se encontro");
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
