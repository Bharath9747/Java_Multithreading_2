class myThread implements Runnable{

    private final int val;

    myThread(int val) {
        this.val = val;
    }

    @Override
    public void run() {
        System.out.println(val);
    }
}