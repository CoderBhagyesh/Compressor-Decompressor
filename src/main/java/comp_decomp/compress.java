package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compress {

    public static void method(File file)throws IOException {
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"\\CompressedFile.gz");
        GZIPOutputStream gz = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer))!=-1) {
            gz.write(buffer, 0, len);
        }

        gz.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\ASUS\\OneDrive\\Documents\\Deep Learning\\DL1");
        method(path);
    }
}


