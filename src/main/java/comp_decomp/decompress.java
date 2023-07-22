package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompress {

    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gz = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "\\DecompressedFile");

        byte[] buffer = new byte[1024];
        int len;

        while ((len = gz.read(buffer))!=-1) {
            fos.write(buffer, 0, len);
        }

        gz.close();
        fis.close();
        fos.close();
    }
    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\ASUS\\OneDrive\\Documents\\Deep Learning\\CompressedFile.gz");
        method(path);
    }
}
