package ��������ҵ;

public class PlainRectTest {
	public static void main(String[] args) {
		PlainRect pr = new PlainRect(20,10,10,10);
		System.out.println("���λ��"+pr.getArea());
		System.out.println("�ܳ�λ��"+pr.getPerimeter());
		System.out.println("���Ƿ��ھ����ڣ�"+pr.isInside(25.5, 13));
	}
}
