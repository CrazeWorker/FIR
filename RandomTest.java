import java.util.Random;
public class RandomTest{
	public static void main(String [] args){
		//创建实例变量
		Random random = new Random();
		int i = random.nextInt(100);
		System.out.println(i);
	}
}