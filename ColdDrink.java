package 建造者模式;

public abstract class ColdDrink implements Item{
	@Override
	public Packing packing() {
		return new Bottle();
	}
	
	@Override
	public abstract double price();
}
