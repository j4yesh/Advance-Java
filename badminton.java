import java.util.*;

class PlayGround {
    private ArrayList<Character> pg;
    private String curChance;
    PlayGround(ArrayList<Character> p) {
        this.pg = p;
        this.curChance = "right";
    }

    public synchronized void leftHit() {
        System.out.println("Left hit triggered");
        try {
            while(this.curChance.equals("right")){
                wait(); 
            }
            int i = 1;
            while (pg.get(i).equals('*')) {
                if (i + 1 == pg.size() - 1) break;
                Character hold = pg.get(i);
                pg.set(i, pg.get(i + 1));
                pg.set(i + 1, hold);
                i++;
                Thread.sleep(100);
                System.out.println("Left shift: " + pg);
            }
        } catch (Exception e) {
            System.out.println("Error in leftHit: " + e.getMessage());
        } finally {
            this.curChance="right";
            notifyAll();
        }
    }

    public synchronized void rightHit() {
        System.out.println("Right hit triggered");
        try {
            while(this.curChance.equals("left")){
                wait(); 
            }
            int i = pg.size() - 2;
            while (pg.get(i).equals('*')) {
                if (i - 1 == 1) break;
                Character hold = pg.get(i);
                pg.set(i, pg.get(i - 1));
                pg.set(i - 1, hold);
                i--;
                Thread.sleep(100);

                System.out.println("Right shift: " + pg);
            }
        } catch (Exception e) {
            System.out.println("Error in rightHit: " + e.getMessage());
        } finally {
            this.curChance = "left";
            notifyAll();
        }
    }
}



class playerA extends Thread{

    PlayGround pg;

    playerA(PlayGround pg){
        this.pg=pg;
    }

    public void run() {
        try{
            while (true) {
                pg.leftHit();
                Thread.sleep(5000);
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class playerB extends Thread{
    PlayGround pg;
    playerB(PlayGround pg){
        this.pg=pg;
    }

    public void run() {
        try{
            while (true) {
                pg.rightHit();
                Thread.sleep(5000);
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

public class badminton {
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder("A*-------------------------------------B");
        int n=sb.length();

        ArrayList<Character> playground = new ArrayList<>();
        String str = sb.toString();

        for(int i=0;i<str.length();i++){
            playground.add(str.charAt(i));
        }

        PlayGround globPlay = new PlayGround(playground);

        Runnable display = ()->{
            while(true){
                System.out.println(playground);
                try{
                    Thread.sleep(100);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        };

        playerA a = new playerA(globPlay);
        playerB b = new playerB(globPlay);
        Thread t1 = new Thread(display);
        
        a.start();
        b.start();
        // t1.start();

    }
}
