package ������;
// ����ģʽ
public class Factory {
	public static Car getInstanse(String name) {
		if(name.equals("�γ�")) {
			return new JiaoCar();
		}else if(name.equals("����")) {
			return new HuoCar();
		}else {
			return null;
		}
	}
}
