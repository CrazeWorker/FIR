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
		// 创建字节输出流对象
		FileOutputStream fo = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.txt");
		// 创建高效的流
		BufferedOutputStream bf = new BufferedOutputStream(fo);
		bf.write("您好".getBytes());
		bf.close();
	}
	
	
}
