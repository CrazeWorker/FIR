/*需求分析：用方法和ArrayList类实现随机点名系统
   1、定义一个ArrayList类用于存储学生的姓名
   2、用ArrayList类的方法实现数据的修改和存取
   3、产生随机数
   4、随机数做索引查找姓名
*/
import java.util.ArrayList;
import java.util.Random;
public class CallName4{
	public static void main(String [] args){
		//定义一个ArrayList集合，其类型为StudentName
		ArrayList<StudentName> array1 = new ArrayList<StudentName>();
		//分别调用各种方法
		add1(array1);
		printArray(array1);
		randomCall(array1);
	}
	public static void printArray(ArrayList<StudentName> array){
		//定义一个方法遍历集合，并且打印每一个集合的各个数据
		//利用ArrayList的size方法取集合的长度
		for(int i=0;i<array.size();i++){
			StudentName s = array.get(i);
			System.out.println(s.name+" "+s.age);
		}
	}
	public static void add1(ArrayList<StudentName> array){
		//定义方法初始化集合中的元素
		//创建心得集合对象，并且初始化对象
		StudentName s1 = new StudentName();
		StudentName s2 = new StudentName();
		StudentName s3 = new StudentName();
		StudentName s4 = new StudentName();
		StudentName s5 = new StudentName();
		s1.name = "张三";
		s1.age  = 20;
		s2.name = "李四";
		s2.age  = 21;
		s3.name = "赵武";
		s3.age  = 22;
		s4.name = "溜溜";
		s4.age  = 23;
		s5.name = "琴琴";
		s5.age  = 24;
		//利用add方法将对象添加到集合内
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		array.add(s5);
	}
	public static void randomCall(ArrayList<StudentName> array){
		//创建随机数对象，产生一个随机数
		Random r = new Random();
		int num = r.nextInt(array.size());
		//利用get方法，随机数做索引取出相对应的学生
		StudentName s =array.get(num);
		System.out.println(" 随机出的学生是：");
		System.out.println(s.name+" "+s.age);
	}
}