package test;
import org.junit.jupiter.api.Test;

import model.*;
import model.Character;

public class CharacterTest {

	private Character charac;
	
	public void setupEscenario() {
		charac = new Character("","","",4);
		
		Technique e1 = new Technique("K",1);
		Technique e2 = new Technique("M",2);
		Technique e3 = new Technique("L",4);
		
		charac.addTechniqueNameTechnique(e1);
		charac.addTechniqueNameTechnique(e2);
    	charac.addTechniqueNameTechnique(e3);
		
		
	}
	
	@Test 
	 void test(){
		setupEscenario();
		while(charac.getNext() != null) {
			System.out.println(charac.getNext().getNameCharacter());
		}
	}
	
	@Test
	void testEliminar() {
		setupEscenario();
		
		charac.delatedTechniqueNameTechnique("L");
	}
	
	@Test
	void testModificarInfluencer() {
		setupEscenario();
		
		charac.modificarInfluencer("l", 100);
	}
	
}
