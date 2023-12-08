public class ThreadEx1 {
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(()-> print(1,10));
        Thread th2 = new Thread(()-> print(11,20));
        Thread th3 = new Thread(()-> print(21,30));
        Thread th4 = new Thread(()-> print(31,40));
        Thread th5 = new Thread(()-> print(41,50));
        Thread th6 = new Thread(()-> print(51,60));
        th1.start();
        th1.join();
        th2.start();
        th2.join();
        th3.start();
        th3.join();
        th4.start();
        th4.join();
        th5.start();
        th5.join();
        th6.start();
        th6.join();

    }

    private static void print(int i, int i1) {
        synchronized (lock) {
            for (int j = i; j <= i1; j++) {
                System.out.println(Thread.currentThread().getName() + " " + j);
            }
        }
    }
}
