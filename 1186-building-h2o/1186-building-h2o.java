class H2O {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int turn;

    public H2O() {
        turn=0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try{
            while(turn==2){
            condition.await();
        }
       
        
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        ++turn;
        condition.signalAll();
         }finally{
            lock.unlock();
         }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try{

        
        while(turn<2){
        condition.await();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        turn=0;
        condition.signalAll();
        }finally{
            lock.unlock();
        }

    }
}