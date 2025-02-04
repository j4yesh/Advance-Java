import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

class engine{
    public int spin=0;

    final public ReadWriteLock renterLock = new ReentrantReadWriteLock();
    final public Lock readLock = renterLock.readLock();
    final public Lock writeLock = renterLock.writeLock();
 
    void read(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" reading the spin");
        }finally{
            readLock.unlock();
        }
    }

    void write(){
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" writing the spin ");
        }finally{
            writeLock.unlock();
        }
    }
}

public class readWriteLock {
    public static void main(String[] args) {
        //Read lock : aquire only if there is 0 writer, no matter if there is multiple reader
        //write lock : aquire only if there is 0 writer and 0 reader
        engine e1 = new engine();
        Runnable r = new Runnable(){
            @Override
            public void run(){
                try{
                    for(int i=0;i<5;i++){
                        e1.read();
                        Thread.sleep(1000);
                    }
                }catch(Exception e){

                }
            }
        };
        Runnable r1 = new Runnable(){
            @Override
            public void run(){
                try{
                    for(int i=0;i<5;i++){
                        e1.write();
                        Thread.sleep(1000);
                    }
                }catch(Exception e){

                }
            }
        };
        new Thread(r).start();
        new Thread(r1).start();
    }
}
