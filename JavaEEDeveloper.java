package www.Oracle_Day12_Test;
/*
 * ����JavaEE��������ʦ����
 * 
 * ���ţ���������������
 */
public class JavaEEDeveloper extends Developer{
	public void work(){
		//���ø����get������ȡ˽�г�Ա����number �� name
		System.out.println("Ա����Ϊ"+super.getNumber()+"��JavaEE����ʦ"+super.getName()+"���ڿ����Ա�");
	}
}
