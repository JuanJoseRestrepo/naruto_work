package ui;
import java.util.Scanner;

import model.*;

public class Main {
	private University univer;
	private Scanner reader;
	
	public Main(){
		reader = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}

	private void showMenu() {
		int inputUser = 0; 
		
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("1.");
		
		while(inputUser != 3) {
			inputUser = reader.nextInt();
			reader.nextLine();
			
			if(inputUser == 1) {
				
			}else if(inputUser == 2) {
				
			}else {
				System.out.println("Hasta la proxima!!");
				univer.serializableClan();
			}
			
		}
		
	}

}
