package Testing.Async;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Download {
    public void downloading(String urlstring) throws IOException {
        String filename = "./test_" + urlstring.split("/")[urlstring.split("/").length - 1];
        @SuppressWarnings("deprecation")
        URL url = new URL(urlstring);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(5000);

        InputStream inputStream = connection.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(filename);

        byte[] data = new byte[4096];
        int byteread;
        while ((byteread = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, byteread);
        }

        System.out.println("下载完成");
        outputStream.close();
        inputStream.close();
    }
}
