package Testing.Async;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Multiple_stream {
    
}

class Mythread extends Thread
{
    String filename="./test.png";
    public void run()
    {
        @SuppressWarnings("deprecation")
        URL url = new URL("https://blog.alistofyjj.top/img/fluid.png");
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();//打开一个http链接
        connection.setConnectTimeout(3*1000);
        InputStream inputStream=connection.getInputStream(); //得到输入流
        FileOutputStream outputStream= new FileOutputStream(filename); //定义输出流

        byte[] data= new byte[4096];
        int byteread;
        while ((byteread=inputStream.read(data))!=-1) {
            outputStream.write(data,0,byteread);
        }

        outputStream.close();
        inputStream.close();
    }
}
