package test;
import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testClan {
	
	private Clan c;
	
	private void setupEscenario1() {
		 c = new Clan("");
		
		Samurai s1 = new Samurai("J","Ninja","2019/03/09",100);
		Samurai s2 = new Samurai("N","Ninja","12/03/2019",1231);
		Samurai s3 = new Samurai("Ma","Ninja","12/03/2019",1415231);
		Samurai s4 = new Samurai("A","Ninja","12/03/2019",11231321);
		Samurai s5 = new Samurai("B","Ninja","12/03/2019",11231321);
		Samurai s6 = new Samurai("Z","Ninja","12/03/2019",12);
		
		c.lookForNotRepeatCharacters(s1);
		c.lookForNotRepeatCharacters(s2);
		c.lookForNotRepeatCharacters(s4);
		c.lookForNotRepeatCharacters(s3);
		c.lookForNotRepeatCharacters(s5);
		c.lookForNotRepeatCharacters(s6);
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
		System.out.println("ad" + c.mostrarInfo() + "ad");
	}
	
	@Test
	void ordenar() {
		setupEscenario1();
		 

		
		System.out.println("//" + c.mostrarInfo() + "//");
	}

}
