package test;
import org.junit.jupiter.api.Test;

import exceptions.notFoundTechnique;
import model.*;
import model.Samurai;

public class CharacterTest {

	private Samurai charac;
	
	public void setupEscenario() {
		charac = new Samurai("","","",4);
		

		Technique e2 = new Technique("M",2);
		Technique e3 = new Technique("L",3);
		Technique e4 = new Technique("Z",6);
		Technique e1 = new Technique("K",8);
		Technique e5 = new Technique("I",8);
		Technique e6 = new Technique("J",2);
		Technique e7 = new Technique("O",1);
		Technique e8 = new Technique("Q",2);
		Technique e9 = new Technique("U",3);
		Technique e10 = new Technique("D",6);
		Technique e11 = new Technique("H",6);
		Technique e12 = new Technique("ZZZ",9);
		
		charac.lookForNotRepeatTechniques(e7);
		charac.lookForNotRepeatTechniques(e4);
    	charac.lookForNotRepeatTechniques(e1);
    	charac.lookForNotRepeatTechniques(e3);
    	charac.lookForNotRepeatTechniques(e5);
    	charac.lookForNotRepeatTechniques(e6);
    	charac.lookForNotRepeatTechniques(e2);
    	charac.lookForNotRepeatTechniques(e8);
    	charac.lookForNotRepeatTechniques(e9);
    	charac.lookForNotRepeatTechniques(e12);
    	charac.lookForNotRepeatTechniques(e11);
    	charac.lookForNotRepeatTechniques(e10);
	}
	
	public void setupEscenario2() {
		charac = new Samurai("","","",4);
		

		Technique e2 = new Technique("M",2);
		Technique e3 = new Technique("L",3);
		Technique e4 = new Technique("Z",6);
		Technique e1 = new Technique("K",8);
		Technique e5 = new Technique("I",8);
		Technique e6 = new Technique("J",2);
		Technique e7 = new Technique("O",1);
		Technique e8 = new Technique("Q",2);

		charac.addFinal(e1);
		charac.addInicio(e2);
		charac.addInicio(e3);
		charac.addInicio(e4);
		charac.addInicio(e5);
		charac.addInicio(e6);
		charac.addInicio(e7);
		charac.addInicio(e8);
		
		
	}
	
	@Test
	void mostrar() {
		setupEscenario();
		System.out.println("AQUIIIII");
		System.out.println(charac.mostrarInfo());
	}
	
	
	@Test
	void testEliminar() {
		setupEscenario();
		
		charac.delatedTechniqueNameTechnique("L"); 
		System.out.println(charac.mostrarInfo());
	}
	
	@Test
	void testModificarInfluencer() {
		setupEscenario();
		
	
		try {
			charac.modificarInfluencer("m", 100);
			charac.ordenarPorInsercionInfluencer();
			System.out.println(charac.mostrarInfo());
		} catch (notFoundTechnique e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void ordenar() {
		setupEscenario();
		charac.ordenarPorSeleccionNombre();
		System.out.println("//" +charac.mostrarInfo());
	}
	
	@Test
	void ordenar1() {
		setupEscenario();
		charac.ordenarPorInsercionInfluencer();
		System.out.println("//--" +charac.mostrarInfo());
	}
	
}
