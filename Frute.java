
public class Frute {
	
static class Frutes{
		 int color=0;
		public void eat() {
			System.out.println("ÎÒÄÜ³Ô");
		}
	}
	 
static class Apple extends Frutes{
	}
public static void main(String[] args) {
		Apple apple = new Apple();
		apple.eat();
	}
}
