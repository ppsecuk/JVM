package com.sda;

public class DeadLockMain {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Runnable first = new MyRunnable(lock1, lock2);
        new Thread(first).start();

        Runnable second = new MyRunnable(lock1, lock2);
        new Thread(second).start();
    }

    private static class MyRunnable implements Runnable{
        private final Object firstLock;
        private final Object secondLock;

        public MyRunnable(Object firstLock, Object secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run(){
           synchronized (firstLock){

               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   return;
               }
               synchronized (secondLock){
                   System.out.println(Thread.currentThread().getName() + " Finished my job!");
               }
           }
        }
    }
}
