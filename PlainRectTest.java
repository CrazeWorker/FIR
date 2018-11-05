package 第三天作业;

public class PlainRectTest {
	public static void main(String[] args) {
		PlainRect pr = new PlainRect(20,10,10,10);
		System.out.println("面积位："+pr.getArea());
		System.out.println("周长位："+pr.getPerimeter());
		System.out.println("点是否在矩形内："+pr.isInside(25.5, 13));
	}
}
