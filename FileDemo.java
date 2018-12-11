import java.io.File;
import java.io.IOException;


public class FileDemo {
	    public static void main(String[] args) {
	        File file = new File("F:\\lintong");
	        if (file.isDirectory()) {
	            if (file.exists()) {
	                if (file.list().length == 0) {
	                    file.delete();
	                    file.mkdir();
	                } else {
	                    File[] files = file.listFiles();
	                    for (File f : files) {
	                        f.delete();
	                    }
	                    file.delete();
	                    file.mkdir();
	                }
	            } else {
	                file.mkdir();
	            }
	        } else {
	            file.delete();
	        }

	        // 创建b.txt文件
	        File fi = new File("F:\\lintong\\b.txt");
	        try {
	            if (fi.exists()) {
	                fi.delete();
	                fi.createNewFile();
	            } else {
	                fi.createNewFile();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
