package 第二天;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DVD {
	// 定义四个数组分别表示名称name,是否可借状态,借出日期,借出次数
	static String[] name = new String[6];
	static boolean[] status = new boolean[6];
	static String[] date = new String[6];
	static int[] num = new int[6];
	static int count = 0;
	
	// 查看图书信息
	public static void check() {
		// 如果没有图书信息，输出提示
		if(count == 0) {
			System.out.println("没有任何图书信息!");
			return;
		}
		// 输出表头
		System.out.println("名称\t\t是否可借\t\t借出日期\t\t借出次数");
		// 循环遍历输出图书信息
		for (int i = 0; i < 6; i++) {
			if(name[i] != null) {
				System.out.println(name[i]+"\t\t"+status[i]+"\t\t"+date[i]+"\t\t"+num[i]);
			}	
		}
		System.out.println("***************************");
	}
	
	// 添加图书信息
	public static void add() {
		// 已经存储6个图书信息时提示货架已满
		if(count == 6) {
			System.out.println("货架已满！");
			return;
		}
		// 添加图书信息
		while(true) {
			for (int i = 0; i < 6; i++) {
				if(name[i] == null) {
					Scanner sc = new Scanner(System.in);
					System.out.println("请输入图书名称：");
					name[i] = sc.next();
					status[i] = true;
					count++;
					System.out.println("添加《"+name[i]+"》成功！");
					System.out.println("***************************");
					break;
				}
			}
			System.out.println("添加完毕请输入0返回菜单，若继续添加请输入1");
			Scanner c = new Scanner(System.in);
			int nums = c.nextInt();
			if(nums==0) {
				break;
			}else if(nums==1){
				continue;
			}else {
				System.out.println("输入功能编号错误，自动返回菜单！");
				break;
			}
		}
	}
	
	// 删除图书信息
	public static void delete() {
		// 边界提醒
		if(count == 0) {
			System.out.println("没有可删除的图书信息！");
			return;
		}
		System.out.println("请输入您要删除的图书名称:");
		Scanner sc = new Scanner(System.in);
		String dname = sc.next();
		// 删除，并清空图书信息
		boolean flag = false;
		for (int i = 0; i < 6; i++) {
			if(name[i]!=null&&name[i].equals(dname)) {
				if(status[i] == false) {
					System.out.println("此图书已被借阅，无法删除!");
					flag = true;
					return;
				}
				name[i] = null;
				status[i] = false;
				date[i] = null;
				num[i] = 0;
				count--;
				flag = true;
				System.out.println("删除成功！");
				System.out.println("***************************");
				break;
			}
		}
		if(!flag) {
			System.out.println("未找到图书信息，删除失败！");
			System.out.println("***************************");
			return;
		}
	}
	
	// 借出图书
	@SuppressWarnings("deprecation")
	public static void borrow() {
		if(count == 0) {
			System.out.println("没有可供借出的图书！");
			return;
		}
		System.out.println("请输入您要借出的图书名称：");
		Scanner sc = new Scanner(System.in);
		String bname = sc.next();
		boolean flag = false;
		for (int i = 0; i < 6; i++) {
			if(name[i]!=null&&name[i].equals(bname)) {
				if(status[i] == false) {
					System.out.println("该书已被借出，无法借阅！");
					flag = true;
					break;
				}
				status[i] = false;
				num[i]++;
				Calendar c = Calendar.getInstance();
				date[i] = (c.get(Calendar.MONTH)+1)+"-"+(c.get(Calendar.DAY_OF_MONTH));
				flag = true;
				System.out.println("借书成功！请按时归还！");
				System.out.println("***************************");
				break;
			}
		}
		if(!flag) {
			System.out.println("未查找到相关的图书信息！");
			System.out.println("***************************");
			return;
		}
	}
	
	// 归还图书
	public static void giveBack() {
		System.out.println("请输入您要归还的图书名称：");
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
				System.out.println("归还成功！您的租金为："+money+"元.");
				System.out.println("***************************");
				break;
			}
		}
		if(!flag) {
			System.out.println("未查找到相关的图书信息！");
			System.out.println("***************************");
			return;
		}
	}
	
	
	public static void show() {
		System.out.println("欢迎使用图书管理系统!");
		System.out.println("--------------------------");
		System.out.println("1.新增图书");
		System.out.println("2.查看图书");
		System.out.println("3.删除图书");
		System.out.println("4.借出图书");
		System.out.println("5.归还图书");
		System.out.println("6.退出系统");
		System.out.println("请选择相应的功能编号：");
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
					System.out.println("欢迎下次使用！");
					return;
				default:
					System.out.println("请输入正确的功能编号！");
			}
		}
	}
}


















