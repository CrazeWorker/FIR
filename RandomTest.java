import java.util.Random;
public class RandomTest{
	public static void main(String [] args){
		//����ʵ������
		Random random = new Random();
		int i = random.nextInt(100);
		System.out.println(i);
	}
}