import java.util.Random;
public class SwitchTest{
	public static void main(String[] args){
		Random sc = new Random();
		int week = sc.nextInt(9);
		switch(week){
			case 1:
			System.out.println("����һ");
			break;
			case 2:
			System.out.println("���ڶ�");
			break;
			case 3:
			System.out.println("������");
			break;
			case 4:
			System.out.println("������");
			break;
			case 5:
			System.out.println("������");
			break;
			case 6:
			System.out.println("������");
			break;
			case 7:
			System.out.println("������");
			break;
			default:
			System.out.println("�������ݲ���ȷ");
			break;
		}
		
	}
}