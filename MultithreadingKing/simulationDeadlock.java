package MultithreadingKing;

class Pen{
    synchronized void writingWithPen(Paper paper){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Is writing ");
    }
}

class Paper{
    synchronized void writingOnPaper(Pen pen){
        System.out.println(Thread.currentThread().getName());
        System.out.println("Is writing with Pen"+pen.hashCode()+ " and "+this.hashCode());
    }
}

public class simulationDeadlock {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Runnable Aperson = new Runnable() {
            @Override
            public void run(){
                pen.writingWithPen(paper);
            }
        };
        Runnable Bperson = new Runnable(){
            @Override
            public void run(){
                paper.writingOnPaper(pen);
            }
        };
        new Thread(Aperson).start();
        new Thread(Bperson).start();
    }
}
