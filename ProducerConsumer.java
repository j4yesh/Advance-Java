import java.util.*;
import java.util.function.Consumer;

 class SharedBuffer {
    public Queue<Integer> buffer;
    public static int size=5;

    SharedBuffer(){
        this.buffer=new LinkedList<>();
    }

    public synchronized void consumer() throws InterruptedException {
        while(buffer.isEmpty()){
            System.out.println("buffer empty ...waiting");
            wait();
        }
        System.out.println(buffer.poll() + "consumed");
        notifyAll();
    }

    public synchronized void producer(int value) throws InterruptedException{
        while(buffer.size()>=5){
            System.out.println("buffer is full ...waiting");
            wait();
        }
        buffer.add(value);
        System.out.println(value +" produced in buffer");
        notifyAll();
    }
}

class producer extends Thread{
    private SharedBuffer sb;
    int value=0;
    producer(SharedBuffer sb){
        this.sb=sb;
    }
    @Override
    public void run(){
        while(true){
            try{
                sb.producer(value++);
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.print(e.getMessage());
            }
        }
    }
}

class consumer extends Thread{
    private SharedBuffer sb;
    int value=0;
    consumer(SharedBuffer sb){
        this.sb=sb;
    }
    @Override
    public void run(){
        while(true){
            try{
                sb.consumer();
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String [] args){
        // Object
        SharedBuffer sb = new SharedBuffer();
        producer pd=new producer(sb);
        consumer cm=new consumer(sb);
        pd.start();
        cm.start();
    }    
}
