package MultithreadingKing;


class Meter{
    public int cnt;
    Meter(){
        this.cnt=0;
    }

    public void increment(){
        synchronized(this){
            for(int i=0;i<15;i++){
                this.cnt++;
                System.out.println(" pointing: "+cnt);
            }
        }
    }
}

class runity extends Thread{
    public Meter m;
    runity(Meter m){
        this.m=m;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        m.increment();
    }
}

public class synchronization1 {
    public static void main(String [] args){
        System.out.println("HELLO UNCLE");

        Meter m = new Meter();
        runity r1 = new runity(m);
        runity r2 = new runity(m);
        r1.start();
        r2.start();
    }
}
