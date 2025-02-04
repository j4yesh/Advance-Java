// package javaeightfeatures.lambda;
package JavaEight.Lambda;
interface Engine{
    void startEngine();
}

public class lambda {
    public static void main(String [] args){
        Engine bike = ()->{
            System.out.println("engine running on 2000cc");
        };
        Engine bike1 = ()->{
            System.out.println("engine running on 5000cc");
            Engine bike2 = () -> {
                System.out.println("bike2: nested engine of bike1 ");
                System.out.println(bike.getClass().getName());
                System.out.println(bike.hashCode());
            };
            bike2.startEngine();
        };
        bike.startEngine();
        bike1.startEngine();
    }
}
