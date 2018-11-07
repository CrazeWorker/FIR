package 工厂模式;

import org.junit.Test;

public class Summon {
	public static Occupation getOccupation(String s) {
		switch (s) {
		case "saber":
			return new Saber();
		case "archer":
			return new Archer();
		case "lancer":
			return new Lancer();
		}
		return null;
	}
	
	@Test
	public void test() {
		String s1 = "saber";
		Summon.getOccupation(s1).attact();
		String s2 = "archer";
		Summon.getOccupation(s2).attact();
		String s3 = "lancer";
		Summon.getOccupation(s3).attact();
	}
}
