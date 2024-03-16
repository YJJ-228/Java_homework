package Testing.Async;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Multiple_stream {
    public static void main(String[] args) {
        Mythread t1=new Mythread();
        t1.run();
    }
}

class Mythread extends Thread
{
    public void run() {
        Download t1 = new Download();
        Download t2 = new Download();
        Download t3 = new Download();
        Download t4 = new Download();
        try {
            t1.downloading("https://blog.alistofyjj.top/img/fluid.png");
            t2.downloading("https://s2.51cto.com/images/avater/202311/951b41d06d32b1bfe1006950721c6bb070de13.jpg");
            t3.downloading("https://s2.51cto.com/images/avater/202309/f1096fa159c3070dc3e64323be97a0ab48ad81.jpg");
            t4.downloading("https://i2.hdslb.com/bfs/archive/6a58d978db68f71ef3497064bb3222ebfe0cf104.jpg");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}

class Download
{
    public void downloading(String urlstring) throws IOException
    {
        String filename = "./test_"+urlstring.split("/")[urlstring.split("/").length-1];
        @SuppressWarnings("deprecation")
		URL url = new URL(urlstring);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = connection.getInputStream(); 
        FileOutputStream outputStream= new FileOutputStream(filename);

        byte[] data= new byte[4096];
        int byteread;
        while ((byteread=inputStream.read(data))!=-1) {
            outputStream.write(data,0,byteread);
        }

        System.out.println("下载完成");
        outputStream.close();
        inputStream.close();
    }
}

