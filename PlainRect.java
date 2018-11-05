package 第三天作业;

public class PlainRect extends Rect{
	private double startX;
	private double startY;
	public double getStartX() {
		return startX;
	}
	public void setStartX(double startX) {
		this.startX = startX;
	}
	public double getStartY() {
		return startY;
	}
	public void setStartY(double startY) {
		this.startY = startY;
	}
	
	// 构造方法
	public PlainRect(double width, double height,double startX, double startY) {
		super();
		this.width = width;
		this.height = height;
		this.startX = startX;
		this.startY = startY;
	}
	public PlainRect() {
		width = 0;
		height = 0;
		startX = 0;
		startY = 0;
	}
	
	// 判断点是否在矩形内
	public boolean isInside(double x,double y) {
		if(x >= startX && x <= (startX + width) && y >=(startY - height) && y <= startY) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
