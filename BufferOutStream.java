package first;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOutStream {
	public static void main(String[] args) throws IOException {
		write();
	}

	private static void write() throws IOException {
		// �����ֽ����������
		FileOutputStream fo = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.txt");
		// ������Ч����
		BufferedOutputStream bf = new BufferedOutputStream(fo);
		bf.write("����".getBytes());
		bf.close();
	}
	
	
}
