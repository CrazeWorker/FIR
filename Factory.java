package 第三天;
// 工厂模式
public class Factory {
	public static Car getInstanse(String name) {
		if(name.equals("轿车")) {
			return new JiaoCar();
		}else if(name.equals("货车")) {
			return new HuoCar();
		}else {
			return null;
		}
	}
}
