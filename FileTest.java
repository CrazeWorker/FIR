package first;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Administrator\\Desktop\\test.txt";
		//创建文件对象
		File f = new File(path);
		//输出绝对路径
		System.out.println("输出绝对路径:"+f.getAbsolutePath());
		//输出文件大小
		System.out.println("输出文件大小:"+f.length());
		//输出文件名称
		System.out.println("输出文件名称:"+f.getName());
		//输出创建文件时的封装路径，即path
		System.out.println("输出文件的封装路径:"+f.getPath());
		File f1 = new File("C:\\Users\\Administrator\\Desktop\\test2.txt");
		//创建文件，如果文件不存在，创建 true 如果文件存在，则不创建 false。 如果路径错误，IOException。
		boolean b = f1.createNewFile();
		System.out.println("文件是否创建成功:"+b);
		//-----------删除文件操作-------注意：不去回收站。慎用------
		boolean b2 = f1.delete();
		System.out.println("文件是否删除成功:"+b2);
		//-----------需要判断文件是否存在------------
		boolean b3 = f1.exists();
		System.out.println("文件是否存在:"+b3);
		//mkdir()创建单个目录。//dir.mkdirs();创建多级目录
		File dir = new File("C:\\Users\\Administrator\\Desktop\\aab");
		boolean b4 = dir.mkdir();
		System.out.println("目录是否创建成功:"+b4);
		//删除目录时，如果目录中有内容，无法直接删除。
		System.out.println("目录是否删除成功:"+dir.delete());
		// 要判断是否是文件还是目录，必须先判断存在。
		System.out.println("是否位文件:"+f.isFile());
		System.out.println("是否为目录:"+f.isDirectory());
		//输出文件夹中的文件，返回值为String[]
		File fl = new File("C:\\Users\\Administrator\\Desktop\\游戏");
		for (String string : fl.list()) {
			System.out.print(string+" ");
		}
		
	}
}
