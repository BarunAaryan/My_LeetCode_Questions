class FooBar {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean turn = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (turn) {
                    condition.await();
                }
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            turn = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!turn) {
                    condition.await();
                }
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            turn = false;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}