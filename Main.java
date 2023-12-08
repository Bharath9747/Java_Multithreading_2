import java.util.concurrent.*;


public class Main{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0;i<100;i++)
        {
            myThread t = new myThread(i);

            executorService.submit(t);

        }
        executorService.shutdown();

    }
}
