package Day_7_HomeWork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StuDaoImp implements StuDao{
	private Map<Integer,Student> m = new HashMap<>();
	
	@Override
	public void getInfo(int number) {
		// TODO Auto-generated method stub
		if(number>=m.size()) {
			System.out.println("您所查找的学生不存在!");
		}else {
			Student s = m.get(number);
			System.out.println("姓名："+s.getName()+"  专业："+s.getMajor()+"  成绩："+s.getGrade());
		}
	}
	
	private Set<Integer> getGrade() {
		Set<Integer> s = new TreeSet<>();
		for (int i = 0; i < m.size(); i++) {
			s.add(m.get(i).getGrade());
		}
		return s;
	}
	
	@Override
	public int addGrade() {
		// TODO Auto-generated method stub
		Set<Integer> s = getGrade();
		int sum = 0;
		Iterator<Integer> it = s.iterator();
		while(it.hasNext()) {
			sum += it.next();
		}
		return sum;
	}
	
	@Override
	public int avgGrade() {
		// TODO Auto-generated method stub
		return addGrade()/m.size();
	}

	@Override
	public void addStu(Student s) {
		// TODO Auto-generated method stub
		m.put(m.size(), s);
	}
	
}
