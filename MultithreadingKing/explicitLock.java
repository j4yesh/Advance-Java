package MultithreadingKing;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.sound.midi.SysexMessage;

class Engine extends Thread{
    int aerow=9;

    public static ReentrantLock lock = new ReentrantLock();

    public void run() {
        try {
            this.ShiftGear();
        } catch (Exception e) {
            System.out.println(" error while shifting the gear");
        }
    }

    public void ShiftGear() throws Exception{
        if(lock.tryLock(2000,TimeUnit.MILLISECONDS)){   
            try{
                aerow+= 9;
                System.out.println(Thread.currentThread().getName()+" initiated the operation");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName()+" completed the operation");
            }catch(Exception e){
                System.out.println("exception "+e.getMessage());
            }finally{
                lock.unlock();
            }
        }else{
            while(lock.isLocked()){
                System.out.println(Thread.currentThread().getName()+" will try again later");
                Thread.sleep(500);
            }
            ShiftGear();
        }
    }
}

public class explicitLock {
    public static void main(String [] args){
        Engine e1 = new Engine();
        Engine e2= new Engine();
        e1.start();
        e2.start();
    }
}
