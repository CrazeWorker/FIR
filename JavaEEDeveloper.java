package www.Oracle_Day12_Test;
/*
 * 描述JavaEE开发工程师的类
 * 
 * 工号，姓名，工作方法
 */
public class JavaEEDeveloper extends Developer{
	public void work(){
		//调用父类的get方法获取私有成员变量number 和 name
		System.out.println("员工号为"+super.getNumber()+"的JavaEE工程师"+super.getName()+"正在开发淘宝");
	}
}
