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
	
	public void modifiqueNameClan(String nameClan,String nameNew) throws notClanException {
		boolean t = false;
		
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				clanes.get(i).setNameClan(nameNew);
				t = true;
			}
		}
		
		if(t == false) {
			throw new notClanException("No se encontro el clan");
		}
		
	}
	
	public void modifiqueName(String nameClan,String nameSamurai,String nameNew) throws SamuraiNotFoundException, notClanException {
		
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				
				clanes.get(i).modificarNameCharacter(nameSamurai, nameNew);
				t = true;
			}
		}
		if(t == false) {
			throw new notClanException("No se encontro");
		}
		
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
	
	public String searchClan(String nameClan) {
		
		String msj = "";
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				msj = clanes.get(i).getNameClan();
				t = true;
			}
		}
		return msj;
	}
	
	public String showInformationSamurai(String nameClan) {
		String msj = "";
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				msj += clanes.get(i).mostrarInfo();
				t = true;
			}
		}
		
		return msj;
	}
	
	public String showInformationTechnique(String nameClan,String namePerso) {
		String msj = "";
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				msj += clanes.get(i).callMethodShowInfo(namePerso);
				t = true;
			}
		}
		
		return msj;
	}
	
	public void callDelatedTechnique(String nameClan,String nameSamurai,String nameTechnique) throws SamuraiNotFoundException, notClanException {
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				clanes.get(i).callMethodDelatedSamurai(nameSamurai, nameTechnique);
				t = true;
			}
		}
		if(t == false) {
			throw new notClanException("No se encontro");
		}
		
	}
	
	public void callDelatedSamurai(String nameClan,String nameSamurai) throws notClanException {
		boolean t =false;
		
		for(int j = 0; j < clanes.size() && !t;j++) {
			if(clanes.get(j).getNameClan().equalsIgnoreCase(nameClan)) {
				clanes.get(j).delatedSamurai(nameSamurai);
				t = true;
			}
		}
		
		if(t == false) {
			throw new notClanException("No se encontro el clan");
		}
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

	public void callSortBurble(String nameClan) {
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				clanes.get(i).ordenarPorBurbujaMejorada();
				t = true;
			}
		}
		
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
