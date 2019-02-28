package first;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Administrator\\Desktop\\test.txt";
		//�����ļ�����
		File f = new File(path);
		//�������·��
		System.out.println("�������·��:"+f.getAbsolutePath());
		//����ļ���С
		System.out.println("����ļ���С:"+f.length());
		//����ļ�����
		System.out.println("����ļ�����:"+f.getName());
		//��������ļ�ʱ�ķ�װ·������path
		System.out.println("����ļ��ķ�װ·��:"+f.getPath());
		File f1 = new File("C:\\Users\\Administrator\\Desktop\\test2.txt");
		//�����ļ�������ļ������ڣ����� true ����ļ����ڣ��򲻴��� false�� ���·������IOException��
		boolean b = f1.createNewFile();
		System.out.println("�ļ��Ƿ񴴽��ɹ�:"+b);
		//-----------ɾ���ļ�����-------ע�⣺��ȥ����վ������------
		boolean b2 = f1.delete();
		System.out.println("�ļ��Ƿ�ɾ���ɹ�:"+b2);
		//-----------��Ҫ�ж��ļ��Ƿ����------------
		boolean b3 = f1.exists();
		System.out.println("�ļ��Ƿ����:"+b3);
		//mkdir()��������Ŀ¼��//dir.mkdirs();�����༶Ŀ¼
		File dir = new File("C:\\Users\\Administrator\\Desktop\\aab");
		boolean b4 = dir.mkdir();
		System.out.println("Ŀ¼�Ƿ񴴽��ɹ�:"+b4);
		//ɾ��Ŀ¼ʱ�����Ŀ¼�������ݣ��޷�ֱ��ɾ����
		System.out.println("Ŀ¼�Ƿ�ɾ���ɹ�:"+dir.delete());
		// Ҫ�ж��Ƿ����ļ�����Ŀ¼���������жϴ��ڡ�
		System.out.println("�Ƿ�λ�ļ�:"+f.isFile());
		System.out.println("�Ƿ�ΪĿ¼:"+f.isDirectory());
		//����ļ����е��ļ�������ֵΪString[]
		File fl = new File("C:\\Users\\Administrator\\Desktop\\��Ϸ");
		for (String string : fl.list()) {
			System.out.print(string+" ");
		}
		
	}
}
