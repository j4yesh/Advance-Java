package Multithreading;

import java.util.Random;

class InstructionFollower extends Thread{
    public int signal;
    private Random random;
    public static char [] charSet={'a','b','c','d','e','f','g','h','i','6','3','z','e','q'};
    InstructionFollower(int s){
        this.signal=s;
        random=new Random();
    }
    void setSignal(int signal){
        this.signal=signal;
    }
    @Override
    public void run(){
        int len=charSet.length;
        try{
            int strLen=75;
            while(true){
                if(signal==1){
                    StringBuffer sb = new StringBuffer();
                    int shift= random.nextInt(2)-random.nextInt(2) ;
                    strLen=strLen+shift;
                    if(strLen<0)strLen=5;
                    for(int i=0;i<strLen;i++){
                        int idx= random.nextInt(len);
                        sb.append(charSet[idx]);
                    }
                    System.out.println(sb.toString());
                }else{
                    System.out.println(" NO SIGNAL :( ");
                }
                Thread.sleep(80);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class RandomController extends Thread{
    InstructionFollower iff;
    Random random;
    RandomController(InstructionFollower iff){
        this.iff=iff;
        random=new Random();
    }
    @Override
    public void run(){
        try{    
            while(true){
                int signal = random.nextInt(2);
                // System.out.println(signal);
                iff.setSignal(signal);
                Thread.sleep(3000);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

public class OnOffSimulation {
    public static void main(String[] args) {
        int signal=1;
        InstructionFollower ifo = new InstructionFollower(signal);
        ifo.start();
        RandomController rc = new RandomController(ifo);
        rc.start();
    }
}
