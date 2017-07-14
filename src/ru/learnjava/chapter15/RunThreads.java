package ru.learnjava.chapter15;

/**
 * Created by belyakovvv1 on 14.07.2017.
 */
public class RunThreads implements Runnable {

    public static void main(String[] args) {
        RunThreads runner = new RunThreads();
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);

        alpha.setName("thread Alpha");
        beta.setName("thread Beta");

        alpha.start();
        beta.start();
    }

    public void run() {
        for (int i = 0; i < 25; i++) {
            String s = Thread.currentThread().getName();
            System.out.println("Now working " + s);
        }
    }
}
