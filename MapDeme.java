package �ھ���;

import java.util.HashMap;
import java.util.Map;


public class MapDeme {
	// ������Ű༶�ļ��ϣ��༶�ü��ϱ�ʾ
	Map<Integer, Map<Integer, Student>> map = new HashMap<>();
	// ����һ��ļ���
	Map<Integer, Student> java1 = new HashMap<>();
	// ��������ļ���
	Map<Integer, Student> java2 = new HashMap<>();
	
	// ��ʼ��
	public void info() {	
		map.put(1, java1);
		map.put(2, java2);
		// ���һ���ѧ��
		java1.put(1, new Student("С��", 78,"���"));
		java1.put(2, new Student("С��", 90,"���"));
		// ��Ӷ����ѧ��
		java2.put(1, new Student("С��", 92,"����ý��"));
		java2.put(2, new Student("С��", 88,"����ý��"));
	}
	
	// ����ѧ������
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
	
	// ��ӡ
	public void searchByName(String name) {
		Student student = getStuByName(name);
		if(student!=null) {
			System.out.println(student.toString());
		}else {
			System.out.println("û�и�ѧ������Ϣ!");
		}
	}
}
