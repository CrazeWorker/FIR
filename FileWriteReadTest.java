package ��ʮ����;

import java.io.File;
import java.io.IOException;

public class FileWriteReadTest {
	public static void main(String[] args) {
		String path = "H:\\1.txt";
		String path2 = "H:\\2.txt";
		// ��������
		WriteAndRead wr = new WriteAndRead();
		File f1 = wr.createFile(path);
		File f2 = wr.createFile(path2);
		// д
		String s = "dwadwa";
		byte[] b = s.getBytes();
		
		try {
			// ��ȡ ����д��
			wr.writeFile(f1, b);
			System.out.println(wr.writeFile(f2, wr.readFile(f1)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
