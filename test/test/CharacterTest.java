package test;
import org.junit.jupiter.api.Test;

import model.*;
import model.Samurai;

public class CharacterTest {

	private Samurai charac;
	
	public void setupEscenario() {
		charac = new Samurai("","","",4);
		
		Technique e1 = new Technique("K",1);
		Technique e2 = new Technique("M",2);
		Technique e3 = new Technique("L",4);
		Technique e4 = new Technique("K",1);
		
		charac.lookForNotRepeatTechniques(e1);
		charac.lookForNotRepeatTechniques(e2);
    	charac.lookForNotRepeatTechniques(e3);
    	charac.lookForNotRepeatTechniques(e4);
		
	
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
		
		charac.modificarInfluencer("l", 100);
	}
	
}
