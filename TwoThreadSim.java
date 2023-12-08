
class Count{
private int val=0;

    public int getVal() {
        return val;
    }

    public void add() throws InterruptedException {
        synchronized (this)
        {
            for (int i=0;i<10;i++) {
                if(i%2==0)
                    wait();
                System.out.println("Add "+val);
                val++;
                notify();
            }
        }
    }
    public void sub() throws InterruptedException {
        synchronized (this)
        {
            for (int i=0;i<10;i++) {
                System.out.println("Sub "+val);
                val--;
                notify();
            }
        }
    }
}
public class TwoThreadSim {
    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.add();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.sub();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
          t1.start();
          t2.start();
        t1.join();
        t2.join();
        System.out.println(c.getVal());
    }
}
