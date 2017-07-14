package ru.learnjava.chapter15;

/**
 * Created by belyakovvv1 on 14.07.2017.
 */
public class RyanAndMonicaJob implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();

        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);

        one.setName("Ryan");
        two.setName("Monica");

        one.start();
        two.start();

    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdarwal(10);
            if(account.getBalance()<0){
                System.out.println("Limit exceeded");
            }
        }
    }

    private synchronized void makeWithdarwal(int amount){
        if (account.getBalance() >= amount){
            System.out.println(Thread.currentThread().getName() + " is about to make a withdrawal");
            try{
                System.out.println(Thread.currentThread().getName() + " go sleep");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " waking up");
                System.out.println(Thread.currentThread().getName() + " finishing transaction. " + account.withdraw(amount) + " money left");
            }catch (Exception e ){
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Sorry, not enough money for client " + Thread.currentThread().getName());
        }
    }
}
