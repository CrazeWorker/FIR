package www.Oracle_Test1;

public class Student extends Person{
	private int num;
	Student(String name, int age,int num) {
		super(name, age);
		this.num = num;
	}
	
	public void speak(){
		System.out.println("my name is "+name+"\nI'm "+age+" years old."+"\nmy StudentNum is "+num);
	}
	
}
