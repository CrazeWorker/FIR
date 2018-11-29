package 第九天;

import java.util.HashMap;
import java.util.Map;


public class MapDeme {
	// 创建存放班级的集合，班级用集合表示
	Map<Integer, Map<Integer, Student>> map = new HashMap<>();
	// 创建一班的集合
	Map<Integer, Student> java1 = new HashMap<>();
	// 创建二班的集合
	Map<Integer, Student> java2 = new HashMap<>();
	
	// 初始化
	public void info() {	
		map.put(1, java1);
		map.put(2, java2);
		// 添加一班的学生
		java1.put(1, new Student("小明", 78,"软件"));
		java1.put(2, new Student("小李", 90,"软件"));
		// 添加二班的学生
		java2.put(1, new Student("小王", 92,"数字媒体"));
		java2.put(2, new Student("小张", 88,"数字媒体"));
	}
	
	// 查找学生对象
	private Student getStuByName(String name) {
		for (int i = 1; i <= map.size(); i++) {
			for (int j = 1; j <= map.get(i).size(); j++) {
				if(name!=null&&name.equals(map.get(i).get(j).getName())) {
					return map.get(i).get(j);	
				}
			}
		}
		return null;
	}
	
	// 打印
	public void searchByName(String name) {
		Student student = getStuByName(name);
		if(student!=null) {
			System.out.println(student.toString());
		}else {
			System.out.println("没有该学生的信息!");
		}
	}
}
