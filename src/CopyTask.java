import java.io.*;

public class CopyTask implements Runnable {
    @Override
    public void run() {

        try (DataInputStream input = new DataInputStream(new FileInputStream("D:\\516 Felina.mkv"));
             DataOutputStream output = new DataOutputStream(new FileOutputStream("D:\\Ready\\516 Felina.mkv"))) {
            byte[] buf = new byte[4096];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

