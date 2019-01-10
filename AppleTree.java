public class AppleTree implements Behavior{
	private int legs = 0;
	private String type = "Plant";
	public void eat(){
		System.out.println("i can't eat.");
	}
	public void run(){
		System.out.println("i have no leg");
	}
	public int getLegs(){
		return legs;
	}
	public String getType(){
		return type;
	}
}