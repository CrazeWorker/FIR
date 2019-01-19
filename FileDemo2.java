import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        // 创建文件夹
        File file = new File("C:\\Users\\Administrator\\Desktop\\cc\\vs");
        file.mkdir();
        if (file.exists()) {
            file.delete();
        }
        System.out.println(file.exists());
    }
}
