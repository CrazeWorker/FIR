package www.Oracle_Day11_Test03;

public abstract class Teacher {
	protected String name;
	protected int age;
	abstract void teach();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
