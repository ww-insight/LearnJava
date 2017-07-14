package ru.learnjava.chapter15;

/**
 * Created by belyakovvv1 on 14.07.2017.
 */
public class ThreadTester {

    public static void main(String[] args) {
        ThreadTester t = new ThreadTester();
        t.go();
    }
    public void go(){
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);

        myThread.start();
        try {
           Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Back to main");
    };
}
