package test;
import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testClan {
	
	private Clan c;
	
	private void setupEscenario1() {
		 c = new Clan("");
		
		Samurai s1 = new Samurai("J","Ninja","2019/03/09",100);
		Samurai s2 = new Samurai("N","Ninja1","12/03/2019",1231);
		Samurai s3 = new Samurai("Ma","Ninja2","12/03/2019",1415231);
		Samurai s4 = new Samurai("A","Ninja3","12/03/2019",11231321);
		Samurai s5 = new Samurai("B","Ninja4","12/03/2019",11231321);
		Samurai s6 = new Samurai("Z","Ninja5","12/03/2019",12);
		Samurai s7 = new Samurai("X","Ninja2","12/03/2019",1415231);
		Samurai s8 = new Samurai("Y","Ninja3","12/03/2019",11231321);
		Samurai s9 = new Samurai("D","Ninja4","12/03/2019",11231321);
		Samurai s10 = new Samurai("K","Ninja5","12/03/2019",12);
		Samurai s11 = new Samurai("W","Ninja","2019/03/09",100);
		Samurai s12 = new Samurai("T","Ninja1","12/03/2019",1231);
		Samurai s13 = new Samurai("O","Ninja2","12/03/2019",1415231);
		Samurai s14 = new Samurai("P","Ninja3","12/03/2019",11231321);
		Samurai s15 = new Samurai("F","Ninja4","12/03/2019",11231321);
		Samurai s16 = new Samurai("V","Ninja5","12/03/2019",12);
		Samurai s17 = new Samurai("G","Ninja2","12/03/2019",1415231);
		Samurai s18 = new Samurai("PO","Ninja3","12/03/2019",11231321);
		Samurai s19 = new Samurai("RT","Ninja4","12/03/2019",11231321);
		Samurai s20 = new Samurai("KY","Ninja5","12/03/2019",12);
		
		c.lookForNotRepeatCharacters(s1);
		c.lookForNotRepeatCharacters(s2);
		c.lookForNotRepeatCharacters(s4);
		c.lookForNotRepeatCharacters(s3);
		c.lookForNotRepeatCharacters(s5);
		c.lookForNotRepeatCharacters(s6);
		c.lookForNotRepeatCharacters(s7);
		c.lookForNotRepeatCharacters(s8);
		c.lookForNotRepeatCharacters(s9);
		c.lookForNotRepeatCharacters(s10);
		c.lookForNotRepeatCharacters(s11);
		c.lookForNotRepeatCharacters(s12);
		c.lookForNotRepeatCharacters(s13);
		c.lookForNotRepeatCharacters(s14);
		c.lookForNotRepeatCharacters(s15);
		c.lookForNotRepeatCharacters(s16);
		c.lookForNotRepeatCharacters(s17);
		c.lookForNotRepeatCharacters(s18);
		c.lookForNotRepeatCharacters(s19);
		c.lookForNotRepeatCharacters(s20);
	}

	private void setupEscenario2() {
		 c = new Clan("");
			
		Samurai s1 = new Samurai("J","Ninja","2019/03/09",100);
		Samurai s2 = new Samurai("N","Ninja1","12/03/2019",1231);
		Samurai s3 = new Samurai("Ma","Ninja2","12/03/2019",1415231);
		Samurai s4 = new Samurai("A","Ninja3","12/03/2019",11231321);
		Samurai s5 = new Samurai("B","Ninja4","12/03/2019",11231321);
		Samurai s6 = new Samurai("Z","Ninja5","12/03/2019",12);
		
		c.addInicio(s1);
		c.addInicio(s2);
		c.addInicio(s6);
		c.addInicio(s4);
		c.addInicio(s5);
		c.addInicio(s3);
		
	}
	
	@Test
	void mostrarEscenario1() {
		setupEscenario1();
		System.out.println(c.mostrarInfo());
	}
	
	@Test
	void delatedSomething() {
		setupEscenario1();
		
		c.delatedSamurai("B");
		c.delatedSamurai("A");
		c.delatedSamurai("Z");
		c.ordenarPorBurbujaMejorada();
		System.out.println("ad" + c.mostrarInfo() + "ad");
	}
	
	@Test
	void ordenar() {
		setupEscenario1();
		
		c.ordenarPorBurbujaMejorada();
		System.out.println("//" + c.mostrarInfo() + "//");
	}
	
	@Test
	void agregarInicio() {
		setupEscenario2();
		c.ordenarPorBurbujaMejorada();
		System.out.println("//oo" + c.mostrarInfo() + "//");
	}

}
