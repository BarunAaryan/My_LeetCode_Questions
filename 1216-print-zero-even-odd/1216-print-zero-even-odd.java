class ZeroEvenOdd {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int turn = 0;
    private int i=1;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            lock.lock();
            try {
                while (turn != 0 && i <= n) {
                    condition.await();
                }

                if (i > n) {
                    break;
                }

                printNumber.accept(0);

                // Alternate between even (2) and odd (1)
                turn = (i % 2 == 0) ? 2 : 1;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            lock.lock();
            try {
                while (turn != 2 && i <= n) {
                    condition.await();
                }

                if (i > n) {
                    break;
                }

                printNumber.accept(i++);
                turn = 0;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        } 
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
       while (i <= n) {
            lock.lock();
            try {
                while (turn != 1 && i <= n) {
                    condition.await();
                }

                if (i > n) {
                    break;
                }

                printNumber.accept(i++);
                turn = 0;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        } 
    }
}