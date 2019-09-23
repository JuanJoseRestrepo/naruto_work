package model;

import java.io.*;
import java.util.ArrayList;

import exceptions.ClanSImilarException;
import exceptions.SamuraiNotFoundException;
import exceptions.notClanException;
import exceptions.notFoundTechnique;

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
	
	public void ordenarPorInsercion(){
		
		for(int i = 1; i < clanes.size();i++) {
			
			for(int j = i; j > 0 && clanes.get(j-1).compareTo(clanes.get(j)) > 0;j--) {
				Clan temp = clanes.get(j);
				clanes.set(j, clanes.get(j-1));
				clanes.set(j-1, temp);
			}
		}
	}
	
	public String searchObjectClan(String nameC) throws notClanException {
		String msj = "";
		boolean t = false;
		for(int i = 0; i <  clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameC)) {
				msj += clanes.get(i).toString();
				t = true;
			}
		}
		
		if(t == false) {
			throw new notClanException("No se encontro");
		}
		
		
		return msj;
	}
	
	public void ordenarPorSeleccion() {
		
		for(int i = 0; i < clanes.size();i++) {
			Clan menor = clanes.get(i);
			int indice = i;
			
			for(int j = i + 1; j < clanes.size()-1;j++) {
				if(clanes.get(j).compare(clanes.get(j),menor) > 0) {
					menor = clanes.get(j);
					indice = j;
				}
			}
			Clan temp = clanes.get(i);
			clanes.set(i, menor);
			clanes.set(indice, temp);
		}
		
	}
	
	public void modifiquePowerTechnique(String nameClan,String nameSamurai,String nameTechnique,int powerInfluencer) throws notFoundTechnique, SamuraiNotFoundException, notClanException {
		
		boolean t = false;
		
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				
				clanes.get(i).modificarInfluencerTechnique(nameSamurai, nameTechnique,powerInfluencer);
				t = true;
			}
		}
		if(t == false) {
			throw new notClanException("No se encontro");
		}
		
	}
	
	
	public void modifiqueNameTechnique(String nameClan,String nameSamurai,String nameTechnique,String newTechnique) throws notClanException, SamuraiNotFoundException, notFoundTechnique {
		
		boolean t = false;
		
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				
				clanes.get(i).modificarNameTechnique(nameSamurai, nameTechnique,newTechnique);
				t = true;
			}
		}
		if(t == false) {
			throw new notClanException("No se encontro");
		}
		
	}
	
	public void modifiquePower(String nameClan,String nameSamurai,int nameNew) throws SamuraiNotFoundException, notClanException {
		
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				
				clanes.get(i).modificarPowerSamurai(nameSamurai, nameNew);
				t = true;
			}
		}
		if(t == false) {
			throw new notClanException("No se encontro");
		}
		
	}
	
	public void modifiqueDateCreation(String nameClan,String nameSamurai,String nameNew) throws SamuraiNotFoundException, notClanException {
		
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				
				clanes.get(i).modificarDateSamurai(nameSamurai, nameNew);
				t = true;
			}
		}
		if(t == false) {
			throw new notClanException("No se encontro");
		}
		
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
	
	public void modifiqueNameInfluencer(String nameClan,String nameSamurai,String nameNew) throws SamuraiNotFoundException, notClanException {
		
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				
				clanes.get(i).modificarNameInfluencer(nameSamurai, nameNew);
				t = true;
			}
		}
		if(t == false) {
			throw new notClanException("No se encontro");
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
	
	public String showInformationTechnique(String nameClan,String namePerso) throws SamuraiNotFoundException, notClanException {
		String msj = "";
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				msj += clanes.get(i).callMethodShowInfo(namePerso);
				t = true;
			}
		}
		
		if(t == false) {
			throw new notClanException("No se encontro");
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

	public void callSortBurblePorNombre(String nameClan) {
		boolean t = false;
		for(int i = 0; i < clanes.size() && !t;i++) {
			if(clanes.get(i).getNameClan().equalsIgnoreCase(nameClan)) {
				clanes.get(i).ordenarPorBurbujaMejorada();
				t = true;
			}
		}	
	}
	
	public void callSortBurblePorPower(String nameClan) {
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
