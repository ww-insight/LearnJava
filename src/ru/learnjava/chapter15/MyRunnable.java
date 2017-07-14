package ru.learnjava.chapter15;

/**
 * Created by belyakovvv1 on 14.07.2017.
 */
public class MyRunnable implements Runnable {

    public void run(){
        go();
    }

    public void go(){
        doMore();
    }

    public void doMore(){
        System.out.println("Вершина стека");
    }
}
