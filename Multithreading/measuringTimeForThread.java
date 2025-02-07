    package Multithreading;



    public class measuringTimeForThread {
        static int factorial(int num){
            //Assume this is very resource intensive
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            int res=1;
            while(num>0){
                res=res*num;
                num--;
            }
            return num;
        }
        public static void main(String[] args) {
            long start=System.currentTimeMillis();
            int n=5;
            Thread [] thr= new Thread[n];
            for(int i=1;i<n+1;i++){
                int iff=i;
                thr[i-1] = new Thread(()->{
                    int res1= measuringTimeForThread.factorial(iff);
                    System.out.println(" res: "+res1);
                });
                thr[i-1].start();
            }
            for(int i=0;i<n;i++){
                try{
                    thr[i].join();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            long end=System.currentTimeMillis();
            System.out.println("Took "+(end-start)+" ms");
        }
    }
