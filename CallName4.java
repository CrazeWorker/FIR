/*����������÷�����ArrayList��ʵ���������ϵͳ
   1������һ��ArrayList�����ڴ洢ѧ��������
   2����ArrayList��ķ���ʵ�����ݵ��޸ĺʹ�ȡ
   3�����������
   4���������������������
*/
import java.util.ArrayList;
import java.util.Random;
public class CallName4{
	public static void main(String [] args){
		//����һ��ArrayList���ϣ�������ΪStudentName
		ArrayList<StudentName> array1 = new ArrayList<StudentName>();
		//�ֱ���ø��ַ���
		add1(array1);
		printArray(array1);
		randomCall(array1);
	}
	public static void printArray(ArrayList<StudentName> array){
		//����һ�������������ϣ����Ҵ�ӡÿһ�����ϵĸ�������
		//����ArrayList��size����ȡ���ϵĳ���
		for(int i=0;i<array.size();i++){
			StudentName s = array.get(i);
			System.out.println(s.name+" "+s.age);
		}
	}
	public static void add1(ArrayList<StudentName> array){
		//���巽����ʼ�������е�Ԫ��
		//�����ĵü��϶��󣬲��ҳ�ʼ������
		StudentName s1 = new StudentName();
		StudentName s2 = new StudentName();
		StudentName s3 = new StudentName();
		StudentName s4 = new StudentName();
		StudentName s5 = new StudentName();
		s1.name = "����";
		s1.age  = 20;
		s2.name = "����";
		s2.age  = 21;
		s3.name = "����";
		s3.age  = 22;
		s4.name = "����";
		s4.age  = 23;
		s5.name = "����";
		s5.age  = 24;
		//����add������������ӵ�������
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		array.add(s5);
	}
	public static void randomCall(ArrayList<StudentName> array){
		//������������󣬲���һ�������
		Random r = new Random();
		int num = r.nextInt(array.size());
		//����get�����������������ȡ�����Ӧ��ѧ��
		StudentName s =array.get(num);
		System.out.println(" �������ѧ���ǣ�");
		System.out.println(s.name+" "+s.age);
	}
}