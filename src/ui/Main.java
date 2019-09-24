package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.ClanSImilarException;
import exceptions.SamuraiNotFoundException;
import exceptions.errorRank;
import exceptions.notClanException;
import exceptions.notFoundTechnique;
import model.*;

public class Main {
	private University univer;
	private Scanner reader;
	
	public Main(){
		reader = new Scanner(System.in);
		univer = new University("serializables\\Sereliazable.dat");
	}

	private void showMenu() {
		int inputUser = 0; 
		
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("1.Agregar un clan");
		System.out.println("2.Agregar un Samurai");
		System.out.println("3.Agregar una tecnica a un Samurai");
		System.out.println("4.Eliminar un Clan");
		System.out.println("5.Eliminar un Samurai");
		System.out.println("6.Eliminar Tecnica");
		System.out.println("7.Mostrar info clan");
		System.out.println("8.Mostrar info del personaje");
		System.out.println("9.Mostrar info technicas");
		System.out.println("10.Modificar nombre del Clan");
		System.out.println("11.Modificar el nombre del samurai");
		System.out.println("12.Modificar la personalidad del samurai");
		System.out.println("13.Modificar la fecha de creacion del samurai");
		System.out.println("14.Modificar el poder del personaje del samurai");
		System.out.println("15.Modificar el nombre de la tecnica");
		System.out.println("16.Modificar el influenciador de a tecnica");
		System.out.println("17.Buscar secuencialmente el nombre de la tecnica");
		System.out.println("18.Buscar secuencialmente el influenciador de la tecnica");
		System.out.println("19.Buscar secuencialmente el nombre del samurai");
		System.out.println("20.Buscar secuencialmente el poder del samurai");
		System.out.println("21.Mostrar ordenadamente technicas");
		System.out.println("22.Mostrar ordenadamente las technicas 2");
		System.out.println("23.Buscar secuencialmente a un clan");
		System.out.println("24.Mostrar ordenadamente a los samurais");
		System.out.println("25. Mostrar ordanadamente a los samurais 2");
		System.out.println("26.Salir");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
		
		while(inputUser != 26) {
			try {
			inputUser = reader.nextInt();
			reader.nextLine();
			
			if(inputUser <= 0 || inputUser >= 27) {
				throw new errorRank("Se salio");
			}
			
			if(inputUser == 1) {
				
				System.out.println("Por favor digite el nombre del clan");
				String nombreClan = reader.nextLine();
				
				univer.addClan(nombreClan);
				System.out.println(univer.infoClan());
				
			}else if(inputUser == 2) {
				System.out.println("Digite el nombre del clan");
				String nombreC = reader.nextLine();
				
				System.out.println("Digite el nombre del Samurai DateBayo");
				String nameSa = reader.nextLine();
				
				System.out.println("Digite su personalidad");
				String personality = reader.nextLine();
				
				System.out.println("Digite la fecha de creacion" +"||"+ " " + "||En formato de  YYYY/MM/DD");
				String dates = reader.nextLine();
				
				System.out.println("Digite su poder");
				int power = reader.nextInt();
				reader.nextLine();
				
				Samurai m = new Samurai(nameSa,personality,dates,power);
				
				System.out.println(univer.callTheMethodLookForTheNoRepeatSamurai(nombreC, m));
				univer.callSortBurblePorNombre(nombreC);
				System.out.println(univer.showInformationSamurai(nombreC));
			}else if(inputUser == 3){
				System.out.println("Digite el nombre del clan");
				String nameClan = reader.nextLine();
				
				System.out.println("Digite el nombre del personaje");
				String nameCharacter = reader.nextLine();
			
				System.out.println("Digite el nombre de la tecnica");
				String nameTec = reader.nextLine();
				
				System.out.println("Digite el influenciador de la tecnica");
				int influencer = reader.nextInt();
				reader.nextLine();
				
				Technique e3 = new Technique(nameTec,influencer);
				
				System.out.println(univer.callTheMethodsLookForNotRepeatTechnique(nameClan,nameCharacter, e3));
				
			}else if(inputUser == 4){
				System.out.println("Digite el nombre de clan a eliminar");
				String nameClansito = reader.nextLine();
				
				univer.EliminarClan(nameClansito);
				System.out.println(univer.infoClan());
				
			}else if(inputUser == 5){
			System.out.println("Digite el nombre del clan");
			String nameClan = reader.nextLine();
			
			System.out.println("Digite el nombre del Samurai");
			String nameNinja = reader.nextLine();
			
			univer.callDelatedSamurai(nameClan, nameNinja);
			System.out.println(univer.showInformationSamurai(nameClan));
			
			}else if(inputUser == 6) {
			System.out.println("Digite el nombre del clan");
			String nombreDelClan = reader.nextLine();
			
			System.out.println("Digite el nombre del personaje");
			String nombrePersonaje = reader.nextLine();
			
			System.out.println("Digite el nombre de la tecnica");
			String nameTec = reader.nextLine();
			
			univer.callDelatedTechnique(nombreDelClan, nombrePersonaje, nameTec);
			System.out.println(univer.showInformationTechnique(nombreDelClan, nombrePersonaje));
			
			}else if(inputUser == 7) {
				
				univer.ordenarPorInsercion();
				System.out.println(univer.infoClan());
				
			}else if(inputUser == 8) {
				System.out.println("Por favor digite el nombre del clan");
				String nameClan = reader.nextLine();
				
				System.out.println(univer.showInformationSamurai(nameClan));
				
			}else if(inputUser == 9) {
				System.out.println("Por favor digite el nombre del clan");
				String nameClan = reader.nextLine();
				
				System.out.println("Por favor digite el nombre del samurai");
				String nameSamurai = reader.nextLine();
				
				System.out.println(univer.showInformationTechnique(nameClan, nameSamurai));
				
			}else if(inputUser == 10) {
				
				System.out.println("Digite el nombre del clan que va a cambiar");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nuevo nombre");
				String nameNew = reader.nextLine();
				
				univer.modifiqueNameClan(nameC, nameNew);
				univer.ordenarPorInsercion();
				System.out.println(univer.infoClan());
				
			}else if(inputUser == 11) {
				System.out.println("Digite el nombre del clan donde va a cambiar el personaje");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nombre del samurai a cambiar");
				String nameSamu = reader.nextLine();
				
				System.out.println("Digite el nuevo nombre del samurai");
				String nameNew = reader.nextLine();
				
				univer.modifiqueName(nameC, nameSamu, nameNew);
				univer.ordenarPorSeleccion();
				System.out.println(univer.showInformationSamurai(nameC));
				
			}else if(inputUser == 12) {
				System.out.println("Digite el nombre del clan donde va a cambiar la personalidad de la personalidad");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nombre del samurai a cambiar");
				String nameSamu = reader.nextLine();
				
				System.out.println("Digite la personalidad del samurai");
				String perso = reader.nextLine();
				
				univer.modifiqueNameInfluencer(nameC, nameSamu, perso);
				System.out.println(univer.showInformationSamurai(nameC));
				
			}else if(inputUser == 13) {
				System.out.println("Digite el nombre del clan donde va a cambiar la fecha de creacion");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el samurai al cual le va a cambiar la fecha");
				String nameSamu = reader.nextLine();
				
				System.out.println("Digite la fecha nueva" + " " + "||" + "En formato de YYYY/MM/DD"+ "||");
				String dateCreation = reader.nextLine();
				
				univer.modifiqueDateCreation(nameC, nameSamu, dateCreation);
				System.out.println(univer.showInformationSamurai(nameC));
				
			}else if(inputUser == 14) {
				System.out.println("Digite el clan del samurai al cual le va a cambiar el poder");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el samurai al cual le va a cambiar el poder");
				String nameSamu = reader.nextLine();
				
				System.out.println("Digite el nuevo poder a cambiar");
				int power = reader.nextInt();
				reader.nextLine();
				
				univer.modifiquePower(nameC, nameSamu, power);
				System.out.println(univer.showInformationSamurai(nameC));
				
			}else if(inputUser == 15) {
				System.out.println("Digite el nombre del clan al cual le va a cambiar el nombre de la tecnica");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nombre del samurai al cual le va a cambiar la tecnica");
				String nameSamu = reader.nextLine();
				
				System.out.println("Digite el nombre de la tecnica que va a cambiar");
				String nameTechnique = reader.nextLine();
				
				System.out.println("Digite el nombre nuevo de la tecnica que va a cambiar");
				String techNew = reader.nextLine();
				
				univer.modifiqueNameTechnique(nameC, nameSamu, nameTechnique, techNew);
				System.out.println(univer.showInformationTechnique(nameC, nameSamu));
			}else if(inputUser == 16) {
				System.out.println("Digite el nombre del clan al cual le va a cambiar el poder de la tecnica");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nombre del samurai al cual le va a cambiar la tecnica");
				String nameSamu = reader.nextLine();
				
				System.out.println("Digite el nombre de la tecnica que va a cambiar");
				String nameTechnique = reader.nextLine();
				
				System.out.println("Digite el poder nuevo de la tecnica que va a cambiar");
				int powerTech = reader.nextInt();
				reader.nextLine();
				
				univer.modifiquePowerTechnique(nameC, nameSamu, nameTechnique, powerTech);
				System.out.println(univer.showInformationTechnique(nameC, nameSamu));
			}else if(inputUser == 17) {
				System.out.println("Digite el nombre del clan");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nombre del samurai");
				String nameSamu = reader.nextLine();
				
				System.out.println("Digite el nombre de la tecnica");
				String nameTech = reader.nextLine();
				
				Long a = System.currentTimeMillis();
				System.out.println(univer.callMethodSecuencialTechniqueName(nameC, nameSamu, nameTech));
				Long b = System.currentTimeMillis();
				
				System.out.println("El tiempo que se demora es:" + (b-a));
				
			}else if(inputUser == 18) {
				System.out.println("Digite el nombre del clan");
				String nameC = reader.nextLine();
				
				System.out.println("DIgite el nombre del samurai");
				String nameSamu = reader.nextLine();
				
				System.out.println("Digite el factor de influencia de la tecnica");
				int influencer = reader.nextInt();
				reader.nextLine();
				
				Long a = System.currentTimeMillis();
				System.out.println(univer.callMethodSecuencialTechniqueInfluencer(nameC,nameSamu,influencer));
				Long b = System.currentTimeMillis();
				
				System.out.println("El tiempo que se demora es:" + (b-a));
				
			}else if(inputUser == 19) {
				System.out.println("Digite el nombre del clan");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nombre del samurai");
				String nameSamu = reader.nextLine();
				
				Long a = System.currentTimeMillis();
				System.out.println(univer.callMethodSecuencialSamuName(nameC, nameSamu));
				Long b = System.currentTimeMillis();
				
				System.out.println("El tiempo que se demora es:" + (b-a));
				
			}else if(inputUser == 20) {
				System.out.println("Digite el nombre del clan");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el poder del samurai");
				int power = reader.nextInt();
				reader.nextLine();
				
				Long a = System.currentTimeMillis();
				System.out.println(univer.callMethodSecuencialPower(nameC, power));
				Long b = System.currentTimeMillis();
				
				System.out.println("El tiempo que se demora es:" + (b-a));
				
			}else if(inputUser == 21) {
				System.out.println("Digite el nombre del clan");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nombre del samurai");
				String nameSamu = reader.nextLine();
				
				long a = System.currentTimeMillis();
				univer.callMethodSelectionMethod(nameC, nameSamu);
				long b = System.currentTimeMillis();
				
				System.out.println(univer.showInformationTechnique(nameC, nameSamu));
				System.out.println("El tiempo es:" + (b-a));
			}else if(inputUser == 22) {
				System.out.println("Digite el nombre del clan");
				String nameC = reader.nextLine();
				
				System.out.println("Digite el nombre del samurai");
				String nameSamu = reader.nextLine();
				
				long a = System.currentTimeMillis();
				univer.callMethodInsertionMethod(nameC,nameSamu);
				long b = System.currentTimeMillis();
				
				System.out.println(univer.showInformationTechnique(nameC, nameSamu));
				System.out.println("El tiempo es:" + (b-a));
			}else if(inputUser == 23) {
				System.out.println("Digite el nombre del clan");
				String nameC = reader.nextLine();
				
				long a = System.currentTimeMillis();
				System.out.println(univer.searchObjectClan(nameC));
				long b = System.currentTimeMillis();
				
				System.out.println("El tiempo es:" +(b-a));
				
			}else if(inputUser == 24) {
				
				System.out.println("Por favor digite el nombre del clan");
				String nameClan = reader.nextLine();
				
				System.out.println("Por favor digite el nombre del samurai");
				String nameSamurai = reader.nextLine();
				
				Long a = System.currentTimeMillis();
				univer.callSortBurblePorNombre(nameClan);
				Long b = System.currentTimeMillis();
				
				System.out.println(univer.showInformationTechnique(nameClan, nameSamurai));
				
				System.out.println("El tiempo es:" + (b-a));
			}else if(inputUser == 25) {
				
				System.out.println("Por favor digite el nombre del clan");
				String nameClan = reader.nextLine();
				
				System.out.println("Por favor digite el nombre del samurai");
				String nameSamurai = reader.nextLine();
				
				Long a = System.currentTimeMillis();
				univer.callSortBurblePorPower(nameClan);
				Long b = System.currentTimeMillis();
				
				System.out.println(univer.showInformationTechnique(nameClan, nameSamurai));
				
				System.out.println("El tiempo es:" + (b-a));
				
			}
			else if(inputUser == 26){
			
				System.out.println("Hasta la proxima!!");
				univer.serializableClan();
			}
			
		}catch(notClanException e) {
			e.getCause();
			System.out.println("No se encontro el clan");
		} catch (ClanSImilarException e) {
			System.out.println("Hay clanes iguales, no se puede agregar");
			e.getCause();
		} catch (SamuraiNotFoundException e) {
			System.out.println("No se encontro al ninja");
			e.getCause();
		}catch(InputMismatchException e) {
			System.out.println("Digite una opcion valida");
			reader.nextLine();
			e.getCause();
		} catch (errorRank e) {
			System.out.println("Por favor digite un rango valido");
			e.getCause();
		} catch (notFoundTechnique e) {
			System.out.println("No se encontro la tecnica");
			e.getCause();
		}
	}
		
}
	
	public static void main(String[] args) { 
		Main m = new Main();
		m.showMenu();

	}

}
