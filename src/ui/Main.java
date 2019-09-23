package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.ClanSImilarException;
import exceptions.SamuraiNotFoundException;
import exceptions.errorRank;
import exceptions.notClanException;
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
		System.out.println("17.Salir");
		
		while(inputUser != 17) {
			try {
			inputUser = reader.nextInt();
			reader.nextLine();
			
			if(inputUser <= 0 || inputUser >= 18) {
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
				univer.callSortBurble(nombreC);
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
				System.out.println(univer.infoClan());
				
			}else if(inputUser == 11) {
				System.out.println("");
				
			}else if(inputUser == 12) {
				
			}else if(inputUser == 13) {
				
			}else if(inputUser == 14) {
				
			}else if(inputUser == 15) {
				
			}else if(inputUser == 16) {
				
			}
			else if(inputUser == 17){
			
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
		}
	}
		
}
	
	public static void main(String[] args) { 
		Main m = new Main();
		m.showMenu();

	}

}
