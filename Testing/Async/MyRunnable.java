package Testing.Async;

import java.io.IOException;

public class MyRunnable implements Runnable {
    String url;

    MyRunnable(String urlstring){
        this.url=urlstring;
    }

    public synchronized void run() {
        Download t1 = new Download();
        try {
            t1.downloading(url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
