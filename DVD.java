package �ڶ���;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DVD {
	// �����ĸ�����ֱ��ʾ����name,�Ƿ�ɽ�״̬,�������,�������
	static String[] name = new String[6];
	static boolean[] status = new boolean[6];
	static String[] date = new String[6];
	static int[] num = new int[6];
	static int count = 0;
	
	// �鿴ͼ����Ϣ
	public static void check() {
		// ���û��ͼ����Ϣ�������ʾ
		if(count == 0) {
			System.out.println("û���κ�ͼ����Ϣ!");
			return;
		}
		// �����ͷ
		System.out.println("����\t\t�Ƿ�ɽ�\t\t�������\t\t�������");
		// ѭ���������ͼ����Ϣ
		for (int i = 0; i < 6; i++) {
			if(name[i] != null) {
				System.out.println(name[i]+"\t\t"+status[i]+"\t\t"+date[i]+"\t\t"+num[i]);
			}	
		}
		System.out.println("***************************");
	}
	
	// ���ͼ����Ϣ
	public static void add() {
		// �Ѿ��洢6��ͼ����Ϣʱ��ʾ��������
		if(count == 6) {
			System.out.println("����������");
			return;
		}
		// ���ͼ����Ϣ
		while(true) {
			for (int i = 0; i < 6; i++) {
				if(name[i] == null) {
					Scanner sc = new Scanner(System.in);
					System.out.println("������ͼ�����ƣ�");
					name[i] = sc.next();
					status[i] = true;
					count++;
					System.out.println("��ӡ�"+name[i]+"���ɹ���");
					System.out.println("***************************");
					break;
				}
			}
			System.out.println("������������0���ز˵������������������1");
			Scanner c = new Scanner(System.in);
			int nums = c.nextInt();
			if(nums==0) {
				break;
			}else if(nums==1){
				continue;
			}else {
				System.out.println("���빦�ܱ�Ŵ����Զ����ز˵���");
				break;
			}
		}
	}
	
	// ɾ��ͼ����Ϣ
	public static void delete() {
		// �߽�����
		if(count == 0) {
			System.out.println("û�п�ɾ����ͼ����Ϣ��");
			return;
		}
		System.out.println("��������Ҫɾ����ͼ������:");
		Scanner sc = new Scanner(System.in);
		String dname = sc.next();
		// ɾ���������ͼ����Ϣ
		boolean flag = false;
		for (int i = 0; i < 6; i++) {
			if(name[i]!=null&&name[i].equals(dname)) {
				if(status[i] == false) {
					System.out.println("��ͼ���ѱ����ģ��޷�ɾ��!");
					flag = true;
					return;
				}
				name[i] = null;
				status[i] = false;
				date[i] = null;
				num[i] = 0;
				count--;
				flag = true;
				System.out.println("ɾ���ɹ���");
				System.out.println("***************************");
				break;
			}
		}
		if(!flag) {
			System.out.println("δ�ҵ�ͼ����Ϣ��ɾ��ʧ�ܣ�");
			System.out.println("***************************");
			return;
		}
	}
	
	// ���ͼ��
	@SuppressWarnings("deprecation")
	public static void borrow() {
		if(count == 0) {
			System.out.println("û�пɹ������ͼ�飡");
			return;
		}
		System.out.println("��������Ҫ�����ͼ�����ƣ�");
		Scanner sc = new Scanner(System.in);
		String bname = sc.next();
		boolean flag = false;
		for (int i = 0; i < 6; i++) {
			if(name[i]!=null&&name[i].equals(bname)) {
				if(status[i] == false) {
					System.out.println("�����ѱ�������޷����ģ�");
					flag = true;
					break;
				}
				status[i] = false;
				num[i]++;
				Calendar c = Calendar.getInstance();
				date[i] = (c.get(Calendar.MONTH)+1)+"-"+(c.get(Calendar.DAY_OF_MONTH));
				flag = true;
				System.out.println("����ɹ����밴ʱ�黹��");
				System.out.println("***************************");
				break;
			}
		}
		if(!flag) {
			System.out.println("δ���ҵ���ص�ͼ����Ϣ��");
			System.out.println("***************************");
			return;
		}
	}
	
	// �黹ͼ��
	public static void giveBack() {
		System.out.println("��������Ҫ�黹��ͼ�����ƣ�");
		Scanner sc = new Scanner(System.in);
		String gname = sc.next();
		boolean flag = false;
		for (int i = 0; i < 6; i++) {
			if(name[i].equals(gname)) {
				status[i] = true;
				Calendar c = Calendar.getInstance();
				double money = 2 + (c.get(Calendar.DAY_OF_MONTH) - Integer.parseInt(date[i].split("-")[1]))*0.2;
				date[i] = null;
				flag = true;
				System.out.println("�黹�ɹ����������Ϊ��"+money+"Ԫ.");
				System.out.println("***************************");
				break;
			}
		}
		if(!flag) {
			System.out.println("δ���ҵ���ص�ͼ����Ϣ��");
			System.out.println("***************************");
			return;
		}
	}
	
	
	public static void show() {
		System.out.println("��ӭʹ��ͼ�����ϵͳ!");
		System.out.println("--------------------------");
		System.out.println("1.����ͼ��");
		System.out.println("2.�鿴ͼ��");
		System.out.println("3.ɾ��ͼ��");
		System.out.println("4.���ͼ��");
		System.out.println("5.�黹ͼ��");
		System.out.println("6.�˳�ϵͳ");
		System.out.println("��ѡ����Ӧ�Ĺ��ܱ�ţ�");
	}
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		while(true) {
			show();
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			switch(a) {
				case 1:
					add();
					break;
				case 2:
					check();
					break;
				case 3:
					delete();
					break;
				case 4:
					borrow();
					break;
				case 5:
					giveBack();
					break;
				case 6:
					System.out.println("��ӭ�´�ʹ�ã�");
					return;
				default:
					System.out.println("��������ȷ�Ĺ��ܱ�ţ�");
			}
		}
	}
}


















