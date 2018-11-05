package ��������ҵ;

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
	
	// ���췽��
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
	
	// �жϵ��Ƿ��ھ�����
	public boolean isInside(double x,double y) {
		if(x >= startX && x <= (startX + width) && y >=(startY - height) && y <= startY) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
