// import *java.threads

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable{
    public String str = "";
    @Override
    public void run(){
        for(int i=0;i<99;i++){
            System.out.println(i + str);
        }
    }
}

public class multithreading {
    public void printi(){
        System.out.println("Monster from printi");
    }
    public static void main(String []args){
        System.out.println(" every buddy is a gangster");
        // MyThread t1 = new MyThread();
        // MyThread t2 = new MyThread();
        // t1.str="t1";
        // t2.str="t2";
        // t1.start();
        // t2.start();

        // Thread thread = new Thread(new MyThread());
        // thread.start();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executor.submit(printi);
        }
    }
}
