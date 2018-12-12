package 第十二天;

import java.io.File;
import java.io.IOException;

public class FileWriteReadTest {
	public static void main(String[] args) {
		String path = "H:\\1.txt";
		String path2 = "H:\\2.txt";
		// 创建对象
		WriteAndRead wr = new WriteAndRead();
		File f1 = wr.createFile(path);
		File f2 = wr.createFile(path2);
		// 写
		String s = "dwadwa";
		byte[] b = s.getBytes();
		
		try {
			// 读取 并且写入
			wr.writeFile(f1, b);
			System.out.println(wr.writeFile(f2, wr.readFile(f1)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
