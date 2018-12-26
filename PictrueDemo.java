package 十七周周三;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PictrueDemo {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Administrator\\Desktop\\图片素材\\1.jpg");
		File f2 = new File("C:\\Users\\Administrator\\Desktop\\2.jpg");
		
		f2.createNewFile();
		try {
			InputStream in = new FileInputStream(f);
			OutputStream out = new FileOutputStream(f2);
			int len = 0;
			while((len = in.read()) != -1) {
				out.write(len);
			}
			
			in.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
