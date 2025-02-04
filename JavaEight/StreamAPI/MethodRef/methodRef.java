package JavaEight.StreamAPI.MethodRef;
import java.util.*;

@FunctionalInterface
interface Bike {
    void runEngine();
}

@FunctionalInterface
interface  BikeProvider {
    SuperBike getBike();
}

class SuperBike{
    public static void runEngine(){
        System.out.println("Engine is running statically on 8000rpm");
    }
    public static void runEngineThread()  {
        try{
            for(int i=0;i<5;i++){
                Thread.sleep(20);
                System.out.println("Engine completing Rotation: "+i);
            }
        }catch(Exception e){
            System.out.println("engine failure");
        }
    }
}

public class methodRef {
    public static void main(String[] args) {

        //Declaring body with lambda function
        Bike b1 = ()->{
            System.out.println("engine is running at 500cc");
        };
        b1.runEngine(); 

        //Example with runnable interface
        Runnable runnableEngine = SuperBike::runEngineThread;
        Thread engineThread = new Thread(runnableEngine);  // thread can take method as param
        engineThread.start();
        runnableEngine.run();
        
        //Method reference : Static method
        Bike b2 = SuperBike::runEngine;
        b2.runEngine();


        //Method reference : Instance method
        //use b1 , which is declared above
        Bike b3 = b1::runEngine;
        b3.runEngine();

        //Constructor reference 
        //First declaring with lambda function
        BikeProvider bikeProvider = ()->{
            return new SuperBike();
        };
        SuperBike sb = bikeProvider.getBike();
        sb.runEngine();
        
        BikeProvider bikeProviderConsRef= SuperBike::new;
        SuperBike sb1 = bikeProviderConsRef.getBike();
        sb1.runEngine();

        

    }
}
